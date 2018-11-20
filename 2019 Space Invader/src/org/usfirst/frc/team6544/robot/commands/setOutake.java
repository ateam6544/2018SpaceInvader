package org.usfirst.frc.team6544.robot.commands;

import org.usfirst.frc.team6544.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class setOutake extends InstantCommand {
	private double speed;
    public setOutake(double speed) {
       requires(Robot.claw);
       this.speed = speed;
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.claw.setClawLeft(speed);
    	Robot.claw.setClawRight(speed);
    }

}
