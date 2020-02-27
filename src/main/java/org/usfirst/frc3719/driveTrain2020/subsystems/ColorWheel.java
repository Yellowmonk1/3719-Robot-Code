/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc3719.driveTrain2020.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;

import org.usfirst.frc3719.driveTrain2020.Robot;
import org.usfirst.frc3719.driveTrain2020.commands.SpinColorWheelRotation;
import org.usfirst.frc3719.driveTrain2020.commands.SpinColorWheelPosition;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * Add your docs here.
 */
public class ColorWheel extends SubsystemBase {
 

  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  /**
   * Creates a new ColorWheel.
   */

   
  public final static WPI_TalonSRX controlPanelSpinner = new WPI_TalonSRX(5);
  private char colorCase;
  private final I2C.Port i2cPort = I2C.Port.kOnboard; 
  private final ColorSensorV3 colorSensor = new ColorSensorV3(i2cPort);
  private final ColorMatch colorMatcher = new ColorMatch();
  private static final Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
  private static final Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
  private static final Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
  private static final Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);

  public static Encoder redLineEncoder = new Encoder(1, 2, false, Encoder.EncodingType.k1X);
  private Color detectedColor;
  public static ColorMatchResult match;
  private String colorString;
  private final int proximity = colorSensor.getProximity();

  @Override
  public void periodic() {
    
    colorMatcher.addColorMatch(kBlueTarget);
    colorMatcher.addColorMatch(kGreenTarget);
    colorMatcher.addColorMatch(kRedTarget);
    colorMatcher.addColorMatch(kYellowTarget);
    detectedColor = colorSensor.getColor();
    match = colorMatcher.matchClosestColor(detectedColor);

    if (match.color == kBlueTarget) {
      colorString = "Blue";
    } else if (match.color == kRedTarget) {
      colorString = "Red";
    } else if (match.color == kGreenTarget) {
      colorString = "Green";
    } else if (match.color == kYellowTarget) {
      colorString = "Yellow";
    } else {
      colorString = "Unknown";
    }
    final double IR = colorSensor.getIR();

    /*SmartDashboard.putNumber("Red", detectedColor.red);
    SmartDashboard.putNumber("Blue", detectedColor.blue);
    SmartDashboard.putNumber("Green", detectedColor.green);
    SmartDashboard.putNumber("IR", IR);

    SmartDashboard.putNumber("Proximity", proximity);
    SmartDashboard.putNumber("Confidence", match.confidence);
    SmartDashboard.putString("Detected Color", colorString);*/
   
    SmartDashboard.putNumber("Encoder Value", redLineEncoder.get());
    String gameData;
    gameData = DriverStation.getInstance().getGameSpecificMessage();
    if (gameData.length() > 0) {
      switch (gameData.charAt(0)) {
      case 'B':
        Robot.colorCase = kRedTarget;

        // Blue case code
        break;
      case 'G':
        Robot.colorCase = kYellowTarget;

        // Green case code
        break;
      case 'R':
        Robot.colorCase = kBlueTarget;

        // Red case code
        break;
      case 'Y':
        Robot.colorCase = kGreenTarget;

        // Yellow case code
        break;
      default:
        // This is corrupt data
        break;
      }

    }

  }

  public static void CPMotorControlPosition() {
    //redLineEncoder.setDistancePerPulse(1./1024.);
    if (Robot.colorCase != match.color  ) {
      //if(redLineEncoder.getDistance() < (Robot.oi.circOfControlPanel / (Robot.oi.circOfWheel / 1024))){
        controlPanelSpinner.set(.353 );
      }
      else if(Robot.colorCase == match.color){
        controlPanelSpinner.set(0);
        redLineEncoder.reset();
      }
     }
     public static void StopColorWheel(){
      redLineEncoder.setDistancePerPulse(1./1024.);
       while(redLineEncoder.getDistance() < 0){
         controlPanelSpinner.set(-.2);
       }
     }
     
     
  

  
  public static void CPMotorControlRotation(){
    redLineEncoder.setDistancePerPulse(Robot.oi.circOfWheel/1024);
    if(redLineEncoder.getDistance() < (((Robot.oi.circOfControlPanel / Robot.oi.circOfWheel) * 1024/3))){
      controlPanelSpinner.set(.353);
      SmartDashboard.putNumber("Distance", redLineEncoder.getDistance());
    }
    else{
      controlPanelSpinner.set(0);
      
    }
  }
    
  }
  
  