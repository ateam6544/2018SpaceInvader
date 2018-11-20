package org.usfirst.frc.team6544.robot.commands;

import org.usfirst.frc.team6544.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class InitStop2Lift extends InstantCommand {

    public InitStop2Lift() {
        super();
        // Use requires() here to declare subsystem dependencies
        requires(Robot.liftsystem);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.liftsystem.stopTop2Manual();
    }

}
