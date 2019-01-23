/**
 * This java file consists the code for handling the  event generated
 * by the object of class GuiConvertDmlFlat
 *
 */
package sasco;
import java.awt.event.*;
import javax.swing.JOptionPane;
import java.util.StringTokenizer.*;
import java.io.*;
import java.util.*;

/**
 * @author Administrator
 *
 */
public class GuiConvertDmlFlatEvntHandler implements ActionListener {
	GuiConverDmlFlat objGuiConvertDmlFlat;
	ArrayList listTokenFlat ;
	FileWriter writerFlat;
	FileReader readerFlat;
	
	/**
	 *  This constructor initaisles the components
	 * @param objGuiConvertDmlFlat
	 */

	public GuiConvertDmlFlatEvntHandler(GuiConverDmlFlat objGuiConvertDmlFlat) {
		this.objGuiConvertDmlFlat =objGuiConvertDmlFlat;
		listTokenFlat= new ArrayList();
		JOptionPane.showMessageDialog ( objGuiConvertDmlFlat,new 
			 	  String("Enter DML in Sasco format" +"\n"+
			 	  		"for exapmle" +"\n"+
			 	  		"string(1)     goldcard_ind;"+"\n"+
  "date(YYYY-MM-DD)     prvdr_role_eff_dt;"+"\n"+
  "decimal(20)   provider_id; "));  	
	}
    
	/**
	 * This method handles the button click event 
	 *  (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
   public void actionPerformed(ActionEvent ae){

	   String txtAreaFlat;
	   String strToken;
	   int start=1;
	   
	   String arg=(String)ae.getActionCommand();
	   if(arg.equals("Convert DML")){
		   
	  
	   txtAreaFlat=objGuiConvertDmlFlat.txtAreaDmlFlat.getText();
	   String str = txtAreaFlat.trim();


		 if(txtAreaFlat.equals(""))
		   {
		   JOptionPane.showMessageDialog ( objGuiConvertDmlFlat,new 
		 	  String("Enter DML in Sasco format "));    
		       }
	   
		 else {
			 
			 try {

				   //writing dml to temporary file
					FileWriter writer = new FileWriter("temp.txt");
					//writer.write(txtAreaFlat);
					writer.write(str);
					writer.close();
					 

					//reading from temporary file
					
					FileReader reader  = new FileReader("temp.txt");
					BufferedReader br =new BufferedReader(reader);
				    String s =" ";
					StringBuffer sb = new StringBuffer();
					

					//reading file
					while((s= br.readLine())!=null){
						
			 java.util.StringTokenizer scan =
			new java.util.StringTokenizer(s," \t+()\t+;\n");
									    
	   	    //scanning started
			  while(scan.hasMoreTokens())
			     {   
	           	String trimmer =  scan.nextToken();
			    //removing any white spaces
	           	
	           	trimmer =trimmer.trim();
	 		   listTokenFlat.add(trimmer); 
				  }
			  strToken = listTokenFlat.get(0).toString();
			    String checkToken=strToken.trim(); 
			   
			   String check="string";
			   			

			   if(checkToken.equalsIgnoreCase( check))
			     {
			         
			     
				  sb.append("@"+start+" "+listTokenFlat.get(2)+"  $"+listTokenFlat.get(1)+".");
			      sb.append("\n");
			
	    try 
	        { 
	     int ia =Integer.parseInt(listTokenFlat.get(1).toString());
	      start = start + ia;
      	    }catch(Exception e)
      	    {
      	    	 JOptionPane.showMessageDialog ( objGuiConvertDmlFlat,new 
      	 		 	  String("DML not in Sasco Format "+e));  
      	   
      	    
      	    } 
    }	
		
		 else
		   {
		  sb.append("@"+start+" "+listTokenFlat.get(2)+"  "+listTokenFlat.get(1)+".");
		   sb.append("\n");
				  
		      try {
		    	 
		   	  String test =listTokenFlat.get(0).toString();
		 		     if(test.equalsIgnoreCase("DATE"))
		             {
		       int ib=listTokenFlat.get(1).toString().length();
		        start =start +ib;
		              }
		     else {
		      int ia =Integer.parseInt(listTokenFlat.get(1).toString());
			
				      start = start + ia;	  
					    	  
		    	  }
		         
		         }catch(Exception e)
		         {
		        	 JOptionPane.showMessageDialog ( objGuiConvertDmlFlat,new 
		       		 	  String("Dml not in Sasco format"+e));     	 
		         
		         }
				     
		    
			    
			    }  		
			   listTokenFlat.clear();  
					
		}
			 
					String pul =sb.toString();
				     //displaying dml code created in rext area
					objGuiConvertDmlFlat.txtAreaDmlFlat.setText(" ");
					objGuiConvertDmlFlat.txtAreaDmlFlat.setText(pul);
					//closing files
					reader.close();
				    	 
			 
			 
			 
			 
			 }catch(Exception e)
			 {
				 JOptionPane.showMessageDialog (objGuiConvertDmlFlat,new 
						  String("DML  not in SASCO format ! ")); 	
			 }
		 
			 File f1 = new File("temp.txt");
			    boolean success = f1.delete();
				
	
		 
	      }
	   
	   
  }
	   
	   


 }
	
}
