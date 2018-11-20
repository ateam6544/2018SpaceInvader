package org.usfirst.frc.team6544.robot.commands;

import org.usfirst.frc.team6544.robot.Robot;
import org.usfirst.frc.team6544.robot.RobotMap;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class gripperMastAutoDown extends InstantCommand {

	public gripperMastAutoDown() {
      requires(Robot.liftsystem);
    }

    // Called once when the command executes
    protected void initialize() {
    		Robot.liftsystem.enablePID(RobotMap.bottomEncoderLimit);
    }
    
	protected void interrupted() {
    	Robot.liftsystem.stopTop2Manual();
    }
}
