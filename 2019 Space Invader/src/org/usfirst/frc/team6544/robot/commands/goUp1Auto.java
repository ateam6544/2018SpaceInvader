package org.usfirst.frc.team6544.robot.commands;

import org.usfirst.frc.team6544.robot.Robot;
import org.usfirst.frc.team6544.robot.subsystems.MainMast;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class goUp1Auto extends Command {

    public goUp1Auto() {
       requires(Robot.mast1);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.mast1.goUp();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return MainMast.getTopLimit();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.mast1.activateClamp();
    	Robot.mast1.stop();
    }
}
