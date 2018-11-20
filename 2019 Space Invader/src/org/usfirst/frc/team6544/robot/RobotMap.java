/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6544.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
/*
 * XBOX BUTTON MAPPING FOR DRIVER STATION AS FOLLOWS
 * Button 1 = A
 * Button 2 = B
 * Button 3 = X OR small left wheel button up
 * Button 4 = Y
 * Button 5 = Left Bumper
 * Button 6 = Right Bumper OR small right wheel down
 * Button 7 = Select / Menu Button
 * Button 8 = Start / Enter Button
 * Button 9 = Click in Left Analog Stick OR small left wheel down
 * Button 10 = Click in Right Analog Stick
 * 
 * Axis 0 = Left stick left + right
 * Axis 1 = Left stick up + down
 * Axis 2 = Left trigger
 * Axis 3 = Right trigger
 * Axis 4 = Right stick left + right
 * Axis 5 = Right stick up + down
 * 
 * POV = D-Pad
 * POV LEFT = small right wheel up
 */
public class RobotMap {
	//Joystick Ports And Command Buttons
		public static final int CloseClawButton = 3; // stop in-take
		public static final int OpenClawButton = 2; // start in-take
		public static final int ShootButton = 1; // shoot out-take
		public static final int ClimbLeftButton = 5; // climbs while the left bumper button on the Xbox controller is pressed
		public static final int ShootSButton = 5;// slow shoot button
		public static final int FullTopButton = 4; // Auto full liftsystem top when Y is hit on the xobx controller
		public static final int FullBottomButton = 1; // Auto full liftsystem bottom when A is hit on the xobx controller
		public static final int GripperTopButtonAuto = 2; // Auto gripper top when B is hit on the xobx controller
		public static final int GripperBottomButtonAuto = 3; // Auto gripper bottom X is hit on the xobx controller
		public static final int mainControl = 8;
		public static final int gripperControl = 7;
		public static final int FullSpeedButton = 7;
		public static final int HalfSpeedButton = 8;
		public static final int QuaterSpeedButton = 3;
		public static final int UnJamButton = 2;
		public static final int holdButton = 6;
//		public static final int MainTopButtonManual = 7; // Manual main mast top when 7 is hit on the Logitech Controller
//		public static final int MainBottomButtonManual = 10; // Manual main mast bottom 10 is hit on the Logitech controller
//		public static final int MainTopButtonAuto = 9; // Auto main mast top when 9 is hit on the Logitech Controller
//		public static final int MainBottomButtonAuto = 12; // Auto main mast bottom 12 is hit on the Logitech controller
//		public static final int GripperTopButtonManual = 8; // Auto gripper mast top when 8 is hit on the Logitech Controller
//		public static final int GripperBottomButtonManual = 11; // Auto gripper mast bottom 11 is hit on the Logitech controller
		//Motors
		public static final int kLiftMotor = 5;
	    public static final int kSecondaryLiftMotor = 3;
	    public static final int kFronLeftCIM = 0;
	    public static final int kBackRightCIM = 6;
	    public static final int kFrontRightCIM = 7;
	    public static final int kbackLeftCIM = 4;
	    public static final int kLeftClawCIM = 2;
	    public static final int kRightClawCIM = 1;
	//Motor Speed constants
	    public static final double LiftMotorUpSpeed = 0.5;
	    public static final double LiftMotorDownSpeed = -0.35;
	    public static final double SecondaryLiftMotorUpSpeed = 0.5;
	    public static final double SecondaryLiftMotorDownSpeed = -0.35;
	    public static final double SecondaryLiftMotorUpSpeedAuto = 0.75;
	    public static final double SecondaryLiftMotorDownSpeedAuto = -0.35;
	    public static final double IntakeSpeed = -0.35;
	    //public static double driveSpeed;
	//Solenoids
	    public static final int pitchDoubleSol[] = {0,1};
	    public static final int kBrakeSingleSol[] = {4,5};
	    public static final int kShifterSingleSol[] = {6,7};
	//Input Devices
	    public static final int CubeDetect = 0;
	    public static final int CubeDetect2 = 1;
	    public static final int LiftBottomSwitch = 2;
	    public static final int LiftTopSwitch = 3;
	//Constants 
	    public static final int kTimeoutMs = 10;
	    public static final int kPIDLoopIdx = 10;
	    public static final int kSlotIdx = 0;
	    public static final int allowablePIDError = 5;
	    public static final double bottomEncoderLimit = 100;
	    public static final double topEncoderLimit = 29000;
	    public static final double cubeDriveEncoderValue = 300;
		public static final double scalingConstant = 0.4;
		public static int driveDistance = 0;
		public static boolean stopDrive = false;
}
