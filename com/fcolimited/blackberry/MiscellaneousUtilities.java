package com.fcolimited.blackberry.utils;

import net.rim.blackberry.api.browser.Browser;
import net.rim.blackberry.api.browser.BrowserSession;
import net.rim.device.api.math.Fixed32;
import net.rim.device.api.system.EncodedImage;

public class MiscellaneousUtilities {

	public MiscellaneousUtilities() {
		
	}
	/**
	 * Opens a URL in the default device browser
	 * @param url
	 */
	public static void openBrowser(String url){
		if(!(url.equals("") || url == null)){
			System.out.println("Opening URL: "+url);
			BrowserSession browserSession = Browser.getDefaultSession();
			browserSession.displayPage(url);
		} else {
			System.out.println("You should supply a value for the URL to be opened in the browser!");
		}		
	}
	/**
	 * Resizes/Scales a given Encoded image object to the specified width -- maintaining the aspect ratio
	 * @param encoded
	 * @param newWidth
	 * @return EncodedImage
	 */
	public static EncodedImage scaleImageToWidth(EncodedImage encoded, int newWidth) {
        return scaleToFactor(encoded, encoded.getWidth(), newWidth);
	}
	/**
	 * Resizes/Scales a given Encoded image object to the specified height -- maintaining the aspect ratio
	 * @param encoded
	 * @param newHeight
	 * @return EncodedImage
	 */
	public static EncodedImage scaleImageToHeight(EncodedImage encoded, int newHeight) {
	    return scaleToFactor(encoded, encoded.getHeight(), newHeight);
	}
	/**
	 * Does the actual scaling for the Encoded image
	 * @param encoded
	 * @param curSize
	 * @param newSize
	 * @return EncodedImage
	 */
	public static EncodedImage scaleToFactor(EncodedImage encoded, int curSize, int newSize) {
	    int numerator = Fixed32.toFP(curSize);
	    int denominator = Fixed32.toFP(newSize);
	    int scale = Fixed32.div(numerator, denominator);	
	    return encoded.scaleImage32(scale, scale);
	}
	/**
	 * Returns the index of an item within an array starting it's search at index zero (0)
	 * @param arr The array to be searched
	 * @param item The string object to be searched for
	 * @return String
	 */
	public static int arrayIndex(String[] arr,String item){
		int index = MiscellaneousUtilities.arrayIndex(arr,item, 0);
		return index;
	}
	/**
	 * Returns the index of an item within an array starting it's search at the specified index
	 * @param arr The array to be searched
	 * @param item The string object to be searched for
	 * @param after The index to begin the search at
	 * @return String
	 */
	public static int arrayIndex(String[] arr,String item,int after){
		int index = -1;
		try{
			if(arr.length > after){
				for(int i=after;i<arr.length;i++){
					if(arr[i].equals(item)){
						index = i;
						break;
					}
				}			
			}
			System.out.println("Array Index is: "+index);
		} catch(Exception e){
			System.out.println("Array Index Error: " + e.getMessage());
			index = -1;
		}
		return index;
	}
}
