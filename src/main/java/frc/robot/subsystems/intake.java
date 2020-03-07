package frc.robot.subsystems;

//imports
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.Robot;


//imports de codigo
import frc.robot.subsystems.controles;
import frc.robot.subsystems.disparar;


public class intake{


    //variables de imports
    private controles localControles;
    private disparar localDisparar;
    
    //variables de motores
    public WPI_TalonSRX motorIntake;

    //switches
    private DigitalInput switch1, switch2, switchSubirPelotas;

    //estados de los switches
    private boolean boolSwitchesIntakePresionados, boolSubirPelotasPresionado;

    //cantidad de pelotas en robot
    private int cantidadDePelotas;

    public intake(){

        cantidadDePelotas = 0;

        localDisparar = new disparar();
        localControles = new controles();
        motorIntake = new WPI_TalonSRX(13);

        //switchSubirPelotas = new DigitalInput(0);
        //switch1 = new DigitalInput(1);
        //switch2 = new DigitalInput(2);

        //positivo es meter pelotas, negativo sacar pelotas
        motorIntake.setInverted(true);

    }

    public void intakePeriodic(){

        //funcionamiento normal del intake con el control
        if(localControles.controlDrivetrain.getRawButton(6)){

            motorIntake.set(.5);

        } else if(localControles.controlDrivetrain.getRawButton(5)){

            motorIntake.set(-.5);

        } else{

            motorIntake.set(0);

        }

    }
}