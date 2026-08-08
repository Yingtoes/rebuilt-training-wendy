package frc.robot;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SpindexSubsystem extends SubsystemBase {
    public TalonFX motor = new TalonFX(-1);
    private static final TalonFXConfiguration motorConfig = new TalonFXConfiguration();

    static {
        motorConfig.CurrentLimits.StatorCurrentLimit = 80.0;
        motorConfig.MotorOutput.NeutralMode = NeutralModeValue.Coast;
        motorConfig.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;
    }

    public SpindexSubsystem() {
        motor.getConfigurator().apply(motorConfig);
    }

    public void moveMotorSpeed(double speed) {
        motor.set(speed);
    }

    public void start() {
        moveMotorSpeed(0.5);
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
