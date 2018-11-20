package org.usfirst.frc.team6544.robot.commands;

import org.usfirst.frc.team6544.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class goBottom1Manual extends InstantCommand {

	  public goBottom1Manual() {
	        requires(Robot.mast1);
	    }
	  
   // Called once when the command executes
   protected void initialize() {
   	Robot.mast1.deactivateClamp();
   	Robot.mast1.climb();;
   }
   @Override
   protected void interrupted() {
	   Robot.mast1.stop();
		Robot.mast1.activateClamp();
   }
}
