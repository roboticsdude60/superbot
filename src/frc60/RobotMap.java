// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package frc60;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;
import com.kauailabs.navx.frc.*;
import edu.wpi.first.wpilibj.SPI;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static CANTalon driveleftBack;
    public static CANTalon driverightBack;
    public static RobotDrive driveRobotDrive2;
    public static SpeedController intakeIntakeSpeedController;
    public static Relay ballStirrerStirSpike;
    public static Relay gearHolderClampMotorSpike;
    public static Relay gearHolderLiftMotorSpike;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static CANTalon leftFront;
    public static CANTalon rightFront;
    public static AHRS navx;
    
    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveleftBack = new CANTalon(3);
        LiveWindow.addActuator("Drive", "leftBack", driveleftBack);
        
        driverightBack = new CANTalon(1);
        LiveWindow.addActuator("Drive", "rightBack", driverightBack);
        
        driveRobotDrive2 = new RobotDrive(driveleftBack, driverightBack);
        
        driveRobotDrive2.setSafetyEnabled(true);
        driveRobotDrive2.setExpiration(0.1);
        driveRobotDrive2.setSensitivity(0.5);
        driveRobotDrive2.setMaxOutput(1.0);

        intakeIntakeSpeedController = new Talon(0);
        LiveWindow.addActuator("Intake", "IntakeSpeedController", (Talon) intakeIntakeSpeedController);
        
        ballStirrerStirSpike = new Relay(0);
        LiveWindow.addActuator("BallStirrer", "StirSpike", ballStirrerStirSpike);
        
        gearHolderClampMotorSpike = new Relay(1);
        LiveWindow.addActuator("GearHolder", "ClampMotorSpike", gearHolderClampMotorSpike);
        
        gearHolderLiftMotorSpike = new Relay(2);
        LiveWindow.addActuator("GearHolder", "LiftMotorSpike", gearHolderLiftMotorSpike);
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        navx = new AHRS(SPI.Port.kMXP);
        driveRobotDrive2.setExpiration(0.2);
        
        leftFront = new CANTalon(4);
        rightFront = new CANTalon(2);
        leftFront.changeControlMode(TalonControlMode.Follower);
        rightFront.changeControlMode(TalonControlMode.Follower);
        leftFront.set(driveleftBack.getDeviceID());
        rightFront.set(driverightBack.getDeviceID());
        
        driveleftBack.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
        driverightBack.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
        
        leftFront.enableBrakeMode(true);
        rightFront.enableBrakeMode(true);
        driveleftBack.enableBrakeMode(true);
        driverightBack.enableBrakeMode(true);
        
        driveleftBack.reverseSensor(true);
        driverightBack.reverseSensor(true);
        driveleftBack.enableZeroSensorPositionOnIndex(false, false);
        driverightBack.enableZeroSensorPositionOnIndex(false, false);
        driveleftBack.setProfile(0);
        driverightBack.setProfile(0);
    }
}
