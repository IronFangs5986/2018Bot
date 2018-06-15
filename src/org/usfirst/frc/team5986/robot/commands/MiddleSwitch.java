package org.usfirst.frc.team5986.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class MiddleSwitch extends CommandGroup {

	public MiddleSwitch(String gameData) {
		if (gameData.length() > 0) {
			if (gameData.charAt(0) == 'L') {
				System.out.println("Left switch");
				addSequential(new IntakeDown());
				addSequential(new WaitCommand(1));
				addParallel(new CloseClaw());
				addParallel(new ElevatorMiddle(.7));
				addSequential(new EncoderTurn(45, 2.5, false, false));
				addSequential(new EncoderStraightDrive(.7, 6, 2));
				addParallel(new IntakeUp());
				addSequential(new EncoderTurn(45, 2.5, true, false));
				addSequential(new WaitCommand(1));
				addSequential(new OpenClaw());
				addSequential(new WaitCommand(.5));
				addSequential(new CloseClaw());
				addParallel(new ElevatorMoveBottom());
				addSequential(new EncoderStraightDrive(-.7, 2, 0));
				addSequential(new EncoderStraightDrive(0, 0, 0));
				addSequential(new OpenClaw());
				addSequential(new OpenClaw());
			} else if (gameData.charAt(0) == 'R') {
				addSequential(new IntakeDown());
				addSequential(new WaitCommand(1));
				addParallel(new CloseClaw());
				addParallel(new ElevatorMiddle(.7));
				addSequential(new EncoderTurn(45, 2.5, true, false));
				addSequential(new EncoderStraightDrive(.7, 6, 2));
				addParallel(new IntakeUp());
				addSequential(new EncoderTurn(45, 2.5, false, false));
				addSequential(new WaitCommand(1));
				addSequential(new OpenClaw());
				addSequential(new WaitCommand(.5));
				addSequential(new CloseClaw());
				addParallel(new ElevatorMoveBottom());
				addSequential(new EncoderStraightDrive(-.7, 2, 0));
				addSequential(new EncoderStraightDrive(0, 0, 0));
				addSequential(new OpenClaw());
				addSequential(new OpenClaw());
				// addSequential(new EncoderTurn(105, 2.5, false, false));
				// addParallel(new AutoIntake(-.7));
				// addParallel(new OpenClaw());
				// addParallel(new IntakeDown());
				// addSequential(new EncoderStraightDrive(.7, 3, 0));
				// addSequential(new EncoderStraightDrive(-.7, 3, 0));
				/*
				 * addSequential(new MoveUntilGetCube(.7)); addParallel(new ElevatorMiddle(.4));
				 * addSequential(new EncoderTurn(105, 2.5, false, true)); addParallel(new
				 * IntakeUp()); addSequential(new EncoderStraightDrive(.7, 4, 0));
				 * addSequential(new OpenClaw()); addSequential(new WaitCommand(.5));
				 * addSequential(new CloseClaw()); addParallel(new ElevatorMoveBottom());
				 * addSequential(new EncoderStraightDrive(-.7, 4, 0));
				 */
			}
		}
	}
}
