package org.usfirst.frc.team6544.robot.commands;

import org.usfirst.frc.team6544.robot.Robot;
import org.usfirst.frc.team6544.robot.subsystems.MainMast;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LeftSideSwitchScale extends Command {
	private double endLoop = 0;
	private double startAngle = 0;
	private double scalingConstant = 0.3;
	private double loopcount = 0;
	private double loopcount3 = 0;
	private double driveangle1;
	private boolean isfinished = false;
	private double Switchloopcount = 0;
	private double Switchloopcount2 = 0;
	private double Switchdriveangle1;
	public LeftSideSwitchScale() {
		super(14.5);
       requires(Robot.claw);
       requires(Robot.liftsystem);
       requires(Robot.mast1);
       requires(Robot.drivesystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivesystem.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.mast1.autoTimeOut();
    	String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		if(gameData.length() == 3) {
			if(gameData.charAt(0)=='L') {
				Robot.drivesystem.reset();
				 while (startAngle >= -5){ 
			        	startAngle = Robot.drivesystem.getAngle();
			        	Robot.drivesystem.arcadeDrive(0.55, -0.55); 
			      	//chassis.tankDrive(.8,.8); //Sets the speed of the robot for each wheel and makes them turn 
			      	 Timer.delay(0.001);                      //creates a delay
			     	 //Increments the loop counter by 1
			      }
				while(Switchloopcount < 250) {
		    		double driveAngle = Robot.drivesystem.getAngle();
		    		Robot.drivesystem.arcadeDrive(-0.6, -driveAngle * scalingConstant);
		    		Timer.delay(0.01);
		    		Switchloopcount++;
		    	}
				while (Switchdriveangle1 <= 20){ 
		        	Switchdriveangle1 = Robot.drivesystem.getAngle();
		        	Robot.drivesystem.arcadeDrive(-0.55, 0.55); 
		      	//chassis.tankDrive(.8,.8); //Sets the speed of the robot for each wheel and makes them turn 
		      	 Timer.delay(0.001);                      //creates a delay
		     	 //Increments the loop counter by 1
		      }
				 Timer.delay(.3);
			    while(MainMast.getTopLimit() == false) {
			    	Robot.mast1.deactivateClamp();
			    	Robot.mast1.goUp();
			    }
			    Robot.drivesystem.reset();
			    while(Switchloopcount2 < 70) {
		    		double driveAngle = Robot.drivesystem.getAngle();
		    		Robot.drivesystem.arcadeDrive(-0.5, -driveAngle * scalingConstant);
		    		Timer.delay(0.01);
		    		Switchloopcount2++;
		    	}
			    Timer.delay(1);
			    Robot.claw.clawDown();
			    Timer.delay(1);
			    Robot.claw.setClawLeft(-1);
			    Robot.claw.setClawRight(-1);
			}else if(gameData.charAt(1)=='L') {	 
				Robot.drivesystem.reset();
				while(loopcount < 211) {
		    		double driveAngle = Robot.drivesystem.getAngle();
		    		Robot.drivesystem.arcadeDrive(-0.8, -driveAngle * scalingConstant);
		    		Timer.delay(0.01);
		    		loopcount++;
		    	}
			        while (driveangle1 <= 9){ 
			        	driveangle1 = Robot.drivesystem.getAngle();
			        	Robot.drivesystem.arcadeDrive(-0.55, 0.55); 
			      	//chassis.tankDrive(.8,.8); //Sets the speed of the robot for each wheel and makes them turn 
			      	 Timer.delay(0.001);                      //creates a delay
			     	 //Increments the loop counter by 1
			      }
			        Timer.delay(.3);
			        Robot.drivesystem.reset();
			        while(MainMast.getTopLimit() == false) {
				    	Robot.mast1.deactivateClamp();
				    	Robot.mast1.goUp();
				    }
			        Timer.delay(.3);
			        while(loopcount3 < 29) {
			    		Robot.drivesystem.arcadeDrive(-0.7, 0);
			    		Timer.delay(0.01);
			    		loopcount3++;
			    	}
			    Timer.delay(1);
			    Robot.liftsystem.enablePID(29000);
			    Timer.delay(.5);
			    Robot.claw.clawDown();
			    Timer.delay(.3);
			    Robot.claw.setClawLeft(-1);
			    Robot.claw.setClawRight(-1);
			}else if((gameData.charAt('0') & gameData.charAt('1')) != 'L'){
				while(endLoop < 350) {
		    		double driveAngle = Robot.drivesystem.getAngle();
		    		Robot.drivesystem.arcadeDrive(-0.55, -driveAngle * scalingConstant);
		    		Timer.delay(0.01);
		    		endLoop++;
		    	}
			}
		}
		isfinished = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(isfinished == true | Robot.mast1.timeout) {
    	}
        return isfinished;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
