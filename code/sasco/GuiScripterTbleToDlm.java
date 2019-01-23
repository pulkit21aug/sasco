/**
 * This java file contains the code to  create the GUI for generatig code 
 * for case "TABLE TO Delimited file 
 */
package sasco;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import javax.swing.SpringLayout;
import javax.swing.Spring;
import javax.swing.*;
/**
 *This class  creates the GUI  for generatig code 
 * for case "TABLE TO Delimited file 
 *@author Pulkit Saxena
 *@version 1.0
 *@Date 17-Jun-07 
 */
class GuiScripterTbleToDlm extends JFrame {

	//decralring componenets
  
public JLabel lblSchema;
public JLabel lblSrcTableName;
public JLabel lblDml;
public JTextField txtSchema;
public JTextField srcTableName;
public JTextArea  txtAreaDmlAif;
public JButton btnGenCode;
public JPanel pnlSchTb;
public Container container;
/*
 * This is constructor for initialising variables
 */
public GuiScripterTbleToDlm(String Title){
   super(Title);
   
	//initialisiing the variables
	lblSchema = new JLabel("Enter Scehma");
	lblSrcTableName = new JLabel("Enter source table name");
	lblDml = new  JLabel("Enter DML of AIF");
	 txtAreaDmlAif = new JTextArea();
	 txtAreaDmlAif.setEditable(false);
	 //adding scroll pane
	 JScrollPane scrollPane = 
		    new JScrollPane(txtAreaDmlAif,
		                    JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		                    JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	   scrollPane.setPreferredSize(new Dimension(250, 300));

	   txtAreaDmlAif.setEditable(true);
	  
	   //making constraints  for adding txtarea 
	   GridBagConstraints cs = new GridBagConstraints();
	   cs.fill = GridBagConstraints.BOTH;
	   cs.weightx = 1.0;
	   cs.weighty = 1.0;
	   txtSchema = new JTextField(15);
	   srcTableName = new JTextField(15);
	   btnGenCode = new JButton("Generate Code"); 
	 
	   //setting layout of form
	   SpringLayout layout = new SpringLayout();
	   pnlSchTb = new JPanel(layout);
	   
	   //adding components to panel
	   pnlSchTb.add(lblSchema);
	   pnlSchTb.add(txtSchema);
	   pnlSchTb.add(lblSrcTableName);
	   pnlSchTb.add(srcTableName);
	   pnlSchTb.add(lblDml);
	   pnlSchTb.add(scrollPane,cs);
	   pnlSchTb.add(btnGenCode);
	   
	   //setting constarints for layout for lblSchema
	  
	   SpringLayout.Constraints labelCons =
           layout.getConstraints(lblSchema);
   labelCons.setX(Spring.constant(80));
   labelCons.setY(Spring.constant(100));
   
  //setting constarints for layout for txtSchema
   SpringLayout.Constraints textFieldCons =
       layout.getConstraints(txtSchema);

   textFieldCons.setX(Spring.sum(
   Spring.constant(80), labelCons.getConstraint(SpringLayout.EAST)));
   textFieldCons.setY(Spring.constant(100));

 //setting constarints for layout for lblSrcTableNameCons
   SpringLayout.Constraints lblSrcTableNameCons =
	  layout.getConstraints(lblSrcTableName);
   lblSrcTableNameCons.setX(Spring.constant(80));
   lblSrcTableNameCons.setY(Spring.constant(125));
   
//setting constarints for layout for srcTableName	   
   SpringLayout.Constraints srcTableNameCons =
	   layout.getConstraints(srcTableName);
   srcTableNameCons.setX(Spring.sum(
		   Spring.constant(80), labelCons.getConstraint(SpringLayout.EAST)));
   srcTableNameCons.setY(Spring.constant(125));
   
   
   //setting constraints for lblDml
   SpringLayout.Constraints lblDmlCons =
		  layout.getConstraints(lblDml);
	   lblDmlCons.setX(Spring.constant(80));
	   lblDmlCons.setY(Spring.constant(150));
     
	//setting constraints for scrollPane
	   SpringLayout.Constraints scrollPaneCons =
		   layout.getConstraints(scrollPane);
	   scrollPaneCons.setX(Spring.sum(
			   Spring.constant(80), labelCons.getConstraint(SpringLayout.EAST)));
	   scrollPaneCons.setY(Spring.constant(150));
	      
	 //setting layout for  btnGenCode
	   SpringLayout.Constraints btnGenCodeCons =
		   layout.getConstraints(btnGenCode);
	   btnGenCodeCons.setX(Spring.constant(250));
	   btnGenCodeCons.setY(Spring.constant(480));
	   
	  //adding panel to container
	   
	   container = this.getContentPane(); 
       container.add(pnlSchTb);
          
   
      
      //setting look and feel
       setSize(700,600);
     JFrame.setDefaultLookAndFeelDecorated(true);
     this.setVisible(true);     

     //creating objectof clas whih handles events
     GuiScripterTbleToDlmEvntHandler scripterTbleToDlm = new
          GuiScripterTbleToDlmEvntHandler(this); 
  
     btnGenCode.addActionListener(scripterTbleToDlm);
     
     GuiScripterTbleToDlmAdapter adapterScripterTbleToDlm = 
    	 new GuiScripterTbleToDlmAdapter(this);
     this.addWindowListener(adapterScripterTbleToDlm);
}
}
