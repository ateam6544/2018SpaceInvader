/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6544.robot;

import org.usfirst.frc.team6544.robot.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public Joystick XboxController = new Joystick(0);
	public Joystick LogitechController3D = new Joystick(1);
	private JoystickButton startIntake = new JoystickButton(LogitechController3D, RobotMap.OpenClawButton);// create the start claw button object
	private JoystickButton stopTakes = new JoystickButton(LogitechController3D, RobotMap.CloseClawButton);// creates a button object to stop the claw motors
	private JoystickButton shoot = new JoystickButton(LogitechController3D, RobotMap.ShootButton);// creates a button object to shoot the cube with the claw motors
	private JoystickButton slowShoot = new JoystickButton(LogitechController3D, RobotMap.ShootSButton);
	private JoystickButton climb = new JoystickButton(XboxController, RobotMap.ClimbLeftButton);
	private JoystickButton mainMastControl = new JoystickButton(LogitechController3D, 4);
	private JoystickButton gripperControl = new JoystickButton(LogitechController3D, 6);
	private JoystickButton goTopFull = new JoystickButton(LogitechController3D, 10);
	private JoystickButton goBottomFull = new JoystickButton(LogitechController3D, 9);
	private JoystickButton gripperTopAuto = new JoystickButton(LogitechController3D, 12);
	private JoystickButton gripperBottomAuto = new JoystickButton(LogitechController3D, 11);
	private JoystickButton pitchUp = new JoystickButton(LogitechController3D, 8);
	private JoystickButton pitchDown = new JoystickButton(LogitechController3D, 7);
	private JoystickButton FullSpeed = new JoystickButton(XboxController, RobotMap.FullSpeedButton);
	private JoystickButton HalfSpeed = new JoystickButton(XboxController, RobotMap.HalfSpeedButton);
	private JoystickButton QuaterSpeed = new JoystickButton(XboxController, RobotMap.QuaterSpeedButton);
	//private JoystickButton UnJam = new JoystickButton(XboxController, RobotMap.UnJamButton);
	public OI(){
		startIntake.whenPressed(new StartIntake());
		stopTakes.whenPressed(new Stoptakes());
		shoot.whenPressed(new setOutake(-1));
		slowShoot.whenPressed(new SlowOutake());
		mainMastControl.whileHeld(new JoyControl1());
		mainMastControl.whenReleased(new JoyControl1PosHold());
	    gripperControl.whileHeld(new JoyControl2());
	    gripperControl.whenReleased(new JoyHoldPos2());
		goTopFull.whenPressed(new fullMastUp());
		goBottomFull.whenPressed(new FullMastDown());
		gripperTopAuto.whenPressed(new gripperMastAutoUp());
		gripperBottomAuto.whenPressed(new gripperMastAutoDown());
		pitchUp.whenPressed(new clawDown());
		pitchDown.whenPressed(new setPitch());
		FullSpeed.whenPressed(new SpeedControl(1));
		HalfSpeed.whenPressed(new SpeedControl(1.5));
		QuaterSpeed.whenPressed(new SpeedControl(2));
		climb.whenPressed(new Climb());// climb when the left bumber button on the xbox controller is presseds
		climb.whenPressed(new ShiftLow());
		climb.whenReleased(new StopClimb());
		//UnJam.whileHeld(new UnJam());
		SmartDashboard.putData("Deactivate Brake", new deactivateBrake());
//		SmartDashboard.putData("Shifter High", new ShiftHigh());//Puts a shift high button to the smart dashboard
//		SmartDashboard.putData("Shifter Low", new ShiftLow());//Puts a shift low button to the smart dashboard
	}
}
/*
 * Unused commands
 * SmartDashboard.putData("Shifter High", new ShiftHigh());//Puts a shift high button to the smart dashboard
 * SmartDashboard.putData("Shifter Low", new ShiftLow());//Puts a shift low button to the smart dashboard
 * SmartDashboard.putData("Gripper Up", new PitchUp());//Puts a gripper up button to the smart dashboard
 * SmartDashboard.putData("Gripper Down", new PitchDown());//Puts a gripper up button to the smart dashboard
 * SmartDashboard.putData("Brake Activate", new SetClamp(true));//Puts a brake activate button to the smart dashboard
*/
