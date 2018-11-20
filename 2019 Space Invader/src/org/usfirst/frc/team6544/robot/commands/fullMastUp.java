package org.usfirst.frc.team6544.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class fullMastUp extends CommandGroup {

	public fullMastUp() {
		    addSequential(new deactivateBrake());
    		addParallel(new goUp1Auto());
        	addParallel(new gripperMastAutoUp());    
    }
}
