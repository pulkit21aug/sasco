/**
 * This source file consists a class SasEditor which contains 
 * the main method to call an object of WelcomeForm class
 * @author Pulkit_Saxena
 * @version 0.00a
 * Date :31-May-2007
 */
package sasco;

public class SasEditor {

	/**
	 * This method is the entry to the program
	 * and calss an onject of GuiSasco
	 * @param args
	 */
	public static void main(String[] args) {
			
	  WelcomeForm welcomeForm = new WelcomeForm("Sasco");
      try
      {
    	   Thread.sleep(5000);
      }catch(Exception e){};
      
      welcomeForm.showGuiSasco();
      }
        
    }



