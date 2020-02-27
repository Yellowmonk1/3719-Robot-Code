/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc3719.driveTrain2020.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import org.usfirst.frc3719.driveTrain2020.commands.*;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Servo;


/**
 * Add your docs here.
 */
public class Lifter extends SubsystemBase {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
private Servo servo1;
  private WPI_VictorSPX winch2;
  private WPI_TalonSRX winch1;
  private SpeedControllerGroup speedControllerGroup1;
  public static DigitalInput limitSwitchLifter;
  //static Counter counter = new Counter(limitSwitchLifter);
  public Lifter() {
    Servo servo1 = new Servo(0);
addChild("Servo 1",servo1);

  winch2 = new WPI_VictorSPX(8);
        addChild("Speed Controller 1",winch2);
        winch2.setInverted(false);
        
        winch1 = new WPI_TalonSRX(9);
        addChild("Speed Controller 2",winch1);
        winch1.setInverted(false);
        
        speedControllerGroup1 = new SpeedControllerGroup(winch2, winch1  );
        addChild("Speed Controller Group 1",speedControllerGroup1);
  }
  @Override
  public void periodic() {

  }
  public void pawlLockOpen(){
    servo1.set(1);
  }
  public void pawlLockClosed(){
    servo1.set(0);
  }
  public double pawlLockValue(){
    servo1.get();
    return servo1.get();
  }
  public void lifterUp(){
    speedControllerGroup1.set(.3);
  }
  public void lifterDown(){
    speedControllerGroup1.set(-.3);
  }


 /* public static boolean isSwitchSet() {
    return counter.get() > 0;
  }*/
  
}
