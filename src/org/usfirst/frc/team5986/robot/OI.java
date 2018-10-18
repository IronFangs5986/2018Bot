/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5986.robot;

import org.usfirst.frc.team5986.robot.commands.CloseClaw;
import org.usfirst.frc.team5986.robot.commands.IntakeDown;
import org.usfirst.frc.team5986.robot.commands.IntakeUp;
import org.usfirst.frc.team5986.robot.commands.OpenClaw;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	public static Joystick joystick1;
	public Joystick joystick2;
	public static Joystick joystick3;

	public JoystickButton j1b1;
	public JoystickButton j1b2;
	public JoystickButton j1b3;
	public JoystickButton j1b4;
	public JoystickButton j1b5;
	public JoystickButton j1b6;
	public JoystickButton j1b7;
	public JoystickButton j1b8;
	public JoystickButton j1b9;
	public JoystickButton j1b10;
	public JoystickButton j1b11;
	public JoystickButton j1b12;
	public JoystickButton j2b1;
	public JoystickButton j2b2;
	public JoystickButton j2b3;
	public JoystickButton j2b4;
	public JoystickButton j2b5;
	public JoystickButton j2b6;
	public JoystickButton j2b7;
	public JoystickButton j2b8;
	public JoystickButton j2b9;
	public JoystickButton j2b10;
	public JoystickButton j2b11;
	public JoystickButton j2b12;
	public JoystickButton j3b1; // Trigger - Open/close
	public JoystickButton j3b2; // Side -shift
	public JoystickButton j3b11; // Intake Down
	public JoystickButton j3b12; // Intake Up

	public OI() {

		joystick2 = new Joystick(1);
		joystick1 = new Joystick(0);
		joystick3 = new Joystick(3);

		j1b1 = new JoystickButton(joystick1, 1);
		j1b2 = new JoystickButton(joystick1, 2);
		j1b3 = new JoystickButton(joystick1, 3);
		j1b4 = new JoystickButton(joystick1, 4);
		j1b5 = new JoystickButton(joystick1, 5);
		j1b6 = new JoystickButton(joystick1, 6);
		j1b7 = new JoystickButton(joystick1, 7);
		j1b8 = new JoystickButton(joystick1, 8);
		j1b9 = new JoystickButton(joystick1, 9);
		j1b10 = new JoystickButton(joystick1, 10);
		j1b11 = new JoystickButton(joystick1, 11);
		j1b12 = new JoystickButton(joystick1, 12);
		j2b1 = new JoystickButton(joystick2, 1);
		j2b2 = new JoystickButton(joystick2, 2);
		j2b3 = new JoystickButton(joystick2, 3);
		j2b4 = new JoystickButton(joystick2, 4);
		j2b5 = new JoystickButton(joystick2, 5);
		j2b6 = new JoystickButton(joystick2, 6);
		j2b7 = new JoystickButton(joystick2, 7);
		j2b8 = new JoystickButton(joystick2, 8);
		j2b9 = new JoystickButton(joystick2, 9);
		j2b10 = new JoystickButton(joystick2, 10);
		j2b11 = new JoystickButton(joystick2, 11);
		j2b12 = new JoystickButton(joystick2, 12);
		j3b1 = new JoystickButton(joystick3, 1);
		j3b11 = new JoystickButton(joystick3, 11);
		j3b12 = new JoystickButton(joystick3, 12);

		j1b2.whenPressed(new OpenClaw());
		j1b6.whenPressed(new OpenClaw());
		j1b3.whenPressed(new CloseClaw());
		j1b5.whenPressed(new CloseClaw());
		j1b1.whenPressed(new IntakeDown());
		j1b4.whenPressed(new IntakeUp());

		j3b1.whenPressed(new OpenClaw());
		j3b1.whenReleased(new CloseClaw());
		j3b11.whenPressed(new IntakeDown());
		j3b12.whenPressed(new IntakeUp());

		// j1b8.whenPressed(new sendToArduino(42));
		// j1b8.whenReleased(new sendToArduino(324));
	}

	public static Joystick getDriver() {
		return joystick1;
	}

	public double getIntakeSpeed() {
		if (Math.abs(joystick1.getRawAxis(5)) > RobotMap.sensitivity) {
			return -1.0 * (Math.abs(joystick1.getRawAxis(5)));
		} else {
			return 0.0;
		}
	}

	public double getJoystick1X() {
		if (Math.abs(joystick1.getX()) > RobotMap.sensitivity) {
			return -1.0 * joystick1.getX();
		} else {
			return 0.0;
		}
	}

	public double getJoystick1Y() {
		if (Math.abs(joystick1.getY()) > RobotMap.sensitivity) {
			return -1.0 * joystick1.getY();
		} else {
			return 0.0;
		}
	}

	public double getJoystick1Z() {
		if (Math.abs(joystick1.getRawAxis(3)) > RobotMap.sensitivity) {
			return -1.0 * (Math.abs(joystick1.getRawAxis(3)));
		} else {
			return 0.0;
		}
	}

	public Joystick getJoystick2() {
		return joystick2;
	}

	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
