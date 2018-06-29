package org.usfirst.frc.team5986.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DoNothingAuto extends CommandGroup {
	public DoNothingAuto() {
		addSequential(new CloseClaw());
		addSequential(new IntakeDown());

	}
}
