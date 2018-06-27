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
	double leftRSpeed;
	double rightRSpeed;
	boolean done = false;
	boolean hasCube = false;
	int bucounter = 0;
	int counter = 0;
	int intakeCounter = 0;
	int fastCounter = 0;
	private final Ultrasonic proximity = RobotMap.ultra;

	public MoveUntilGetCube(double speed, double returnSpeed) {
		requires(Robot.driveTrain);
		botSpeed = -speed;
		leftSpeed = botSpeed;
		rightSpeed = botSpeed;
		leftRSpeed = -returnSpeed;
		rightRSpeed = -returnSpeed;
	}

	protected void initialize() {
		startDistance = Robot.driveTrain.getRightDistance();
		System.out.println(driveDistance);
		System.out.println("Starting Distance: " + Robot.driveTrain.getRightDistance());
	}

	protected void execute() {
		if ((proximity.getRangeInches() > RobotMap.cubeProximity && hasCube != true) || bucounter < 25) {
			if (intakeCounter < 50) {
				if (fastCounter < 25) {
					Robot.driveTrain.tankDrive(-1, -1);
					fastCounter++;
				} else {
					Robot.intake.speed(1);
					if (counter < 6) { // NOSIDE specialty move lisp
						// if (counter < 150) { //CURVE
						// Robot.driveTrain.tankDrive(leftSpeed, rightSpeed * .75); //CURVE
						Robot.driveTrain.tankDrive(leftSpeed, rightSpeed); // NOSIDE specialty move
						counter++;
					} else {
						if (counter < 12) { // NOSIDE specialty move
							// if (counter < 200) { //CURVE
							// Robot.driveTrain.tankDrive(leftSpeed * .75, rightSpeed); //CURVE
							Robot.driveTrain.tankDrive(leftSpeed / 2, rightSpeed / 2); // NOSIDE specialty move
							counter++;
						} else {
							counter = 0;
						}
					}
					intakeCounter++;
				}
			} else {
				if (bucounter > 1) {
					if (intakeCounter < 56) {
						Robot.intake.speed(1);
						intakeCounter++;
					} else {
						intakeCounter = 0;
					}
				} else {

					if (intakeCounter < 56) {
						Robot.intake.speed(-.7);
						intakeCounter++;
					} else {
						intakeCounter = 0;
					}
				}
			}
			if (proximity.getRangeInches() > RobotMap.cubeProximity && hasCube != true) {

			} else {
				Robot.intake.speed(1);
				bucounter++;
			}
		} else {
			if (hasCube) {
				if (Robot.driveTrain.getRightDistance() > startDistance) {
					Robot.driveTrain.tankDrive(-leftRSpeed, -rightRSpeed);
				} else {
					done = true;
				}
			} else {
				movedDistance = Robot.driveTrain.getRightDistance() - startDistance;
				Robot.claw.close();
				try {
					Thread.sleep(500);
					hasCube = true;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return done;
	}

	protected void end() {
		hasCube = false;
		bucounter = 0;
		counter = 0;
		done = false;
		Robot.driveTrain.stop();
	}
}
