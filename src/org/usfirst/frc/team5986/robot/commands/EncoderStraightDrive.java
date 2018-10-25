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
	double startDistance;

	public EncoderStraightDrive(double speed, double userFeet, double userInches) {
		requires(Robot.driveTrain);
		if (speed < 0) {
			forward = false;
		} else {
			forward = true;
		}
		// Initialize
		driveDistance = (userFeet + (userInches / 12));
		if (forward) {
			endDistance = Robot.driveTrain.getRightDistance() + driveDistance;
		} else {
			endDistance = Robot.driveTrain.getRightDistance() - driveDistance;
		}
		System.out.println(driveDistance);
		System.out.println("Starting Distance: " + Robot.driveTrain.getRightDistance());
		System.out.println("End Distance: " + endDistance);
		// Initialize End
		botSpeed = -speed;
		leftSpeed = botSpeed;
		rightSpeed = botSpeed;
	}

	protected void initialize() {
		// Initialize
		if (forward) {
			endDistance = Robot.driveTrain.getRightDistance() + driveDistance;
		} else {
			endDistance = Robot.driveTrain.getRightDistance() - driveDistance;
		}
		startDistance = Robot.driveTrain.getRightDistance();
		System.out.println(driveDistance);
		System.out.println("Starting Distance: " + Robot.driveTrain.getRightDistance());
		System.out.println("End Distance: " + endDistance);
		// Initialize End
	}

	protected void execute() {
		double current = Robot.driveTrain.getRightDistance() - startDistance;
		System.out.println("Distance: " + Robot.driveTrain.getRightDistance());
		Robot.driveTrain.tankDrive(getSpeed(current, driveDistance), getSpeed(current, driveDistance));
		// Robot.driveTrain.tankDrive(leftSpeed, rightSpeed);
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

	protected void interrupted() {
		end();
	}

	private double getSpeed(double current, double total) {
		double speed = (-1 / ((-1 - ((total - 1) / 2)) * (-1 - ((total - 1) / 2))));
		speed = speed * (current - ((total - 1) / 2)) * (current - ((total - 1) / 2));
		speed = speed + 1;
		// System.out.println("***Speed: " + speed);
		return speed * -2;
	}
}
