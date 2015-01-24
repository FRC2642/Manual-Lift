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
	Encoder encoder;
	double Kp = .03;
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	myRobot = new RobotDrive(0,1);
    	stick = new Joystick(0);
    	gyro = new Gyro(4);
    	encoder = new Encoder(0, 1);
    	myRobot.setInvertedMotor(MotorType.kFrontLeft, true);
    	myRobot.setInvertedMotor(MotorType.kRearLeft, true);
    }
    
    /**
     * This function is run once each time the robot enters autonomous mode
     */
    public void autonomousInit() {
    	autoLoopCounter = 0;
    	gyro.reset();
    	encoder.reset();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	while(-encoder.getDistance() < 150){
    		myRobot.mecanumDrive_Polar(0.5, gyro.getAngle() * Kp, 0);
    	}
    	gyro.reset();
    	encoder.reset();
    	while(gyro.getAngle() < 83){
    		myRobot.mecanumDrive_Polar(0, 83, -.5);
    	}
    	gyro.reset();
    	encoder.reset();
    	while(-encoder.getDistance() < 150){
    		myRobot.mecanumDrive_Polar(0.5, gyro.getAngle() * Kp, 0);
    	}
    	gyro.reset();
    	encoder.reset();
    	while(gyro.getAngle() < 83){
    		myRobot.mecanumDrive_Polar(0, 83, -.5);
    	}
    	gyro.reset();
    	encoder.reset();
    	while(-encoder.getDistance() < 150){
    		myRobot.mecanumDrive_Polar(0.5, gyro.getAngle() * Kp, 0);
    	}
    	gyro.reset();
    	encoder.reset();
    	while(gyro.getAngle() < 83){
    		myRobot.mecanumDrive_Polar(0, 83, -.5);
    	}
    	gyro.reset();
    	encoder.reset();
    	while(-encoder.getDistance() < 150){
    		myRobot.mecanumDrive_Polar(0.5, gyro.getAngle() * Kp, 0);
    	}
    	gyro.reset();
    	encoder.reset();
    	while(gyro.getAngle() < 83){
    		myRobot.mecanumDrive_Polar(0, 83, -.5);
    	}
    }
    	/**
    	gyro.reset();
    	encoder.reset();
    	Timer.delay(1);
    	myRobot.mecanumDrive_Polar(0, 3600, .5);
    	System.out.println("I like big butts and I cannot lie!");
    	System.out.println("The other brothers can't deny!");
    	System.out.println("When a girl walks in with an itty bitty waist");
    	System.out.println("And a round thing in your face you get");
    	System.out.println("Sprung!");
    	 **/
    	
    	
        	
    	/**
    	}else if(encoder.getDistance() <= 20 && encoder.getDistance() > 10){
    		myRobot.mecanumDrive_Cartesian(0.0, 0.5, gyro.getAngle() * Kp, 0.0);
    		//myRobot.mecanumDrive_Cartesian(0.0,  0.0,  0.0, 0.0);
        	Timer.delay(1.0);
    	}else if(encoder.getDistance() > 20){
    		myRobot.mecanumDrive_Cartesian(0.0, 0.5, gyro.getAngle() * Kp, 0.0);
    		//myRobot.mecanumDrive_Cartesian(0.0,  0.0,  0.0, 0.0);
        	Timer.delay(1.0);
    	}else{
    		myRobot.mecanumDrive_Cartesian(0.5, 0.0, gyro.getAngle() * Kp, 0.0);
    		myRobot.mecanumDrive_Cartesian(0.0,  0.0,  0.0, 0.0);
        	Timer.delay(1.0);
        	encoder.reset();
        	encoder2.reset();
    	}	
    	}
    	/*
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
        myRobot.mecanumDrive_Polar(stick.getMagnitude(), stick.getDirectionDegrees(), stick.getRawAxis(4));
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    	LiveWindow.run();
    }
    
}