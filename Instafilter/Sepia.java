package com.mattnguyencs.Instafilter;

public class Sepia implements Filterable{

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

				double nRed = ((red * .393) + (green * .769) + (blue * .189));
				double nGreen = ((red * .349) + (green * .686) + (blue * .168));
				double nBlue = ((red * .272) + (green * .534) + (blue * .131));
				
				red = (int)Math.round(nRed);
				green = (int)Math.round(nGreen);
				blue = (int)Math.round(nBlue);
				
				if(red > 255)
				{
					red = 255;
				}
				if(blue > 255)
				{
					blue = 255;
				}
				if(green > 255)
				{
					green = 255;
				}
				
				Pixel newPixel = new Pixel(red,green,blue);
				pic.setPixel(i, g, newPixel);		
			}
		}
		return pic;
	}
}
