package frc.robot.intake;

import static edu.wpi.first.units.Units.Degrees;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.NeutralModeValue;

public class IntakeConfig {

    public static final TalonFXConfiguration deployMotorConfig = new TalonFXConfiguration();
    public static final TalonFXConfiguration rollerMotorConfig = new TalonFXConfiguration();

    public static double ROLLER_ON_SPEED = 0.5;
    public static double ROLLER_STOP_SPEED = 0;
    public static double ROLLER_REVERSE_SPEED = -0.5;

    static {
        deployMotorConfig.MotorOutput.NeutralMode = NeutralModeValue.Coast;
        rollerMotorConfig.MotorOutput.NeutralMode = NeutralModeValue.Coast;

        deployMotorConfig.Feedback.SensorToMechanismRatio = IntakeConst.GEAR_RATIO;
        deployMotorConfig.SoftwareLimitSwitch.ForwardSoftLimitEnable = true;
        deployMotorConfig.SoftwareLimitSwitch.ForwardSoftLimitThreshold =
                IntakeConst.MAX_ANGLE.in(Degrees);
        deployMotorConfig.SoftwareLimitSwitch.ReverseSoftLimitThreshold =
                IntakeConst.MIN_ANGLE.in(Degrees);
    }
}
