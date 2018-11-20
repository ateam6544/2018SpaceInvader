package org.usfirst.frc.team6544.robot.commands;

import org.usfirst.frc.team6544.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;


/**
 *
 */
public class XboxDrive extends Command {
	
	public XboxDrive() {
        requires(Robot.drivesystem); // Use requires() here to declare subsystem dependencies
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivesystem.arcadeDrive(Robot.m_oi.XboxController);
    	//Robot.drivesystem.arcadeDrive(Robot.m_oi.XboxController,Robot.drivesystem.throttleOutput(),Robot.drivesystem.toppleSaftey(LiftSystem.getSecondaryliftEncoder()));
		//Robot.drivesystem.arcadeDrive(Robot.m_oi.getLogitechController(), Robot.drivesystem.throttleOutput(), Robot.drivesystem.toppleSaftey(LiftSystem.getSecondaryliftEncoder()));
    }
	

    // Make this return true when this Command no longer needs to run execute() , Robot.m_oi.getThrottle()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    Robot.drivesystem.stop();// Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    	
}
    protected void interrupted() {
    }
}
