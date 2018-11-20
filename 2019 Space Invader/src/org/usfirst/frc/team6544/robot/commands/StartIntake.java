package org.usfirst.frc.team6544.robot.commands;

import org.usfirst.frc.team6544.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


/**
 *
 */
public class StartIntake extends Command {
	public StartIntake() {
    	requires(Robot.claw);
    	//this.on = on;
    }
    protected void execute() {
//    	Robot.claw.setClawLeft(.35);//right
//    	Robot.claw.setClawRight(0.5);//left
    	Robot.claw.intakeLeft();
    	Robot.claw.intakeRight();
    }
    protected boolean isFinished() {
      	return (Robot.claw.hasCubeAll());
    }
    protected void end() {
    	Robot.claw.intakeStop();
//    	for(int i=1; i<11; i++){
//           Robot.liftsystem.goTop1Both();
//        }
//    	Robot.liftsystem.deactivateClamp();
    }
}
