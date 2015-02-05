package org.usfirst.frc.team2642.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Encoder;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	Joystick stick;
	DigitalInput limitswitch;
	Encoder encoder;
	Jaguar jaguar;
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	stick = new Joystick(0);
    	limitswitch = new DigitalInput(2);
    	encoder = new Encoder(0, 1);
    	jaguar = new Jaguar(0);
    }
    
    /**
     * This function is run once each time the robot enters autonomous mode
     */
    public void autonomousInit() {
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	
    }
    
    /**
     * This function is called once each time the robot enters tele-operated mode
     */
    public void teleopInit(){
    	encoder.reset();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	boolean toggle = true;
    	boolean limittoggle = false;
    	if(encoder.getDistance() >=100){
    		toggle = !toggle;
    	}else if(limitswitch.get()){
    		limittoggle = true;
    	}else if(encoder.getDistance() <=0){
    		toggle = !toggle;
    		limittoggle = !limittoggle;	
    	}
    	if(limittoggle == true && toggle == true && encoder.getDistance() <=100){
    		jaguar.set(.25);
    	}else{
    		jaguar.set(-.25);
    	}
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    	LiveWindow.run();
    }
    
}
