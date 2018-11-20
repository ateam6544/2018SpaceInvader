package org.usfirst.frc.team6544.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class FullMastDown extends CommandGroup {

    public FullMastDown() {
    	addSequential(new deactivateBrake());
        addSequential(new goBottom1Auto());
        addSequential(new gripperMastAutoDown());
    }
}
