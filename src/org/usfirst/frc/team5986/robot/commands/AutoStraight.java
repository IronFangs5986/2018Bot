package org.usfirst.frc.team5986.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoStraight extends CommandGroup {

	public AutoStraight() {
		/*
		 * addSequential(new CloseClaw()); addParallel(new EncoderStraightDrive(.7, 3,
		 * 0)); addSequential(new ElevatorMiddle(.4)); addSequential(new
		 * WaitCommand(1)); addSequential(new OpenClaw()); addSequential(new
		 * WaitCommand(1)); addSequential(new CloseClaw()); addSequential(new
		 * EncoderStraightDrive(.7, 3, 0)); addSequential(new WaitCommand(1));
		 * addSequential(new ElevatorTop(.4)); addSequential(new OpenClaw());
		 * addSequential(new WaitCommand(1)); addSequential(new CloseClaw());
		 * addSequential(new WaitCommand(1)); addSequential(new EncoderStraightDrive(.7,
		 * 3, 0));
		 * 
		 * addSequential(new EncoderTurn(45, 2.5, true)); addSequential(new
		 * EncoderTurn(60, 2.5, false)); addSequential(new EncoderStraightDrive(.7, 5,
		 * 0));
		 */
		// addParallel(new CloseClaw());
		// addSequential(new EncoderStraightDrive(.7, 11, 0));

		// addParallel(new OpenClaw());
		// addParallel(new AutoIntake(.5));
		// addParallel(new IntakeDown());
		// addSequential(new MoveUntilGetCube(.7, 1));
		// addSequential(new EncoderTurn(20, 2.1, true, false, true));
		addSequential(new AutoOneSideTurn(25, 2.1, false, false));
	}
}
