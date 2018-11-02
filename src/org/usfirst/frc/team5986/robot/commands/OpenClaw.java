package org.usfirst.frc.team5986.robot.commands;

import org.usfirst.frc.team5986.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class OpenClaw extends Command {

	public OpenClaw() {

		requires(Robot.claw);
	}

	protected void execute() {
		Robot.claw.open();
		NetworkTable.getTable("SmartDashboard").putString("claw", "open");
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

}
