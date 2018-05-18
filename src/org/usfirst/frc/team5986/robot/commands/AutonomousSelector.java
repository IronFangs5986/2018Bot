package org.usfirst.frc.team5986.robot.commands;

import org.usfirst.frc.team5986.robot.Constants;
import org.usfirst.frc.team5986.robot.Robot;
import edu.wpi.first.wpilibj.command.CommandGroup;


public class AutonomousSelector extends CommandGroup {
	public enum StartingPosition {
        Left("Left"),
        Center("Center"),
        Right("Right");

        public String name;

        StartingPosition (String name) {
            this.name = name;
        }
    }
	 public enum Goal {
	        Nothing("Do nothing"),
	        Baseline("Cross the baseline"),
	        Switch("Place a cube in the switch"),
	        Scale("Place a cube in the scale");

	        public String name;

	        Goal (String name) {
	            this.name = name;
	        }
	    }
	 
	// Input values
	    private StartingPosition startingPosition;
	    private Goal goal;

	    public AutonomousSelector (StartingPosition startingPosition, Goal goal) {

	        // Require the subsystems this command group uses
	        requires(Robot.driveTrain);

	        // Remember the input values
	        this.startingPosition = startingPosition;
	        this.goal = goal;

	        // Generate the routine using the input values
	        generateRoutine();

	    }
	    
	    private void generateRoutine () {

	        // Left-side autonomous routines
	        if (this.startingPosition == StartingPosition.Left) {
	            leftRoutines();
	        }

	        // Center autonomous routines
	        else if (this.startingPosition == StartingPosition.Center) {
	            //centerRoutines();
	        }

	        // Right-side autonomous routines
	        else if (this.startingPosition == StartingPosition.Right) {
	            //rightRoutines();
	        }

	    }

	    private void leftRoutines () {

	        // Left-side baseline auto
	        if (this.goal == Goal.Baseline) {

	            // Drive past the baseline
	            addSequential(new FollowPath(Constants.rightBaseline));

	        }

	        // Left-side switch auto
	        if (this.goal == Goal.Switch) {

	            
	        }

	        if (this.goal == Goal.Scale) {

	           
	            // TODO: Figure out what to do if we don't own the left scale

	        }

	    }
}
