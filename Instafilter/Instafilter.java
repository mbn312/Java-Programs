package com.mattnguyencs.Instafilter;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Instafilter {
  private Scanner scanner;
  
  private ShowImage original;
  
  private ArrayList<Filterable> filters;
  
  private ArrayList<ShowImage> filteredImage;
 
  
  public Instafilter() {
    this.scanner = new Scanner(System.in);
    this.filters = new ArrayList<>();
    this.filteredImage = new ArrayList<>();
  }
  
  public void run() {
    boolean keepRunning = true;
    while (keepRunning) {
      int command = menu();
      if (command == 0) {
        keepRunning = false;
        continue;
      } 
      if (command == 1) {
        loadAndShowImage();
        continue;
      } 
      if (this.original != null) {
        PixelArray pa = this.original.getPixelArray();
        try {
          pa = ((Filterable)this.filters.get(command - 2)).filter(pa);
          ShowImage si = new ShowImage(pa.getBufferedImage(), ((Filterable)this.filters.get(
                command - 2)).toString());
          this.filteredImage.set(command - 2, si);
        } catch (Exception e) {
          e.printStackTrace();
        } 
        continue;
      } 
      System.out
        .println("No image loaded. Please load an image first.");
    } 
  }
  
  public void addFilter(Filterable filter) {
    if (filter != null) {
      this.filters.add(filter);
      this.filteredImage.add(null);
    } 
  }
  
  private int menu() {
    boolean showMenu = true;
    int input = 0;
    while (showMenu) {
      System.out.println("");
      System.out.println("0. Quit.");
      System.out.println("1. Load Image.");
      System.out.println("2. GrayScale.");
      System.out.println("3. Blur.");
      System.out.println("4. Sepia.");
      System.out.println("--------------");
      System.out.print("Input command: ");
      try {
        input = Integer.parseInt(this.scanner.nextLine());
        if (input >= this.filters.size() + 2) {
          System.out
            .println("Please choose a command from the list.\n");
          continue;
        } 
        showMenu = false;
      } catch (Exception e) {
        System.out
          .println("Please enter an integer number from the list.");
      } 
    } 
    return input;
  }
  
  private void loadAndShowImage() {
    System.out.print("Input the file name: ");
    String filename = this.scanner.nextLine();
    try { 
      File f = new File(filename);
      if (f.exists() && f.isFile()) {
        this.original = new ShowImage(filename, "Original File");
      } else {
        System.out
          .println("File not present. Make sure the file is in project directory.");
      } 
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
}
