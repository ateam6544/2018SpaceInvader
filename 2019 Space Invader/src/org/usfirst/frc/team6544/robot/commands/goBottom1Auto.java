package org.usfirst.frc.team6544.robot.commands;

import org.usfirst.frc.team6544.robot.Robot;
import org.usfirst.frc.team6544.robot.subsystems.MainMast;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class goBottom1Auto extends Command {

    public goBottom1Auto() {
        requires(Robot.mast1);
    }
    
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.mast1.goDown();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return MainMast.getBottomLimit();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.mast1.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.mast1.stop();
    }
}
