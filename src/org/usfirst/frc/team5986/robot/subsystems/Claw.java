package org.usfirst.frc.team5986.robot.subsystems;

import org.usfirst.frc.team5986.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Claw extends Subsystem{
private final Solenoid open = RobotMap.holderOpen;
private final Solenoid close = RobotMap.holderClose;
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
public void open() {
	open.set(true);
	close.set(false);
}
public void close() {
	open.set(false);
	close.set(true);
}
}
