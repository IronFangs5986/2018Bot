package org.usfirst.frc.team5986.robot.commands;

import org.usfirst.frc.team5986.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ElevatorTop extends Command {
	double eSpeed;

	public ElevatorTop(double speed) {
		requires(Robot.elevator);
		eSpeed = -speed;
	}

	protected void initialize() {

	}

	protected void execute() {
		Robot.elevator.move(eSpeed, false);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return (!Robot.elevator.getTop());
	}

	protected void end() {
		Robot.elevator.move(-.2, false);
	}
}
