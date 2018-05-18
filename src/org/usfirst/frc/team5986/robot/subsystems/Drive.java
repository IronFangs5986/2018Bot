package org.usfirst.frc.team5986.robot.subsystems;

import org.usfirst.frc.team5986.robot.RobotMap;
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
		
	}
public void arcadeDrive(Double x, Double y) {
	robotDrive.arcadeDrive(x, y);
}
public void followPath() {
	
}
public void setPath(Path path) {
	// TODO Auto-generated method stub
	
}

}
