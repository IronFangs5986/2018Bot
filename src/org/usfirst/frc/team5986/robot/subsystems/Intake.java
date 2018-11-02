package org.usfirst.frc.team5986.robot.subsystems;

import org.usfirst.frc.team5986.robot.RobotMap;
import org.usfirst.frc.team5986.robot.commands.MoveIntake;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class Intake extends Subsystem {
	private final WPI_TalonSRX inLeft = RobotMap.inLeft;
	private final WPI_TalonSRX inRight = RobotMap.inRight;
	private final double intakeDeadZone = RobotMap.intakeDeadZone;
	private final double intakeMaxSpeed = RobotMap.intakeMaxSpeed;
	// boolean elevatorIsMoving = Elevator.elevatorIsMoving;
	double intakeSpeed;
	boolean newJoystick = false;

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new MoveIntake());
	}

	public void speed(double speed) {
		boolean elevatorIsMoving = Elevator.isElevatorMoving();
		if (elevatorIsMoving) {
			intakeSpeed = -.2;
		} else {
			if (!newJoystick) {
				if (Math.abs(speed) < intakeDeadZone) { // .3
					intakeSpeed = 0;
				} else {

					if (Math.abs(speed) > intakeMaxSpeed) { // .7
						if (speed < 0) {
							intakeSpeed = -intakeMaxSpeed;
						} else {
							intakeSpeed = intakeMaxSpeed;
						}
					} else {
						intakeSpeed = speed;
					}
				}
			} else {
				// New Joystick
				if (speed > 0) {
					intakeSpeed = 0;
				} else {
					intakeSpeed = -speed;
				}
			}

		}
		inLeft.set(intakeSpeed * -1);
		inRight.set(intakeSpeed);
		NetworkTable.getTable("SmartDashboard").putNumber("intakeSpeed", Math.abs(intakeSpeed));
	}
}
