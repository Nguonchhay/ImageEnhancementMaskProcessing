package views;

import javax.swing.*;

import models.Window;

import java.awt.*;
import java.awt.event.*;

public class JDemo extends JFrame implements ActionListener {

	public JDemo() {
		super("Mask Image Enhancement");
		Window.setMaximize(this,false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		initMenu();
	}
	
	public void initMenu(){
		JMenuBar bar=new JMenuBar();
		setJMenuBar(bar);
		
		/***********Menu File************************/
		JMenu file=new JMenu("File");
			file.setMnemonic('f');
		JMenuItem fileNew=new JMenuItem("New                         Ctrl + N");
			fileNew.setMnemonic('n');
		JMenuItem fileOpen=new JMenuItem("Open image file     Ctrl + O");
		JMenuItem fileSave=new JMenuItem("Save                        Ctrl + S");
		JMenuItem fileSaveAs=new JMenuItem("Save As ... ");
		JMenuItem fileExit=new JMenuItem("Exit                         Ctrl + Q");
		
		file.add(fileNew);
		file.add(fileOpen);
		file.add(fileSave);
		file.add(fileSaveAs);		
		file.add(fileExit);
		
		/**************Menu Help**********************/
		JMenu help=new JMenu("Help");
		help.setMnemonic('h');
		JMenuItem helpViewHelp=new JMenuItem("How to use this system");
		JMenuItem helpAbout=new JMenuItem("Group 3");	
		help.add(helpViewHelp);
		help.add(helpAbout);
		helpViewHelp.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new ViewHelp().setVisible(true);
			}
		});
		helpAbout.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new ViewAbout().setVisible(true);
			}
		});
		/******************Add Menu to MenuBar********************/
		bar.add(file);
		bar.add(help);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(
			            UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		new JDemo().setVisible(true);
	}
}
