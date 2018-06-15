package org.usfirst.frc.team5986.robot.commands;

import org.usfirst.frc.team5986.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutoIntake extends Command {
	double speedVar;
	public AutoIntake(double speed) {
		requires(Robot.intake);
		speedVar = speed;
	}

	protected void execute() {
		Robot.intake.speed(speedVar);
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

}
