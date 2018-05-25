package org.usfirst.frc.team5986.robot.commands;

import org.usfirst.frc.team5986.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class AutoStraight extends CommandGroup {

	public AutoStraight() {
		addSequential(new CloseClaw());
		addSequential(new EncoderStraightDrive(.7, 4, 0));
		/*addSequential(new WaitCommand(1));
		addSequential(new OpenClaw());
		addSequential(new WaitCommand(1));
		addSequential(new CloseClaw());
		addSequential(new WaitCommand(1));
		addSequential(new OpenClaw());
		addSequential(new WaitCommand(1));
		addSequential(new CloseClaw());*/
	}
}
