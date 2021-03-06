package org.usfirst.frc.team5986.robot.util.paths;

import jaci.pathfinder.Waypoint;
import org.usfirst.frc.team5986.robot.Constants;
import org.usfirst.frc.team5986.robot.util.paths.Path;
public class RightBaseline extends Path {
	 public RightBaseline () {

	        // Set the name of this path
	        setName("RightCrossBaseline");

	        // Set the config
	        setConfig(Constants.pathfinderConfig);

	        double halfBotLen = Constants.kRobotLength / 2.0;
	        double halfBotWid = Constants.kRobotWidth / 2.0;

	        setPoints(new Waypoint[] {
	                new Waypoint((halfBotLen),              (2.5 + halfBotWid), 0.0),
	                new Waypoint((halfBotLen + (2.0/12.0)), (2.5 + halfBotWid), 0.0),
	                new Waypoint((9.0),                     (2.5),              0.0),
	                new Waypoint((14.0),                    (2.5),              0.0),
	        });

	    }
}
