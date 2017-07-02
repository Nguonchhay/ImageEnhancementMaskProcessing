package views;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class ViewHelp extends JFrame implements ActionListener {

	public ViewHelp(){
		setSize(700,900);		
		setLayout(null);
		initControls();
	}
	public void initControls(){
		int TPx=10,TPy=30,TPw=650,TPh=300;
		int IPx=40,IPy=320,IPw=600,IPh=270;
		int LPx=40,LPy=550,LPw=500,LPh=300;
		titlePanel();
		aboutProject(TPx,TPy,TPw,TPh);
		imagePanel("elevator.png",IPx,IPy,IPw,IPh);
		HelpList(LPx,LPy,LPw,LPh);
	}
	public void titlePanel(){
		
		String title = "<html><h1 style = 'font-family:georgia; color:blue;font-size:25'><i>Help</i></h1></html>";
		JLabel lbl=new JLabel(title);
		lbl.setBounds(300,-40,400,150);
		lbl.setFont(new Font("David",Font.PLAIN,40));
		getContentPane().add(lbl);
	}
	public void aboutProject(int x,int y,int w,int h){
		//JPanel p=new JPanel(new FlowLayout());
		//p.setBounds(x, y, w, h);

String detail ="<html><p> &#09;This elevator simulation system is to simulate an elevator and provide meaningful information, the output will determine, for a given number of elevators, how many passengers per a specific time that it can carry from the source floor to the destination floor of the shopping center.</p></br>There sevrals characteristics of the this simulator such as:<ul>";
detail+="<li>The number of elevators in the building will be determined by the user.</li>";
detail+="<li> The building will contain a fixed number of floors. </li>";
detail+="<li>The number of passengers that can fit into the elevator will be fixed.</li>";
detail+="<li>The passengers will be counted as they leave the elevator at their destination floor. </li>";
detail+="<li>The destination floor will be determined using a random Poisson interval. </li>";
detail+="<li>The simulation will continue until the end simulation run time. </li>";
detail+="<li>A report will be generated showing the activity of the elevators and passengers.</li></ul></html>";
		JLabel lbl=new JLabel(detail);
		lbl.setBounds(x,y,w,h);
		getContentPane().add(lbl);
	}
	public void imagePanel(String image,int Px,int Py,int Pw,int Ph){
		MyImagePanel img=new MyImagePanel(image,Px,Py,Pw,Ph);
		getContentPane().add(img);
		
	}
	public void HelpList(int x,int y,int w,int h){
		
	String list = "<html><ol><li>Menu<ul><li>File</li><li>Help</li></ul>";
			list+="<li>Input</li>";
			list+="<li>Report</li>";
			list+="<li>Elevator traffic</li>";
			list+="<li>Clock</li>";
			list+="<li>Queue Information</li></ol></html>";
			
	JLabel lbl=new JLabel(list);
	lbl.setBounds(x,y,w,h);
	getContentPane().add(lbl);
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}

