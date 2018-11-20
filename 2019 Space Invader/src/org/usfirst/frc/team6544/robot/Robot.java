/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6544.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team6544.robot.commands.Baseline2;
import org.usfirst.frc.team6544.robot.commands.Scale;
import org.usfirst.frc.team6544.robot.commands.ScaleLeft;
import org.usfirst.frc.team6544.robot.commands.SwitchClose;
import org.usfirst.frc.team6544.robot.commands.SwitchClose2;
import org.usfirst.frc.team6544.robot.commands.SwitchClose3;
import org.usfirst.frc.team6544.robot.commands.LeftSideSwitchScale;
import org.usfirst.frc.team6544.robot.commands.SwitchSide;
import org.usfirst.frc.team6544.robot.commands.SwitchSideLeft;
import org.usfirst.frc.team6544.robot.subsystems.CameraProcessor;
import org.usfirst.frc.team6544.robot.subsystems.Claw;
import org.usfirst.frc.team6544.robot.subsystems.DriveSystem;
import org.usfirst.frc.team6544.robot.subsystems.LiftSystem;
import org.usfirst.frc.team6544.robot.subsystems.MainMast;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	public static OI m_oi; // creates OI object
    public static Claw claw = new Claw(); //creates claw object
    public static DriveSystem drivesystem = new DriveSystem(); //creates drivesystem object
    public static LiftSystem liftsystem = new LiftSystem(); //creates liftsystem object
    public static MainMast mast1 = new MainMast(); //creates liftsystem object
    private CameraProcessor Cam1; //creates private only accesible to this class camera processor object
	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();
protected int station;
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		Cam1 = new CameraProcessor("GripperCam",0);//set the camera name and what usb port it is connected to
		Cam1.start(); //Cam1.SendToDashboard("cam0");
		m_oi = new OI(); // Instantiate the OI class
		SmartDashboard.putData("Auto Target", m_chooser);
		m_chooser.addDefault("Right Position Switch", new SwitchClose3());
		m_chooser.addObject("Left Position Switch", new SwitchClose2());// chooser.addObject("My Auto", new MyAutoCommand());
		m_chooser.addObject("Baseline", new Baseline2());
		Robot.claw.clawUp();
		Robot.liftsystem.resettSecondaryliftEncoder();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		Robot.liftsystem.resettSecondaryliftEncoder();
		Robot.claw.clawUp();
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.delete("GripperCam");
		SmartDashboard.updateValues();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		Robot.drivesystem.reset(); //reset the gyro sensor to position 0*
		m_autonomousCommand = m_chooser.getSelected();
		if (m_autonomousCommand != null) {//start auto command
			m_autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run(); // run the schedualar, satrts FIRST systems
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		Robot.mast1.highGear();
		Robot.liftsystem.resettSecondaryliftEncoder();
		SmartDashboard.delete("Auto Selected");
		if (m_autonomousCommand != null) {//stop auto command if not already stoped
			m_autonomousCommand.cancel();
		}
		log();
		stop();
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		log();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
	public void log() {
		//DriveSystem.log();
		LiftSystem.log();
		Claw.log();
		//MainMast.log();
	}
	public void stop() {
		Robot.mast1.stop();
		Robot.liftsystem.stopTop2Manual();
		Robot.claw.stopLeft();
		Robot.claw.stopRight();
		Robot.drivesystem.stop();
		
	}
}
