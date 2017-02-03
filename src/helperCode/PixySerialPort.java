package helperCode;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PixySerialPort {
	static SerialPort pixyport;

	public static void init() {
		pixyport = new SerialPort(19200, SerialPort.Port.kUSB1);
	}

	public static void test() {
		String message = pixyport.readString();
		SmartDashboard.putString("pixy", message);
	}

	private static String values = "0.0,0.00,0.00,0.00,0.00,0.00,";
	private static String thisTime = "";
	private static String[] vals;
	private static double turn = 0.0;
	private static int errors = 0;
	private static int bytesReceived = 0;
	public static double getTurnValue() {
		
		bytesReceived = pixyport.getBytesReceived();
		System.out.println(bytesReceived);
		
		if (bytesReceived > 5) {
			thisTime = pixyport.readString();
			System.out.println(thisTime);
			
			values += thisTime;
			System.out.println(values);
			
			vals = values.split(",");
			
			//values = vals[vals.length - 4] + "," + vals[vals.length - 3] + "," + vals[vals.length - 2] + ","
				//	+ vals[vals.length - 1];
			
			try {
				System.out.println("the second to last" + vals[vals.length - 2]); 
				turn = Double.parseDouble(vals[vals.length - 2]);
			} catch (java.lang.NumberFormatException e) {
				errors++;
				System.out.println("This is number parsing error  # " + errors);
				turn = 0.0;
			}
		}
		System.out.println("End of method getTurnValue() returning " + turn );
		return -turn;
	}

}
