package org.usfirst.frc.team6544.robot.commands;

import org.usfirst.frc.team6544.robot.Robot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *Control Autonomous turning 
 */
public class turn extends Command {
    public double angle;
    public double speedLeft;
    public double turnangle;
    public double scalingConstant=0.3;
    public boolean kcontinue = false;
    public turn(double setAngle, double speedLeft, double turnangle) {
        requires(Robot.liftsystem);
        this.angle = setAngle;
        this.speedLeft = speedLeft;
        this.turnangle = turnangle;
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double driveAngle = 0;
    	while (driveAngle < angle){
    		kcontinue = false;
        	driveAngle = Robot.drivesystem.getAngle();
      		Robot.drivesystem.arcadeDrive(speedLeft, -driveAngle * scalingConstant);
      	 Timer.delay(0.01);                      //creates a delay
      }
    	kcontinue = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return kcontinue;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivesystem.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}