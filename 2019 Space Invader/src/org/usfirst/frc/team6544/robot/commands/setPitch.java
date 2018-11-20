package org.usfirst.frc.team6544.robot.commands;

import org.usfirst.frc.team6544.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 * Command to set the claw up or down
 * @param stat if set true claw will gp up
 * @param stat if set false claw will go down
 */
public class setPitch extends InstantCommand {
	
    public setPitch() {
      requires(Robot.claw);
     
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.claw.clawDown();
    }

}
