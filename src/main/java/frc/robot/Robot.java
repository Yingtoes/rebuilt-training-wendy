// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import static edu.wpi.first.units.Units.MetersPerSecond;
import static edu.wpi.first.units.Units.Radians;
import static edu.wpi.first.units.Units.RotationsPerSecond;

import com.ctre.phoenix6.swerve.SwerveModule.DriveRequestType;
import com.ctre.phoenix6.swerve.SwerveRequest;

import edu.wpi.first.math.geometry.Pose3d;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.LinearVelocity;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

import frc.robot.drivetrain.CommandSwerveDrivetrain;
import frc.robot.drivetrain.DriveConfig;
import frc.robot.feeder.FeederSubsystem;
import frc.robot.hood.HoodConst;
import frc.robot.hood.HoodSubsystem;
import frc.robot.intake.IntakeSubsystem;
import frc.robot.shooter.ShooterSubsystem;
import frc.robot.spindexer.SpindexSubsystem;
import frc.robot.trajectory.Trajectory;
import frc.robot.turret.TurretSubsystem;

public class Robot extends TimedRobot {

    private final SpindexSubsystem spindexer = new SpindexSubsystem();
    private final IntakeSubsystem intake = new IntakeSubsystem();
    private final FeederSubsystem feeder = new FeederSubsystem();
    private final HoodSubsystem hood = new HoodSubsystem();
    private final ShooterSubsystem shooter = new ShooterSubsystem();
    private final TurretSubsystem turret = new TurretSubsystem();
    private final CommandSwerveDrivetrain drivetrain = new CommandSwerveDrivetrain(null, null);
    private final CommandXboxController controller =
            new CommandXboxController(DriveConfig.CONTROLLER_PORT);

    public Robot() {
        initBindings();
        initDashboard();
    }

    public void initDashboard() {
        SmartDashboard.putData("Spindexer", spindexer);
        SmartDashboard.putData("Intake", intake);
        SmartDashboard.putData("Feeder", feeder);
        SmartDashboard.putData("Hood", hood);
        SmartDashboard.putData("Shooter", shooter);
    }

    public void initBindings() {
        controller
                .leftBumper()
                .whileTrue(new StartEndCommand(spindexer::start, spindexer::stop, spindexer));
        controller.povDown().onTrue(intake.runOnce(intake::deploy));
        controller.povUp().onTrue(intake.runOnce(intake::stow));
        drivetrain.setDefaultCommand(
                drivetrain.applyRequest(
                        () ->
                                getSwerveRequest(
                                        -controller.getLeftY(),
                                        -controller.getLeftX(),
                                        -controller.getRightX())));
    }

    public Command autoAim() {
        Pose3d robotPose = new Pose3d(drivetrain.getState().Pose);
        Angle turretYaw = Trajectory.getTurretToShootYaw(robotPose);
        LinearVelocity shootLinearVelocity = Trajectory.getLinearVelocity(robotPose);
        double flywheelSpeed =
                Trajectory.estimateFlywheelSpeed(
                        shootLinearVelocity.in(MetersPerSecond),
                        HoodConst.SHOOTER_ANGLE.in(Radians));
        return Commands.parallel(
                turret.runOnce(() -> turret.moveYaw(turretYaw)),
                shooter.runOnce(
                        () -> shooter.moveAngularVelocity(RotationsPerSecond.of(flywheelSpeed))));
    }

    public SwerveRequest getSwerveRequest(double xThrottle, double yThrottle, double rotThrottle) {
        if (!DriveConfig.ENABLED) {
            return new SwerveRequest.Idle();
        }
        SwerveRequest.FieldCentric joystickRelativeToField =
                new SwerveRequest.FieldCentric()
                        .withDeadband(DriveConfig.DEADBAND_MAX_SPEED)
                        .withRotationalDeadband(DriveConfig.DEADBAND_MAX_ANGULAR_VELOCITY)
                        .withDriveRequestType(DriveRequestType.Velocity);
        return joystickRelativeToField
                .withVelocityX(DriveConfig.MAX_SPEED.times(xThrottle))
                .withVelocityY(DriveConfig.MAX_SPEED.times(yThrottle))
                .withRotationalRate(DriveConfig.MAX_ANGULAR_VELOCITY.times(rotThrottle));
    }

    @Override
    public void robotInit() {}

    @Override
    public void robotPeriodic() {
        // CommandScheduler.getInstance().schedule(autoAim());
        // CommandScheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() {}

    @Override
    public void autonomousPeriodic() {}

    @Override
    public void teleopInit() {}

    @Override
    public void teleopPeriodic() {}

    @Override
    public void disabledInit() {}

    @Override
    public void disabledPeriodic() {}

    @Override
    public void testInit() {}

    @Override
    public void testPeriodic() {}

    @Override
    public void simulationInit() {}

    @Override
    public void simulationPeriodic() {}
}
