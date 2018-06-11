package org.usfirst.frc.team5986.robot.commands;

import org.usfirst.frc.team5986.robot.ADIS16448_IMU;
import org.usfirst.frc.team5986.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.interfaces.Gyro;

public class EncoderTurn extends Command {
	double leftSpeed;
	double rightSpeed;
	double endDegrees;
	double newDegrees;
	Gyro gyro = new ADIS16448_IMU();
	public EncoderTurn(double degrees, double speed) {
		requires(Robot.driveTrain);
		newDegrees = degrees;
		if (degrees > 0) { //Turn right
		leftSpeed = Math.abs(-speed);
		rightSpeed = Math.abs(-speed/2);
		} else if (degrees < 0) { //Turn left
			leftSpeed = Math.abs(-speed/2);
			rightSpeed = Math.abs(-speed);	
		}
	}
	protected void initialize() {
		gyro.reset();
		endDegrees = gyro.getAngle() + newDegrees;
		System.out.println(newDegrees);
		System.out.println("Starting Degrees: "+ gyro.getAngle());
		System.out.println("End Degrees: "+endDegrees);
	}
	protected void execute() {
		Robot.driveTrain.tankDrive(leftSpeed, rightSpeed);
		System.out.println("Degrees: "+ gyro.getAngle());
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return (gyro.getAngle() >= endDegrees);
	}
	protected void end() {
		Robot.driveTrain.stop();
	}
}