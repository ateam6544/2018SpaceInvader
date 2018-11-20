package org.usfirst.frc.team6544.robot.commands;

import org.usfirst.frc.team6544.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *Command used to activate and deactivate the brake
 *@Param stat true activates the clamp
 *@Param stat false deactivates the clamp
 */
public class SetClamp extends InstantCommand {
    public SetClamp() {
       requires(Robot.mast1);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.mast1.deactivateClamp();
    }

}
