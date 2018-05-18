package org.usfirst.frc.team5986.robot.commands;

import org.usfirst.frc.team5986.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeUp extends Command {
	
public IntakeUp() {
	requires(Robot.intakeDrop);
}
protected void execute() {
	Robot.intakeDrop.up();
}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

}
