package org.usfirst.frc.team5986.robot.commands;

import org.usfirst.frc.team5986.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TankDrive extends Command {
	public TankDrive() {
		requires(Robot.driveTrain);
	}

	protected void execute() {
		// Robot.driveTrain.tankDrive(Robot.oi.joystick1);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
}
