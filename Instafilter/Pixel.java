package com.mattnguyencs.Instafilter;

import java.awt.Color;

public class Pixel {
  public int r;
  
  public int g;
  
  public int b;
  
  public Pixel(Color color) {
    this.r = color.getRed();
    this.g = color.getGreen();
    this.b = color.getBlue();
  }
  
  public Pixel(int color) {
    this.r = color >> 16 & 0xFF;
    this.g = color >> 8 & 0xFF;
    this.b = color & 0xFF;
  }
  
  public Pixel(int red, int green, int blue) {
    this.r = red;
    this.g = green;
    this.b = blue;
  }
  
  public int getRGB() {
    int rgb = -16777216;
    rgb |= this.r << 16;
    rgb |= this.g << 8;
    rgb |= this.b;
    return rgb;
  }
  
  public boolean equals(Object obj) {
    Pixel p = (Pixel)obj;
    return (this.r == p.r && this.g == p.g && this.b == p.b);
  }
  
  public String toString() {
    return "(" + this.r + ", " + this.g + ", " + this.b + ")";
  }
}
