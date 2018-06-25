package org.usfirst.frc.team5986.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class MiddleSwitch extends CommandGroup {
	int counter = 0;

	public MiddleSwitch(String gameData) {
		if (gameData.length() > 0) {
			if (gameData.charAt(0) == 'L') {
				System.out.println("Left switch");
				addSequential(new IntakeDown());
				addSequential(new WaitCommand(1));
				addParallel(new CloseClaw());
				addParallel(new ElevatorMiddle(.7));
				addSequential(new EncoderTurn(45, 2.5, false, false, false));
				addSequential(new EncoderStraightDrive(.7, 6, 2));
				addParallel(new IntakeUp());
				addSequential(new EncoderTurn(45, 2.5, true, false, false));
				addSequential(new WaitCommand(1));
				addSequential(new OpenClaw());
				addSequential(new WaitCommand(.5));
				addSequential(new CloseClaw());
				addParallel(new ElevatorMoveBottom());
				addSequential(new EncoderStraightDrive(-.7, 2, 0));
			} else if (gameData.charAt(0) == 'R') {
				addSequential(new IntakeDown());
				addSequential(new WaitCommand(1));
				addParallel(new CloseClaw());
				addParallel(new ElevatorMiddle(.7));
				// while (counter < 10) {
				addSequential(new EncoderTurn(45, 2.5, true, false, false));
				addSequential(new EncoderStraightDrive(.75, 6, 2));
				addParallel(new IntakeUp());
				addSequential(new EncoderTurn(45, 2.5, false, false, false));
				addSequential(new WaitCommand(.5));
				addSequential(new OpenClaw());
				addSequential(new WaitCommand(.5));
				addSequential(new CloseClaw());
				addParallel(new ElevatorMoveBottom());

				// ATTEMPT AT 2.0
				// addParallel(new IntakeDown());
				// addParallel(new AutoIntake(1));
				// addSequential(new EncoderStraightDrive(-.7, 5, 0));
				// addSequential(new EncoderTurn(65, 2.1, true, true, false));
				// addSequential(new OpenClaw()); // "parallel"
				// addSequential(new MoveUntilGetCube(.8, .8));
				// addParallel(new ElevatorMiddle(.8));
				// addParallel(new AutoIntake(0));
				// addSequential(new EncoderTurn(45, 2.1, true, false, false));
				// addParallel(new IntakeUp());
				// addSequential(new EncoderStraightDrive(.85, 5, 0));

				// addSequential(new WaitCommand(.5));
				// addSequential(new OpenClaw());
				// addSequential(new WaitCommand(.5));
				// addSequential(new CloseClaw());
				// addParallel(new ElevatorMoveBottom());

				// addParallel(new IntakeDown());
				// addParallel(new AutoIntake(1));
				// addSequential(new EncoderStraightDrive(-.85, 5, 0));
				// ATTEMPT AT 2.0 END

				// ATTEMPT AT 3.0
				addParallel(new IntakeDown());
				addParallel(new AutoIntake(1));
				addSequential(new EncoderStraightDrive(-.75, 2, 0));
				addSequential(new EncoderTurn(40, 2.1, true, true, true));
				addSequential(new OpenClaw());
				addSequential(new MoveUntilGetCube(.8, .8));
				addSequential(new IntakeDown());
				addSequential(new WaitCommand(.5));
				addSequential(new ElevatorMiddle(.8));
				addSequential(new EncoderTurn(40, 2.1, true, false, true));
				addSequential(new EncoderStraightDrive(.75, 2, 0));
				// ATTEMPT AT 3.0 END
				/*
				 * addSequential(new EncoderTurn(45, 2.5, false, true)); addParallel(new
				 * AutoIntake(1)); addParallel(new IntakeDown()); addSequential(new
				 * EncoderStraightDrive(-.7, 4, 2)); addSequential(new EncoderTurn(70, 2.5,
				 * true, true)); addParallel(new OpenClaw()); addSequential(new
				 * MoveUntilGetCube(.7, .7)); addSequential(new AutoIntake(0));
				 */

				// Front

				// addParallel(new ElevatorMiddle(1));
				// counter++;
				// }
				// *** *** *** EXTRA *** *** ***
				/*
				 * addParallel(new ElevatorMiddle(.7)); addSequential(new EncoderTurn(45, 2.5,
				 * true, false)); addSequential(new EncoderStraightDrive(.7, 6, 2));
				 * addParallel(new IntakeUp()); addSequential(new EncoderTurn(45, 2.5, false,
				 * false)); // while (counter < 10) { addSequential(new WaitCommand(.5));
				 * addSequential(new OpenClaw()); addSequential(new WaitCommand(.5));
				 * addSequential(new CloseClaw()); addParallel(new ElevatorMoveBottom());
				 */

				// addSequential(new EncoderTurn(45, 2.5, false, true));
				// addSequential(new EncoderStraightDrive(-.7, 4, 0));
				// addParallel(new EncoderTurn(90, 2.5, false, false));

				// WORKING DESTROy
				/*
				 * addSequential(new EncoderTurn(45, 2.5, true, true)); addSequential(new
				 * EncoderTurn(80, 3, false, false)); addSequential(new EncoderStraightDrive(1,
				 * 2, 0)); addSequential(new EncoderStraightDrive(-1, 1, 0)); addParallel(new
				 * AutoIntake(.7)); addParallel(new IntakeDown()); addSequential(new
				 * OpenClaw()); addSequential(new WaitCommand(1)); addSequential(new
				 * MoveUntilGetCube(.7, 1)); addParallel(new AutoIntake(-.7)); addSequential(new
				 * ElevatorMiddle(1)); addParallel(new AutoIntake(0)); addSequential(new
				 * EncoderStraightDrive(.7, 2, 0)); addParallel(new IntakeUp());
				 * addSequential(new EncoderTurn(130, 3, false, true)); // addSequential(new
				 * EncoderTurn(45, 2.1, true, false)); addSequential(new
				 * EncoderStraightDrive(.7, 3, 6)); // *** *** *** EXTRA *** *** ***
				 * addSequential(new WaitCommand(.5)); addSequential(new OpenClaw());
				 * addSequential(new WaitCommand(.5)); addSequential(new CloseClaw());
				 * addParallel(new ElevatorMoveBottom()); addSequential(new EncoderTurn(45, 2.5,
				 * true, true));
				 */

				/*
				 * addParallel(new AutoIntake(-.7)); addParallel(new IntakeDown());
				 * addSequential(new OpenClaw()); addSequential(new MoveUntilGetCube(.4));
				 * addParallel(new EncoderTurn(45, 2.5, false, true)); addParallel(new
				 * ElevatorMiddle(.7)); addSequential(new EncoderStraightDrive(.7, 4, 0));
				 */
				// counter++;
				// }
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
