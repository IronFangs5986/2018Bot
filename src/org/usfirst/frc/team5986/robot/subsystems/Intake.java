package org.usfirst.frc.team5986.robot.subsystems;

import org.usfirst.frc.team5986.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import org.usfirst.frc.team5986.robot.commands.*;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem{
	private final WPI_TalonSRX inLeft = RobotMap.inLeft;
	private final WPI_TalonSRX inRight = RobotMap.inRight;
	private final double intakeDeadZone = RobotMap.intakeDeadZone;
	private final double intakeMaxSpeed = RobotMap.intakeMaxSpeed;
			
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new MoveIntake());
	}

	public void speed(double speed) {
		if (speed > intakeDeadZone) {
			if (speed > intakeMaxSpeed) {
				inLeft.set(intakeMaxSpeed * -1);
				inRight.set(intakeMaxSpeed);		
			} else {
			inLeft.set(speed * -1);
			inRight.set(speed);	
			}
		}
    }
}
