package frc.robot.trajectory;

import static edu.wpi.first.units.Units.Degrees;
import static edu.wpi.first.units.Units.MetersPerSecond;
import static edu.wpi.first.units.Units.Radians;

import edu.wpi.first.math.geometry.Pose3d;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.LinearVelocity;

import frc.robot.hood.HoodConst;

public class Trajectory {

    public static final double MODEL_C1 = 18.18081;
    public static final double MODEL_C2 = 9.66252;
    public static final double MODEL_C3 = 1.21676;
    public static final double MODEL_C4 = 0.00849423;
    public static final double MODEL_C5 = -2.4087;

    /** returns the distance between hub and robot x-axis field coord system */
    public static double getXDistanceHubtoRobot(Pose3d robotPosition) {
        return FieldConst.HUB_X - robotPosition.transformBy(FieldConst.LAUNCHER_TRANSFORM).getX();
    }

    /** returns the distance between hub and robot y-axis field coord system */
    public static double getYDistanceHubtoRobot(Pose3d robotPosition) {
        return FieldConst.HUB_Y - robotPosition.transformBy(FieldConst.LAUNCHER_TRANSFORM).getY();
    }

    /** returns the height distance between hub and robot */
    public static double getZDistanceHubtoRobot(Pose3d robotPosition) {
        return FieldConst.HUB_HEIGHT
                - robotPosition.transformBy(FieldConst.LAUNCHER_TRANSFORM).getZ();
    }

    /** returns the robots current rotation */
    public static Angle getRobotRotation(Pose3d robotPosition) {
        return Radians.of(
                robotPosition.transformBy(FieldConst.LAUNCHER_TRANSFORM).getRotation().getZ());
    }

    /** return angle to move to shoot at hub */
    public static Angle getTurretToShootYaw(Pose3d robotPosition) {
        robotPosition = robotPosition.transformBy(FieldConst.LAUNCHER_TRANSFORM);
        return Degrees.of(
                        Math.atan(
                                getXDistanceHubtoRobot(robotPosition)
                                        / getYDistanceHubtoRobot(robotPosition)))
                .minus(getRobotRotation(robotPosition));
    }

    /** returns the linear velocity(mps) to need to make it in the hub */
    public static LinearVelocity getLinearVelocity(Pose3d robotPosition) {
        robotPosition = robotPosition.transformBy(FieldConst.LAUNCHER_TRANSFORM);
        double hypotenuse =
                Math.hypot(
                        getXDistanceHubtoRobot(robotPosition),
                        getYDistanceHubtoRobot(robotPosition));
        double verticalDisplacement = getYDistanceHubtoRobot(robotPosition);
        return MetersPerSecond.of(
                hypotenuse
                        / Math.cos(HoodConst.SHOOTER_ANGLE.in(Radians))
                        * Math.sqrt(
                                FieldConst.g
                                        / (2
                                                * (hypotenuse
                                                        * Math.tan(
                                                                HoodConst.SHOOTER_ANGLE.in(Radians)
                                                                        - verticalDisplacement)))));
    }

    public static double estimateFlywheelSpeed(double launchSpeed, double launchPitch) {
        return (Math.log(
                                (MODEL_C1 + MODEL_C2 * launchPitch) / launchSpeed
                                        - MODEL_C3 * launchPitch
                                        - 1)
                        + MODEL_C5)
                / -MODEL_C4;
    }
}
