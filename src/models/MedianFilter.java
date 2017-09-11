package models;

import javax.swing.JOptionPane;

import dyimagefx.*;
import dyimagefx.filter.*;

public class MedianFilter extends AbstractFilter {

	protected MyImage processImage;
	
	public MedianFilter() {
		processImage = new MyImage();
		super.path = "";
	}
	
	public MedianFilter(String path) {
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
				Median.medianFilter_ZeroFill(processImage, kernel);
			} else if (padding== 1) {
				Median.medianFilter_ValueFill(processImage, kernel);
			}
			processImage.writeImage(FileProcess.getCurrentPath() + "/images/" + super.getFilename());
		}
	}
}