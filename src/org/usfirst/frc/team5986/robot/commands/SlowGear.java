package org.usfirst.frc.team5986.robot.commands;

import org.usfirst.frc.team5986.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SlowGear extends Command{
	public SlowGear() {

    	requires(Robot.shifters);
    }
	protected void execute() {
		Robot.shifters.fast(false);
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}
}
