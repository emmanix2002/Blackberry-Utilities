package com.fcolimited.blackberry.components;
/**
 * This class is an extension for the BitmapField component that helps you easily create actionable bitmap
 * buttons (i.e. clickable Image buttons) extremely easily.
 * You simply supply the bitmap (preferably a PNG with a transparent background -- so that it's highlight 
 * state can be styled in the paint() method) and override the doAction() method for the field.
 * 
 * That's actually all there is to it... :)
 * 
 * @author Okeke Emmanuel <emmanix2002@gmail.com>
 * @link http://www.about.me/eokeke
 */
import java.util.Hashtable;
import net.rim.device.api.system.Bitmap;
import net.rim.device.api.system.Characters;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.TouchEvent;
import net.rim.device.api.ui.component.BitmapField;

public class BitmapButtonField extends BitmapField {
	/**
	 * You can use this object to store key=>value pairs of details on the component
	 * it makes it easier to retrieve properties for the particular component that 
	 * you may choose to reuse in the doAction() method.
	 */
	public Hashtable object_data = new Hashtable();
	
	public BitmapButtonField() {
		this.applyStyle();
	}
	/**
	 * Constructor 
	 * Preferable to use this one :)
	 * @param bitmap
	 */
	public BitmapButtonField(Bitmap bitmap) {
		this(bitmap, Field.FOCUSABLE|Field.FIELD_LEFT);
	}
	/**
	 * Constructor  :)
	 * @param bitmap
	 * @param style
	 */
	public BitmapButtonField(Bitmap bitmap, long style) {
		super(bitmap, style);
		this.applyStyle();
	}
	/**
	 * Sets a margin on the field
	 */
	public void applyStyle(){
		this.setMargin(2, 0, 2, 8);
	}
	/**
	 * Simply handles the redraw of the field
	 */
	protected void paint(Graphics graphics){
		if(this.isFocus()){
			graphics.setBackgroundColor(0x00F7C200); 
			//you can specify any colour code to be used to highlight the bitmap
			graphics.clear();
		}
		super.paint(graphics);
	}
	/**
	 * Determine whether the passed in status represents a click event
	 * @param int status The integer value passed in the navigationClick method for UI components
	 * @return boolean isClicked a boolean value that tells us whether or not it's a click event
	 */
	public static boolean isComponentClicked(int status){
		boolean isClicked = false;
		//a variable that tell us if the component was clicked
		if(status == KeypadListener.STATUS_FOUR_WAY){
			//it was clicked
			isClicked = true;
		} else if(status == KeypadListener.STATUS_TRACKWHEEL){
			//it was as well
			isClicked = true;
		} else if(status == TouchEvent.UNCLICK){
			//yes it was clicked
			isClicked = true;
		}
		return isClicked;
	}
	/**
	 * Handles the navigation click
	 */
	protected boolean navigationClick(int status,int time){
		if(BitmapButtonField.isComponentClicked(status)){
			this.doAction();
			return true;
		}
		return super.navigationClick(status, time);
	}
	/**
	 * Invokes the doAction() method of the component when the trackball is pressed
	 */
	protected boolean trackwheelClick(int status,int time){
		if(BitmapButtonField.isComponentClicked(status)){
			this.doAction();
			return true;
		}
		return super.trackwheelClick(status, time);
	}
	/**
	 * Handles a key press (if it's ENTER) when the component is highlighted
	 * It makes the key press invoke the click action on the component
	 */
	protected boolean keyChar(char key,int status,int time){
		if(key == Characters.ENTER){
			this.doAction();
			return true;
		}					
		return super.keyChar(key, status, time);
	}
	/**
	 * Handles a touch event on the component
	 */
	protected boolean touchEvent(TouchEvent message){
		if(message.getEvent() == TouchEvent.UNCLICK){
			this.doAction();
			return true;
		}
		return super.touchEvent(message);
	}
	/**
	 * This method has to be overridden with the action to be performed when the button is clicked or touched
	 * 
	 */
	public void doAction(){
		
	}
}