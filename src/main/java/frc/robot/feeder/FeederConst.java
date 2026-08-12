package frc.robot.feeder;

import com.ctre.phoenix6.CANBus;

public class FeederConst {
    public static CANBus CAN_BUS = new CANBus();
    public static int MOTOR_ID = -1; // TODO

    public static double MOTOR_START = 0.5;
    public static double MOTOR_REVERSE = -0.5;
}
