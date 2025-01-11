// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class tankDrive extends SubsystemBase {
  /** Creates a new tankDrive. */
  CANSparkMax fL;
  CANSparkMax fR;
  CANSparkMax bL;
  CANSparkMax bR;
  DifferentialDrive tank_Drive;
  public tankDrive() {
    fL = new CANSparkMax(4 , MotorType.kBrushless);
    fR = new CANSparkMax(3 , MotorType.kBrushless);
    bR = new CANSparkMax(2 , MotorType.kBrushless);
    bL = new CANSparkMax(1 , MotorType.kBrushless);
    bL.follow(fL);
    bR.follow(fR);
    fL.setInverted(true);
    tank_Drive = new DifferentialDrive(fL , fR);
  }

  public DifferentialDrive getDifferentialDrive(){
    return tank_Drive;
  }
    
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
