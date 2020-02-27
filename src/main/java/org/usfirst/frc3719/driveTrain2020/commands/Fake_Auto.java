/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc3719.driveTrain2020.commands;

import org.usfirst.frc3719.driveTrain2020.Robot;

import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * Add your docs here.
 */
public class Fake_Auto extends CommandBase {
  /**
   * Add your docs here.
   */
  public Fake_Auto(double timeout) {
    super();
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    Robot.drivetrainSub.DriveMotor(.7);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
  }

  // Called once after timeout
  @Override
  public void end(boolean interrupted) {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  
}
