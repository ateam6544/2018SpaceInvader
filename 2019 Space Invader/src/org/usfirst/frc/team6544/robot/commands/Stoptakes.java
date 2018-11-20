package org.usfirst.frc.team6544.robot.commands;

import org.usfirst.frc.team6544.robot.Robot;
import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class Stoptakes extends InstantCommand {
    public Stoptakes() {
    	requires(Robot.claw);
    }
    protected void execute() {
    	Robot.claw.intakeStop();
    }
}
