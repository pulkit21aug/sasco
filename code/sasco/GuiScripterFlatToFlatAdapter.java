/**
 * This java file consists a class which handles the window closing
 * event generated by the object of the class GuiScripterFlatToFlat
 */
package sasco;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * This class handles the window closing event generated  by the 
 * object of class GuiScripterFlatToFlat.It extends WindowAdapter class.
 * @author Pulkt Saxena
 * @version 1.0
 * Date 15-Jul-2007
 *
 */
public class GuiScripterFlatToFlatAdapter extends WindowAdapter{
	GuiScripterFlatToFlat objGuiScripterFlatToFlat;
	/**
	 * This constructor initialises the class variables
	 * @param  objGuiScripterFlatToFlat
	 */
	
	
	public GuiScripterFlatToFlatAdapter(GuiScripterFlatToFlat objGuiScripterFlatToFlat) {
	this.objGuiScripterFlatToFlat =objGuiScripterFlatToFlat;
	
	}
	/**
	 * This method  handles the window closing event
	 * @param we :WindowEvent
	 */
	public void windowClosing(WindowEvent we){
		objGuiScripterFlatToFlat.setVisible(false);
		GuiSasco objGuiSasco = new GuiSasco ("Java-SAS Editor"); 
		
	}
	
	
}




