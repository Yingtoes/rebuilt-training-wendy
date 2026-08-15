package frc.robot.hood;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

public class HoodConfig {
    public static TalonFXConfiguration motorConfig = new TalonFXConfiguration();
    public static double STATOR_CURRENT_LIMIT = 80.0;

    static {
        motorConfig.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;
        motorConfig.CurrentLimits.StatorCurrentLimit = STATOR_CURRENT_LIMIT;
        motorConfig.MotorOutput.NeutralMode = NeutralModeValue.Brake;
    }
}
