package views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ViewImage extends JFrame {
	
	public ViewImage(String path) {
		setSize(700,860);
		setLayout(null);
		initControls(path);
		setBackground(Color.WHITE);
	}
	
	public void initControls(String path) {
		JLabel title = new JLabel("Adjustment Image");
		title.setBounds(80, 20, 300, 35);
		title.setFont(new Font("Times New Roman", Font.BOLD, 24));
		getContentPane().add(title);
		
		MyImagePanel img=new MyImagePanel(path, 80, 80, 400, 400);
		getContentPane().add(img);
	}
}
