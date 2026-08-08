package frc.robot.spindexer;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SpindexSubsystem extends SubsystemBase {
    public TalonFX motor = new TalonFX(SpindexerConst.MOTOR_ID);

    public SpindexSubsystem() {
        motor.getConfigurator().apply(SpindexerConfig.motorConfig);
    }

    public void moveMotorSpeed(double speed) {
        motor.set(speed);
    }

    public void start() {
        moveMotorSpeed(SpindexerConfig.START_SPEED);
    }

    public void stop() {
        moveMotorSpeed(0.0);
    }

    public double getMotorSpeed() {
        return motor.get();
    }

    @Override
    public void initSendable(SendableBuilder builder) {
        builder.addDoubleProperty("motor speed(frac)", this::getMotorSpeed, this::moveMotorSpeed);
        builder.addDoubleProperty(
                "motor velocity()", () -> motor.getVelocity().getValueAsDouble(), null);
    }
}
