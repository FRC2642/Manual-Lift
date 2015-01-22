package org.usfirst.frc.team2642.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class PolarAuto extends IterativeRobot {
	RobotDrive myRobot;
	Joystick stick;
	int autoLoopCounter;
	Gyro gyro;
	Encoder encoder1;
	Encoder encoder2;	
	double Kp = .03;
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	myRobot = new RobotDrive(0,1);
    	stick = new Joystick(0);
    	gyro = new Gyro(4);
    	encoder1 = new Encoder(0, 1);
    	encoder2 = new Encoder(2, 3);
    	myRobot.setInvertedMotor(MotorType.kFrontLeft, true);
    	myRobot.setInvertedMotor(MotorType.kRearLeft, true);
    }
    
    /**
     * This function is run once each time the robot enters autonomous mode
     */
    public void autonomousInit() {
    	autoLoopCounter = 0;
    	gyro.reset();
    	encoder1.reset();
    	encoder2.reset();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	while(encoder1.getDistance() < 2000){
    		myRobot.mecanumDrive_Polar(0.5, 0, 0);
    	}
    	gyro.reset();
    	encoder1.reset();
    	while(gyro.getAngle() < 90){
    		myRobot.mecanumDrive_Polar(0, 90, 1);
    	}
    	gyro.reset();
    	encoder1.reset();
    	while(encoder1.getDistance() < 2000){
    		myRobot.mecanumDrive_Polar(0.5, 0, 0);
    	}
    	gyro.reset();
    	encoder1.reset();
    	while(gyro.getAngle() < 90){
    		myRobot.mecanumDrive_Polar(0, 90, 1);
    	}
    	gyro.reset();
    	encoder1.reset();
    	while(encoder1.getDistance() < 2000){
    		myRobot.mecanumDrive_Polar(0.5, 0, 0);
    	}
    	gyro.reset();
    	encoder1.reset();
    	while(gyro.getAngle() < 90){
    		myRobot.mecanumDrive_Polar(0, 90, 1);
    	}
    	gyro.reset();
    	encoder1.reset();
    	while(encoder1.getDistance() < 2000){
    		myRobot.mecanumDrive_Polar(0.5, 0, 0);
    	}
    	gyro.reset();
    	encoder1.reset();
    	while(gyro.getAngle() < 90){
    		myRobot.mecanumDrive_Polar(0, 90, 1);
    	}
    	gyro.reset();
    	encoder1.reset();
    	myRobot.mecanumDrive_Polar(0, 0, -1);
    	System.out.println("ANUS!");
    	}
        	
    	/**
    	}else if(encoder1.getDistance() <= 20 && encoder1.getDistance() > 10){
    		myRobot.mecanumDrive_Cartesian(0.0, 0.5, gyro.getAngle() * Kp, 0.0);
    		//myRobot.mecanumDrive_Cartesian(0.0,  0.0,  0.0, 0.0);
        	Timer.delay(1.0);
    	}else if(encoder1.getDistance() > 20){
    		myRobot.mecanumDrive_Cartesian(0.0, 0.5, gyro.getAngle() * Kp, 0.0);
    		//myRobot.mecanumDrive_Cartesian(0.0,  0.0,  0.0, 0.0);
        	Timer.delay(1.0);
    	}else{
    		myRobot.mecanumDrive_Cartesian(0.5, 0.0, gyro.getAngle() * Kp, 0.0);
    		myRobot.mecanumDrive_Cartesian(0.0,  0.0,  0.0, 0.0);
        	Timer.delay(1.0);
        	encoder1.reset();
        	encoder2.reset();
    	}	
    	}
    	/**
    	if(autoLoopCounter < 100) //Check if we've completed 100 loops (approximately 2 seconds)
		{
			myRobot.drive(-0.5, 0.0); 	// drive forwards half speed
			autoLoopCounter++;
			} else {
			myRobot.drive(0.0, 0.0); 	// stop robot
		}
		**/
    
    
    /**
     * This function is called once each time the robot enters tele-operated mode
     */
    public void teleopInit(){
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        myRobot.arcadeDrive(stick);
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    	LiveWindow.run();
    }
    
}
