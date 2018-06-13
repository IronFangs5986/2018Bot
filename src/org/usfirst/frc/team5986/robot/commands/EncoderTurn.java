package org.usfirst.frc.team5986.robot.commands;

import org.usfirst.frc.team5986.robot.ADIS16448_IMU;
import org.usfirst.frc.team5986.robot.Robot;
import org.usfirst.frc.team5986.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.interfaces.Gyro;

public class EncoderTurn extends Command {
	double leftSpeed;
	double rightSpeed;
	double endDisR;
	double travelDisR;
	double endDisL;
	double travelDisL;
	Gyro gyro = new ADIS16448_IMU();
	private final double robotWidth = RobotMap.robotWidth;
	public EncoderTurn(double degrees, double radius, boolean rightTurn) {
		requires(Robot.driveTrain);
		double degreePercent = degrees/360;
		double robotWidthFt = robotWidth/12;
		if (rightTurn) {
		travelDisL = 2*Math.PI*(radius+(robotWidthFt/2))*degreePercent; //23.5 7.4 addSequential(new EncoderTurn(90, 1, true));
		travelDisR = 2*Math.PI*(radius-(robotWidthFt/2))*degreePercent;
		leftSpeed = 1;
		rightSpeed = leftSpeed*(travelDisR/travelDisL);
		//rightSpeed = .5;
		} else {
		travelDisL = 2*Math.PI*(radius-(robotWidthFt/2))*degreePercent; 
		travelDisR = 2*Math.PI*(radius+(robotWidthFt/2))*degreePercent;
		rightSpeed = 1;
		leftSpeed = rightSpeed*(travelDisL/travelDisR);
		//leftSpeed = .5;
		}
		System.out.println("left dis" + travelDisL);
		System.out.println("right dis" + travelDisR);
	}
	protected void initialize() {
		endDisL = Robot.driveTrain.getLeftDistance() + travelDisL;
		endDisR = Robot.driveTrain.getRightDistance() + travelDisR;
		System.out.println("Left: "+Robot.driveTrain.getLeftDistance() +" " +endDisL);
		System.out.println("Right: "+Robot.driveTrain.getRightDistance() +" " +endDisR);
	}
	protected void execute() {
		Robot.driveTrain.tankDrive(-leftSpeed, -rightSpeed);
		System.out.println("Speed: "+ -leftSpeed + " " + -rightSpeed);
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		System.out.println(Robot.driveTrain.getRightDistance() >= endDisR || Robot.driveTrain.getLeftDistance() >= endDisL);
		return (Robot.driveTrain.getRightDistance() >= endDisR || Robot.driveTrain.getLeftDistance() >= endDisL);
		//return (Robot.driveTrain.getLeftDistance() >= endDisL);
		//return false;
	}
	protected void end() {
		Robot.driveTrain.stop();
	}
}