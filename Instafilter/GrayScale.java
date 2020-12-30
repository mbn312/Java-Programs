package com.mattnguyencs.Instafilter;

public class GrayScale implements Filterable{

	public PixelArray filter(PixelArray pic)
	{
		int rows = pic.getWidth();
		int columns = pic.getHeight();
		for(int i = 0 ; i < columns; i++)
		{
			for(int g = 0 ; g < rows; g++)
			{		
				Pixel pixel = pic.getPixel(i, g);
				String code = pixel.toString();
				String test = code.substring(1, code.length()-1);
				String[] color = test.split(", ");
				int red = Integer.parseInt(color[0]);
				int green = Integer.parseInt(color[1]);
				int blue = Integer.parseInt(color[2]);
				
				int gray = (red + green + blue)/3;
				Pixel newPixel = new Pixel(gray,gray,gray);
				pic.setPixel(i, g, newPixel);		
			}
		}
		return pic;
	}
}
