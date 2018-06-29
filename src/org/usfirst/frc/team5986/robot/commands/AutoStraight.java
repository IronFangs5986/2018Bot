package org.usfirst.frc.team5986.robot.commands;

import org.usfirst.frc.team5986.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoStraight extends CommandGroup {

	public AutoStraight() {
		System.out.println("RUNNING STRAIGHT");
		System.out.flush();
		addSequential(new CloseClaw());
		String localgameData = Robot.GameData;
		if (localgameData.length() > 0) {
			System.out.println("*\n*\n*\nGAMEDATA: " + localgameData);
			if (localgameData.charAt(0) == 'L') {
				addSequential(new EncoderStraightDrive(.75, 10, 0));
			} else if (localgameData.charAt(0) == 'R') {
				addSequential(new EncoderStraightDrive(-.75, 10, 0));
			}
		} else {

			addSequential(new IntakeDown());
			System.out.println("GAMEDATA FROM AUTOSTRAIGHT");
		}
	}
}
