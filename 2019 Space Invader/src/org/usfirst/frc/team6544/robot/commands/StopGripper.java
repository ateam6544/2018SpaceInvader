package org.usfirst.frc.team6544.robot.commands;

import org.usfirst.frc.team6544.robot.Robot;
import org.usfirst.frc.team6544.robot.subsystems.LiftSystem;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class StopGripper extends InstantCommand {

    public StopGripper() {
       requires(Robot.liftsystem);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.liftsystem.stopTop2Manual();
    	//Robot.liftsystem.enablePID(LiftSystem.getCurrentSecondaryLiftEncoderCount());
    }

}
