/**
 * This java file contains a class which handles window closing
 * event for GuiScripterTbleToDlm
 */
package sasco;
import java.awt.event.*;
/**
 * This class extends windowAdapter class and has a method
 * which handles window closing event 
 * @author Pulkit Saxena
 * @version 1.0
 * @Date 18-Jun-07
 */
class GuiScripterTbleToDlmAdapter extends WindowAdapter {
	GuiScripterTbleToDlm objGuiScripterTbleToDlm;
 public	GuiScripterTbleToDlmAdapter
 (GuiScripterTbleToDlm objGuiScripterTbleToDlm){
	 
 this.objGuiScripterTbleToDlm = objGuiScripterTbleToDlm;
  }
	
 public void windowClosing(WindowEvent we)
 {
	 objGuiScripterTbleToDlm.setVisible(false);
	 GuiSasco objGuiSasco = new GuiSasco ("Java-SAS Editor"); 
 
 }

 
 
}
