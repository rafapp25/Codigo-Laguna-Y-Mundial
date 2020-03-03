package frc.robot.subsystems;

import com.fasterxml.jackson.core.type.WritableTypeId.Inclusion;

import edu.wpi.first.wpilibj.SlewRateLimiter;
//imports
import edu.wpi.first.wpilibj.Timer;
import frc.robot.Robot;
//imports de mecanismos
//import frc.robot.subsystems.drivetrain;
import frc.robot.subsystems.disparar;


public class autonomo{

    private disparar localDisparar;
    private  SlewRateLimiter smooth;
    int inicio;
    double tiempoIncial;

    public autonomo(){
        smooth = new SlewRateLimiter(0.5);
        localDisparar = new disparar();
        inicio = 1;
        tiempoIncial = Timer.getFPGATimestamp();
    }

    public void autonomoPeriodico(){
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