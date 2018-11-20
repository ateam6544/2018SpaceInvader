package org.usfirst.frc.team6544.robot.commands;

import org.usfirst.frc.team6544.robot.Robot;
import org.usfirst.frc.team6544.robot.subsystems.DriveSystem;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class SpeedControl extends InstantCommand {
	private double DriveSpeed;
    public SpeedControl(double DriveSpeed) {
       requires(Robot.drivesystem);
       this.DriveSpeed = DriveSpeed;
    }

    // Called once when the command executes
    protected void initialize() {
    	DriveSystem.DriveSpeed = this.DriveSpeed;
    }

}
