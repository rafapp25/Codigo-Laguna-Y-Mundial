package frc.robot.subsystems;

//imports
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.I2C;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
// import com.revrobotics.ColorSensorV3;
// import com.revrobotics.ColorMatch;
// import edu.wpi.first.wpilibj.util.Color;
// import com.revrobotics.ColorMatchResult;

//imports de codigo
import frc.robot.subsystems.controles;

public class controlpanel{

    //puertos de cosas
    private controles localControles;
    private WPI_TalonSRX motorControlPanel;
    //private ColorSensorV3 sensorColor;
    private DoubleSolenoid pistonSubirGirador;
    private I2C.Port i2cPort = I2C.Port.kOnboard;
    // private ColorMatch m_colorMatcher;
    // private Color kBlueTarget;
    // private Color kGreenTarget;
    // private Color kRedTarget;
    // private Color kYellowTarget; 


    //variables bool de colores para rotation control
    private int colorDetectadoAlmacenado;

     public controlpanel(){

    //     kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
    //     //esta mal el verde
    //     kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
    //     kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
    //     kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);

    //     m_colorMatcher = new ColorMatch();
    //     sensorColor = new ColorSensorV3(i2cPort);
    //     localControles = new controles();
           //motorControlPanel = new WPI_TalonSRX(6);
    //     pistonSubirGirador = new DoubleSolenoid(1,0,7);

    //     m_colorMatcher.addColorMatch(kBlueTarget);
    //     m_colorMatcher.addColorMatch(kGreenTarget);
    //     m_colorMatcher.addColorMatch(kRedTarget);
    //     m_colorMatcher.addColorMatch(kYellowTarget);   

     }

    public void controlPanelPeriodic(){

        motorControlPanel = new WPI_TalonSRX(6);

        //subir piston
        if(localControles.controlMecanismos.getRawButton(3)){

            pistonSubirGirador.set(Value.kForward);

        } else if(localControles.controlMecanismos.getRawButton(4)){

            pistonSubirGirador.set(Value.kReverse);

        }

        if(localControles.controlMecanismos.getRawButton(5)){

            motorControlPanel.set(.4);

        } else if(localControles.controlMecanismos.getRawButton(6)){

            motorControlPanel.set(-.4);

        } else{

            motorControlPanel.set(0);

        }

        // //detectar colores y asignarlos a variables
        // Color detectedColor = sensorColor.getColor();
        // ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);

        // if (match.color == kBlueTarget) {
        //     System.out.println("azul");
        //   } else if (match.color == kRedTarget) {
        //     System.out.println("rojo");
        //   } else if (match.color == kGreenTarget) {
        //     System.out.println("verde");
        //   } else if (match.color == kYellowTarget) {
        //     System.out.println("amarillo");
        //   } else {
        //     System.out.println("desconocido");
        //   }

    }

    public void rotationControl(){



    }

    public void positionControl(){}

}