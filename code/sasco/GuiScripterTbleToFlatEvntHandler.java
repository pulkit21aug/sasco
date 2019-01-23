/**
 * This java file consists  a class which handles the 
 * event generated by the onject of class GuiScripterTbleToFlat
 */
package sasco;
import java.awt.event.*;
import javax.swing.JOptionPane;
import java.util.StringTokenizer.*;
import java.io.*;
import java.util.*;
/**
 * This class handles the event generated by the onject of 
 * class GuiScripterTbleToFlat and implements ActionListener
 * interface
 * @author Pulkit Saxena
 * @version 1.0
 * Date 15-Jul-2007
 */
public class GuiScripterTbleToFlatEvntHandler implements ActionListener{
	GuiScripterTbleToFlat objGuiScripterTbleToFlat;
	StringBuffer srtBufCode ;
	String strSchema;
	String strTableName;
	String strTableDml;
	ArrayList listTokenTbleToFlat ;
	FileWriter writerTbleToFlat;
	FileReader readerTbleToFlat;
	StringBuffer sb;
	StringBuffer sbFieldName;
        String dmlFormatTbelToFlat;
        String  fieldNames;
	/**
	 * This constructor initialises the 
	 * componenets of the class 
	 * @param objGuiScripterTbleToFlat
	 */
	public GuiScripterTbleToFlatEvntHandler(GuiScripterTbleToFlat objGuiScripterTbleToFlat) {
	this.objGuiScripterTbleToFlat =objGuiScripterTbleToFlat;

    srtBufCode = new StringBuffer();
     listTokenTbleToFlat = new ArrayList();
	
     JOptionPane.showMessageDialog ( objGuiScripterTbleToFlat,new 
		 	  String("Enter DML in Sasco format" +"\n"+
		 	  		"for exapmle" +"\n"+
		 	  		"string(1)     goldcard_ind;"+"\n"+
"date(YYYY-MM-DD)     prvdr_role_eff_dt;"+"\n"+
"decimal(20)   provider_id; "));  

	}

