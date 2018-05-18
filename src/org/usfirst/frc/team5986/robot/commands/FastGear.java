package org.usfirst.frc.team5986.robot.commands;

import org.usfirst.frc.team5986.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class FastGear extends Command{
	public FastGear() {

    	requires(Robot.shifters);
    }
	protected void execute() {
		Robot.shifters.fast(true);
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}
}
