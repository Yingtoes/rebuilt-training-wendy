package frc.robot.turret;

import static edu.wpi.first.units.Units.Degrees;

import com.ctre.phoenix6.configs.CANcoderConfiguration;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.FeedbackSensorSourceValue;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.ctre.phoenix6.signals.SensorDirectionValue;

import edu.wpi.first.units.measure.Angle;

public class TurretConfig {
    public static TalonFXConfiguration motorConfig = new TalonFXConfiguration();
    public static CANcoderConfiguration encoderConfig = new CANcoderConfiguration();
    public static double STATOR_CURRENT_LIMIT = 30.0;
    public static Angle ERROR_TOLERANCE = Degrees.of(3);

    static {
        motorConfig.CurrentLimits.StatorCurrentLimit = STATOR_CURRENT_LIMIT;
        motorConfig.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;
        motorConfig.MotorOutput.NeutralMode = NeutralModeValue.Brake;
        motorConfig.Feedback.FeedbackSensorSource = FeedbackSensorSourceValue.RemoteCANcoder;
        motorConfig.Feedback.FeedbackRemoteSensorID = TurretConst.ENCODER_ID;
        motorConfig.Feedback.SensorToMechanismRatio = TurretConst.ENCODER_TO_MECHANISM_RATIO;
    }

    static {
        encoderConfig.MagnetSensor.MagnetOffset = -0.444;
        encoderConfig.MagnetSensor.SensorDirection = SensorDirectionValue.Clockwise_Positive;
    }
}
