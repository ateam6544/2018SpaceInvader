package org.usfirst.frc.team6544.robot.commands;

import org.usfirst.frc.team6544.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class activateClamp extends InstantCommand {

    public activateClamp() {
        requires(Robot.mast1);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.mast1.activateClamp();
    }

}
