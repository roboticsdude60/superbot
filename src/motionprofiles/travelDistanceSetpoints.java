package motionprofiles;

public class travelDistanceSetpoints {
	
	// max acceleration has to be less than 9.8 m/(s^2)  or the acceleration of gravity
	
	private static int timeMillis;
	private static double accelVal;
	private static double maxVel;
	private static double distanceInches;
	private static double distanceEncoderCounts;
	
	public static int calcPosition(int time) {
		
		
		return 0;
	}
	
	private static double calcVel(int delta, double acceleration, double initialVel){
		// V = V0 + AT
		return initialVel + acceleration * delta;
	}
	
	private static double calcPos(int delta, double initialPos, double initialVel, double acceleration) {
		
		
		return 0;
	}
}
