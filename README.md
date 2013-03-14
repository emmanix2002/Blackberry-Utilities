# Introduction

This repo just contains java classes written for use in the Blackberry JDE. They provide some simple functionality that I tend to reuse in my projects.   


## Requirements

+ Blackberry JDE

## Using ImageLoader (Example)

Please read through the javadoc to get more information     

```java
		Bitmap bmp1 = ImageLoader.getBitmap("splashscreen.png");
		String bmp1_path = ImageLoader.getBitmapPath("splashscreen.png");
		//could return something like: img/640x480/splashscreen.png (for a 640x480 resolution device if it's found in the folder)
		//or: img/default/splashscreen.png (if it's not found in the device specific folder)
		//You could have a folder structure like so:
		//	res/
		//		img/
		//			default/
		//			320x240/
		//			360x480/
		//			480x320/
		//			480x360/
		//			480x640/
		//			640x480/
```     
It is assumed that the images in the project are in the __res__ folder of the project (outside the *src* folder).    
Two (2) variables need to be set [usually the default should be sufficient since a new project automatically creates a res/img folder].   
The 2 variables are:     

```java
	/**
	 * The base path in your resources folder where images are stores
	 * Defaults to: img
	 */
	private static String images_path;
	//has a setter: ImageLoader.setBaseImagePath(String) to change the default folder say to ImageLoader.setBaseImagePath("images") instead of the default
	/**
	 * The default folder to look for images if they're not found in the device specific folder
	 * Defaults to: default
	 */
	private static String images_subfolder_default;
	//has a setter: ImageLoader.setDefaultImageSubFolder(String) to change the default [fallback] folder where to find images say to ImageLoader.setDefaultImageSubFolder("me");
	
```