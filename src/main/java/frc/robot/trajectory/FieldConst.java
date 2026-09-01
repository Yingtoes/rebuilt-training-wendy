package frc.robot.trajectory;

import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.math.geometry.Transform3d;

public class FieldConst {
    public static double HUB_X = 182.11 / 39.3701;
    public static double HUB_Y = 158.84 / 39.3701;
    public static double HUB_HEIGHT = 72.00 / 39.3701;

    public static double g = 9.8;
    public static Transform3d LAUNCHER_TRANSFORM =
            new Transform3d(2.6967, 4.50, 17.9, Rotation3d.kZero);
}
