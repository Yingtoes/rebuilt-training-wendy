package frc.robot.hood;

import static edu.wpi.first.units.Units.Rotations;

import com.ctre.phoenix6.controls.MotionMagicVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class HoodSubsystem extends SubsystemBase {
    public TalonFX motor = new TalonFX(HoodConst.MOTOR_ID);
    private Angle targetPitch;

    public HoodSubsystem() {
        motor.getConfigurator().apply(HoodConfig.motorConfig);
    }

    /**
     * moves hood pitch
     *
     * @param pitch
     */
    public void moveHoodPitch(Angle pitch) {
        targetPitch =
                Rotations.of(
                        MathUtil.clamp(
                                pitch.in(Rotations),
                                HoodConst.MIN_ANGLE.in(Rotations),
                                HoodConst.MAX_ANGLE.in(Rotations)));
        motor.setControl(new MotionMagicVoltage(targetPitch));
    }

    /** moves hood to stow pitch */
    public void stow() {
        moveHoodPitch(HoodConst.MIN_ANGLE);
    }

    /**
     * returns pitch
     *
     * @return pitch(Rotations)
     */
    public Angle getPitch() {
        return motor.getPosition().getValue();
    }

    @Override
    public void initSendable(SendableBuilder builder) {
        builder.addDoubleProperty("hood pitch(Rotation)", () -> getPitch().in(Rotations), null);
        builder.addDoubleProperty(
                "target pitch(Rotation)",
                () -> targetPitch.in(Rotations),
                (pitch) -> moveHoodPitch(Rotations.of(pitch)));
    }
}
