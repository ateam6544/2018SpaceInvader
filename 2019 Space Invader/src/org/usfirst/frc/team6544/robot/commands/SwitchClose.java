package org.usfirst.frc.team6544.robot.commands;

import org.usfirst.frc.team6544.robot.Robot;
import org.usfirst.frc.team6544.robot.subsystems.DriveSystem;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SwitchClose extends Command {
	private double drive1Loop = 0;
	private boolean isfinished = false;
	private double scalingConstant = 0.3;
    public SwitchClose() {
       requires(Robot.drivesystem);
       requires(Robot.liftsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		if(DriveSystem.getDistance() !=0) {
    		Robot.drivesystem.resetDistance();
    	}
		if(gameData.length() == 3) {
			if(gameData.charAt(0)=='L') {
    	while(drive1Loop < 350) {
    		double driveAngle = Robot.drivesystem.getAngle();
    		Robot.drivesystem.arcadeDrive(-0.6, -driveAngle * scalingConstant);
    		Timer.delay(0.01);
    		drive1Loop++;
    	}
    	 double driveAngle = 0;
     	while (driveAngle < 75){
         	driveAngle = Robot.drivesystem.getAngle();
       		Robot.drivesystem.arcadeDrive(0.35, -driveAngle * scalingConstant );
       	 Timer.delay(0.01);                      //creates a delay
       }
     	Timer.delay(0.1);
     	Robot.claw.clawDown();
     	Timer.delay(0.1);
			}else if(gameData.charAt(0)=='R') {	 
				while(DriveSystem.getDistance() < 150) {
		    		double driveAngle = Robot.drivesystem.getAngle();
		    		Robot.drivesystem.arcadeDrive(-0.6, -driveAngle * scalingConstant);
		    		Timer.delay(0.01);
		    	}
				   double driveAngle = 0;
			     	while (driveAngle < 90){
			         	driveAngle = Robot.drivesystem.getAngle();
			       		Robot.drivesystem.arcadeDrive(0.35, -driveAngle * scalingConstant );
			       	 Timer.delay(0.01);                      //creates a delay
			       }
			     	Robot.drivesystem.resetDistance();
			     	while(DriveSystem.getDistance() < 150) {
			    		double driveAngle1 = Robot.drivesystem.getAngle();
			    		Robot.drivesystem.arcadeDrive(-0.6, -driveAngle1 * scalingConstant);
			    		Timer.delay(0.01);
			    	}
			}
		}
		
    	isfinished = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(isfinished == true) {
    		drive1Loop = 0;
    	}
        return isfinished;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
