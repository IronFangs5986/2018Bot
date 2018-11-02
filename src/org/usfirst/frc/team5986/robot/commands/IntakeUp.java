package org.usfirst.frc.team5986.robot.commands;

import org.usfirst.frc.team5986.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class IntakeUp extends Command {

	public IntakeUp() {
		requires(Robot.intakeDrop);
	}

	protected void execute() {
		Robot.intakeDrop.up();
		NetworkTable.getTable("SmartDashboard").putString("intake", "up");
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

}
