package org.usfirst.frc.team5986.robot.commands;

import org.usfirst.frc.team5986.robot.Robot;
import org.usfirst.frc.team5986.robot.RobotMap;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Command;

public class MoveUntilGetCube extends Command {
	double ftDistance;
	double inDistance;
	double driveDistance;
	double movedDistance;
	double startDistance;
	double botSpeed;
	double leftSpeed;
	double rightSpeed;
	boolean done = false;
	boolean hasCube = false;
	private final Ultrasonic proximity = RobotMap.ultra;

	public MoveUntilGetCube(double speed) {
		requires(Robot.driveTrain);
		botSpeed = -speed;
		leftSpeed = botSpeed;
		rightSpeed = botSpeed;
	}

	protected void initialize() {
		startDistance = Robot.driveTrain.getRightDistance();
		System.out.println(driveDistance);
		System.out.println("Starting Distance: " + Robot.driveTrain.getRightDistance());
	}

	protected void execute() {
		if (proximity.getRangeInches() > RobotMap.cubeProximity) {
			Robot.driveTrain.tankDrive(leftSpeed, rightSpeed);
		} else {
			if (hasCube) {
				if (Robot.driveTrain.getRightDistance() > startDistance) {
					Robot.driveTrain.tankDrive(-leftSpeed, -rightSpeed);
				} else {
					done = true;
				}
			} else {
				movedDistance = Robot.driveTrain.getRightDistance() - startDistance;
				hasCube = true;
			}
		}
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return done;
	}

	protected void end() {
		Robot.driveTrain.stop();
	}
}
