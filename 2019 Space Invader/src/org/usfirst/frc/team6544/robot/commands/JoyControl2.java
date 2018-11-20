package org.usfirst.frc.team6544.robot.commands;

import org.usfirst.frc.team6544.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class JoyControl2 extends InstantCommand {

    public JoyControl2() {
       requires(Robot.liftsystem);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.liftsystem.joystickControlMode2(Robot.m_oi.LogitechController3D);
    }

}
