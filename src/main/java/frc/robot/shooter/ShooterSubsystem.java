package frc.robot.shooter;

import static edu.wpi.first.units.Units.RotationsPerSecond;

import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.controls.MotionMagicVelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.MotorAlignmentValue;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.hood.HoodConst;

public class ShooterSubsystem extends SubsystemBase {
    public TalonFX rightMotor = new TalonFX(ShooterConst.RIGHT_MOTOR_ID, HoodConst.LAUNCHER_CANBUS);
    public TalonFX leftMotor = new TalonFX(ShooterConst.LEFT_MOTOR_ID, HoodConst.LAUNCHER_CANBUS);

    public AngularVelocity targetAngularVelocity = RotationsPerSecond.of(70);
    public boolean enabled;

    public ShooterSubsystem() {
        rightMotor.getConfigurator().apply(ShooterConfig.motorConfig);
        leftMotor.getConfigurator().apply(ShooterConfig.motorConfig);
        leftMotor.setControl(new Follower(rightMotor.getDeviceID(), MotorAlignmentValue.Opposed));
    }

    /**
     * moves the velocity of the shooter(rps)
     *
     * @param velocity
     */
    public void moveAngularVelocity(AngularVelocity velocity) {
        if (enabled) {
            return;
        }
        targetAngularVelocity =
                RotationsPerSecond.of(
                        MathUtil.clamp(
                                velocity.in(RotationsPerSecond),
                                -(ShooterConst.MAX_ANGULAR_VELOCITY).in(RotationsPerSecond),
                                ShooterConst.MAX_ANGULAR_VELOCITY.in(RotationsPerSecond)));
        rightMotor.setControl(new MotionMagicVelocityVoltage(targetAngularVelocity));
    }

    /** stops the shooter motors */
    public void stop() {
        moveAngularVelocity(RotationsPerSecond.of(0));
    }

    /**
     * returns the velocity(rps)
     *
     * @return
     */
    public AngularVelocity getAngularVelocity() {
        return rightMotor.getVelocity().getValue();
    }

    /** enables the shooter */
    public void enable() {
        enabled = true;
    }

    /** disables the shooter */
    public void disable() {
        enabled = false;
    }

    @Override
    public void initSendable(SendableBuilder builder) {
        builder.addDoubleProperty(
                "angular velocity(rps)", () -> getAngularVelocity().in(RotationsPerSecond), null);
        builder.addDoubleProperty(
                "target angular velocity (rps)",
                () -> targetAngularVelocity.in(RotationsPerSecond),
                (targetAngularVelocity) ->
                        moveAngularVelocity(RotationsPerSecond.of(targetAngularVelocity)));
        builder.addBooleanProperty(
                "enabled",
                () -> enabled,
                (enable) -> {
                    if (enable) enable();
                    else disable();
                });
    }
}
