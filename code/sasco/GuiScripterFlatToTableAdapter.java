/**
 * This java file consists a class which handles the window closing
 * event genertaed  by the object of class GuiScripterFlatToTable
 */
package sasco;

import java.awt.event.*;

/**
 * This class handles the window closing event .It exetnds 
 * the WindowAdapter class 
 * @author Pulkit Saxena
 * @version 1.0
 * Date 15-Jul-2007
 *
 */
class GuiScripterFlatToTableAdapter extends WindowAdapter{
	GuiScripterFlatToTable objGuiScripterFlatToTable;
	/**
	 * This constructor initialises the components
	 */
	public GuiScripterFlatToTableAdapter(GuiScripterFlatToTable objGuiScripterFlatToTable) {
		this.objGuiScripterFlatToTable = objGuiScripterFlatToTable;
	}

  
	/**
	 * This method handles the window closing event and closes
	 * the the current form 
	 */
	public void windowClosing(WindowEvent we)
	 {
		objGuiScripterFlatToTable.setVisible(false);
		 GuiSasco objGuiSasco = new GuiSasco ("Java-SAS Editor"); 
	 
	 }


}

