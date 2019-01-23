/**
 * This java file consists a class which handles the window closing
 * event for the object of class GuiScripterDlmToDlm
 */
package sasco;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * This class handles the window closing event geneated by
 * the object of GuiScripterDlmToDlm
 * @author Pulkit Saxena
 * @version 1.0
 * Date 1-Jul-2007
 */
class GuiScripterDlmToDlmAdapter extends WindowAdapter {
	GuiScripterDlmToDlm objGuiScripterDlmToDlm;
	/**
	 * This constructor initiales the vaiabels
	 * @param objGuiScripterDlmToDlm
	 */
	public GuiScripterDlmToDlmAdapter(GuiScripterDlmToDlm objGuiScripterDlmToDlm) {
		this.objGuiScripterDlmToDlm = objGuiScripterDlmToDlm;
		
	}

	/**
	 * This method  handles the window closing event
	 * @param we :WindowEvent
	 */
	public void windowClosing(WindowEvent we){
		objGuiScripterDlmToDlm.setVisible(false);
		GuiSasco objGuiSasco = new GuiSasco ("Java-SAS Editor"); 
		
	}
	
	
}