  public void actionPerformed(ActionEvent ae){
	
		
//		to recognise who created event
		 String arg=(String)ae.getActionCommand();
	 //event handled 
		 if(arg.equals("Generate Code"))
		 {
			
			     int start=1;
			   String strToken;
			//creating code for connection to database
			 
			 strSchema = objGuiScripterTbleToFlat.txtSchema.getText();
			 strTableName = 
				 objGuiScripterTbleToFlat.srcTableName.getText();
			 strTableDml = 
		    	 objGuiScripterTbleToFlat.txtAreaDmlAif.getText();
			
			 //removing extra lines
			 String strTableDmlTrim =strTableDml.trim();
			 
			 if(strSchema.equals("")||strTableName.equals("")||
					 strTableDml.equals(""))
			 {
				 JOptionPane.showMessageDialog ( objGuiScripterTbleToFlat,new 
		            	 String("enter all values dml/table schema/table name "));  
		    
			 }
			 else 
			 {
				// System.out.println("else being");
			  try {
			//writing dml to temporary file
			FileWriter writerTbleToFlat = new FileWriter("temp1.txt");
			//writerTbleToFlat.write(strTableDml);
			writerTbleToFlat.write(strTableDmlTrim);
			writerTbleToFlat.close();
			
			//reading from temporary file
					
			FileReader readerTbleToFlat  = new FileReader("temp1.txt");
			BufferedReader br =new BufferedReader(readerTbleToFlat);
			String strTbleToFlat =" ";
		     sb = new StringBuffer();
			sbFieldName  = new  StringBuffer();		
							
					
					//reading file
					while((strTbleToFlat = br.readLine())!=null){
					//scanning for tokens 
			 java.util.StringTokenizer scanTbleToFlat =
				new java.util.StringTokenizer(strTbleToFlat," \t+()\t+;\n");
					    
				    //scanning started
					    while(scanTbleToFlat.hasMoreTokens())
					     {   
			           	String trimmerTbleToFlat =  scanTbleToFlat.nextToken();
					    //removing any white spaces
			           	
			           	trimmerTbleToFlat =trimmerTbleToFlat.trim();
			 		   listTokenTbleToFlat.add(trimmerTbleToFlat); 
						  }
					 
					
					 
					    String   strTokenTbleToFlat = listTokenTbleToFlat.get(0).toString();
					    String checkTokenTblToFlat=strTokenTbleToFlat.trim(); 
					   
					   String checkTbleToFlat="string";
					  
					   if(checkTokenTblToFlat.equalsIgnoreCase(checkTbleToFlat))
					     {
					    	     
					  sb.append("@"+start+" "+listTokenTbleToFlat.get(2)+"  $"+listTokenTbleToFlat.get(1)+".");
				      sb.append("\n");
				      sbFieldName.append("\t\t\t"+listTokenTbleToFlat.get(2)+",");
				       sbFieldName.append("\n");
		    try 
		        { 
		     int ia =Integer.parseInt(listTokenTbleToFlat.get(1).toString());
		      start = start + ia;
	      	    }catch(Exception e)
	      	    {
	      	    	 JOptionPane.showMessageDialog ( objGuiScripterTbleToFlat,new 
	      	 		 	  String("DML not in Sasco Format "+e));  
	      	   
	      	    
	      	    } 


	                                  
	         }
			   else {
					   sb.append("@"+start+" "+listTokenTbleToFlat.get(2)+"  "+listTokenTbleToFlat.get(1)+".");
			   sb.append("\n");
			   sbFieldName.append("\t\t\t"+listTokenTbleToFlat.get(2)+",");
		       sbFieldName.append("\n"); 	  
			      try {
			    	 
			   	  String test =listTokenTbleToFlat.get(0).toString();
			 		     if(test.equalsIgnoreCase("DATE"))
			             {
			       int ib=listTokenTbleToFlat.get(1).toString().length();
			        start =start +ib;
			              }
			     else {
			      int ia =Integer.parseInt(listTokenTbleToFlat.get(1).toString());
				
					      start = start + ia;	  
						    	  
			    	  }
			         
			         }catch(Exception e)
			         {
			        	 JOptionPane.showMessageDialog ( objGuiScripterTbleToFlat,new 
			       		 	  String("Dml not in Sasco format"+e));     	 
			         
			         }
					     
					 




	                                    }  
					   listTokenTbleToFlat.clear();   
					  }
			 dmlFormatTbelToFlat =sb.toString();
		     fieldNames =sbFieldName.toString();  
	  		//System.out.println(dmlFormatTbelToFlat);
	  		//System.out.println(fieldNames);
		     //closing files
			readerTbleToFlat.close();
			  }catch(Exception e)
			  {
				  
				  JOptionPane.showMessageDialog ( objGuiScripterTbleToFlat,new 
			            	 String("Dml not in sasco format "));    
				  
			  }	
			  File f1 = new File("temp1.txt");
			    boolean success = f1.delete(); 
			   String con ="libname   "+strSchema+
			 "    db2  database=     user=      password=     schema=" +strSchema+";";
			 
			 String comntCon ="/**Connecting to database:Enter values*/";
			 
			 srtBufCode.append(con);
			 srtBufCode.append("\n");
			 srtBufCode.append(comntCon);
			 srtBufCode.append("\n");
			 
			//creating  proc sql;
			 String strProcTbleToFlat = "proc sql ;";
			srtBufCode.append(strProcTbleToFlat);
			 srtBufCode.append("\n");
			 
			 //creating expected output table
			 String strCreate = "Create table  "+ strTableName+"_expectedOutput as (";
			 
		    srtBufCode.append(strCreate);
		   srtBufCode.append("\n"); 
		   srtBufCode.append("select");
		    srtBufCode.append("\n");
		   //creating list of  field names
		    srtBufCode.append(fieldNames);
		    srtBufCode.append("\n");
		     
		   //ending proc sql statement
		    String endSqlTbleToFlat =" from "+strSchema+"."+strTableName+");";
		    
		    srtBufCode.append(endSqlTbleToFlat);
		    srtBufCode.append("\n\n");
		    srtBufCode.append("quit;");
		    srtBufCode.append("\n");
		    
		    //creating output code
		    //creating data code
		    String outPut = "filename summary";
		    String outPutCmnt ="/*enter file path*/";
		    String dataTbleToFlat ="data "+strTableName+"_actual_output;";
		    String dataInputTbleToFlat ="infile  summary  Flat='|'  dsd;"+"\n"+"input"+"\n";
		    
		    srtBufCode.append(outPut);
		   srtBufCode.append("\n");
		   srtBufCode.append(outPutCmnt);
		   srtBufCode.append("\n");
		   srtBufCode.append(dataTbleToFlat);
		    srtBufCode.append("\n");
		    srtBufCode.append("\n");
		    srtBufCode.append(dataInputTbleToFlat);
		    srtBufCode.append(dmlFormatTbelToFlat);
		    srtBufCode.append("\n"+";");
		    srtBufCode.append("\n");
		    srtBufCode.append("run;");
		    srtBufCode.append("\n");
		    srtBufCode.append("\n");
		    //writing proc sql
		    String fileTbleToFlat ="create  table "+strTableName+"_actual_file as (";
		    String fileSqlTbleToFlat ="select  *  from "+strTableName+"_actual_output );";
		    
		    srtBufCode.append(fileTbleToFlat);
		    srtBufCode.append("\n");
		    srtBufCode.append(fileSqlTbleToFlat);
		    srtBufCode.append("\n");
		    srtBufCode.append("\n");
		    srtBufCode.append("quit;");
		    srtBufCode.append("\n");
		    //proc priting
		    
		    String procPrintTbleToFlatAif ="proc print  data= "+strTableName+"_actual_file ;"; 
		    String procPrintTbleToFlatTble ="proc print  data= "+strTableName+"_expectedOutput ;";
		    srtBufCode.append(procPrintTbleToFlatAif);
		    srtBufCode.append("\n");
		    srtBufCode.append(procPrintTbleToFlatTble);
		    srtBufCode.append("\n");
		   String codeTbleToFlat =srtBufCode.toString();
			//System.out.println(codeTbleToFlat );
		 
			
			objGuiScripterTbleToFlat.setVisible(false);
			GuiSasco objGuiSasco = new GuiSasco ("Java-SAS Editor");
			objGuiSasco.txtAreaSasEditor.setText(codeTbleToFlat);
			 }
	 }


	}
	}
		    
			