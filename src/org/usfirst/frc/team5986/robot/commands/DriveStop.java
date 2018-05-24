package org.usfirst.frc.team5986.robot.commands;

import org.usfirst.frc.team5986.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveStop extends Command{
public DriveStop() {
	requires(Robot.driveTrain);
}
protected void execute() {
	Robot.driveTrain.stop();
}
protected void end() {
	Robot.driveTrain.stop();
}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
