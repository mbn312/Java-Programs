package com.mattnguyencs.Instafilter;

public class Main 
{
    public static void main( String[] args )
    {
		Instafilter instafilter = new Instafilter();

		instafilter.addFilter(new GrayScale());
		instafilter.addFilter(new Blur());
		instafilter.addFilter(new Sepia());
		instafilter.run();
    }
}
