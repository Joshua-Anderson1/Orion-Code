/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;

public class MechanumDrive extends Command {
  public MechanumDrive() {
    requires(Robot.mechanumDriveMethod);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    boolean trigger = false;
    if(Robot.m_oi.bigBoiDriver.getRawAxis(2) > 0.25){
      trigger = true;
    }
    Robot.mechanumDriveMethod.BigBoiDrive(Robot.m_oi.bigBoiDriver.getRawAxis(0), Robot.m_oi.bigBoiDriver.getRawAxis(1), Robot.m_oi.bigBoiDriver.getRawAxis(4), trigger);
    SmartDashboard.putNumber("Front Left Motor", RobotMap.frontLeft.get());
    SmartDashboard.putNumber("Front Right Motor", RobotMap.frontRight.get());
    SmartDashboard.putNumber("Rear Left Motor", RobotMap.rearLeft.get());
    SmartDashboard.putNumber("Rear Right Motor", RobotMap.rearRight.get());
    SmartDashboard.putNumber("Other Y Axis", Robot.m_oi.bigBoiDriver.getRawAxis(0));
    SmartDashboard.putNumber("Other X Axis", Robot.m_oi.bigBoiDriver.getRawAxis(1));
    //SmartDashboard.putBoolean("Bumper", Robot.m_oi.bigBoiDriver.getRawButton(5));
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
