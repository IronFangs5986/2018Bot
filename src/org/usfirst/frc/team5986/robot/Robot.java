/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5986.robot;

import org.usfirst.frc.team5986.robot.commands.AutoStraight;
import org.usfirst.frc.team5986.robot.commands.DoNothingAuto;
import org.usfirst.frc.team5986.robot.commands.MiddleScale;
import org.usfirst.frc.team5986.robot.commands.MiddleSwitch;
import org.usfirst.frc.team5986.robot.commands.SwitchRightAuto;
import org.usfirst.frc.team5986.robot.subsystems.Claw;
import org.usfirst.frc.team5986.robot.subsystems.Drive;
import org.usfirst.frc.team5986.robot.subsystems.Elevator;
import org.usfirst.frc.team5986.robot.subsystems.Intake;
import org.usfirst.frc.team5986.robot.subsystems.IntakeDrop;
import org.usfirst.frc.team5986.robot.subsystems.Shifters;

import com.analog.adis16448.frc.ADIS16448_IMU;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends IterativeRobot {
	// DELETE
	// DigitalInput limitSwitch = new DigitalInput(4);
	// DigitalInput limitSwitch2 = new DigitalInput(5);
	// DELETE END

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

	// private SendableChooser<StartingPosition> stposChooser;
	// private SendableChooser<Goal> goalChooser;
	SendableChooser auto = new SendableChooser<>();
	SendableChooser chooser = new SendableChooser<>();

	NetworkTable table = NetworkTable.getTable("SmartDashboard");

	private int mode = 0;

	final String doNothing = "Do absolutely nothing like Mr. Horwath said";
	final String autoStraight = "Straight";
	final String middleSwitch = "Middle Switch";
	final String middleScale = "Middle Scale";
	final String rightSwitch = "Right Switch";
	String[] autoList = { doNothing, autoStraight, middleSwitch, middleScale, rightSwitch };

	public static String GameData = "UUU";

	public static final ADIS16448_IMU imu = new ADIS16448_IMU();

	/**
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
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
		table.putStringArray("AutoList", autoList);
		auto = new SendableChooser();
		auto.addDefault("Do absolutely nothing like Mr. Horwath said", 1);
		auto.addObject("Straight", 2);
		auto.addObject("Middle Switch", 3);
		auto.addObject("Middle Scale", 4);
		auto.addObject("Right Switch", 5);
		SmartDashboard.putData("automodes", auto);

		// table.putValue("automodes", auto);
		chooser = new SendableChooser();
		chooser.addDefault("Do absolutely nothing like Mr. Horwath said", 1);
		chooser.addObject("Straight", 2);
		chooser.addObject("Middle Switch", 3);
		chooser.addObject("Middle Scale", 4);
		chooser.addObject("Right Switch", 5);
		SmartDashboard.putData("Automous Selector", chooser);
		// Starting position chooser

		table.putNumber("autoSelected", 0);
		printData();
		defaultValues();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode. You
	 * can use it to reset any subsystem information you want to clear when the
	 * robot is disabled.
	 */
	@Override
	public void disabledInit() {
		// Robot.drive.ResetEncoders();
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		printData();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable chooser
	 * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
	 * remove all of the chooser code and uncomment the getString code to get the
	 * auto name from the text box below the Gyro
	 *
	 * <p>
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons to
	 * the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {

		System.out.println("*\n*\nGOT DATA -1\n*\n*");
		// while (GameData == "UUU" && GameData.charAt(0) == 'U' && GameData.charAt(1)
		// == 'U'
		// && GameData.charAt(2) == 'U') {
		// System.out.println("*\n*\nATTEMPTING TO GET DATA\n*\n*");
		// try {
		// Thread.sleep(5);
		GameData = DriverStation.getInstance().getGameSpecificMessage();
		// mode = (int) chooser.getSelected();
		mode = (int) table.getNumber("autoSelected", 0) + 1;
		System.out.println("*\n*\nMODE\n*\n*" + mode);
		if (mode == 1) {
			autonomousCommand = (Command) new DoNothingAuto();
		} else if (mode == 2) {
			autonomousCommand = (Command) new AutoStraight();
		} else if (mode == 3) {
			autonomousCommand = (Command) new MiddleSwitch();
		} else if (mode == 4) {
			autonomousCommand = (Command) new MiddleScale();
		} else if (mode == 5) {
			autonomousCommand = (Command) new SwitchRightAuto();
		}
		System.out.println(GameData);
		// autonomousCommand = (Command) auto.getSelected();
		if (autonomousCommand != null) {
			autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		// System.out.println("Running scheduled autonomous periodic");
		Scheduler.getInstance().run();
		printData();
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
		printData();
		// System.out.println("Switch: "+ limitSwitch.get());
		// System.out.println("Switch: "+ limitSwitch2.get()+"\n\n");
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}

	private void printData() {
		double speedl = RobotMap.leftEncoder.getDistance();
		double speedr = driveTrain.getRightDistance();
		SmartDashboard.putNumber("Left", speedl);
		SmartDashboard.putNumber("Right", speedr);

		if (RobotMap.ultra.getRangeInches() < RobotMap.cubeProximity) {
			// SmartDashboard.putString("Power Cube", "Loaded: " +
			// RobotMap.ultra.getRangeInches());
			table.putString("PowerCube", "in");
		} else {
			// SmartDashboard.putString("Power Cube", "Not Loaded: " +
			// RobotMap.ultra.getRangeInches());
			table.putString("PowerCube", "out");
		}
		SmartDashboard.putNumber("Gyro-X", imu.getAngleX());
		SmartDashboard.putNumber("Gyro-Y", imu.getAngleY());
		SmartDashboard.putNumber("Gyro-Z", imu.getAngleZ());

		// table.putNumber("Gyro-X", imu.getAngleX());
		table.putNumber("Gyro-Y", imu.getAngleY() * -1);
		table.putNumber("battery", DriverStation.getInstance().getBatteryVoltage());
		table.putNumber("leftDist", -speedl);
		table.putNumber("rightDist", speedr);
		// table.putNumber("Gyro-X", imu.getAngleX());
		// System.out.println(RobotMap.ultra.getRangeInches());
		boolean safe = NetworkTable.getTable("SmartDashboard").getBoolean("switchOne", false);
		System.out.println("Safe: " + safe);
	}

	private void defaultValues() {
		NetworkTable.getTable("SmartDashboard").putString("intake", "up");
		NetworkTable.getTable("SmartDashboard").putString("claw", "closed");
		NetworkTable.getTable("SmartDashboard").putNumber("elevatorMax", .9);
		NetworkTable.getTable("SmartDashboard").putNumber("intakeMax", .9);
	}

	public static String getGameData() {

		return DriverStation.getInstance().getGameSpecificMessage();
	}
}
