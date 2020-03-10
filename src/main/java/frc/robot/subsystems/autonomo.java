package frc.robot.subsystems;

import com.fasterxml.jackson.core.type.WritableTypeId.Inclusion;

import edu.wpi.first.wpilibj.SlewRateLimiter;

//imports
import edu.wpi.first.wpilibj.Timer;
import frc.robot.Robot;
import com.revrobotics.CANEncoder;

//imports de mecanismos
import frc.robot.subsystems.drivetrain;
import frc.robot.subsystems.disparar;
import frc.robot.subsystems.intake;



public class autonomo{

    private disparar localDisparar;

    private intake localIntake;
    
    private Timer tiempoAutonomo;

    private double tiempoActual;

    private SlewRateLimiter smooth;

    public autonomo(){

        tiempoAutonomo = new Timer();
       
        tiempoAutonomo.start();

        localDisparar = new disparar();
        localIntake = new intake();

    }

    public void autonomoPeriodico(){

        tiempoActual = tiempoAutonomo.get();
        
        //funciones de disparar
        if(tiempoActual < 4){
           
            localDisparar.dispararParaAutonomo();

        } else if(tiempoActual > 11 && tiempoActual < 15){

            localDisparar.dispararParaAutonomo();

        } else{

            localDisparar.detenerDispararParaAutonomo();

        }

        //funciones de movimiento + intake
        //se mueve hacia el trench y toma las 3 pelotas
        if (tiempoActual > 4 && tiempoActual < 7.5){

            Robot.localDrivetrain.driveTrainNeo.tankDrive(-.55, -.59);

            localIntake.motorIntake.set(.45);

        //sale del trench    
        } else if(tiempoActual > 7.5 && tiempoActual < 11){

            Robot.localDrivetrain.driveTrainNeo.tankDrive(.55, .59);

            localIntake.motorIntake.set(0);

        //frenar todos estos motores cuando se deba
        } else{

            Robot.localDrivetrain.driveTrainNeo.tankDrive(0, 0);

            localIntake.motorIntake.set(0);

        }

}
}