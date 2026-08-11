package frc.robot.intake;

import static edu.wpi.first.units.Units.Degrees;
import static edu.wpi.first.units.Units.Rotations;

import com.ctre.phoenix6.controls.MotionMagicVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
    public TalonFX deployMotor = new TalonFX(IntakeConst.DEPLOY_MOTOR_ID);
    public TalonFX rollerMotor = new TalonFX(IntakeConst.ROLLER_MOTOR_ID);

    public IntakeSubsystem() {
        deployMotor.getConfigurator().apply(IntakeConfig.deployMotorConfig);
        rollerMotor.getConfigurator().apply(IntakeConfig.rollerMotorConfig);
        deployMotor.setPosition(IntakeConst.MAX_ANGLE);
    }

    /**
     * Method sets intake roller motor speed to the value in parameter
     *
     * @param speed
     */
    public void moveRollerSpeed(double speed) {
        rollerMotor.set(speed);
    }

    /** This method turns the intake roller on */
    public void rollersOn() {
        moveRollerSpeed(IntakeConfig.ROLLER_ON_SPEED);
    }

    /** method turns the intake rollers off */
    public void rollersOff() {
        moveRollerSpeed(IntakeConfig.ROLLER_STOP_SPEED);
    }

    /** method move intake rollers in the opposite direction */
    public void rollersReverse() {
        rollerMotor.set(IntakeConfig.ROLLER_REVERSE_SPEED);
    }

    /**
     * method moves the angle of the intake
     *
     * @param angle
     */
    public void moveAngle(Angle angle) {
        Angle targetAngle =
                Rotations.of(
                        MathUtil.clamp(
                                angle.in(Rotations),
                                IntakeConst.MIN_ANGLE.in(Rotations),
                                IntakeConst.MAX_ANGLE.in(Rotations)));
        deployMotor.setControl(new MotionMagicVoltage(targetAngle));
    }

    /** method moves the intake down */
    public void moveDown() {
        moveAngle(IntakeConst.MIN_ANGLE);
    }

    /** method moves the intake up */
    public void moveUp() {
        moveAngle(IntakeConst.MAX_ANGLE);
    }

    /** method deploys the intake(turns the rollers on and moves the intake down) */
    public void deploy() {
        moveDown();
        rollersOn();
    }

    /** method stows the intake(turns the rollers off and moves the intake up) */
    public void stow() {
        rollersOff();
        moveUp();
    }

    /** method returns the current position of the angle(angle) */
    public Angle getCurrAngle() {
        return deployMotor.getPosition().getValue();
    }

    @Override
    public void initSendable(SendableBuilder builder) {
        builder.addDoubleProperty(
                "angle (deg)",
                () -> getCurrAngle().in(Rotations),
                (angle) -> moveAngle(Degrees.of(angle)));
    }
}
