/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc3719.driveTrain2020.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

public class ManipulatorIntake extends SubsystemBase {
  private WPI_VictorSPX rightintake;
  private WPI_TalonSRX leftintake;
  private SpeedControllerGroup speedControllerGroup2;
  /**
   * Creates a new ManipulatorIntake.
   */
  public ManipulatorIntake() {
    
    rightintake = new WPI_VictorSPX(10);
    addChild("Speed Controller 3", rightintake);

    leftintake = new WPI_TalonSRX(11);
    addChild("Speed Controller 4", leftintake);
    
    speedControllerGroup2 = new SpeedControllerGroup(rightintake, leftintake);
    addChild("Speed Controller Group 2", speedControllerGroup2);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void setIntake(double Intake){
    speedControllerGroup2.set(Intake);
}
}
