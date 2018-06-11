package org.usfirst.frc.team5986.robot.commands;

import org.usfirst.frc.team5986.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class AutoStraight extends CommandGroup {

	public AutoStraight() {
		/*addSequential(new CloseClaw());
		addParallel(new EncoderStraightDrive(.7, 3, 0));
		addSequential(new ElevatorMiddle(.4));
		addSequential(new WaitCommand(1));
		addSequential(new OpenClaw());
		addSequential(new WaitCommand(1));
		addSequential(new CloseClaw());
		addSequential(new EncoderStraightDrive(.7, 3, 0));
		addSequential(new WaitCommand(1));
		addSequential(new ElevatorTop(.4));
		addSequential(new OpenClaw());
		addSequential(new WaitCommand(1));
		addSequential(new CloseClaw());
		addSequential(new WaitCommand(1));
		addSequential(new EncoderStraightDrive(.7, 3, 0));*/
		addSequential(new EncoderTurn(45, .7));
	}
}
