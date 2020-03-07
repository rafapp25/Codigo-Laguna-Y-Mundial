package frc.robot.subsystems;

//imports
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Robot;

//imports de codigo
import frc.robot.subsystems.controles;

public class drivetrain{
    //variables
    public CANSparkMax motor1, motor2, motor3, motor4;

    public static DifferentialDrive driveTrainNeo;

    //variables de codigo
    private controles localControles;

    public drivetrain(){

        localControles = new controles();

        motor1 = new CANSparkMax(1, MotorType.kBrushless);
        motor2 = new CANSparkMax(2, MotorType.kBrushless);
        motor3 = new CANSparkMax(3, MotorType.kBrushless);
        motor4 = new CANSparkMax(4, MotorType.kBrushless);

        motor3.setInverted(true);
        motor1.setInverted(true);

        //3 sigue a 4, 2 sigue a 1
        motor2.follow(motor1);
        motor3.follow(motor4);

        driveTrainNeo = new DifferentialDrive(motor4, motor1);

    }

    public void drivetrainPeriodic(){
     
        if(Math.abs(localControles.controlDrivetrain.getRawAxis(1)) < .08){
            driveTrainNeo.arcadeDrive(0, -localControles.controlDrivetrain.getRawAxis(2) * .65);
            }

        if(Math.abs(localControles.controlDrivetrain.getRawAxis(1)) > .08){
            driveTrainNeo.arcadeDrive(localControles.controlDrivetrain.getRawAxis(1), localControles.controlDrivetrain.getRawAxis(2) * localControles.controlDrivetrain.getRawAxis(1) * .8);
        }
    }

    public void drivetrainParaAutonomo(){

        driveTrainNeo.arcadeDrive(.3, 0);

        Timer.delay(3);

        driveTrainNeo.arcadeDrive(0, 0);

    }
}



