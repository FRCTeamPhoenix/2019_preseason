package frc.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

import DriveTrainSubsytem.java;

public class Gamepad extends Command {
    
    Joystick m_gamepad;
    DriveTrainSubsytem m_tankDrive;
    double leftWheels = 0.0;
    double rightWheels = 0.0;
    }
    public Gamepad(Joystick gamepad, TankDrive tankDrive, double leftWheels, double rightWheels) {
        requires(tankDrive);
        m_gamepad = gamepad;
        m_tankDrive = tankDrive;

        if(Math.abs(gamepad.getRawAxis(1)) > 0) {
            leftWheels = gamepad.getRawAxis(1);
            //0 is a placeholder as we do not have any constants for the deadzone.
        }
        else {
            leftWheels = 0.0;
        }

        if(Math.abs(gamepad.getRawAxis(2)) > 0) {
            rightWheels = gamepad.getRawAxis(2);
            //0 is a placeholder as we do not have any constants for the deadzone.
        }
        else {
            rightWheels = 0.0;
        }
    }

    protected void initialize() {
    	m_tankDrive.setPercentage(-leftWheels, -rightWheels);
    }

    protected void execute() {
        double leftWheels = 0.0;
        double rightWheels = 0.0;
        double axis1 = m_gamepad.getRawAxis(1);
        double axis2 = m_gamepad.getRawAxis(2);

        if(Math.abs(axis1) > 0) {
            leftWheels = axis1;
        }
        if(Math.abs(axis2) > 0) {
            leftWheels = axis2;

        m_tankDrive.setPercentage(-leftWheels, -rightWheels);
        }
    }

    protected boolean isFinished() {
    	return false;
    }

    protected void end() {
    	m_tankDrive.setPercentage(0.0, 0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}