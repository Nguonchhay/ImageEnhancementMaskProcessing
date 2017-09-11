package models;

import javax.swing.JOptionPane;

import dyimagefx.*;
import dyimagefx.filter.*;

public class MeanFilter extends AbstractFilter {

	public Mean meanFilter;
	protected MyImage processImage;
	
	public MeanFilter() {
		processImage = new MyImage();
		super.path = "";
	}
	
	public MeanFilter(String path) {
		processImage = new MyImage();
		super.path = path;
	}
	
	public void enhanceImage() {
		if (super.path.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, "Please, profile image path to enhance");
		} else {
			processImage.readImage(super.path);
			int padding = (int) super.getPadding();
			int kernel = (int) super.getKernel();
			if (padding == 0) {
				Mean.meanFilter_ZeroFill(processImage, kernel);
			} else if (padding== 1) {
				Mean.meanFilter_ValueFill(processImage, kernel);
			}
			processImage.writeImage(FileProcess.getCurrentPath() + "/images/temp.jpg");
		}
	}
}