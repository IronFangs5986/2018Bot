package org.usfirst.frc.team5986.robot.commands;

import org.usfirst.frc.team5986.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class EncoderStraightDrive extends Command {
	double ftDistance;
	double inDistance;
	double driveDistance;
	double endDistance;
	double botSpeed;
	double leftSpeed;
	double rightSpeed;
	boolean forward;

	public EncoderStraightDrive(double speed, double userFeet, double userInches) {
		requires(Robot.driveTrain);
		driveDistance = (userFeet + (userInches / 12));
		if (speed < 0) {
			forward = false;
		} else {
			forward = true;
		}
		botSpeed = -speed;
		leftSpeed = botSpeed;
		rightSpeed = botSpeed;
	}

	protected void initialize() {
		if (forward) {
			endDistance = Robot.driveTrain.getRightDistance() + driveDistance;
		} else {
			endDistance = Robot.driveTrain.getRightDistance() - driveDistance;
		}
		System.out.println(driveDistance);
		System.out.println("Starting Distance: " + Robot.driveTrain.getRightDistance());
		System.out.println("End Distance: " + endDistance);
	}

	protected void execute() {
		Robot.driveTrain.tankDrive(leftSpeed, rightSpeed);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		if (forward) {
			return (Robot.driveTrain.getRightDistance() >= endDistance);
		} else {
			return (Robot.driveTrain.getRightDistance() <= endDistance);
		}
	}

	protected void end() {
		Robot.driveTrain.stop();
	}
}
