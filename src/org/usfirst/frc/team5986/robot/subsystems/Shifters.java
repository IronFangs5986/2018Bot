package org.usfirst.frc.team5986.robot.subsystems;

import org.usfirst.frc.team5986.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shifters extends Subsystem{
	private final Solenoid fastGear = RobotMap.shifterFast;
	private final Solenoid slowGear = RobotMap.shifterSlow;
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
public void fast(Boolean fast) {
	if (fast == true) {
		fastGear.set(true);
		slowGear.set(false);
	} else {
		fastGear.set(false);
		slowGear.set(true);
	}
}
}
