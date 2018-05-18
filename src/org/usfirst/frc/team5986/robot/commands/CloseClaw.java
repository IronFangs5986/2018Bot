package org.usfirst.frc.team5986.robot.commands;

import org.usfirst.frc.team5986.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class CloseClaw extends Command{

	public CloseClaw() {

    	requires(Robot.claw);
    }
	protected void execute() {
		Robot.claw.close();
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

}