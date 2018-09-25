package frc;

import com.ctre.phoenix.ParamEnum;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.automodes.ExampleAuto;
import frc.subsystems.ExampleSubsystem;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple robot class
 */

public class Robot extends IterativeRobot {

    Joystick gamepad;
  
    List<WPI_TalonSRX> talonArray = new ArrayList<WPI_TalonSRX>();
    WPI_TalonSRX rollerLeft;
    WPI_TalonSRX rollerRight;
    WPI_TalonSRX driveBackLeft;
    WPI_TalonSRX driveBackRight;
    WPI_TalonSRX driveFrontLeft;
    WPI_TalonSRX driveFrontRight;
    WPI_TalonSRX talonLoader;

    ExampleSubsystem drivetrain;

  /**
   * Constructor for Example Robot
   * 
   * <p>Initializes the subsystems, talons and gamepad</p>
   */
	public Robot() {
		
		gamepad = new Joystick(0);
	
        rollerLeft = new WPI_TalonSRX(8);
        rollerRight = new WPI_TalonSRX(5);
        driveBackLeft = new WPI_TalonSRX(4);
        driveBackRight = new WPI_TalonSRX(3);
        driveFrontLeft = new WPI_TalonSRX(2);
        driveFrontRight = new WPI_TalonSRX(1);
        talonLoader = new WPI_TalonSRX(6);
        
	}

  /**
   * Creates the auto mode chooser
   */
	@Override
	public void robotInit() {
		
	}

  /**
   * Configs the talon for teleop mode
   */
	public void teleopInit() {
        Scheduler.getInstance().add(new Gamepad());
		
        rollerLeft.configSetParameter(ParamEnum.eOnBoot_BrakeMode, 0.0, 0, 0, 0);
        rollerRight.configSetParameter(ParamEnum.eOnBoot_BrakeMode, 0.0, 0, 0, 0);
        driveBackLeft.configSetParameter(ParamEnum.eOnBoot_BrakeMode, 0.0, 0, 0, 0);
        driveBackRight.configSetParameter(ParamEnum.eOnBoot_BrakeMode, 0.0, 0, 0, 0);
        driveFrontLeft.configSetParameter(ParamEnum.eOnBoot_BrakeMode, 0.0, 0, 0, 0);
        driveFrontRight.configSetParameter(ParamEnum.eOnBoot_BrakeMode, 0.0, 0, 0, 0);

	}

  /**
   * Teleop control for driver
   */
	public void teleopPeriodic() {
    
        Scheduler.getInstance().run();
    
	}

  /**
   * Disables the talon and removes all commands
   */
	public void disabledInit() {

        rollerLeft.set(ControlMode.Current, 0);
        rollerRight.set(ControlMode.Current, 0);
        driveBackLeft.set(ControlMode.Current, 0);
        driveBackRight.set(ControlMode.Current, 0);
        driveFrontLeft.set(ControlMode.Current, 0);
        driveFrontRight.set(ControlMode.Current, 0);
		Scheduler.getInstance().removeAll();
  
  }

  /**
   * Adds the example auto mode to Scheduler
   */
	public void autonomousInit() {

	}

  /**
   *  Runs the Scheduler
   */
	public void autonomousPeriodic(){

		Scheduler.getInstance().run();

  }

  
	@Override
	public void testInit() {

	}

	@Override
	public void testPeriodic() {

  }
  
}
