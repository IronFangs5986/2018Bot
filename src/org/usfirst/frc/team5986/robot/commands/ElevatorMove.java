package org.usfirst.frc.team5986.robot.commands;

import org.usfirst.frc.team5986.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ElevatorMove extends Command {
	public ElevatorMove() {
		requires(Robot.elevator);
	}

	protected void execute() {
		Robot.elevator.move(Robot.oi.joystick2.getY(), true);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
