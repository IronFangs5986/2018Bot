package org.usfirst.frc.team5986.robot.commands;

import org.usfirst.frc.team5986.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class MiddleSwitch extends CommandGroup {
	int counter = 0;

	public MiddleSwitch() {
		counter = 0;
		String gameData = Robot.getGameData();
		if (gameData.length() > 0) {
			if (gameData.charAt(0) == 'L') {
				System.out.println("Left switch");
				addSequential(new IntakeDown());
				addSequential(new WaitCommand(1));
				addParallel(new CloseClaw());
				addParallel(new ElevatorMiddle(.7));
				addSequential(new EncoderTurn(25, 2.1, false, false, false));
				addSequential(new EncoderStraightDrive(.75, 4, 7));
				addParallel(new IntakeUp());
				addSequential(new EncoderTurn(41, 3, true, false, false));
				addSequential(new EncoderStraightDrive(.75, 2, 2));
				addSequential(new WaitCommand(.5));
				addSequential(new OpenClaw());
				addSequential(new WaitCommand(.5));
				addSequential(new CloseClaw());
				while (counter < 10) {
					addParallel(new ElevatorMoveBottom());
					addParallel(new IntakeDown());
					addParallel(new AutoIntake(1));
					addSequential(new EncoderStraightDrive(-.75, 2, 2));
					addSequential(new AutoOneSideTurn(24 * (counter + 1), 2.1, false, true));
					addSequential(new OpenClaw());
					addSequential(new MoveUntilGetCube(1, .8));
					// EXTRA
					addSequential(new EncoderStraightDrive(-.8, 2, 0));
					// EXTRA END
					addSequential(new IntakeDown());
					addSequential(new WaitCommand(.5));
					addSequential(new AutoIntake(-.7));
					addSequential(new ElevatorMiddle(.8));
					addParallel(new IntakeUp());
					addSequential(new AutoOneSideTurn(30 * (counter + 1), 2.1, false, false));
					addSequential(new EncoderStraightDrive(.75, 4, 6));

					addSequential(new WaitCommand(.5));
					addSequential(new OpenClaw());
					addSequential(new WaitCommand(.5));
					addSequential(new CloseClaw());
					counter++;
				}
				counter = 0;
				addSequential(new EncoderStraightDrive(-.7, 2, 0));
			} else if (gameData.charAt(0) == 'R') {
				addSequential(new IntakeDown());
				addSequential(new WaitCommand(1));
				addParallel(new CloseClaw());
				addParallel(new ElevatorMiddle(.7));
				addSequential(new EncoderTurn(15, 2.1, true, false, false));
				addSequential(new EncoderStraightDrive(.75, 4, 2));
				addParallel(new IntakeUp());
				addSequential(new EncoderTurn(41, 3, false, false, false));
				addSequential(new EncoderStraightDrive(.75, 3, 3));
				addSequential(new WaitCommand(.5));
				addSequential(new OpenClaw());
				addSequential(new WaitCommand(.5));
				addSequential(new CloseClaw());
				while (counter < 10) {
					addParallel(new ElevatorMoveBottom());
					addParallel(new IntakeDown());
					addParallel(new AutoIntake(1));
					addSequential(new EncoderStraightDrive(-.75, 2, 8));
					addSequential(new AutoOneSideTurn(22 * (counter + 1), 2.1, true, true));
					addSequential(new OpenClaw());
					addSequential(new MoveUntilGetCube(.8, .8));
					addSequential(new IntakeDown());
					addSequential(new WaitCommand(.5));
					addSequential(new AutoIntake(-.7));
					addSequential(new ElevatorMiddle(.8));
					addParallel(new IntakeUp());
					addSequential(new EncoderTurn(45, 2.1, true, false, true));
					addSequential(new EncoderStraightDrive(.75, 2, 0));

					addSequential(new WaitCommand(.5));
					addSequential(new OpenClaw());
					addSequential(new WaitCommand(.5));
					addSequential(new CloseClaw());
					counter++;
				}
				counter = 0;
			}
		}
	}
}
