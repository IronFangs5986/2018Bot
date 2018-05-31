package org.usfirst.frc.team5986.robot.commands;

import org.usfirst.frc.team5986.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ElevatorMoveBottom extends Command {
public ElevatorMoveBottom() {
	requires(Robot.elevator);
}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}
	protected void execute() {
		Robot.elevator.stop();
	}
}
