package org.usfirst.frc.team5986.robot.commands;

import org.usfirst.frc.team5986.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class RobotStop extends Command {
	public RobotStop() {
		requires(Robot.driveTrain);
	}

	protected void execute() {
		Robot.driveTrain.stop();
		Robot.driveTrain.tankDrive(0,0);
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
