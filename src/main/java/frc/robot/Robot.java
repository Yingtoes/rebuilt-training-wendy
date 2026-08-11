// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

import frc.robot.intake.IntakeSubsystem;
import frc.robot.spindexer.SpindexSubsystem;

public class Robot extends TimedRobot {

    private final SpindexSubsystem spindexer = new SpindexSubsystem();
    private final IntakeSubsystem intake = new IntakeSubsystem();
    private final CommandXboxController controller = new CommandXboxController(0);

    public Robot() {
        initBindings();
        initDashboard();
    }

    public void initDashboard() {
        SmartDashboard.putData("Spindexer", spindexer);
        SmartDashboard.putData("Intake", intake);
    }

    public void initBindings() {
        controller
                .leftBumper()
                .whileTrue(new StartEndCommand(spindexer::start, spindexer::stop, spindexer));
        controller.povDown().onTrue(intake.runOnce(intake::deploy));
        controller.povUp().onTrue(intake.runOnce(intake::stow));
    }

    @Override
    public void robotInit() {}

    @Override
    public void robotPeriodic() {
        CommandScheduler.getInstance().run();
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
