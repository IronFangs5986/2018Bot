package org.usfirst.frc.team5986.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class MiddleScale extends CommandGroup {

	public MiddleScale(String gameData) {
		System.out.println("Ra");
		if (gameData.length() > 0) {
			if (gameData.charAt(0) == 'L') {
				System.out.println("Left scale autonomous");
				addSequential(new IntakeDown());
				addSequential(new WaitCommand(1));
				addParallel(new CloseClaw());
				addParallel(new ElevatorTop(.7));
				addSequential(new EncoderTurn(85, 2.5, false, false));
				addSequential(new IntakeUp());
				addSequential(new EncoderStraightDrive(1, 7, 7));
				addSequential(new EncoderTurn(10, 2.5, false, false));
				addSequential(new EncoderTurn(123, 2.5, true, false)); // 115
				addSequential(new EncoderStraightDrive(1, 7, 6));
				addSequential(new EncoderTurn(135, 2.5, true, false));
				addSequential(new WaitCommand(1));
				addParallel(new OpenClaw());
				addSequential(new WaitCommand(1));
				addParallel(new CloseClaw());
				addSequential(new EncoderTurn(75, 2.1, false, true));
				addSequential(new ElevatorMoveBottom());
				addSequential(new AutoIntake(0));
				addSequential(new RobotStop());
			} else if (gameData.charAt(0) == 'R') {
				System.out.println("Right scale autonomous");
				addSequential(new IntakeDown());
				addSequential(new WaitCommand(1));
				addParallel(new CloseClaw());
				addParallel(new ElevatorTop(.7));
				addSequential(new EncoderTurn(75, 2.5, true, false));
				addSequential(new IntakeUp());
				addSequential(new EncoderStraightDrive(1, 7, 7));
				addSequential(new EncoderTurn(45, 2.5, true, false));
				addSequential(new EncoderTurn(125, 2.5, false, false)); // 115
				addSequential(new EncoderStraightDrive(1, 9, 0));
				addSequential(new EncoderTurn(110, 2.5, false, false));
				addSequential(new WaitCommand(1));
				addParallel(new OpenClaw());
				addSequential(new WaitCommand(1));
				addParallel(new CloseClaw());
				addSequential(new EncoderTurn(75, 2.1, true, true));
				addSequential(new ElevatorMoveBottom());
				addSequential(new AutoIntake(0));
				addSequential(new RobotStop());

			}
		}
	}
}
