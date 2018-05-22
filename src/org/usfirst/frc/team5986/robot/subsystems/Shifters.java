package org.usfirst.frc.team5986.robot.subsystems;

import org.usfirst.frc.team5986.robot.RobotMap;
import org.usfirst.frc.team5986.robot.commands.ShiftGear;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shifters extends Subsystem{
	private final Solenoid fastGear = RobotMap.shifterFast;
	private final Solenoid slowGear = RobotMap.shifterSlow;
	private final double shifterDeadZone = RobotMap.shifterDeadZone;
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new ShiftGear());
	}
public void shift(double speed) {
	if (speed >= shifterDeadZone) {
		fastGear.set(true);
		slowGear.set(false);
	} else {
		fastGear.set(false);
		slowGear.set(true);
	}
}
}
