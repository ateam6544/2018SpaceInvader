package org.usfirst.frc.team6544.robot.commands;

import org.usfirst.frc.team6544.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class SlowOutake extends InstantCommand {

    public SlowOutake() {
       requires(Robot.claw);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.claw.intakeLeftSlow();
    	Robot.claw.intakeRightSlow();
    }

}
