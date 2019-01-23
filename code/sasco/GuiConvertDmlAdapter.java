/*
 * This source file consists of a class which handles 
 * window closing event
 * @author Pulkit Saxena
 * 
 */


package sasco;
import java.awt.event.*;
class GuiConvertDmlAdapter extends WindowAdapter {

	GuiConvertDml objGuiConvertDml ;
	/**
	 * This constructor initialises the class object 
	 * @param objGuiConvertDml
	 */
	public GuiConvertDmlAdapter(GuiConvertDml objGuiConvertDml){
	this.objGuiConvertDml = objGuiConvertDml;
	}
	
	/**
	 *This method handles the window closing event
	 *@param  we  
	 */ 
	public void windowClosing(WindowEvent we)
	 {
		 objGuiConvertDml.setVisible(false);
	  }

	
}
