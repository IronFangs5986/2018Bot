package org.usfirst.frc.team5986.robot.subsystems;

import org.usfirst.frc.team5986.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class IntakeDrop extends Subsystem{
	
	private final Solenoid intakePiston1 = RobotMap.intakePiston;
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
public void up() {
	intakePiston1.set(false);
}
public void down() {
	intakePiston1.set(true);
}
}
