package org.usfirst.frc.team5986.robot.commands;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.command.Command;

public class sendToArduino extends Command {
	DigitalOutput arduino = new DigitalOutput(9);
	// static I2C Wire = new I2C(Port.kOnboard, 4);
	// SerialPort usbPort = new SerialPort(9600, Port.kUSB);
	// DigitalOutput arduino = new
	// DigitalOutput(getChannelFromPin(PinType.DigitalIO, 9));
	int sendValue;

	public sendToArduino(int i) {
		sendValue = i;
	}

	protected void execute() {
		// usbPort.writeString("test");
		// arduino.setPWMRate(42) ;
		// arduino.pulse(42);
		// arduino.updateDutyCycle(42);
		// arduino.set(true);
		// arduino.set(42);
		I2C Wire = new I2C(Port.kOnboard, 4);
		String WriteString = "go";
		char[] CharArray = WriteString.toCharArray();
		byte[] WriteData = new byte[CharArray.length];
		for (int i = 0; i < CharArray.length; i++) {
			WriteData[i] = (byte) CharArray[i];
		}
		Wire.transaction(WriteData, WriteData.length, null, 0);

	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

}
