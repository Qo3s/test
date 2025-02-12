// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LimeLight extends SubsystemBase {
  /** Creates a new limeLight. */
  NetworkTable table;
  NetworkTableEntry tx,ty,Id,ta,info;
  double x,y,area,id;
  double[] Info;
  double[] targetInfo;
  String limelightName;
  
  
  public LimeLight(String hostName) {
    this.limelightName = "limelight-" + hostName;
  
    this.table = NetworkTableInstance.getDefault().getTable(limelightName);
    this.tx = table.getEntry("tx");
    this.Id = table.getEntry("tid");
    this.ty = table.getEntry("ty");
    this.ta = table.getEntry("ta");
    this.info = table.getEntry("targetpose_robotspace");
    NetworkTableEntry frontCameraSet = table.getEntry("camerapose_robotspace_set");
    
    double[] frontCameraPose;

    frontCameraPose = frontCameraSet.getDoubleArray(new double[6]);
    frontCameraPose[0] = -0.3111754;
    frontCameraPose[1] = 0.0;
    frontCameraPose[2] = 0.2853182;
    frontCameraPose[3] = 0.0;
    frontCameraPose[4] = 35;
    frontCameraPose[5] = 0.0;
  }

  public double getAprilTagPosition(int place){
    x = tx.getDouble(0.0);
    y = ty.getDouble(0.0);
    area = ta.getDouble(0.0);
    id = Id.getDouble(0.0);
    Info = info.getDoubleArray(new double[6]);
    targetInfo = new double[]{id,Info[0],Info[1],Info[2],Info[3],Info[4],Info[5]};
    SmartDashboard.putNumber("camera x pos", table.getEntry("camerapose_robotspace").getDoubleArray(new double[6])[0]);
    /**SmartDashboard.putNumber("x",x);
    SmartDashboard.putNumber("y",y);
    SmartDashboard.putNumber("area",area);
    SmartDashboard.putNumber("ID",id);
    SmartDashboard.putNumber("x pos",Info[0]);
    SmartDashboard.putNumber("y pos",Info[1]);
    SmartDashboard.putNumber("z pos",Info[2]);
    SmartDashboard.putNumber("pitch",Info[3]);
    SmartDashboard.putNumber("yaw",Info[4]);
    SmartDashboard.putNumber("roll",Info[5]);*/
    return targetInfo[place];
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
