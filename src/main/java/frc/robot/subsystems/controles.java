package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;

public class controles{

    public Joystick controlMecanismos, controlDrivetrain;

    public controles(){

        controlDrivetrain = new Joystick(0);
        controlMecanismos = new Joystick(1);

    }

}