package org.usfirst.frc.team6544.robot.commands;

import org.usfirst.frc.team6544.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Baseline2 extends Command {
	private int loopcount = 0;
	private boolean isfinished = false;
   public Baseline2() {
	   super(14.5);
     requires(Robot.drivesystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	while(loopcount < 350) {
    		Robot.drivesystem.arcadeDrive(-0.6, 0);
    		Timer.delay(0.01);
    		loopcount++;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isfinished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivesystem.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
