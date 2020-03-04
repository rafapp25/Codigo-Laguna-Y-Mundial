package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
//imports
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Timer;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

//imports de codigo
import frc.robot.subsystems.controles;

public class disparar{

    public WPI_TalonSRX motorAcercar, 
    motorDisparar, motorGirarSusana, motorGirarCapucha;

    public VictorSPX motorSubirPelotas;

    private controles localControles;

    public disparar(){

        motorAcercar = new WPI_TalonSRX(5);
        motorSubirPelotas = new VictorSPX(10);
        motorDisparar = new WPI_TalonSRX(9);
        motorGirarSusana = new WPI_TalonSRX(7);
        motorGirarCapucha = new WPI_TalonSRX(8);
        localControles = new controles();

        motorSubirPelotas.setInverted(true);
        motorAcercar.setInverted(true);

    }

    public void dispararPeriodic(){

        //apuntar susana a velocidades constantes
        motorGirarSusana.set(localControles.controlMecanismos.getRawAxis(2));

        //apuntar capucha
        if(localControles.controlMecanismos.getRawButton(12) == true){

            motorGirarCapucha.set(-localControles.controlMecanismos.getRawAxis(1));

        } else{

            motorGirarCapucha.set(0);

        }

        //disparar con botones 1 y 2
        if(localControles.controlMecanismos.getRawButton(2) == true){

            motorDisparar.set(1);

        } else{

            motorDisparar.set(0);

        }

        //disparar reverse
        if(localControles.controlMecanismos.getRawButton(11) == true){

            motorSubirPelotas.set(ControlMode.PercentOutput,-.5);
            motorAcercar.set(-.5);

        }

        else if(localControles.controlMecanismos.getRawButton(1)){

            motorAcercar.set(.5);
            motorSubirPelotas.set(ControlMode.PercentOutput, .3);
            

        } 

        else{

            motorAcercar.set(0);
            motorSubirPelotas.set(ControlMode.PercentOutput, 0);

        }

       
    }

    public void dispararParaAutonomo(){

            motorDisparar.set(1);

            Timer.delay(2);

            motorAcercar.set(.4);
            motorSubirPelotas.set(ControlMode.PercentOutput,.3);

    }

    public void detenerDispararParaAutonomo(){

        motorDisparar.set(0);
        motorAcercar.set(0);
        motorSubirPelotas.set(ControlMode.PercentOutput,0);

    }



    

}