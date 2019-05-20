/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.MechanumDrive;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 * Add your docs here.
 */
public class MechanumDriveMethod extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public void BigBoiDrive(double x, double y, double z, boolean trigger){
    double LeftFrontOutput = 0.0;
    double RightFrontOutput = 0.0;
    double LeftRearOutput = 0.0;
    double RightRearOutput = 0.0;
    if(x > -0.25 && x < 0.25){
      x = 0.0;
    }
    if(y > -0.25 && y < 0.25){
      y = 0.0;
    }
    if(z > -0.25 && z < 0.25){
      z = 0.0;
    }
    SmartDashboard.putNumber("Z Axis", z);
    SmartDashboard.putNumber("Y Axis", y);
    SmartDashboard.putNumber("X Axis", x);
    if(y > 0.0){
      if(x == 0.0){
        LeftFrontOutput = y * -1.0;
        RightFrontOutput = y;
        LeftRearOutput = y * -1.0;
        RightRearOutput = y;
      } else if(x < 0.0){
        LeftFrontOutput = 0.0;
        RightFrontOutput = y;
        LeftRearOutput = y * -1.0;
        RightRearOutput = 0.0;
      } else{
        LeftFrontOutput = y * -1.0;
        RightFrontOutput = 0.0;
        LeftRearOutput = 0.0;
        RightRearOutput = y;
      }
    } else if(y < 0.0){
      if(x == 0.0){
        LeftFrontOutput = y * -1.0;
        RightFrontOutput = y;
        LeftRearOutput = y * -1.0;
        RightRearOutput = y;
      } else if(x < 0.0){
        LeftFrontOutput = y * -1.0;
        RightFrontOutput = 0.0;
        LeftRearOutput = 0.0;
        RightRearOutput = y;
      } else{
        LeftFrontOutput = 0.0;
        RightFrontOutput = y;
        LeftRearOutput = y * -1.0;
        RightRearOutput = 0.0;
      }
    } else{
        if(z > 0.0){
          LeftFrontOutput = z * -1.0;
          RightFrontOutput = z * -1.0;
          LeftRearOutput = z;
          RightRearOutput = z;
        } else if (z < 0.0){
          LeftFrontOutput = z * -1.0;
          RightFrontOutput = z * -1.0;
          LeftRearOutput = z;
          RightRearOutput = z;
      } else{
          LeftFrontOutput = x;
          RightFrontOutput = x;
          LeftRearOutput = x;
          RightRearOutput = x;
      }
    }
    if(trigger){
      LeftFrontOutput /= 2;
      RightFrontOutput /= 2;
      LeftRearOutput /= 2;
      RightRearOutput /= 2;
    }
    RobotMap.frontLeft.set(LeftFrontOutput);
    RobotMap.frontRight.set(RightFrontOutput);
    RobotMap.rearLeft.set(LeftRearOutput);
    RobotMap.rearRight.set(RightRearOutput);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new MechanumDrive());
  }
}
