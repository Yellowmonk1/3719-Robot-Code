/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc3719.driveTrain2020.commands;

import org.usfirst.frc3719.driveTrain2020.Robot;
import org.usfirst.frc3719.driveTrain2020.subsystems.ColorWheel;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class SpinColorWheelRotation extends CommandBase {
  /**
   * Creates a new SpinColorWheelRotation.
   */
  public SpinColorWheelRotation() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    ColorWheel.redLineEncoder.reset();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
   ColorWheel.CPMotorControlRotation();

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
   if(ColorWheel.redLineEncoder.getDistance() < (((Robot.oi.circOfControlPanel / Robot.oi.circOfWheel) * 1024)/3 )){ 
     return false;
   }
   else{
      return true;
    }
  }
}
