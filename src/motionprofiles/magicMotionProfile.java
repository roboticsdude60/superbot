package motionprofiles;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

public class magicMotionProfile {
	private static CANTalon leftMaster;
	
	public static void initMagicMode(CANTalon leftMaster, CANTalon leftFollower) {
		magicMotionProfile.leftMaster = leftMaster;

		
		leftFollower.changeControlMode(TalonControlMode.Follower);
		leftFollower.set( leftMaster.getDeviceID() );
		
		leftMaster.setFeedbackDevice(CANTalon.FeedbackDevice.CtreMagEncoder_Relative);
	
		leftMaster.setPosition(0);//zero the encoder position to zero
			
		//this is important
		leftMaster.reverseSensor(true);//want both to show positive
		
		leftMaster.changeControlMode(TalonControlMode.MotionMagic);
		
		leftMaster.setF(0.1153); 
		// 1300RPM (8874 native sensor units per 100ms) at full motor output (+1023)
		
		leftMaster.setP(2.0);

		leftMaster.setI(0.0);
		
		leftMaster.setD(20.0);
		
		leftMaster.setIZone(0);//not sure what this is
		
		leftMaster.configNominalOutputVoltage(0.0, 0.0);
		
		leftMaster.configPeakOutputVoltage(12.0, -12.0);
			
		leftMaster.setMotionMagicCruiseVelocity(300); //RPM
		leftMaster.setMotionMagicAcceleration(300); //RPM per second, or in this case 1 second to reach cruise velocity.
		
		leftMaster.changeControlMode(TalonControlMode.MotionMagic);
	}

}
