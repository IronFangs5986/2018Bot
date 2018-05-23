package org.usfirst.frc.team5986.robot.subsystems;

import org.usfirst.frc.team5986.robot.Robot;
import org.usfirst.frc.team5986.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import org.usfirst.frc.team5986.robot.commands.*;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem{
	private final WPI_TalonSRX inLeft = RobotMap.inLeft;
	private final WPI_TalonSRX inRight = RobotMap.inRight;
	private final double intakeDeadZone = RobotMap.intakeDeadZone;
	private final double intakeMaxSpeed = RobotMap.intakeMaxSpeed;
	//boolean elevatorIsMoving = Elevator.elevatorIsMoving;
	double intakeSpeed;	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new MoveIntake());
	}

	public void speed(double speed) {
		boolean elevatorIsMoving = Elevator.isElevatorMoving();
		System.out.println("From intake: "+elevatorIsMoving);
	if (elevatorIsMoving) {
		intakeSpeed = .2;
	} else {
		if (Math.abs(speed) < intakeDeadZone) {
		intakeSpeed = 0;	
		} else {
		
			if (Math.abs(speed) > intakeMaxSpeed) {
				intakeSpeed = intakeMaxSpeed;		
			} else {
			intakeSpeed = speed;
			}
		
    }
		
	}
	inLeft.set(intakeSpeed * -1);
	inRight.set(intakeSpeed);
	}
}
