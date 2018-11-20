package org.usfirst.frc.team6544.robot.commands;

import org.usfirst.frc.team6544.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TimeBaseline extends Command {

	boolean timeToggle, finishToggle;
	double startTime, currentTime, duration, setTime;
	
    public TimeBaseline() {
        requires(Robot.drivesystem);
        timeToggle = true;
        finishToggle = false;
        
        setTime = 3;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (timeToggle == true) {
    		startTime = System.currentTimeMillis();
    		timeToggle = false;
    	}
    	
    	currentTime = System.currentTimeMillis();
    	duration = (currentTime - startTime) / 1000;
    	
    	if (duration <= setTime) {
    		Robot.drivesystem.arcadeDrive(0.7, 0);
    	}
    	else {
    		finishToggle = true;
    		
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finishToggle;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
