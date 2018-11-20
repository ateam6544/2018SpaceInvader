package org.usfirst.frc.team6544.robot.subsystems;

import org.usfirst.frc.team6544.robot.Robot;
import org.usfirst.frc.team6544.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Claw subsystem 
 */
public class Claw extends Subsystem {
	private static final DigitalInput m_cubeDetector = new DigitalInput(RobotMap.CubeDetect); // Left limit switch 
	private static final DigitalInput m_cubeDetector2 = new DigitalInput(RobotMap.CubeDetect2); //Right limit switch  
	private static final DoubleSolenoid shootPos = new DoubleSolenoid(8,RobotMap.pitchDoubleSol[0], RobotMap.pitchDoubleSol[1]); // Claw up/down solenoid control
	private static final WPI_TalonSRX _LeftCIM = new WPI_TalonSRX(RobotMap.kLeftClawCIM); // Left gripper motor
	private static final WPI_TalonSRX _RightCIM = new WPI_TalonSRX(RobotMap.kRightClawCIM); //Right gripper motor
	
	 /**
     *Claw class constructor 
     */
	public Claw(){
		_LeftCIM.setInverted(true);
		_RightCIM.setInverted(true);
	}
	
	 /**
     *Checks if both paddles have been pressed by the cube.
     *Return true only if both switches are active.
     */
    public boolean hasCubeAll() {
    	if((m_cubeDetector.get() && m_cubeDetector2.get()) == true){
    		return true;
    	}else {
    		return false;
    	}
    }
    
    /**
     *Checks if the left switch has been pressed by the cube
     *Returns true if the switch is pressed
     */
    public boolean hasCube1() {
    	return(m_cubeDetector.get());
    }
    
    /**
     *Checks if the right switch has been pressed by the cube
     *Returns true if the switch is pressed
     */
    public boolean hasCube2() {
    	return(m_cubeDetector2.get());
    }
    
    public static void log() {
    	 SmartDashboard.putBoolean("Cube Detected!", Robot.claw.hasCubeAll());
 	}
    
    /**
     *Set the default command to null
     */
	public void initDefaultCommand() {
		setDefaultCommand(null);
	}

    /**
     *Set the claw motors to stop
     */
    public void intakeStop() {
    	_LeftCIM.set(0);
    	_RightCIM.set(0);
    }
    
    /**
     *Set the claw right motor outake speed
     *@param speed set the outake speed between 0-1 or (-0)-(-1)
     */
    public void setClawRight(double speed) {
    	_RightCIM.set(speed);//slow = 0.35 fast = 1
    }
    
    /**
     *Set the claw left motor outake speed
     *@param speed set the outake speed between 0-1 or (-0)-(-1)
     */
    public void setClawLeft(double speed) {
    	_LeftCIM.set(speed);
    }
    //New
    public void intakeLeft() {
    	_LeftCIM.setInverted(true);
    	_LeftCIM.set(0.5);//4
    }
    //New
    public void intakeRight() {
    	_RightCIM.setInverted(true);
	_RightCIM.set(0.5);//4
    }
    public void intakeLeftSlow() {
    	_LeftCIM.setInverted(false);
    	_LeftCIM.set(0.35);
    }
    //New
    public void intakeRightSlow() {
    	_RightCIM.setInverted(false);
	_RightCIM.set(0.35);
    }
    /**
    *Set the claw up or down
    *@param stat if set true claw will gp up
    *@param stat if set false claw will go down
    */
   public void clawUp() {
    		shootPos.set(DoubleSolenoid.Value.kForward);//claw Up
   }
   public void clawDown() {
    		shootPos.set(DoubleSolenoid.Value.kReverse);//claw down
   }
    
    /**
     *Set the claw left motor to stop
     */
	public void stopLeft() {
		_LeftCIM.set(0);
	}
	
	/**
     *Set the claw right motor to stop
     */
	public void stopRight() {
		_RightCIM.set(0);
	}
	
	public void unJamLeft() {
    	_LeftCIM.setInverted(true);
    	_LeftCIM.set(0.85);
    }
    //New
    public void UnJamRight() {
    	_RightCIM.setInverted(false);
	    _RightCIM.set(0.85);
    }
}

