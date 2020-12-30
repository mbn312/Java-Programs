package com.mattnguyencs.Instafilter;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class PixelArray implements Cloneable {
  private BufferedImage rawPixels;
  
  public PixelArray(BufferedImage bi) {
    this.rawPixels = bi;
  }
  
  public void fillArray(Color color) {
    for (int c = 0; c < this.rawPixels.getWidth(); c++) {
      for (int r = 0; r < this.rawPixels.getHeight(); r++)
        this.rawPixels.setRGB(c, r, color.getRGB()); 
    } 
  }
  
  public void setPixel(int r, int c, Pixel p) {
    this.rawPixels.setRGB(c, r, p.getRGB());
  }
  
  public Pixel getPixel(int r, int c) {
	Pixel p = new Pixel(this.rawPixels.getRGB(c, r));
    return p;
  }
  
  public int getHeight() {
	int h = this.rawPixels.getHeight();
    return h;
  }
  
  public int getWidth() {
	  int w = this.rawPixels.getWidth();
    return w;
  }
  
  public BufferedImage getBufferedImage() {
	  BufferedImage img = this.rawPixels;
    return img;
  }
  
  public PixelArray clone() {
	  PixelArray clone = new PixelArray(ImageUtils.deepCopy(this.rawPixels));
    return clone;
  }
}
