package org.usfirst.frc.team5986.robot.commands;

import org.usfirst.frc.team5986.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ArcadeDrive extends Command {

	public ArcadeDrive() {
		requires(Robot.driveTrain);
	}

	protected void execute() {
		Robot.driveTrain.arcadeDrive(Robot.oi.joystick1);
		// Robot.driveTrain.arcadeDrive(Robot.oi.joystick3.getRawAxis(1),
		// Robot.oi.joystick3.getRawAxis(2));
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
