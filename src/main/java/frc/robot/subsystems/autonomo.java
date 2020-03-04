package frc.robot.subsystems;

import com.fasterxml.jackson.core.type.WritableTypeId.Inclusion;

import edu.wpi.first.wpilibj.SlewRateLimiter;
//imports
import edu.wpi.first.wpilibj.Timer;
import frc.robot.Robot;
//imports de mecanismos
import frc.robot.subsystems.drivetrain;
import frc.robot.subsystems.disparar;
import frc.robot.subsystems.intake;


public class autonomo{

    private disparar localDisparar;
    private static intake localIntake;

    private  SlewRateLimiter smooth;
    int inicio;
    
    private double tiempoActual;

    public autonomo(){

        smooth = new SlewRateLimiter(0.5);

        localDisparar = new disparar();
        localIntake = new intake();

        inicio = 1;

        
    }

    public void autonomoPeriodico(){

        tiempoActual = Timer.getFPGATimestamp();
        
        //funciones de disparar
        if(tiempoActual < 4){

            localDisparar.dispararParaAutonomo();

        } else if(tiempoActual > 11 && tiempoActual < 15){

            localDisparar.dispararParaAutonomo();

        } else{

            localDisparar.detenerDispararParaAutonomo();

        }

        //funciones de movimiento
        if (tiempoActual > 4 && tiempoActual < 7.5){

            Robot.localDrivetrain.motor1.set(.5);
            Robot.localDrivetrain.motor4.set(.5);

            localIntake.motorIntake.set(.6);

        } else if(tiempoActual > 7.5 && tiempoActual < 11){

            Robot.localDrivetrain.motor1.set(-.5);
            Robot.localDrivetrain.motor4.set(-.5);

            localIntake.motorIntake.set(0);

        } else{

            Robot.localDrivetrain.motor1.set(0);
            Robot.localDrivetrain.motor4.set(0);

            localIntake.motorIntake.set(0);

        }

      

        if(inicio == 1){
            localDisparar.dispararParaAutonomo();
        }else{
            Robot.localDrivetrain.driveTrainNeo.arcadeDrive(smooth.calculate(-0.3), 0); 
        }
        inicio++;  

        if ( Timer.getFPGATimestamp() > 13){
            Robot.localDrivetrain.driveTrainNeo.arcadeDrive(smooth.calculate(0), 0); 
        }
    }

}