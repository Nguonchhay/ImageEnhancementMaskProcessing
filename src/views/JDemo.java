package views;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileSystemView;

import models.AbstractFilter;
import models.FileProcess;
import models.Item;
import models.Window;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class JDemo extends JFrame implements ActionListener {
	
	public final int ORIGINAL_IMAGE_WIDTH = 450;
	public final int ORIGINAL_IMAGE_HEIGHT = 450;
	
	JPanel panel;
	JButton browseImage;
	JButton apply;
	JLabel originalImage;
	JComboBox method, kernel;
	JComboBox padding;
	AbstractFilter filter = null;
	String selectedImagePath ="";

	public JDemo() {
		super("Mask Image Enhancement");
		Window.setMaximize(this,false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		initMenu();
		initControls();
	}
	
	public void initMenu(){
		JMenuBar bar=new JMenuBar();
		setJMenuBar(bar);
		
		/***********Menu File************************/
		JMenu file=new JMenu("File");
			file.setMnemonic('f');
		JMenuItem fileOpen=new JMenuItem("Broese image     Ctrl + O");
		JMenuItem fileExit=new JMenuItem("Exit                         Ctrl + Q");
		
		file.add(fileOpen);
		fileOpen.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				browseFile();
			}
		});
		
		file.add(fileExit);
		
		/**************Menu Help**********************/
		JMenu help=new JMenu("Help");
		help.setMnemonic('h');
		JMenuItem helpAbout=new JMenuItem("Group 2");
		help.add(helpAbout);
		helpAbout.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new ViewAbout().setVisible(true);
			}
		});
		/******************Add Menu to MenuBar********************/
		bar.add(file);
		bar.add(help);
	}
	
	public void initControls() {
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 1000, 1000);
		
		// Title
		JLabel title = new JLabel("Image / Neighbour Processing");
		title.setBounds(500, 20, 500, 35);
		title.setFont(new Font("Times New Roman", Font.BOLD, 24));
		panel.add(title);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(null);
		leftPanel.setBounds(30, 30, 500, 900);
		
		// Load image
		String browseImageText = "Browse image";
		browseImage = new JButton(browseImageText);
		browseImage.setBounds(50, 100, 120, 35);
		browseImage.addActionListener(this);
		leftPanel.add(browseImage);
		
		// Original image
		originalImage = new JLabel("", JLabel.CENTER);
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		originalImage.setBorder(border);
		originalImage.setBounds(50, 150, this.ORIGINAL_IMAGE_WIDTH, this.ORIGINAL_IMAGE_HEIGHT);
		leftPanel.add(originalImage);
		
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(null);
		rightPanel.setBounds(500, 30, 1400, 900);
		
		// Filtering Methods and Label
		JLabel lblMethod = new JLabel("Filtering methods: ");
		lblMethod.setBounds(150, 140, 150, 35);
		rightPanel.add(lblMethod);
		method = new JComboBox();
		method.setBounds(280, 135, 200, 50);
		method.addItem("Mean Filter (Average Filter)");
		method.addItem("Median Filter");
		method.setSelectedIndex(0);
		rightPanel.add(method);
		
		// Kernel and label
		JLabel lblKernel = new JLabel("Kernels: ");
		lblKernel.setBounds(150, 180, 150, 35);
		rightPanel.add(lblKernel);
		kernel = new JComboBox();
		kernel.addItem(new Item(3, "3 x 3"));
		kernel.addItem(new Item(5, "5 x 5"));
		kernel.addItem(new Item(7, "7 x 7"));
		kernel.setBounds(280, 180, 200, 35);
		rightPanel.add(kernel);
		
		// Padding and label
		JLabel lblPadding = new JLabel("Padding types: ");
		lblPadding.setBounds(150, 220, 150, 35);
		rightPanel.add(lblPadding);
		padding = new JComboBox();
		padding.setBounds(280, 215, 200, 50);
		padding.addItem(new Item(0, "Zero padding"));
		padding.addItem(new Item(1, "Replicated value"));
		padding.setSelectedIndex(0);
		rightPanel.add(padding);
		
		// Apply
		String applyText = "Appy";
		apply = new JButton(applyText);
		apply.setBounds(280, 270, 120, 35);
		apply.addActionListener(this);
		rightPanel.add(apply);
		
		panel.add(leftPanel);
		panel.add(rightPanel);
		getContentPane().add(panel);
	}
	
	public void browseFile() {
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		int returnValue = jfc.showOpenDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = jfc.getSelectedFile();
			originalImage.setIcon(new ImageIcon(new javax.swing.ImageIcon(selectedFile.getAbsolutePath()).getImage().getScaledInstance(this.ORIGINAL_IMAGE_WIDTH, this.ORIGINAL_IMAGE_HEIGHT, Image.SCALE_SMOOTH)));
			selectedImagePath = selectedFile.getAbsolutePath();
		}
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == browseImage) {
			browseFile();
		} else if (event.getSource() == apply) {
			filter = AbstractFilter.getFilter(method.getSelectedItem().toString());
			filter.setPath(selectedImagePath);
			
			Item itemKernel = (Item) kernel.getSelectedItem();
			filter.setKernal(itemKernel.getId());
			
			Item itemPadding = (Item) padding.getSelectedItem();
			filter.setPadding(itemPadding.getId());
			
			filter.enhanceImage();
			if (JOptionPane.showConfirmDialog(this, "Enhancement process is complete. Do you want to display image?") == JOptionPane.OK_OPTION) {
				new ViewImage(FileProcess.getCurrentPath() + "/images/" + filter.getFilename()).setVisible(true);
			}
		}
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
