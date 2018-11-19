package org.usfirst.frc.team5986.robot.subsystems;

import org.usfirst.frc.team5986.robot.Robot;
import org.usfirst.frc.team5986.robot.RobotMap;
import org.usfirst.frc.team5986.robot.commands.ElevatorMove;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class Elevator extends Subsystem {
	private final WPI_TalonSRX elevatorLeft = RobotMap.elevatorLeft;
	private final WPI_TalonSRX elevatorRight = RobotMap.elevatorRight;
	private final double elevatorDeadZone = RobotMap.elevatorDeadZone;
	public static boolean elevatorIsMoving = false;
	double elevatorSpeed;
	public static boolean useIntake;

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new ElevatorMove());
	}

	public void move(double speed, boolean intake) {
		useIntake = intake;
		double maxSpeed = NetworkTable.getTable("SmartDashboard").getNumber("elevatorMax", 0);
		System.out.println(maxSpeed);
		if (Robot.oi.joystick2.getRawButton(3)) {
			elevatorSpeed = -.2;
		} else {
			if (Math.abs(speed) < elevatorDeadZone || speed > 0) {
				elevatorSpeed = 0;
				elevatorIsMoving = false;
				/*
				 * if (Math.abs(Driver.getRawAxis(5)) < intakeDeadZone) { intakeSpeedL = 0;
				 * intakeSpeedR = 0; }
				 */
			} else {
				if (Math.abs(speed) < maxSpeed) {
					elevatorSpeed = speed;
				} else {
					if (speed < 0) {
						elevatorSpeed = -maxSpeed;
					} else {
						elevatorSpeed = maxSpeed;
					}
				}
				System.out.println("***" + elevatorSpeed);
				elevatorIsMoving = true;
			}
		}
		elevatorLeft.set(ControlMode.PercentOutput, elevatorSpeed);
		elevatorRight.set(ControlMode.PercentOutput, elevatorSpeed * -1);
		NetworkTable.getTable("SmartDashboard").putNumber("elevatorSpeed", Math.abs(elevatorSpeed));
		// System.out.println("From elevator: "+elevatorIsMoving);
	}

	public static boolean isElevatorMoving() {
		if (elevatorIsMoving && useIntake) {
			return true;
		} else {
			return false;
		}
	}

	public void stop() {
		elevatorLeft.set(ControlMode.PercentOutput, 0);
		elevatorRight.set(ControlMode.PercentOutput, 0);
	}

	public void hold() {
		elevatorLeft.set(ControlMode.PercentOutput, -.2);
		elevatorRight.set(ControlMode.PercentOutput, .2);
	}

	public boolean getMiddle() {
		return RobotMap.middleSwitch.get();
	}

	public boolean getTop() {
		return RobotMap.topSwitch.get();
	}
}
