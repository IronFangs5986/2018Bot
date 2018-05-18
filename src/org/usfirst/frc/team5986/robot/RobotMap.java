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
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;

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
	
	//Initialize shifter solenoids
	public static Solenoid shifterFast;
	public static Solenoid shifterSlow;
	
	//Initialize claw solenoids
	public static Solenoid holderOpen;
	public static Solenoid holderClose;
	
	//Initialize intake retract solenoid
	public static Solenoid intakePiston;
	
	//Initialize compressor
	public static Compressor compressor;
	
	//Initialize encoders and information
	public static Encoder encoderRight;
    public static Encoder encoderLeft;
    public static double tinch = 19.6437;
    
    public static final double sensitivity = 0.2;
	public static void init() {
		
		FrontLeftMotor = new WPI_TalonSRX(2); //Define front left drive motor
		FrontRightMotor = new WPI_TalonSRX(4); //Define front right drive motor
		BackLeftMotor = new WPI_TalonSRX(1); //Define back left drive motor
		BackRightMotor = new WPI_TalonSRX(3); //Define back right drive motor
		
		inLeft = new WPI_TalonSRX(7); //Define left intake motor
		inRight = new WPI_TalonSRX(6); //Define right intake motor
		
		elevatorLeft = new WPI_TalonSRX(9); //Define left elevator motor
		elevatorRight = new WPI_TalonSRX(8); //Define right elevator motor
		
		driveTrainRobotDrive = new RobotDrive(FrontLeftMotor, BackLeftMotor, FrontRightMotor, BackRightMotor); //Define RobotDrive
		
		shifterFast = new Solenoid(0); //Define shifter fast solenoid
		shifterSlow = new Solenoid(1); //Define shifter slow solenoid
		
		holderOpen = new Solenoid(2); //Define holder open solenoid
		holderClose = new Solenoid(3); //Define holder close solenoid
		
		intakePiston = new Solenoid(4); //Define intake retract solenoid
		
		compressor  = new Compressor(0); //Define compressor
		
		//Set up right encoder
		encoderRight = new Encoder(0, 1, true, Encoder.EncodingType.k4X);
        encoderRight.setPIDSourceType(PIDSourceType.kDisplacement);
        encoderRight.setDistancePerPulse(1.0 / tinch);
        encoderRight.reset();
        
        //Set up left encoder
        encoderLeft = new Encoder(2, 3, false, Encoder.EncodingType.k4X);
        encoderLeft.setPIDSourceType(PIDSourceType.kDisplacement);
        encoderLeft.setDistancePerPulse(1.0 / tinch);
        encoderLeft.reset();
        
		//Set up camera
        UsbCamera server = CameraServer.getInstance().startAutomaticCapture();
		server.setResolution(320, 240);
		server.setFPS(30);
	}
	public Encoder getEncoderRight(){ //Get right encoder information
    	return encoderRight;
    }
    
    public Encoder geetEncoderLeft(){ //Get left encoder information
    	return encoderLeft;
    }
}
