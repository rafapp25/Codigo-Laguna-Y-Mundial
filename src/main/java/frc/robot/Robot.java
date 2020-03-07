package frc.robot;

//imports 
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Compressor;

//imports de otros codigos
import frc.robot.subsystems.controles;
import frc.robot.subsystems.controlpanel;
import frc.robot.subsystems.disparar;
import frc.robot.subsystems.drivetrain;
import frc.robot.subsystems.escalar;
import frc.robot.subsystems.intake;
import frc.robot.subsystems.autonomo;

public class Robot extends TimedRobot {
 
    //objetos de todos los otros codigos
    private controles localControles;
    private controlpanel localControlPanel;
    private disparar localDisparar;
    public static drivetrain localDrivetrain;
    private escalar localEscalar;
    private intake localIntake;
    private autonomo localAutonomo;
    private Compressor compresora;

  @Override
  public void robotInit() {

    compresora = new Compressor(1);
    compresora.setClosedLoopControl(true);

    //iniciar objetos de todos los otros codigos
    localControles = new controles();
    //localControlPanel = new controlpanel();
    localDisparar = new disparar();
    localDrivetrain = new drivetrain();
    localEscalar = new escalar();
    localIntake = new intake();
    

    
    //iniciar todas las funciones init de los subsistemas
    
    

  }

  @Override
  public void robotPeriodic() {

  }

  @Override
  public void autonomousInit() {
    localAutonomo = new autonomo();
  }

  @Override
  public void autonomousPeriodic() {
    
    localAutonomo.autonomoPeriodico();

  }

  @Override
  public void teleopPeriodic() {

    localDrivetrain.drivetrainPeriodic();
    localIntake.intakePeriodic();
    localDisparar.dispararPeriodic();
    localEscalar.escalarPeriodic();
    //localControlPanel.controlPanelPeriodic();

  }

  @Override
  public void testPeriodic() {

    

  }
}
