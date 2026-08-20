package frc.robot.turret;

import static edu.wpi.first.units.Units.Degrees;
import static edu.wpi.first.units.Units.Rotations;

import com.ctre.phoenix6.controls.MotionMagicVoltage;
import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.hood.HoodConst;

public class TurretSubsystem extends SubsystemBase {
    public TalonFX motor = new TalonFX(TurretConst.MOTOR_ID, HoodConst.LAUNCHER_CANBUS);
    public CANcoder encoder = new CANcoder(TurretConst.ENCODER_ID);

    public Angle targetYaw;
    public boolean enabled;

    public TurretSubsystem() {
        motor.getConfigurator().apply(TurretConfig.motorConfig);
        encoder.getConfigurator().apply(TurretConfig.encoderConfig);
    }

    /** enables */
    public void enabled() {
        enabled = true;
    }

    /** disables */
    public void disabled() {
        enabled = false;
    }

    /** returns turrets position(rps) */
    public Angle getTurretYaw() {
        return motor.getPosition().getValue();
    }

    /**
     * moves turret and makes sure it is in range
     *
     * @param angle
     */
    public void moveRawYaw(Angle angle) {
        if (!enabled) {
            return;
        }
        targetYaw =
                Rotations.of(
                        MathUtil.clamp(
                                angle.in(Rotations),
                                TurretConst.MIN_ANGLE.in(Rotations),
                                TurretConst.MAX_ANGLE.in(Rotations)));
        motor.setControl(new MotionMagicVoltage(targetYaw));
    }

    /** stows turret */
    public void stow() {
        moveRawYaw(TurretConst.STOW_ANGLE);
    }

    /**
     * moves yaw using shortest path
     *
     * @param desiredYaw
     */
    public void moveYaw(Angle desiredYaw) {
        // current position of turret
        double currPosition = getTurretYaw().in(Rotations);
        // wanted position
        double desiredPosition = desiredYaw.in(Rotations);
        double relCurrentYaw = currPosition - desiredPosition;
        // min and max range
        double minYawOffset = Math.ceil(TurretConst.MIN_ANGLE.in(Rotations) - desiredPosition);
        double maxYawOffset = Math.floor(TurretConst.MAX_ANGLE.in(Rotations) - desiredPosition);
        // finds closer side
        int closestCoterminalAngle = (int) (Math.round(relCurrentYaw));
        double clampedYawOffset =
                MathUtil.clamp(closestCoterminalAngle, minYawOffset, maxYawOffset);
        double clampedYaw = clampedYawOffset + desiredPosition;
        // moves to desired position
        moveRawYaw(Rotations.of(clampedYaw));
    }

    /** This dumb encoder has no idea where it is so we need to tell it how many spins it did */
    public void calibrateYaw(Angle guess) {
        // Makes sure guess is in range
        if (guess.in(Rotations) > TurretConst.MAX_ANGLE.in(Rotations)
                || guess.in(Rotations) < TurretConst.MIN_ANGLE.in(Rotations)) {
            return;
        }
        // encoder position minute hand
        double encoderCurr = encoder.getPosition().getValueAsDouble();
        // guess of how many rotations
        double guessYaw = guess.in(Rotations) * TurretConst.ENCODER_TO_MECHANISM_RATIO;
        double roundedRotations = Math.round(guessYaw - encoderCurr);
        // Max and min offsets
        double minYawOffset =
                (TurretConst.MIN_ANGLE.in(Rotations) * TurretConst.ENCODER_TO_MECHANISM_RATIO)
                        - guessYaw;
        double maxYawOffset =
                (TurretConst.MAX_ANGLE.in(Rotations) * TurretConst.ENCODER_TO_MECHANISM_RATIO)
                        - guessYaw;
        double clampedOffset =
                MathUtil.clamp(roundedRotations, Math.ceil(minYawOffset), Math.floor(maxYawOffset));
        double clampedYaw = clampedOffset + encoderCurr;
        // set encoder to clamped guess position
        encoder.setPosition(clampedYaw);
    }

    /**
     * returns the yaw error
     *
     * @return
     */
    public Angle getYawError() {
        Angle currentYawError = targetYaw.minus(getTurretYaw());
        return currentYawError;
    }

    /**
     * checks if the yaw error is within the tolerance
     *
     * @return
     */
    public boolean withinTolerance() {
        if (Math.abs(getYawError().in(Rotations)) > 3) {
            return false;
        }
        return true;
    }

    @Override
    public void initSendable(SendableBuilder builder) {
        builder.addBooleanProperty(
                "enabled",
                () -> enabled,
                (enable) -> {
                    if (enable) enabled();
                    else disabled();
                });
        builder.addDoubleProperty("current yaw(deg)", () -> getTurretYaw().in(Degrees), null);
        builder.addDoubleProperty(
                "target yaw(deg)", () -> targetYaw.in(Degrees), (desiredYaw) -> moveYaw(targetYaw));
        builder.addDoubleProperty("yaw error(deg)", () -> getYawError().in(Degrees), null);
        builder.addBooleanProperty("tolerance", () -> withinTolerance(), null);
    }
}
