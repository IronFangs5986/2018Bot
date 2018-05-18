package org.usfirst.frc.team5986.robot.commands;

import org.usfirst.frc.team5986.robot.Robot;
import org.usfirst.frc.team5986.robot.util.paths.Path;

import edu.wpi.first.wpilibj.command.Command;

public class FollowPath extends Command {

    public FollowPath() {

        // This command uses the drivetrain, so...
        requires(Robot.driveTrain);

    }

    public FollowPath (Path path) {

        // This command uses the drivetrain, so...
        requires(Robot.driveTrain);

        // Set the path before we begin following it
        Robot.driveTrain.setPath(path);

    }

    public void initialize () {

        // Reset the followers
        //Robot.driveTrain.resetFollowers();

        // Make sure the robot is in low gear

    }

    public void execute () {

        // Tell the drivetrain to follow the path previously generated
        Robot.driveTrain.followPath();

    }

    public boolean isFinished () {

        //return Robot.driveTrain.leftEncoderFollower.isFinished() && Robot.driveTrain.rightEncoderFollower.isFinished();
return true;
    }
}
