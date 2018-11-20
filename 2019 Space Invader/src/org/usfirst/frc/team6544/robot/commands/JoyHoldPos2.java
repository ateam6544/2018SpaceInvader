package org.usfirst.frc.team6544.robot.commands;

import org.usfirst.frc.team6544.robot.Robot;
import org.usfirst.frc.team6544.robot.subsystems.LiftSystem;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class JoyHoldPos2 extends InstantCommand {

    public JoyHoldPos2() {
       requires(Robot.liftsystem);
    }

    // Called once when the command executes
    protected void initialize() {
    	//Robot.liftsystem.enablePID(LiftSystem.getCurrentSecondaryLiftEncoderCount());
//    	if(LiftSystem.getCurrentSecondaryLiftEncoderCount() <= 200) {
  //  		Robot.liftsystem.setSecondaryMast(0);
    //		Robot.liftsystem.resettSecondaryliftEncoder();
    	//}
    }

}
