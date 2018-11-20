package org.usfirst.frc.team6544.robot.commands;

import org.usfirst.frc.team6544.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class JoyControl1 extends InstantCommand {

    public JoyControl1() {
        requires(Robot.mast1);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.mast1.deactivateClamp();
    	Robot.mast1.joystickControlMode1(Robot.m_oi.LogitechController3D);
    }

}
