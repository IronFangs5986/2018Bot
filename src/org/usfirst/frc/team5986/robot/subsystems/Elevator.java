package org.usfirst.frc.team5986.robot.subsystems;

import org.usfirst.frc.team5986.robot.RobotMap;
import org.usfirst.frc.team5986.robot.commands.ArcadeDrive;
import org.usfirst.frc.team5986.robot.commands.ElevatorMove;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Elevator extends Subsystem {
	private final WPI_TalonSRX elevatorLeft = RobotMap.elevatorLeft;
	private final WPI_TalonSRX elevatorRight = RobotMap.elevatorRight;
	private final double elevatorDeadZone = RobotMap.elevatorDeadZone;
	double elevatorSpeed;

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new ElevatorMove());
	}
	public void move(double speed) {
		if (Math.abs(speed) < elevatorDeadZone) {
			elevatorSpeed = 0;
			/*if (Math.abs(Driver.getRawAxis(5)) < intakeDeadZone) {
				intakeSpeedL = 0;
				intakeSpeedR = 0;
			}*/
		} else {
			elevatorSpeed = speed;
			System.out.println(elevatorSpeed);
			//intakeSpeedR = -.2;
			//intakeSpeedL = .2;
		}
		elevatorLeft.set(ControlMode.PercentOutput, elevatorSpeed);
		elevatorRight.set(ControlMode.PercentOutput, elevatorSpeed * -1);
	}
}
