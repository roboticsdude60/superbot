package helperCode;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Sendable;

public class PixySerialPort {
	static SerialPort pixyport;
	
	
public static void init() {
	pixyport = new SerialPort(9600, SerialPort.Port.kUSB1);
}
	
	public static void test() {
		String message = pixyport.readString();
		SmartDashboard.putString("pixy", message);
	}
	
	private static String values, lastString;
	private static double turn;
	public static double getTurnValue() {
		values = pixyport.readString();
		
		lastString = values.substring( 0, values.lastIndexOf(",")-1 );
		lastString = lastString.substring(lastString.lastIndexOf(",") + 1 );
		turn = Double.parseDouble( lastString );
		
		return turn;
	}

}
