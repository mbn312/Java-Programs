package com.mattnguyencs.Instafilter;

public class Blur implements Filterable{

	public PixelArray filter(PixelArray pic)
	{
		PixelArray clone = pic.clone();
		int rows = pic.getWidth();
		int columns = pic.getHeight();
		
		for(int i = 1; i < columns -1; i++)
		{
			for(int g = 1; g < rows -1; g++)
			{		
				Pixel pixel = clone.getPixel(i - 1, g +1);
				String code = pixel.toString();
				String test = code.substring(1, code.length()-1);
				String[] color = test.split(", ");
				int red = Integer.parseInt(color[0]);
			    int green = Integer.parseInt(color[1]);
				int blue = Integer.parseInt(color[2]);
				
				pixel = clone.getPixel(i - 1, g - 1);
				code = pixel.toString();
				test = code.substring(1, code.length()-1);
				color = test.split(", ");
				red += Integer.parseInt(color[0]);
			    green += Integer.parseInt(color[1]);
				blue += Integer.parseInt(color[2]);
				
				pixel = clone.getPixel(i + 1, g - 1);
				code = pixel.toString();
				test = code.substring(1, code.length()-1);
				color = test.split(", ");
				red += Integer.parseInt(color[0]);
			    green += Integer.parseInt(color[1]);
				blue += Integer.parseInt(color[2]);
				
				pixel = clone.getPixel(i , g - 1);
				code = pixel.toString();
				test = code.substring(1, code.length()-1);
				color = test.split(", ");
				red += Integer.parseInt(color[0]);
			    green += Integer.parseInt(color[1]);
				blue += Integer.parseInt(color[2]);
				
				pixel = clone.getPixel(i + 1, g + 1);
				code = pixel.toString();
				test = code.substring(1, code.length()-1);
				color = test.split(", ");
				red += Integer.parseInt(color[0]);
			    green += Integer.parseInt(color[1]);
				blue += Integer.parseInt(color[2]);
				
				pixel = clone.getPixel(i , g + 1);
				code = pixel.toString();
				test = code.substring(1, code.length()-1);
				color = test.split(", ");
				red += Integer.parseInt(color[0]);
			    green += Integer.parseInt(color[1]);
				blue += Integer.parseInt(color[2]);
				
				pixel = clone.getPixel(i + 1 , g );
				code = pixel.toString();
				test = code.substring(1, code.length()-1);
				color = test.split(", ");
				red += Integer.parseInt(color[0]);
			    green += Integer.parseInt(color[1]);
				blue += Integer.parseInt(color[2]);
				
				pixel = clone.getPixel(i - 1, g);
				code = pixel.toString();
				test = code.substring(1, code.length()-1);
				color = test.split(", ");
				red += Integer.parseInt(color[0]);
			    green += Integer.parseInt(color[1]);
				blue += Integer.parseInt(color[2]);
				
				
				
				Pixel newPixel = new Pixel(red/8,green/8,blue/8);
				pic.setPixel(i, g, newPixel);		
			}
		}
		return pic;
	}

}
