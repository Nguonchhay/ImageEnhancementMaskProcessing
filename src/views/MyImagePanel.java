package views;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import models.FileProcess;

public class MyImagePanel extends JPanel{
	private String image;
	private int x,y,w,h;
	
	public MyImagePanel(String img,int x,int y,int w,int h){
		this.image=img;
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
		setBounds(x,y,w,h);
	}
	
	public void paint(Graphics g){
		Image img=new ImageIcon(FileProcess.getCurrentPath()+"/images/"+image).getImage();
		g.drawImage(img, 0, 0, w, h, this);
	}
}

