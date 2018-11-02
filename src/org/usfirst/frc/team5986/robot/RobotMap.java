/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5986.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Ultrasonic;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	// Initialize drive variables
	public static WPI_TalonSRX FrontLeftMotor;
	public static WPI_TalonSRX FrontRightMotor;
	public static WPI_TalonSRX BackLeftMotor;
	public static WPI_TalonSRX BackRightMotor;

	// Initialize RobotDrive
	public static RobotDrive driveTrainRobotDrive;

	// Initialize intake variables
	public static WPI_TalonSRX inLeft;
	public static WPI_TalonSRX inRight;

	// Initialize elevator variables
	public static WPI_TalonSRX elevatorLeft;
	public static WPI_TalonSRX elevatorRight;

	// Initialize shifter solenoids
	public static Solenoid shifterFast;
	public static Solenoid shifterSlow;

	// Initialize claw solenoids
	public static Solenoid holderOpen;
	public static Solenoid holderClose;

	// Initialize intake retract solenoid
	public static Solenoid intakePiston;

	// Initialize compressor
	public static Compressor compressor;

	// Initialize encoders and information
	public static Encoder rightEncoder;
	public static Encoder leftEncoder;
	public static double tinch = 19.6437;

	// Initialize Switches
	public static DigitalInput middleSwitch;
	public static DigitalInput topSwitch;

	// Initialize Proximity Sensor
	public static Ultrasonic ultra;

	// Initialize Dead Zones
	public static final double sensitivity = 0.2;
	public static final double elevatorDeadZone = 0.2;
	public static final double shifterDeadZone = .75;
	public static final double intakeDeadZone = .3;
	public static final double intakeMaxSpeed = 1; // .7
	public static final double cubeProximity = 5;
	public static final double robotWidth = 15;

	public static boolean intakeUp = true;

	public static void init() {

		FrontLeftMotor = new WPI_TalonSRX(2); // Define front left drive motor
		FrontRightMotor = new WPI_TalonSRX(4); // Define front right drive motor
		BackLeftMotor = new WPI_TalonSRX(1); // Define back left drive motor
		BackRightMotor = new WPI_TalonSRX(3); // Define back right drive motor

		inLeft = new WPI_TalonSRX(7); // Define left intake motor
		inRight = new WPI_TalonSRX(6); // Define right intake motor

		elevatorLeft = new WPI_TalonSRX(9); // Define left elevator motor
		elevatorRight = new WPI_TalonSRX(8); // Define right elevator motor

		driveTrainRobotDrive = new RobotDrive(FrontLeftMotor, BackLeftMotor, FrontRightMotor, BackRightMotor); // Define
																												// RobotDrive

		shifterFast = new Solenoid(0); // Define shifter fast solenoid
		shifterSlow = new Solenoid(1); // Define shifter slow solenoid

		holderOpen = new Solenoid(2); // Define holder open solenoid
		holderClose = new Solenoid(3); // Define holder close solenoid

		intakePiston = new Solenoid(4); // Define intake retract solenoid

		compressor = new Compressor(0); // Define compressor

		// Set up right encoder
		rightEncoder = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
		rightEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
		rightEncoder.setDistancePerPulse((Constants.kDriveWheelDiameter * Math.PI) / Constants.kEncoderPulsesPerRev);
		rightEncoder.reset();

		// Set up left encoder
		leftEncoder = new Encoder(2, 3, true, Encoder.EncodingType.k4X);
		leftEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
		leftEncoder.setDistancePerPulse((Constants.kDriveWheelDiameter * Math.PI) / Constants.kEncoderPulsesPerRev);
		leftEncoder.reset();

		// Set up switches
		middleSwitch = new DigitalInput(4);
		topSwitch = new DigitalInput(5);

		// Set up ultrasonic sensor
		ultra = new Ultrasonic(6, 7);
		ultra.setAutomaticMode(true);
		// Set up camera
		UsbCamera server = CameraServer.getInstance().startAutomaticCapture();
		server.setResolution(160, 120);
		server.setFPS(30);
	}

	public static Encoder getEncoderRight() { // Get right encoder information
		return rightEncoder;
	}

	public static Encoder getEncoderLeft() { // Get left encoder information
		return leftEncoder;
	}
}
