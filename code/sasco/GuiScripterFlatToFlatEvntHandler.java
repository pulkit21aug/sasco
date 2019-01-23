/**
 * This java file consists a class which handles the event 
 * genertaed by the object for the class GuiScripterFlatToFlat
 */
package sasco;

import java.awt.event.*;
import javax.swing.JOptionPane;
import java.util.StringTokenizer.*;
import java.io.*;
import java.util.*;

/**
 * This class handles the event genrated by the object 
 * of class GuiScripterFlatToFlat.It implements 
 * the ActionListener interface
 * @author Pulkit Saxena
 * @version 1.0
 * Date 15-Jul-2007
 *
 */
public class GuiScripterFlatToFlatEvntHandler implements ActionListener {
	
	GuiScripterFlatToFlat objGuiScripterFlatToFlat;
	StringBuffer srtBufCode ;
	String strSrcDml;
	String strTrgtDml;
	ArrayList listTokenFlatToFlatSrc ;
	ArrayList listTokenFlatToFlatTrgt;
	FileWriter writerFlatToFlat;
	FileReader readerFlatToFlat;
	StringBuffer sb;
	StringBuffer sb1;
    String  dmlFormatFlatToFlatSrc;
    String dmlFormatFlatToFlatTrg;
    String strFlatToFlat ;
    String strFlatToFlat1;
    String checkFlatToFlat;
    /**
	 * This constructor intialises the varaibles
	 * @param objGuiScripterFlatToFlat
	 */
	public GuiScripterFlatToFlatEvntHandler(GuiScripterFlatToFlat objGuiScripterFlatToFlat) {
		this.objGuiScripterFlatToFlat =objGuiScripterFlatToFlat;
		 strFlatToFlat =" ";
		 listTokenFlatToFlatSrc = new ArrayList();
		 listTokenFlatToFlatTrgt = new ArrayList();
		 checkFlatToFlat ="string"; 
		  JOptionPane.showMessageDialog ( objGuiScripterFlatToFlat,new 
			 	  String("Enter DML in Sasco format" +"\n"+
			 	  		"for exapmle" +"\n"+
			 	  		"string(1)     goldcard_ind;"+"\n"+
	"string(1)     par_non_par_ind;"+"\n"+
	"decimal(20)   provider_id; "));  

	
	
	}

