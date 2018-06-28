package org.usfirst.frc.team5986.robot.commands;

import org.usfirst.frc.team5986.robot.Robot;
import org.usfirst.frc.team5986.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class AutoOneSideTurn extends Command {
	double leftSpeed;
	double rightSpeed;
	double endDisR;
	double travelDisR;
	double endDisL;
	double travelDisL;
	private final double robotWidth = RobotMap.robotWidth;
	boolean backMove;
	boolean turnRight;

	public AutoOneSideTurn(double degrees, double radius, boolean rightTurn, boolean reverse) {
		requires(Robot.driveTrain);
		backMove = reverse;
		double degreePercent = degrees / 360; // pid
		double robotWidthFt = robotWidth / 12;
		turnRight = rightTurn;
		if (rightTurn) {
			travelDisL = 2 * Math.PI * (radius + (robotWidthFt / 2)) * degreePercent;
			travelDisR = 0;
			if (reverse) {
				leftSpeed = -1;
				rightSpeed = 0;
			} else {
				leftSpeed = 1;
				rightSpeed = 0;
			}

		} else {
			travelDisL = 0;
			travelDisR = 2 * Math.PI * (radius + (robotWidthFt / 2)) * degreePercent;
			if (reverse) {
				rightSpeed = -1;
				leftSpeed = 0;
			} else {
				rightSpeed = 1;
				leftSpeed = 0;
			}
		}
		System.out.println("*** turn left dis" + travelDisL);
		System.out.println("*** turn right dis" + travelDisR);
	}

	protected void initialize() {
		// Initialize
		if (backMove) {
			endDisL = Robot.driveTrain.getLeftDistance() + travelDisL;
			endDisR = Robot.driveTrain.getRightDistance() - travelDisR;
		} else {
			endDisL = Robot.driveTrain.getLeftDistance() - travelDisL;
			endDisR = Robot.driveTrain.getRightDistance() + travelDisR;
		}
		System.out.println("Left: " + Robot.driveTrain.getLeftDistance() + " " + endDisL);
		System.out.println("Right: " + Robot.driveTrain.getRightDistance() + " " + endDisR);

		// Initialize End
	}

	protected void execute() {
		Robot.driveTrain.tankDrive(-leftSpeed, -rightSpeed);
		System.out.println("Speed: " + -leftSpeed + " " + -rightSpeed);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		if (backMove) {
			if (turnRight) {
				System.out.println(
						"*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\nEND CODE 1");
				return (Robot.driveTrain.getLeftDistance() >= endDisL);
			} else {
				System.out.println(
						"*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\nEND CODE 2");
				return (Robot.driveTrain.getRightDistance() <= endDisR);
			}
		} else {
			if (turnRight) {
				System.out.println(
						"*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\nEND CODE 3");
				return (Robot.driveTrain.getLeftDistance() <= endDisL);
			} else {
				System.out.println(
						"*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\nEND CODE 4");
				return (Robot.driveTrain.getRightDistance() >= endDisR);
			}
		}
	}

	protected void end() {
		leftSpeed = 0;
		rightSpeed = 0;
		endDisR = 0;
		travelDisR = 0;
		endDisL = 0;
		travelDisL = 0;
		backMove = false;
		turnRight = false;

		Robot.driveTrain.stop();
	}

	protected void interrupted() {
		end();
	}
}
