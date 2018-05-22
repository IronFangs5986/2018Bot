package org.usfirst.frc.team5986.robot.commands;

import org.usfirst.frc.team5986.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ShiftGear extends Command {
	public ShiftGear() {
		requires(Robot.shifters);
	}

	protected void execute() {
		Robot.shifters.shift(Robot.oi.joystick1.getZ());
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
