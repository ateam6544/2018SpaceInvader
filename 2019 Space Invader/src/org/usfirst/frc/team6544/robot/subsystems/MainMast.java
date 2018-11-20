package org.usfirst.frc.team6544.robot.subsystems;

import org.usfirst.frc.team6544.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *Main mast Subsystem
 */
public class MainMast extends Subsystem {
	 final private DoubleSolenoid LiftGearShifter = new DoubleSolenoid(8,RobotMap.kShifterSingleSol[0],RobotMap.kShifterSingleSol[1]);
	 final private DoubleSolenoid BrakeClamp = new DoubleSolenoid(8,RobotMap.kBrakeSingleSol[0],RobotMap.kBrakeSingleSol[1]);
	 final private static WPI_TalonSRX _LiftMotor = new WPI_TalonSRX(RobotMap.kLiftMotor);
	 final private static DigitalInput bottomLimit = new DigitalInput(RobotMap.LiftBottomSwitch);
	 final private static DigitalInput topLimit = new DigitalInput(RobotMap.LiftTopSwitch);
	 public boolean timeout = false;
	 double timeOut = 0;
	 public void initDefaultCommand() {
    	 setDefaultCommand(null);
    }
    
	/**
	 *  Set the main mast talon ouput based on a JoyStick axsis value
	 *  @param joystick takes the Y axsis of a controller pass a controller object
	 */
	public void joystickControlMode1(Joystick joystick) {
		_LiftMotor.set(ControlMode.PercentOutput, -joystick.getY()/1.1);
		//_LiftMotor.set(ControlMode.PercentOutput, -joyStick.getRawAxis(5)/1.4);
	}
	
	/**
   	 *Deactivate Clamp
   	 */
	public void deactivateClamp() {
		BrakeClamp.set(DoubleSolenoid.Value.kReverse);
	}
	
	/**
   	 * Activate Clamp
   	 */
	public void activateClamp() {
		BrakeClamp.set(DoubleSolenoid.Value.kForward);
	}
	
	  /**
     * Top main mast limit siwtch. Returns true if active and false when not active.
    */
    public static boolean getTopLimit() {
   	 return topLimit.get();//checks to see if the switch is activated returns true or false
    }
    
    /**
	 *  Bottom main mast limit siwtch. Returns true if active and false when not active.
	 */
	public static boolean getBottomLimit() {
   	 return bottomLimit.get();//checks to see if the switch is activated returns true or false
    }
	
	 public static void log() {//to send values to the SmartDashboard called in the robot class
	    	SmartDashboard.putBoolean("bottom limit", getBottomLimit());
	    	SmartDashboard.putBoolean("top limit", getTopLimit());
	    	
	 	 }
	   /**
	   * Shift into high gear
	   */
	    public void highGear() {
			LiftGearShifter.set(DoubleSolenoid.Value.kForward);
		}
		public void lowGear() {
			LiftGearShifter.set(DoubleSolenoid.Value.kReverse);
		}
		
		/**
		 *  Main mast upward speed 1
		 */
		public void goUp() {
			_LiftMotor.set(1);//used to give power to the main mast used in both auto and manual commands
		}
		
		/**
		 *  Main mast downward speed .45
		 */
		public void goDown() {
			_LiftMotor.set(-0.45);//used to give power to the main mast used in both auto and manual commands
		}
		
		public void climb() {
			_LiftMotor.set(-0.95);//used to give power to the main mast used in both auto and manual commands
		}
		
		/**
		 *  Stop Main Mast
		 */
		public void stop() {
			_LiftMotor.set(0);	//activates the clamp and sets the main mast motor to stop
		}
		public void autoTimeOut() {
			while(timeOut < 13) {
				Timer.delay(1);
				timeOut++;
			}
			timeout=true;
		}
		public void autoTimeOut2() {
			autoTimeOut();
		}
}

