package frc.robot.feeder;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

public class FeederConfig {
    public static final TalonFXConfiguration motorConfig = new TalonFXConfiguration();
    public static double STATOR_CURRENT_LIMIT = 80.0;

    static {
        motorConfig.MotorOutput.NeutralMode = NeutralModeValue.Coast;
        motorConfig.CurrentLimits.StatorCurrentLimit = STATOR_CURRENT_LIMIT;
        motorConfig.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;
    }
}
