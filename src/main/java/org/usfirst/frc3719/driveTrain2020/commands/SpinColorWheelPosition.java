/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc3719.driveTrain2020.commands;

import edu.wpi.first.wpilibj2.command.Command;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.CommandBase;

import com.revrobotics.ColorSensorV3;

import org.usfirst.frc3719.driveTrain2020.Robot;
import org.usfirst.frc3719.driveTrain2020.subsystems.ColorWheel;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class SpinColorWheelPosition extends CommandBase {
  
  //Encoder rS775Encoder;
  //double startCoder;
 

  /**
   * Creates a new spinColorWheel.
   */

  public SpinColorWheelPosition() {
    addRequirements(Robot.colorWheel);
    // Use addRequirements() here to declare subsystem dependencies.
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
  }
  

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    ColorWheel.CPMotorControlPosition();
  }
  public void Stop(){
    
  }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    ColorWheel.StopColorWheel();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(Robot.colorCase == Robot.colorWheel.match.color){
      return true;}
      else{return false;}
  }
}
