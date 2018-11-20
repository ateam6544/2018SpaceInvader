/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6544.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6544.robot.Robot;
import org.usfirst.frc.team6544.robot.subsystems.DriveSystem;

/**
 * This command drives the robot over a given distance with simple proportional
 * control This command will drive a given distance limiting to a maximum speed.
 */
public class DriveForward extends Command {
	private double m_driveForwardSpeed;
	private double m_distance;
	private double m_error;
	private static final double kTolerance = 0.5;
	private static final double kP = -1.0 / 5.0;

	public DriveForward() {
		this(200, 0.5);
	}

	public DriveForward(double dist) {
		this(dist, 0.5);
	}

	public DriveForward(double dist, double maxSpeed) {
		requires(Robot.drivesystem);
		m_distance = dist;
		m_driveForwardSpeed = maxSpeed;
	}

	@Override
	protected void initialize() {
		Robot.drivesystem.reset();
		setTimeout(2);
	}

	@Override
	protected void execute() {
		m_error = m_distance - DriveSystem.getDistance();
		if (m_driveForwardSpeed * kP * m_error >= m_driveForwardSpeed) {
			Robot.drivesystem.arcadeDrive(m_driveForwardSpeed, m_driveForwardSpeed);
		} else {
			Robot.drivesystem.arcadeDrive(m_driveForwardSpeed * kP * m_error,
					m_driveForwardSpeed * kP * m_error);
		}
	}

	@Override
	protected boolean isFinished() {
		return Math.abs(m_error) <= kTolerance || isTimedOut();
	}

	@Override
	protected void end() {
		Robot.drivesystem.stop();
	}
}
