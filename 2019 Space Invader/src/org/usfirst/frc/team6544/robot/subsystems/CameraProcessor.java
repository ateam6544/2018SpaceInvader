package org.usfirst.frc.team6544.robot.subsystems;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;

public class CameraProcessor implements Runnable {
private Thread t;
private String camName;
private int camDevID;
private UsbCamera camera;


public CameraProcessor(String CameraName, int DevID){
	camName = CameraName;
	camDevID = DevID;
	
}

public void run(){
	try{
		// Do camera work here
		camera = CameraServer.getInstance().startAutomaticCapture(camName,camDevID); // Starts the capture and assigns the instance to the camera object
	    camera.setResolution(320, 240); //Sets the resolution to 320*240
        
        
	}catch (Exception e){
	}
}

public void start () {
	if (t== null){
		t = new Thread (this);
		t.start();
	}
}
	
	public void SendToDashboard(String StreamName){
		CameraServer.getInstance().putVideo(StreamName, 320, 240); //Sends the stream to the dashboard
	}
	
	
}
