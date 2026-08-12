package frc.robot.feeder;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class FeederSubsystem extends SubsystemBase {
    public final TalonFX motor = new TalonFX(FeederConst.MOTOR_ID, FeederConst.CAN_BUS);

    public FeederSubsystem() {
        motor.getConfigurator().apply(FeederConfig.motorConfig);
    }

    /**
     * method sets feeder speed
     *
     * @param speed
     */
    public void setMotorSpeed(double speed) {
        motor.set(speed);
    }

    /**
     * method starts up the motor
     *
     * @param speed
     */
    public void start() {
        setMotorSpeed(FeederConst.MOTOR_START);
    }

    /**
     * method reverses the motor in opposite direction
     *
     * @param speed
     */
    public void reverse() {
        setMotorSpeed(FeederConst.MOTOR_REVERSE);
    }

    /**
     * method stops motor
     *
     * @param speed
     */
    public void stop() {
        setMotorSpeed(0);
    }

    /**
     * method returns motor speed
     *
     * @param speed
     */
    public double getMotorSpeed() {
        return motor.get();
    }

    @Override
    public void initSendable(SendableBuilder builder) {
        builder.addDoubleProperty("feeder", () -> getMotorSpeed(), (speed) -> setMotorSpeed(speed));
    }
}
