package org.usfirst.frc.team2642.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.Encoder;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class CrabbySquareAuto extends IterativeRobot {
	RobotDrive myRobot;
	Joystick stick;
	int autoLoopCounter;
	double Kp;
	Gyro gyro1;
	Encoder encoder1;
	final int frontLeftChannel	= 2;
    final int rearLeftChannel	= 3;
    final int frontRightChannel	= 1;
    final int rearRightChannel	= 0;
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        myRobot = new RobotDrive(frontLeftChannel, rearLeftChannel, frontRightChannel, rearRightChannel);
    	stick = new Joystick(0);
    	gyro1 = new Gyro(0);
    	encoder1 = new Encoder(4, 5);
    	myRobot.setInvertedMotor(MotorType.kFrontLeft, true);
    	myRobot.setInvertedMotor(MotorType.kRearLeft, true);
    	
    }
    
    /**
     * This function is run once each time the robot enters autonomous mode
     */
    public void autonomousInit() {
    	autoLoopCounter = 0;
    	encoder1.reset();
    	gyro1.reset();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	while(-encoder1.getDistance() < 700){
    		myRobot.mecanumDrive_Cartesian(0.0, -0.5, gyro1.getAngle() * Kp, 0.0);
    		}
    		gyro1.reset();
    		encoder1.reset();
    	while (-encoder1.getDistance() < 700){
    		myRobot.mecanumDrive_Cartesian(-0.5, 0.0, gyro1.getAngle() * Kp, 0.0);

    		}
    		gyro1.reset();
    		encoder1.reset();
    	while(-encoder1.getDistance() < 700){
    		myRobot.mecanumDrive_Cartesian(0.0, 0.5, gyro1.getAngle() * Kp, 0.0);
    		}
			gyro1.reset();
			encoder1.reset();
		while (-encoder1.getDistance() < 700){
    		myRobot.mecanumDrive_Cartesian(0.5, 0.0, gyro1.getAngle() * Kp, 0.0);
			}
			gyro1.reset();
			encoder1.reset();
			autoLoopCounter = 0;
		while(autoLoopCounter < 70){
			myRobot.mecanumDrive_Cartesian(0.0, 0.0, gyro1.getAngle() * Kp, 0.0);
			autoLoopCounter++;
			}
		while(true){
			myRobot.mecanumDrive_Cartesian(0.0, 0.0, 0.0, 0.0);
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
		*/
    
    /**
     * This function is called once each time the robot enters tele-operated mode
     */
    public void teleopInit(){
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	while (isOperatorControl() && isEnabled()) {
            Timer.delay(0.005);		// wait for a motor update time
    	if(stick.getRawButton(1)){
    		myRobot.mecanumDrive_Cartesian(stick.getX(), stick.getY(), stick.getRawAxis(4), gyro1.getAngle() * Kp);
    	}else{
    		myRobot.mecanumDrive_Cartesian(stick.getX(), stick.getY(), stick.getRawAxis(4), 0.0);
    	}
    	}
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    	LiveWindow.run();
    }
    
}
