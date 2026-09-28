package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.signals.FeedbackSensorSourceValue;
import com.ctre.phoenix6.signals.GravityTypeValue;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;

public class SwerveSubsystem extends SubsystemBase implements PIDOutput {

public final PIDController PIDmotor;

public final double kP;
public final double kI;
public final double kD;

public SwerveSubsystem(){
TalonFX swerveMotor = new TalonFX(1);
Falcon swerveMotor2 = new Falcon(2);

PIDmotor = new PIDContoller(kP, kI, kD, swerveMotor2, this);
PIDmotor.setOutputRange(-1,1);

public void MotorDirection(){//when called, switches direction
swerveMotor.set(ControlMode.PercentOutput, ClimberVariables.CLIMB_MOTOR_SPEED*ClimberConstants.CLIMB_MOTOR_DIRECTION);
}


@Override
public void pidWrite(double output){
swerveMotor.set(ControlMode.PercentOutput,output,-output);
}

}
}