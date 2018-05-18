package org.usfirst.frc.team5986.robot.commands;

import org.usfirst.frc.team5986.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class OpenClaw extends Command {

	public OpenClaw() {

    	requires(Robot.claw);
    }
	protected void execute() {
		Robot.claw.open();
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

}
