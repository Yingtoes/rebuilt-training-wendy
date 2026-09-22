package frc.robot.drivetrain;

import static edu.wpi.first.units.Units.MetersPerSecond;
import static edu.wpi.first.units.Units.RotationsPerSecond;

import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.LinearVelocity;

public class DriveConfig {
    public static int CONTROLLER_PORT = 0;
    public static boolean ENABLED = false;
    public static LinearVelocity MAX_SPEED = MetersPerSecond.of(3);
    public static AngularVelocity MAX_ANGULAR_VELOCITY = RotationsPerSecond.of(7.5);
    public static double DEADBAND = 0.1;
    public static LinearVelocity DEADBAND_MAX_SPEED = MAX_SPEED.times(DEADBAND);
    public static AngularVelocity DEADBAND_MAX_ANGULAR_VELOCITY =
            MAX_ANGULAR_VELOCITY.times(DEADBAND);
}
