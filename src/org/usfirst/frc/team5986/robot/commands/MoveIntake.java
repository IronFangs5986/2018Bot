package org.usfirst.frc.team5986.robot.commands;

import org.usfirst.frc.team5986.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class MoveIntake extends Command {
	public MoveIntake() {
		requires(Robot.intake);
	}

	protected void execute() {
		Robot.intake.speed(Robot.oi.joystick1.getRawAxis(5));
		// Robot.intake.speed(Robot.oi.joystick3.getRawAxis(3));
		// System.out.println(Robot.oi.joystick3.getRawAxis(3));
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
