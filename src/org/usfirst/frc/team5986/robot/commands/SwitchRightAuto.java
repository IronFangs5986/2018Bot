package org.usfirst.frc.team5986.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class SwitchRightAuto extends CommandGroup {
	public SwitchRightAuto() {
		addSequential(new EncoderTurn(14, 2.1, true, false, false));
		addSequential(new EncoderStraightDrive(.75, 11, 0));
		// addSequential(new EncoderTurn(90, 2.1, false, false, false));
		addSequential(new AutoOneSideTurn(48, 2.1, false, false));
		addSequential(new WaitCommand(1));
		addSequential(new EncoderStraightDrive(-.75, 2, 0));
	}
}
