package models;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;


public class Window {
	public static int getWindowWidth(){
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		return screenSize.width;
	} 
	public static int getWindowHeight(){
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		return screenSize.height;
	} 
	public static void setMaximize(JFrame frame,boolean taskbar){
		if(taskbar)
			frame.setSize(getWindowWidth(), getWindowHeight()-50);
		else
			frame.setSize(getWindowWidth(), getWindowHeight());
	}
	public static void setCenter(JFrame frame,int w,int h){
		frame.setSize(w, h);
		int x,y;
		x=(getWindowWidth()-w)/2;
		y=(getWindowHeight()-h)/2;
		frame.setLocation(x, y);
	}
}

