/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5986.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5986.robot.commands.AutoStraight;
import org.usfirst.frc.team5986.robot.commands.AutonomousSelector;
import org.usfirst.frc.team5986.robot.commands.AutonomousSelector.Goal;
import org.usfirst.frc.team5986.robot.commands.AutonomousSelector.StartingPosition;
import org.usfirst.frc.team5986.robot.subsystems.Claw;
import org.usfirst.frc.team5986.robot.subsystems.Drive;
import org.usfirst.frc.team5986.robot.subsystems.Elevator;
import org.usfirst.frc.team5986.robot.subsystems.Intake;
import org.usfirst.frc.team5986.robot.subsystems.IntakeDrop;
import org.usfirst.frc.team5986.robot.subsystems.Shifters;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends IterativeRobot {
	
	Command autonomousCommand;
	Command autoCommand;
	Command AutoStraight;
	
	public static OI oi;
	public static Intake intake;
	public static Drive driveTrain;
	public static Claw claw;
	public static IntakeDrop intakeDrop;
	public static Shifters shifters;
	public static Elevator elevator;
	
	//private SendableChooser<StartingPosition> stposChooser;
	//private SendableChooser<Goal> goalChooser;
	SendableChooser<Command> auto = new SendableChooser<>();
	
	final String autoStraight = "Straight";
	String[] autoList = { autoStraight };

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		RobotMap.init();
		
		intake = new Intake();
		driveTrain = new Drive();
		claw = new Claw();
		intakeDrop = new IntakeDrop();
		shifters = new Shifters();
		elevator = new Elevator();
		oi = new OI();
		
		NetworkTable table = NetworkTable.getTable("SmartDashboard");
		table.putStringArray("Auto List", autoList);
auto = new SendableChooser();
auto.addDefault("Straight", new AutoStraight());
SmartDashboard.putData("Auto Modes", auto);
		// Starting position chooser
        /*stposChooser = new SendableChooser<>();
        stposChooser.setName("Starting Position:");
        stposChooser.addDefault("Left", StartingPosition.Left);
        stposChooser.addObject("Center", StartingPosition.Center);
        stposChooser.addObject("Right", StartingPosition.Right);

        // Goal chooser
        /*goalChooser = new SendableChooser<>();
        goalChooser.setName("Goal:");
        goalChooser.addDefault("Nothing", Goal.Nothing);
        goalChooser.addObject("Baseline", Goal.Baseline);
        goalChooser.addObject("Switch", Goal.Switch);
        goalChooser.addObject("Scale", Goal.Scale);*/

        // Put the choosers on the smart dashboard
        //SmartDashboard.putData(stposChooser);
        //SmartDashboard.putData(goalChooser);
//RobotMap.leftEncoder.start();
//RobotMap.rightEncoder.start();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		//Robot.drive.ResetEncoders();
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		 // Grab the selected starting position and goal
        //StartingPosition startingPosition = stposChooser.getSelected();
        //Command goal = auto.getSelected();

        // Use the selected st. pos. and goal to select an autonomous routine
        //autoCommand = new AutonomousSelector(goal);

        // Start the autonomous routine
        //autoCommand.start();
		autonomousCommand = (Command) auto.getSelected();
		if (autonomousCommand != null) {
			autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		double speedl = driveTrain.getLeftDistance();
		double speedr = driveTrain.getRightDistance();
		SmartDashboard.putNumber("Left", speedl);
		SmartDashboard.putNumber("Right", speedr);
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null) {
			autonomousCommand.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("encoder value right", (RobotMap.getEncoderRight().getDistance()));
        SmartDashboard.putNumber("encoder value left",  (RobotMap.getEncoderLeft().getDistance()));
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
