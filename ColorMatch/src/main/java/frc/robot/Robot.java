/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj.Timer;



/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */

  public static VictorSPX spinMotor = new VictorSPX(4);
  public static VictorSPX motor = new VictorSPX(2);
  private final I2C.Port i2cPort = I2C.Port.kOnboard;
  private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);
  private final ColorMatch m_colorMatcher = new ColorMatch();
  
  
  private final Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
  private final Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
  private final Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
  private final Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);
  private final Joystick joy = new Joystick(0);
  private double a;
  private double b;
  private double c;
  private double d;
  int i;
  
  @Override
  public void robotInit() {
  
                                                                                  
  m_colorMatcher.addColorMatch(kBlueTarget);
  m_colorMatcher.addColorMatch(kGreenTarget);
  m_colorMatcher.addColorMatch(kRedTarget);
  m_colorMatcher.addColorMatch(kYellowTarget);  
       
  }

@Override
    public void robotPeriodic() {

     
}
       

    
     ;
  
      

 
  @Override
  public void autonomousInit() {
  

  

    
  }

  @Override
  public void autonomousPeriodic() {

  }

  @Override
  public void teleopInit() {
    a = 0;
    b = 0;
    c = 0;
    d = 0;
    i = 0;
  }

  @Override
  public void teleopPeriodic() {

    
    Color detectedColor = m_colorSensor.getColor();
   
    String colorString;
    ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);   
    
    

    if(joy.getRawButtonPressed(6)){i++;
    }if(i==1){motor.set(ControlMode.PercentOutput, -0.2);Timer.delay(5);motor.set(ControlMode.PercentOutput, 0); spinMotor.set(ControlMode.PercentOutput, -0.3);Timer.delay(10); i=i+1;}
    else if (i==2){spinMotor.set(ControlMode.PercentOutput, 0);motor.set(ControlMode.PercentOutput, 0.2);Timer.delay(5);i=i-2;}
    else if (i==0){spinMotor.set(ControlMode.PercentOutput, 0);motor.set(ControlMode.PercentOutput, 0);}

    if (match.color == kBlueTarget){
      colorString = "Blue";
    } else if (match.color == kRedTarget){
      colorString = "Red";
    } else if (match.color == kGreenTarget){
      colorString = "Green";
    } else if (match.color == kYellowTarget){
      colorString = "Yellow";
    } else {
      colorString = "Unknown";
    }

  
  if (joy.getRawButtonPressed(1)){a++;
  if (a==0){spinMotor.set(ControlMode.PercentOutput, 0);motor.set(ControlMode.PercentOutput, 0);
  }}if (a==1) {motor.set(ControlMode.PercentOutput,-0.2);Timer.delay(5);a++;
  }else if (a==2) {motor.set(ControlMode.PercentOutput, 0);spinMotor.set(ControlMode.PercentOutput, 0.2);
  if (match.color == kGreenTarget){
    spinMotor.set(ControlMode.PercentOutput, 0);Timer.delay(5);motor.set(ControlMode.PercentOutput, 0.2);Timer.delay(5);a++;
  }if (a==3){motor.set(ControlMode.PercentOutput, 0);a=a-3;
  }}
   

  if (joy.getRawButtonPressed(2)){b++;
  if (b==0){spinMotor.set(ControlMode.PercentOutput, 0);motor.set(ControlMode.PercentOutput, 0);
  }}if (b==1) {motor.set(ControlMode.PercentOutput,-0.2);Timer.delay(5);b++;
  }else if (b==2) {motor.set(ControlMode.PercentOutput, 0);spinMotor.set(ControlMode.PercentOutput, 0.2);
  if (match.color == kRedTarget){
    spinMotor.set(ControlMode.PercentOutput, 0);Timer.delay(5);motor.set(ControlMode.PercentOutput, 0.2);Timer.delay(5);b++;
  }if (b==3){motor.set(ControlMode.PercentOutput, 0);b=b-3;
  }}

  if (joy.getRawButtonPressed(3)){c++;
  if (c==0){spinMotor.set(ControlMode.PercentOutput, 0);motor.set(ControlMode.PercentOutput, 0);
  }}if (c==1) {motor.set(ControlMode.PercentOutput,-0.2);Timer.delay(5);c++;
  }else if (c==2) {motor.set(ControlMode.PercentOutput, 0);spinMotor.set(ControlMode.PercentOutput, 0.2);
  if (match.color == kBlueTarget){
    spinMotor.set(ControlMode.PercentOutput, 0);Timer.delay(5);motor.set(ControlMode.PercentOutput, 0.2);Timer.delay(5);c++;
  }if (c==3){motor.set(ControlMode.PercentOutput, 0);c=c-3;
  }}

   
  if (joy.getRawButtonPressed(4)){d++;
  if (d==0){spinMotor.set(ControlMode.PercentOutput, 0);motor.set(ControlMode.PercentOutput, 0);
  }}if (d==1) {motor.set(ControlMode.PercentOutput,-0.2);Timer.delay(5);d++;
  }else if (d==2) {motor.set(ControlMode.PercentOutput, 0);spinMotor.set(ControlMode.PercentOutput, 0.2);
  if (match.color == kYellowTarget){
    spinMotor.set(ControlMode.PercentOutput, 0);Timer.delay(5);motor.set(ControlMode.PercentOutput, 0.2);Timer.delay(5);d++;
  }if (d==3){motor.set(ControlMode.PercentOutput, 0);d=d-3;
  }}

 




    SmartDashboard.putNumber("Red", detectedColor.red);
    SmartDashboard.putNumber("Blue", detectedColor.blue);
    SmartDashboard.putNumber("Green", detectedColor.green);
    SmartDashboard.putNumber("Confidence", match.confidence);
    SmartDashboard.putNumber("a", a);
    SmartDashboard.putNumber("b", b);
    SmartDashboard.putNumber("c", c);
    SmartDashboard.putNumber("d", d);
    SmartDashboard.putNumber("i", i);
    SmartDashboard.putString("Deceted Color", colorString);

}


  
  
  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }

}
