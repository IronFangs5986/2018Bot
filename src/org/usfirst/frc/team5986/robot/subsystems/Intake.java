package org.usfirst.frc.team5986.robot.subsystems;

import org.usfirst.frc.team5986.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import org.usfirst.frc.team5986.robot.commands.*;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem{
	private final WPI_TalonSRX inLeft = RobotMap.inLeft;
	private final WPI_TalonSRX inRight = RobotMap.inRight;
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

	public void speed(double speed) {
		inLeft.set(speed * -1);
		inRight.set(speed);
    }
}
