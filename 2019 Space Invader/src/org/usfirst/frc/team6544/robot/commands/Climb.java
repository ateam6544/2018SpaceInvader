package org.usfirst.frc.team6544.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Climb extends CommandGroup {

    public Climb() {
       addParallel(new clawDown());
       addSequential(new ShiftLow());
       addParallel(new goBottom1Manual());//sets clamp to deactivate and starts mast down
    }
}
