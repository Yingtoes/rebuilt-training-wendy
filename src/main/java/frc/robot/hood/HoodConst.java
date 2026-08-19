package frc.robot.hood;

import static edu.wpi.first.units.Units.Degrees;

import com.ctre.phoenix6.CANBus;

import edu.wpi.first.units.measure.Angle;

public class HoodConst {
    public static int MOTOR_ID = -1; // TODO
    public static CANBus LAUNCHER_CANBUS = new CANBus("launcher");
    public static Angle MAX_ANGLE = Degrees.of(73.606);
    public static Angle MIN_ANGLE = Degrees.of(0);
    public int ROTOR_TO_MECHANISM = 24;
}
