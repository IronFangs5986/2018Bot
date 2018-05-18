package org.usfirst.frc.team5986.robot.commands;

import org.usfirst.frc.team5986.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeDown extends Command {
	
public IntakeDown() {
	requires(Robot.intakeDrop);
}
protected void execute() {
	Robot.intakeDrop.down();
}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

}
