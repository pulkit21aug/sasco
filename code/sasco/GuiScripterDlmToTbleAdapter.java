/**
 * This java file consists a class to handle window closing
 * event for the class GuiScripterDlmToTable
 */
package sasco;
import java.awt.event.*;
/**
 * This class consiste method to handle window closing event 
 * for class GuiScripterDlmToTable
 * @author Pulkit Saxena
 * @version 1.0
 * Date 26-Jun-07
 */
class GuiScripterDlmToTbleAdapter extends WindowAdapter{
	GuiScripterDlmToTable objGuiScripterDlmToTable;
	/**
	 * This is constructor for the class to
	 *  initialse the variabes
	 * 
	 */
	public GuiScripterDlmToTbleAdapter(GuiScripterDlmToTable objGuiScripterDlmToTable)
	  {
		this.objGuiScripterDlmToTable = objGuiScripterDlmToTable;
		
	}
 
	/**
	 * This method handles the window closing event and closes
	 * the the current form 
	 */
	public void windowClosing(WindowEvent we)
	 {
		objGuiScripterDlmToTable.setVisible(false);
		 GuiSasco objGuiSasco = new GuiSasco ("Java-SAS Editor"); 
	 
	 }


}
