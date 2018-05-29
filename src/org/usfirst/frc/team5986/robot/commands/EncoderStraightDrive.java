package org.usfirst.frc.team5986.robot.commands;

import org.usfirst.frc.team5986.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class EncoderStraightDrive extends Command{
double ftDistance;
double inDistance;
double driveDistance;
double endDistance;
double botSpeed;
double leftSpeed;
double rightSpeed;

public EncoderStraightDrive(double speed, double userFeet, double userInches) {
	requires(Robot.driveTrain);
	driveDistance = (userFeet + (userInches/12));
	botSpeed = -speed;
	leftSpeed = botSpeed;
	rightSpeed = botSpeed;
}
protected void initialize() {
	endDistance = Robot.driveTrain.getRightDistance() + driveDistance;
	System.out.println(driveDistance);
	System.out.println("Starting Distance: "+ Robot.driveTrain.getRightDistance());
	System.out.println("End Distance: "+endDistance);
}
protected void execute() {
	Robot.driveTrain.tankDrive(leftSpeed, rightSpeed);
}
@Override
protected boolean isFinished() {
	// TODO Auto-generated method stub
	return (Robot.driveTrain.getRightDistance() >= endDistance);
}
protected void end() {
	Robot.driveTrain.stop();
}
}
