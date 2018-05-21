package org.usfirst.frc.team5986.robot.subsystems;

import org.usfirst.frc.team5986.robot.RobotMap;
import org.usfirst.frc.team5986.robot.commands.ArcadeDrive;
import org.usfirst.frc.team5986.robot.util.paths.Path;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.followers.EncoderFollower;
import jaci.pathfinder.modifiers.TankModifier;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drive extends Subsystem {
	RobotDrive robotDrive = RobotMap.driveTrainRobotDrive;
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new ArcadeDrive());
	}
public void arcadeDrive(Joystick joystick) {
	robotDrive.arcadeDrive(joystick);
}
public void followPath() {
	
}
public void setPath(Path path) {
	// TODO Auto-generated method stub
	
}

}
