package org.usfirst.frc.team5986.robot.commands;

import org.usfirst.frc.team5986.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoStraight extends CommandGroup {

	public AutoStraight() {
		addSequential(new CloseClaw());
		addSequential(new EncoderStraightDrive(.7, 11, 0));
	}
}