	/**
	 * This method handles the event generated by the objetc 
	 * of GuiScripterFlatToFlat and generates the code for the
	 * case when data is moving from Delimited AIF to 
	 * Delimited AIF
	 * @param ae
	 */
	public void actionPerformed(ActionEvent ae){
		String arg=(String)ae.getActionCommand();
		int start =1; 
		int startTrg =1;
		//to recognise who created the event
		 if(arg.equals("Generate Code")){
			 
		strSrcDml = objGuiScripterFlatToFlat.txtAreaSrcDml.getText();
		strTrgtDml = objGuiScripterFlatToFlat.txtAreaTrgDml.getText();
		
		//removing extra lines
		String strSrcDmlTrim =strSrcDml.trim();
		String strTrgtDmlTrim =strTrgtDml.trim();
		
		if(strSrcDml.equals("")||strTrgtDml.equals("")){
		 
			JOptionPane.showMessageDialog (objGuiScripterFlatToFlat,new 
	            	 String("enter  DML of source/target AIF "));  
		
	     	   }
			 
		else{
			
            try{
        	  

        	  //writing dml to temporary file
          writerFlatToFlat  = new FileWriter("temp1.txt");
          //writerFlatToFlat.write(strSrcDml);
          writerFlatToFlat.write(strSrcDmlTrim);
          writerFlatToFlat.close();  
     
          //reading from temporary file
  		
          readerFlatToFlat = new FileReader("temp1.txt");
			BufferedReader br =new BufferedReader(readerFlatToFlat);
			
			//for reading from file
          
            

			
			  
			
			//for generating SAS format dml code
			sb = new StringBuffer();
			//reading file
			while((strFlatToFlat = br.readLine())!=null){
		

		//scanning for tokens 
		 java.util.StringTokenizer scanFlatToFlat =
		new java.util.StringTokenizer(strFlatToFlat," \t+()\t+;\n");	
    
		 //scanning started
		  while(scanFlatToFlat.hasMoreTokens())
		     {   
	     	String trimmerFlatToFlat =  scanFlatToFlat.nextToken();
		    //removing any white spaces
	     	
	     	trimmerFlatToFlat =trimmerFlatToFlat.trim();
	     	listTokenFlatToFlatSrc.add(trimmerFlatToFlat); 
			  }		
			
			
		 String   strTokenFlatToFlat = listTokenFlatToFlatSrc.get(0).toString();
		  String checkTokenFlatToFlat=strTokenFlatToFlat.trim(); 
		   
		     
		   if(checkTokenFlatToFlat.equalsIgnoreCase(checkFlatToFlat)){
				
			
		  
                   	  sb.append("@"+start+" "+listTokenFlatToFlatSrc.get(2)+"  $"+listTokenFlatToFlatSrc.get(1)+".");
			      sb.append("\n");
			
	    try 
	        { 
	     int ia =Integer.parseInt(listTokenFlatToFlatSrc.get(1).toString());
	      start = start + ia;
      	    }catch(Exception e)
      	    {
      	    	 JOptionPane.showMessageDialog ( objGuiScripterFlatToFlat,new 
      	 		 	  String("DML not in Sasco Format "+e));  
      	   
      	    
      	    } 







		   }
		   else {
			   
			        	  


                    sb.append("@"+start+" "+listTokenFlatToFlatSrc.get(2)+"  "+listTokenFlatToFlatSrc.get(1)+".");
		   sb.append("\n");
				  
		      try {
		    	 
		   	  String test =listTokenFlatToFlatSrc.get(0).toString();
		 		     if(test.equalsIgnoreCase("DATE"))
		             {
		       int ib=listTokenFlatToFlatSrc.get(1).toString().length();
		        start =start +ib;
		              }
		     else {
		      int ia =Integer.parseInt(listTokenFlatToFlatSrc.get(1).toString());
			
				      start = start + ia;	  
					    	  
		    	  }
		         
		         }catch(Exception e)
		         {
		        	 JOptionPane.showMessageDialog ( objGuiScripterFlatToFlat,new 
		       		 	  String("Dml not in Sasco format"+e));     	 
		         
		         }








               }
		   listTokenFlatToFlatSrc.clear();   
	

	   }
          
          
            //SAS format dml code genertaed for source AIF
			dmlFormatFlatToFlatSrc =sb.toString();
		    
	  		
		     //closing files
		     readerFlatToFlat.close();         
          
		  //generating SAS format DMl code for target   
		    
		 //writing target dml to a temporary file
		     writerFlatToFlat = new FileWriter("temp2.txt");
		    //writerFlatToFlat.write(strTrgtDml);
		     writerFlatToFlat.write(strTrgtDmlTrim);
		     writerFlatToFlat.close();
		     
		 //reading from the file 
		     readerFlatToFlat = new  FileReader("temp2.txt");
		     BufferedReader br1 =new BufferedReader(readerFlatToFlat);

		     // for reading from file
		String	 strFlatToFlat1 =" ";    
			
			//for generating SAS format dml code
			sb1= new StringBuffer();
			//reading file   

			//			reading file
			while((strFlatToFlat1 = br1.readLine())!=null){

				//scanning for tokens 
				 java.util.StringTokenizer scanFlatToFlat1 =
				new java.util.StringTokenizer(strFlatToFlat1," \t+()\t+;\n");	
		    
				 //scanning started
				  while(scanFlatToFlat1.hasMoreTokens())
				     {   
			     	String trimmerFlatToFlat1 =  scanFlatToFlat1.nextToken();
				    //removing any white spaces
			     	
			     	trimmerFlatToFlat1 =trimmerFlatToFlat1.trim();
			     	listTokenFlatToFlatTrgt.add(trimmerFlatToFlat1); 
				  }		
				  String   strTokenFlatToFlat1 = listTokenFlatToFlatTrgt.get(0).toString();
				  String checkTokenFlatToFlat1=strTokenFlatToFlat1.trim(); 
				   
				  if(checkTokenFlatToFlat1.equalsIgnoreCase(checkFlatToFlat)){
						
			 
				  
				  sb1.append("@"+startTrg+" "+listTokenFlatToFlatTrgt.get(2)+"  $"+listTokenFlatToFlatTrgt.get(1)+".");
			      sb1.append("\n");
			
	    try 
	        { 
	     int ia =Integer.parseInt(listTokenFlatToFlatTrgt.get(1).toString());
	     startTrg = startTrg + ia;
      	    }catch(Exception e)
      	    {
      	    	 JOptionPane.showMessageDialog ( objGuiScripterFlatToFlat,new 
      	 		 	  String("DML not in Sasco Format "+e));  
      	   
      	    
      	    } 

                     }
				   else {
					   
				
                       	     
				 sb1.append("@"+startTrg+" "+listTokenFlatToFlatTrgt.get(2)+"  "+listTokenFlatToFlatTrgt.get(1)+".");
		   sb1.append("\n");
				  
		      try {
		    	 
		   	  String test =listTokenFlatToFlatTrgt.get(0).toString();
		 		     if(test.equalsIgnoreCase("DATE"))
		             {
		       int ib=listTokenFlatToFlatTrgt.get(1).toString().length();
		       startTrg =startTrg +ib;
		              }
		     else {
		      int ia =Integer.parseInt(listTokenFlatToFlatTrgt.get(1).toString());
			
		      startTrg = startTrg + ia;	  
					    	  
		    	  }
		         
		         }catch(Exception e)
		         {
		        	 JOptionPane.showMessageDialog ( objGuiScripterFlatToFlat,new 
		       		 	  String("Dml not in Sasco format"+e));     	 
		         
		         }
				     
		    	   
			





	   
			    	   }
				   listTokenFlatToFlatTrgt.clear();   
			}
        
//			SAS format dml code genertaed for source AIF
			dmlFormatFlatToFlatTrg =sb1.toString();
		   
	  		
		     //closing files
		     readerFlatToFlat.close();  
			
            
      }catch(Exception e){
        	  JOptionPane.showMessageDialog (objGuiScripterFlatToFlat,new 
		            	 String("Dml not in sasco format "));     
          
                     }
   
      File f1 = new File("temp1.txt");
	    boolean success = f1.delete(); 
	    File f2 = new File("temp2.txt");
	    boolean success1 = f2.delete();
      
      //generating SAS code 
      
      srtBufCode = new StringBuffer();
      
      srtBufCode.append("\n");
      
//    creating expected output code data moving from source AIF
		
      //creating data code
		 String outPut = "filename summary";
		    String outPutCmnt ="/*enter file path*/";
		    String dataFlatToFlat ="data  "+"_expected_output;";
		    String dataInputFlatToFlat ="infile  summary  Flat='|'  dsd;"+"\n"+"input"+"\n";
		    
		    srtBufCode.append(outPut);
		    srtBufCode.append("\n");
		    srtBufCode.append(outPutCmnt);
		    srtBufCode.append("\n");
		    srtBufCode.append(dataFlatToFlat);
		    srtBufCode.append("\n");
		    srtBufCode.append("\n");
		    srtBufCode.append(dataInputFlatToFlat);
		    srtBufCode.append(dmlFormatFlatToFlatSrc);
		    srtBufCode.append("\n;\n");
		    srtBufCode.append("run;");
		    srtBufCode.append("\n");
		    srtBufCode.append("\n"); 
	  
		//writing proc sql for epected output
		    

		    //writing proc sql
		    String fileFlatToFlat ="create  table  "+"\t"+"_expected_table as (";
		    String fileSqlFlatToFlat ="select  *  from "+"\t"+"_expected_output );";
		    
		    srtBufCode.append(fileFlatToFlat);
		    srtBufCode.append("\n");
		    srtBufCode.append(fileSqlFlatToFlat);
		    srtBufCode.append("\n");
		    srtBufCode.append("\n"); 
		   
		  //generating code for actual output 
		    
//		  creating data code
			 String outPut1 = "filename summary1";
			    String outPutCmnt1 ="/*enter file path*/";
			    String dataFlatToFlat1 ="data  "+"_actual_output;";
			    String dataInputFlatToFlat1 ="infile  summary1  Flat='|'  dsd;"+"\n"+"input"+"\n";
			    
			    srtBufCode.append(outPut1);
			    srtBufCode.append("\n");
			    srtBufCode.append(outPutCmnt1);
			    srtBufCode.append("\n");
			    srtBufCode.append(dataFlatToFlat1);
			    srtBufCode.append("\n");
			    srtBufCode.append("\n");
			    srtBufCode.append(dataInputFlatToFlat1);
			    srtBufCode.append(dmlFormatFlatToFlatTrg);
			    srtBufCode.append("\n;\n");
			    srtBufCode.append("run;");
			    srtBufCode.append("\n");
			    srtBufCode.append("\n"); 

			    // writing proc sql for actual output
			    

			    // writing proc sql
			    String fileFlatToFlat1 ="create  table "+"\t"+"_actual_table as (";
			    String fileSqlFlatToFlat1 ="select  *  from "+"\t"+"_actual_output );";
			    
			    srtBufCode.append(fileFlatToFlat1);
			    srtBufCode.append("\n");
			    srtBufCode.append(fileSqlFlatToFlat1);
			    srtBufCode.append("\n");
			    srtBufCode.append("\n"); 
			   

			    //proc priting
			    
			    String procPrintFlatAifToFlat ="proc print  data= "+"_expected_table ;"; 
			    String procPrintFlatAifToFlat1 ="proc print  data= "+"_actual_table ;"; 
			    
			    srtBufCode.append(procPrintFlatAifToFlat);
			    srtBufCode.append("\n");
			    srtBufCode.append(procPrintFlatAifToFlat1);
			    srtBufCode.append("\n");   

			    String codeFlatToFlat =srtBufCode.toString();
				//System.out.println(codeTbleToFlat );
			 
				
			    objGuiScripterFlatToFlat.setVisible(false);
				GuiSasco objGuiSasco = new GuiSasco ("Java-SAS Editor");
				objGuiSasco.txtAreaSasEditor.setText(codeFlatToFlat);
		}		
	

 }

 
		 

 }

}


