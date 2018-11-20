package org.usfirst.frc.team6544.robot.subsystems;

import org.usfirst.frc.team6544.robot.RobotMap;
import org.usfirst.frc.team6544.robot.commands.InitStop2Lift;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *  Liftsystem Class Extends Subsystem
 */
public class LiftSystem extends Subsystem {
	private static double secondaryLiftEncoderCount;
    protected boolean saftey;
	final private static WPI_TalonSRX _SecondaryLiftMotor = new WPI_TalonSRX(RobotMap.kSecondaryLiftMotor);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	/**
	 *  Liftsystem Subsystem
	 */
    public LiftSystem() {
    	secondaryLiftInit();
    }
    
    /**
     *  Liftsystem Subsystem
     */
    public void secondaryLiftInit(){
    	 _SecondaryLiftMotor.configAllowableClosedloopError(RobotMap.allowablePIDError, RobotMap.kPIDLoopIdx, RobotMap.kTimeoutMs);//allowed error of the pid controller, loop sensor is on, time out value
		 _SecondaryLiftMotor.configNominalOutputForward(0, RobotMap.kTimeoutMs);// Minimum allowed motor output forward
		 _SecondaryLiftMotor.configNominalOutputReverse(0, RobotMap.kTimeoutMs);// Minimum allowed motor output reverse
		 _SecondaryLiftMotor.configPeakOutputForward(RobotMap.SecondaryLiftMotorUpSpeedAuto, RobotMap.kTimeoutMs);
		 _SecondaryLiftMotor.configPeakOutputReverse(RobotMap.SecondaryLiftMotorDownSpeedAuto, RobotMap.kTimeoutMs);//speed
		 _SecondaryLiftMotor.config_kF(RobotMap.kPIDLoopIdx, 0.0, RobotMap.kTimeoutMs);
		 _SecondaryLiftMotor.config_kP(RobotMap.kPIDLoopIdx, 0.1, RobotMap.kTimeoutMs);
		 _SecondaryLiftMotor.config_kI(RobotMap.kPIDLoopIdx, 0, RobotMap.kTimeoutMs);
		 _SecondaryLiftMotor.config_kD(RobotMap.kPIDLoopIdx, 0.0, RobotMap.kTimeoutMs);
		 _SecondaryLiftMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 10); //sets the sensor connected to the secondary lift encoder
    }
    
    /**
     *  Liftsystem Subsystem
     */
    public void initDefaultCommand() {
        setDefaultCommand(new InitStop2Lift());
    }
    
    /**
     *  Enable the PID controller for the gripper motor
     *  @param secondaryliftEncoder pass the current gripper mast position value
     */
    public void enablePID(double secondaryliftEncoder) {//takes in the desired gripper lift position values between 50 and 30000
    	SmartDashboard.putString("Current Second Lift Valu", "Number:"+secondaryliftEncoder);
		_SecondaryLiftMotor.set(ControlMode.Position, secondaryliftEncoder);//enable the PID motor speed output controller
	}
    
    /**
     *  Reset the secondary lift encoder to zero
     */
    public void resettSecondaryliftEncoder() {
 	   _SecondaryLiftMotor.setSelectedSensorPosition(0, 0, 0);//resets the sensor count on the talon zero the lift at the bottom
  	 }
    
    /**
     *  Get the current gripper mast position 
     */
	public static double getCurrentSecondaryLiftEncoderCount() {
		secondaryLiftEncoderCount = _SecondaryLiftMotor.getSelectedSensorPosition(0); //get secondary lift encoder count
		return secondaryLiftEncoderCount;
	}
	
	/**
	 *  Set the gripper mast talon ouput based on a JoyStick axsis value
	 *  @param joystick takes the Y axsis of a controller passa controller object
	 */
	public void joystickControlMode2(Joystick joystick) {
		_SecondaryLiftMotor.set(ControlMode.PercentOutput, -joystick.getY()/1.2);
		//_SecondaryLiftMotor.set(ControlMode.PercentOutput, -joyStick.getRawAxis(1)/1.4);
	}
	 /**
   	 * log method used to send data to the SmartDashboard, called periodically in the robot class
   	 */
    public static void log() {//to send values to the SmartDashboard called in the robot class
    	SmartDashboard.putData(_SecondaryLiftMotor);
    	//SmartDashboard.putNumber("Secondary Lift Encoder", getCurrentSecondaryLiftEncoderCount());//puts the secondary lift encoder value to the SmartDashboard
    	SmartDashboard.putNumber("Secondary Lift Encoder",0);//puts the secondary lift encoder value to the SmartDashboard
 	 }
 
	/**
	 *  Stop motor enable PID at current position
	 */
	public void stopTop2Manual() {//stops the motor then enables it to hold its position with the PID controller 
		_SecondaryLiftMotor.set(0);//stops the motor
		//enablePID(getCurrentSecondaryLiftEncoderCount());//enables the pid by calling the PID method and passing in the current encouder count with the getSecondaryLiftCount method
	}

	/**
	 *  Liftsystem Subsystem
	 * @param speed set the secondary lift motor speed between -1 and 1
	 */
	public void setSecondaryMast(double speed) {
		_SecondaryLiftMotor.set(speed);
	}
}

