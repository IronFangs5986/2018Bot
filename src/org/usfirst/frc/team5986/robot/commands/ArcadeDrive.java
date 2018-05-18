package org.usfirst.frc.team5986.robot.commands;

import org.usfirst.frc.team5986.robot.OI;
import org.usfirst.frc.team5986.robot.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class ArcadeDrive extends Command{

public ArcadeDrive() {
	requires(Robot.driveTrain);
}

protected void execute() {
	System.out.println(Robot.oi.joystick1.getRawAxis(1)+" "+Robot.oi.joystick1.getRawAxis(4));
	Robot.driveTrain.arcadeDrive(Robot.oi.joystick1.getRawAxis(1), Robot.oi.joystick1.getRawAxis(4));
}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
