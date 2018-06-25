package org.usfirst.frc.team5986.robot.commands;

import org.usfirst.frc.team5986.robot.Robot;
import org.usfirst.frc.team5986.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class EncoderTurn extends Command {
	double leftSpeed;
	double rightSpeed;
	double endDisR;
	double travelDisR;
	double endDisL;
	double travelDisL;
	private final double robotWidth = RobotMap.robotWidth;
	boolean backMove;
	boolean onlyOneSide;

	public EncoderTurn(double degrees, double radius, boolean rightTurn, boolean reverse, boolean oneSide) {
		requires(Robot.driveTrain);
		backMove = reverse;
		double degreePercent = degrees / 360; // pid
		double robotWidthFt = robotWidth / 12;
		onlyOneSide = oneSide;
		if (rightTurn) {
			travelDisL = 2 * Math.PI * (radius + (robotWidthFt / 2)) * degreePercent;

			travelDisR = 2 * Math.PI * (radius - (robotWidthFt / 2)) * degreePercent;
			if (!onlyOneSide) {
				if (reverse) {
					leftSpeed = -1;
					rightSpeed = leftSpeed * (travelDisR / travelDisL);
				} else {
					leftSpeed = 1;
					rightSpeed = leftSpeed * (travelDisR / travelDisL);
				}
			} else {
				if (reverse) {
					leftSpeed = -1;
					rightSpeed = 0;
				} else {
					leftSpeed = 1;
					rightSpeed = 0;
				}
			}
		} else {
			travelDisL = 2 * Math.PI * (radius - (robotWidthFt / 2)) * degreePercent;
			travelDisR = 2 * Math.PI * (radius + (robotWidthFt / 2)) * degreePercent;
			if (!onlyOneSide) {
				if (reverse) {
					rightSpeed = -1;
					leftSpeed = rightSpeed * (travelDisL / travelDisR);
				} else {
					rightSpeed = 1;
					leftSpeed = rightSpeed * (travelDisL / travelDisR);
				}
			} else {
				if (reverse) {
					rightSpeed = -1;
					leftSpeed = 0;
				} else {
					rightSpeed = 1;
					leftSpeed = 0;
				}

			}
		}
		System.out.println("left dis" + travelDisL);
		System.out.println("right dis" + travelDisR);
	}

	protected void initialize() {
		if (backMove) {
			endDisL = Robot.driveTrain.getLeftDistance() - travelDisL;
			endDisR = Robot.driveTrain.getRightDistance() - travelDisR;
		} else {
			endDisL = Robot.driveTrain.getLeftDistance() + travelDisL;
			endDisR = Robot.driveTrain.getRightDistance() + travelDisR;
		}
		System.out.println("Left: " + Robot.driveTrain.getLeftDistance() + " " + endDisL);
		System.out.println("Right: " + Robot.driveTrain.getRightDistance() + " " + endDisR);
	}

	protected void execute() {
		Robot.driveTrain.tankDrive(-leftSpeed, -rightSpeed);
		System.out.println("Speed: " + -leftSpeed + " " + -rightSpeed);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		if (backMove) {
			System.out.println(
					Robot.driveTrain.getRightDistance() >= endDisR || Robot.driveTrain.getLeftDistance() >= endDisL);
			System.out
					.println("L: " + Robot.driveTrain.getLeftDistance() + " R: " + Robot.driveTrain.getRightDistance());
			return (Robot.driveTrain.getRightDistance() <= endDisR || Robot.driveTrain.getLeftDistance() <= endDisL);
		} else {
			System.out.println(
					Robot.driveTrain.getRightDistance() >= endDisR || Robot.driveTrain.getLeftDistance() >= endDisL);
			System.out
					.println("L: " + Robot.driveTrain.getLeftDistance() + " R: " + Robot.driveTrain.getRightDistance());
			return (Robot.driveTrain.getRightDistance() >= endDisR || Robot.driveTrain.getLeftDistance() >= endDisL);
		}
		// return (Robot.driveTrain.getLeftDistance() >= endDisL);
		// return false;
	}

	protected void end() {
		Robot.driveTrain.stop();
	}
}