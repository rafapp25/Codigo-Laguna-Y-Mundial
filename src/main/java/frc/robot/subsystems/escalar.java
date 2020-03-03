package frc.robot.subsystems;

//imports
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;



//imports de codigo
import frc.robot.subsystems.controles;

public class escalar{

    

    private controles localControles;

    private DoubleSolenoid pistonElevador;

    private WPI_TalonSRX motorElevador, motorLevantarRobot;

    public escalar(){

        localControles = new controles();
        pistonElevador = new DoubleSolenoid(1,1,2);
        motorElevador = new WPI_TalonSRX(12);
        motorLevantarRobot = new WPI_TalonSRX(11);

    }

    public void escalarPeriodic(){

        //levantar y colapsar piston
        if(localControles.controlMecanismos.getRawButton(9)){

            pistonElevador.set(Value.kForward);

        } else if(localControles.controlMecanismos.getRawButton(7)){

            pistonElevador.set(Value.kReverse);

        }

        //subir y bajar elevador
        if(localControles.controlMecanismos.getRawButton(8)){

            motorElevador.set(.4);

        } else if(localControles.controlMecanismos.getRawButton(10)){

            motorElevador.set(-.4);
 
        } else{

            motorElevador.set(0);

        }

        //levantar y descender robot al suelo
        if(localControles.controlDrivetrain.getRawButton(4)){

            motorLevantarRobot.set(-1);

        } else if(localControles.controlDrivetrain.getRawButton(3)){

            motorLevantarRobot.set(1);
 
        } else{

            motorLevantarRobot.set(0);

        }

    }

    
}