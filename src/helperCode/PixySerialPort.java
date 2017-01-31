package helperCode;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PixySerialPort {
	static SerialPort pixyport;

	public static void init() {
		pixyport = new SerialPort(9600, SerialPort.Port.kUSB1);
	}

	public static void test() {
		String message = pixyport.readString();
		SmartDashboard.putString("pixy", message);
	}

	private static String values = "0.00,0.00,0.00";
	private static String[] vals;
	private static double turn = 0.0;
	public static double getTurnValue() {
		values += pixyport.readString();
		vals = values.split(",");
		values = vals[vals.length - 2] + "," + vals[vals.length -1];
		turn = Double.parseDouble( vals[vals.length - 2] );
		return turn;
	}

}
