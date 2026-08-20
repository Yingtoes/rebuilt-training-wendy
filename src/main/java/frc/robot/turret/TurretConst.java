package frc.robot.turret;

import static edu.wpi.first.units.Units.Degrees;

import edu.wpi.first.units.measure.Angle;

public class TurretConst {
    public static int MOTOR_ID = -1; // TODO
    public static int ENCODER_ID = -1; // TODO
    public static Angle MAX_ANGLE = Degrees.of(180);
    public static Angle MIN_ANGLE = Degrees.of(-270);
    public static Angle STOW_ANGLE = Degrees.of(0);

    public static double ENCODER_TO_MECHANISM_RATIO = 8.5;
}
