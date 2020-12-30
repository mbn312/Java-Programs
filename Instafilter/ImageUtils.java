package com.mattnguyencs.Instafilter;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;

public class ImageUtils {
  static BufferedImage deepCopy(BufferedImage bi) {
    ColorModel cm = bi.getColorModel();
    boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
    WritableRaster raster = bi.copyData(null);
    return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
  }
}
