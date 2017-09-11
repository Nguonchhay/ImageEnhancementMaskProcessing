package views;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

public class ViewAbout extends JFrame{
	
	public ViewAbout() {
		setSize(700,860);
		setLayout(null);
		initControls();
		setBackground(Color.WHITE);
		
	}
	
	public void initControls() {
		String image = "image";
		String html = "";
		String []detail = {
				"<html><p style = 'font-family: georgia; color: blue;font-size:18'>Name: TOUCH Nguonchhay <br>Sex: Male <br>Responsible: <ul><li>MeanFilter</li><li>Implement form</li><li>Combine all tasks</li></ul><br></p>" + html,
				"<html><p style = 'font-family: georgia; color: teal;font-size:18'>Name: TES Putthira <br>Sex: Female <br>Responsible: <ul><li>MedianFilter</li></ul><br></p>" + html,
				"<html><p style = 'font-family: georgia; color: Green;font-size:18'>Name: Mey Odom <br>Sex: Male <br>Responsible: <ul><li>Design application form</li></ul><br></p>" + html
				};
		
		int Px = 80, Py = 100, Pw = 120, Ph = 160;
		int Fx = 200, Fy = 75, Fw = 400, Fh = 150;
		titlePanel();
		int j;
		for (int i = 0; i < detail.length; i++) {
			j=i+1;
			imagePanel(image+j,Px,Py,Pw,Ph);
			fieldSet(detail[i],Fx,Fy,Fw,Fh, i + 1);
			Py += 170;
			Fy += 170;
		}
		
	}
	
	public void titlePanel() {
		String title = "<html><h1 style = 'font-family:georgia; color:green;font-size:25'><i>Group 2 Members</i></h1></html>";
		JLabel lbl=new JLabel(title);
		lbl.setBounds(250,-40,400,150);
		lbl.setFont(new Font("David",Font.PLAIN,40));
		getContentPane().add(lbl);
	}
	
	public void imagePanel(String image,int Px,int Py,int Pw,int Ph){
		MyImagePanel img=new MyImagePanel(image+".jpg",Px,Py,Pw,Ph);
		getContentPane().add(img);
		
	}
	
	public void fieldSet(String detail,int x,int y,int w,int h, int num) {
		
		JPanel p=new JPanel(new FlowLayout());
		p.setBounds(x, y, w, h);
		p.setBorder(new TitledBorder("Member " + num + " :"));
		
		JLabel lbl=new JLabel(detail);
		p.add(lbl);
		getContentPane().add(p);
	}
	
	public static void main(String[] args) {
		new ViewAbout().setVisible(true);

	}

}
