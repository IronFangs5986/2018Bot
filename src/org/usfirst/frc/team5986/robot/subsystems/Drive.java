package org.usfirst.frc.team5986.robot.subsystems;

import org.usfirst.frc.team5986.robot.Constants;
import org.usfirst.frc.team5986.robot.RobotMap;
import org.usfirst.frc.team5986.robot.commands.ArcadeDrive;
import org.usfirst.frc.team5986.robot.util.paths.Path;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import com.kauailabs.navx.frc.AHRS;
import jaci.pathfinder.followers.EncoderFollower;
import jaci.pathfinder.modifiers.TankModifier;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drive extends Subsystem {
	// Constants
    private int encoderPulsesPerRev = Constants.kEncoderPulsesPerRev;
    private double maxVelocity = Constants.kLowGearMaxVelocity;
    private double kWheelDiameter = Constants.kDriveWheelDiameter;
    private double kWheelbase = Constants.kWheelbaseWidth;
    public EncoderFollower rightEncoderFollower;
    public EncoderFollower leftEncoderFollower;
    private final Encoder mRightEncoder, mLeftEncoder;
    private final TalonSRX mRightMaster, mRightFollower, mLeftMaster, mLeftFollower;
	RobotDrive robotDrive = RobotMap.driveTrainRobotDrive;
	private final AHRS mNavX;
	public Drive() {
		 mRightMaster = RobotMap.FrontRightMotor;
	        mRightFollower = RobotMap.BackRightMotor;
	        mLeftMaster = RobotMap.FrontLeftMotor;
	        mLeftFollower = RobotMap.BackLeftMotor;
		  mRightEncoder = RobotMap.rightEncoder;
	        mLeftEncoder = RobotMap.leftEncoder;
	        rightEncoderFollower = new EncoderFollower();
	        leftEncoderFollower = new EncoderFollower();
	        mNavX = new AHRS(SPI.Port.kMXP, (byte) 200);
	        // Configure stuff
	        configureEncoders();
	}
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new ArcadeDrive());
	}
public void arcadeDrive(Joystick joystick) {
	robotDrive.arcadeDrive(joystick);
}
public void tankDrive(double leftSpeed, double rightSpeed) {
	robotDrive.tankDrive(leftSpeed, rightSpeed);
}
public void stop() {
	robotDrive.arcadeDrive(0.0, 0.0);
	robotDrive.tankDrive(0.0, 0.0);
}
private void configureEncoders () {

    // Set distance per pulse
    mRightEncoder.setDistancePerPulse((kWheelDiameter * Math.PI) / encoderPulsesPerRev);
    mLeftEncoder.setDistancePerPulse((kWheelDiameter * Math.PI) / encoderPulsesPerRev);

    // Invert one side
    mLeftEncoder.setReverseDirection(true);

}
public void setRightSpeed (double speed) {
    mRightMaster.set(ControlMode.PercentOutput, speed);
}

public void setLeftSpeed (double speed) {
    mLeftMaster.set(ControlMode.PercentOutput, speed);
}
public double getLeftDistance() {
	return RobotMap.leftEncoder.getDistance();
}
public double getRightDistance() {
	return RobotMap.rightEncoder.getDistance();
}
public double getRightVelocity () {
    return mRightEncoder.getRate();
}
public double getLeftVelocity () {
    return mLeftEncoder.getRate();
}
public void zeroSensors () {

    mRightEncoder.reset();
    mLeftEncoder.reset();

}
public void reset () {

    // Stop the motors
    setRightSpeed(0);
    setLeftSpeed(0);

    // Zero sensors
    zeroSensors();

}
private double boundPercentage (double input) {
    if (input < -1) input = -1;
    if (input > 1) input = 1;
    return input;
}
public double getYaw () {
    return -mNavX.getYaw();
}
public void followPath() {
	double rightOutput = boundPercentage(rightEncoderFollower.calculate(mRightEncoder.getRaw()));
    double leftOutput = boundPercentage(leftEncoderFollower.calculate(mLeftEncoder.getRaw()));

    // Angle control
    double actualAngle = getYaw();
    double targetAngle = Pathfinder.boundHalfDegrees(Math.toDegrees(rightEncoderFollower.getHeading()));
    double angleError = Pathfinder.boundHalfDegrees(targetAngle - actualAngle);

    double turn = 0.8 * (-1.0/80.0) * angleError;

    // Set the motor speeds according to the calculated outputs
    setRightSpeed(rightOutput - turn);
    setLeftSpeed(leftOutput + turn);
}
public void setPath(Path path) {
	// TODO Auto-generated method stub
	// Generate the path
    Trajectory trajectory = path.getTrajectory();

    // Modify using the wheelbase
    TankModifier modifier = new TankModifier(trajectory).modify(kWheelbase);

    // Set the encoder followers
    rightEncoderFollower.setTrajectory(modifier.getRightTrajectory());
    leftEncoderFollower.setTrajectory(modifier.getLeftTrajectory());
}

}
