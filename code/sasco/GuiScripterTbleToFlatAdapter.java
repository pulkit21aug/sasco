/**
 * This java file consists a class to handle the window
 * closing event generated by the object of GuiScripterTbleToFlat
 */
package sasco;
import java.awt.event.*;
/**
 * This class extends Window Adapter class and ovrides the
 * windowclosing method .
 * @author Pulkit Saxena
 * @version 1.0
 * Date 14-Jul-2007
 *
 */
class GuiScripterTbleToFlatAdapter extends WindowAdapter{
	GuiScripterTbleToFlat objGuiScripterTbleToFlat;
	/**
	 * This constructor initialses the components
	 * @param objGuiScripterTbleToFlat
	 */
	public GuiScripterTbleToFlatAdapter(GuiScripterTbleToFlat objGuiScripterTbleToFlat) {
    this.objGuiScripterTbleToFlat =objGuiScripterTbleToFlat;		
	}
	public void windowClosing(WindowEvent we)
	 {
		 objGuiScripterTbleToFlat.setVisible(false);
		 GuiSasco objGuiSasco = new GuiSasco ("Java-SAS Editor"); 
	 
	 }
}
