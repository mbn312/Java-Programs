package com.mattnguyencs.Instafilter;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class ShowImage {
  BufferedImage image;
  
  public static void main(String[] args) throws Exception {}
  
  public PixelArray getPixelArray() {
    ColorModel cm = this.image.getColorModel();
    boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
    WritableRaster raster = this.image.copyData(null);
    return new PixelArray(new BufferedImage(cm, raster, isAlphaPremultiplied, null));
  }
  
  public BufferedImage getBufferedImage() {
    ColorModel cm = this.image.getColorModel();
    boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
    WritableRaster raster = this.image.copyData(null);
    return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
  }
  
  public ShowImage(final BufferedImage image, final String windowName) throws Exception {
    SwingUtilities.invokeLater(new Runnable() {
          public void run() {
            JFrame editorFrame = new JFrame(windowName);
            editorFrame.setDefaultCloseOperation(3);
            ImageIcon imageIcon = new ImageIcon(image);
            JLabel jLabel = new JLabel();
            jLabel.setIcon(imageIcon);
            editorFrame.getContentPane().add(jLabel, "Center");
            editorFrame.pack();
            editorFrame.setLocationRelativeTo(null);
            editorFrame.setVisible(true);
          }
        });
  }
  
  public ShowImage(final String filename, final String windowName) throws Exception {
    SwingUtilities.invokeLater(new Runnable() {
          public void run() {
            JFrame editorFrame = new JFrame(windowName);
            editorFrame.setDefaultCloseOperation(3);
            ShowImage.this.image = null;
            try {
              ShowImage.this.image = ImageIO.read(new File(filename));
            } catch (IOException e) {
              e.printStackTrace();
              System.exit(1);
            } 
            ImageIcon imageIcon = new ImageIcon(ShowImage.this.image);
            JLabel jLabel = new JLabel();
            jLabel.setIcon(imageIcon);
            editorFrame.getContentPane().add(jLabel, "Center");
            editorFrame.pack();
            editorFrame.setLocationRelativeTo(null);
            editorFrame.setVisible(true);
          }
        });
  }
}