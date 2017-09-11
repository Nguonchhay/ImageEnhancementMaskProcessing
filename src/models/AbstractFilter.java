package models;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class AbstractFilter {
	
	protected String path;
	protected int kernel;
	protected int padding;

	public abstract void enhanceImage();
	
	/**
	 * @param ImageName
	 * @return
	 * @throws IOException
	 */
	public byte[] extractBytes (String ImageName) throws IOException {
		 // open image
		 File imgPath = new File(ImageName);
		 BufferedImage bufferedImage = ImageIO.read(imgPath);

		 // get DataBufferBytes from Raster
		 WritableRaster raster = bufferedImage .getRaster();
		 DataBufferByte data   = (DataBufferByte) raster.getDataBuffer();

		 return data.getData();
	}
	
	/**
	 * @param className
	 * 
	 * @return AbstractFilter
	 */
	public static AbstractFilter getFilter(String className) {
		AbstractFilter filter = null;
		switch (className) {
			case "Mean Filter (Average Filter)":
				filter = new MeanFilter();
			case "Median Filter":
				filter = new MedianFilter();
		}
		return filter;
	}
	
	public String getPath() {
		return path;
	}
	
	public String getFilename() {
		File f = new File(path);
		return f.getName();
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public int getKernel() {
		return kernel;
	}
	
	public void setKernal(int kernel) {
		this.kernel = kernel;
	}
	
	public int getPadding() {
		return padding;
	}
	
	public void setPadding(int padding) {
		this.padding = padding;
	}
}
