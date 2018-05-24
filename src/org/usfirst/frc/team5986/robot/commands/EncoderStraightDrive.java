package org.usfirst.frc.team5986.robot.commands;

import org.usfirst.frc.team5986.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class EncoderStraightDrive extends Command{
int ftDistance;
int inDistance;
int driveDistance;
double endDistance;
double botSpeed;
double leftSpeed;
double rightSpeed;
public EncoderStraightDrive(double speed, int userFeet, int userInches) {
	requires(Robot.driveTrain);
	driveDistance = (userInches + (12 * userFeet));
	botSpeed = speed;
	leftSpeed = botSpeed;
	rightSpeed = botSpeed;
}
protected void initialize() {
	endDistance = Robot.driveTrain.getRightDistance() + driveDistance;
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
