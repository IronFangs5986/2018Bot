package org.usfirst.frc.team5986.robot.commands;

import org.usfirst.frc.team5986.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class IntakeDown extends Command {

	public IntakeDown() {
		requires(Robot.intakeDrop);
	}

	protected void execute() {
		Robot.intakeDrop.down();
		// .intakeUp = false;
		NetworkTable.getTable("SmartDashboard").putString("intake", "down");
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

}
