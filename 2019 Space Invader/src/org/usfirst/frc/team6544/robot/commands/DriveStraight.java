package org.usfirst.frc.team6544.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6544.robot.Robot;
import org.usfirst.frc.team6544.robot.RobotMap;
import org.usfirst.frc.team6544.robot.subsystems.DriveSystem;

/**
 *Command used to drive the robot straight
 *@Param speed sets the Drive System speed
 *@Param distance sets the robot to go straight until distance is reached
 */
	public class DriveStraight extends Command {
		private double speed;
		private double distance;
		public DriveStraight(double speed, double distance) {
			requires(Robot.drivesystem);
			this.speed = speed;
			this.setDistance(distance);
		}

		// Called just before this Command runs the first time
		@Override
		protected void initialize() {
			Robot.drivesystem.reset();
			Robot.drivesystem.resetDistance();
		}

		protected void execute() {
			while(DriveSystem.getDistance() <= RobotMap.driveDistance) {
			Robot.drivesystem.arcadeDrive(speed,-Robot.drivesystem.getAngle() * RobotMap.scalingConstant);	
			}
			RobotMap.stopDrive = true;
		}
		// Make this return true when this Command no longer needs to run execute()
		@Override
		protected boolean isFinished() {
			return RobotMap.stopDrive;
		}

		// Called once after isFinished returns true
		@Override
		protected void end() {
			Robot.drivesystem.stop();
		}

		public double getDistance() {
			return distance;
		}

		public void setDistance(double distance) {
			this.distance = distance;
		}
	}
