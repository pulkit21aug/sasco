/**
 * This java file consists a class which creates the GUI
 * for generating the code for the scenario 
 * when data is moving from Delimited file to Table
 */
package sasco;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import javax.swing.SpringLayout;
import javax.swing.Spring;
import javax.swing.*;
/**
 * This class creates The GUI and exetnds The JFrame class.
 * It creates the event and delegates them to event handler 
 * @author Pulkit Saxena
 * Date :-24-Jun-07
 * @version 1.0
 */
class GuiScripterDlmToTable extends JFrame {
  
	 //declaring components
	public JLabel lblTrgtSchema;
	public JLabel lblTrgtTableName;
	public JLabel lblDml;
	public JTextField txtTrgtSchema;
	public JTextField trgtTableName;
	public JTextArea  txtAreaSrcDmlAif;
	public JButton btnGenCodeDlmtoTble;
	public JPanel pnlDlmToTble;
	public Container container1;
	
	/**
	 * This is constructor for the class  which initilaiese
	 * The variables
	 * @param String Title:-name shown on title bar of GUI form
	 */
	public GuiScripterDlmToTable(String Title) {
		super(Title);
 	 
		//initialising the variables
		lblTrgtSchema = new JLabel("Enter Output Table Schema");
		lblTrgtTableName = new JLabel("Enter Output Table Name");
		lblDml = new JLabel("Enter the source DML of AIF");
		txtTrgtSchema = new JTextField(15);
		trgtTableName = new JTextField(15);
		txtAreaSrcDmlAif = new JTextArea();
		txtAreaSrcDmlAif.setEditable(false);
		//adding scrollpane to txtAreaSrcDmlAif
	    	
	
	    JScrollPane scrollPane = 
		    new JScrollPane(txtAreaSrcDmlAif,
		                    JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		                    JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	   scrollPane.setPreferredSize(new Dimension(250, 300));

	   txtAreaSrcDmlAif.setEditable(true);
	   
	   //setting constraints for scrolllpane
	   
//	 making constraints  for adding txtarea 
	   GridBagConstraints cs = new GridBagConstraints();
	   cs.fill = GridBagConstraints.BOTH;
	   cs.weightx = 1.0;
	   cs.weighty = 1.0;
	   
	   //creating buttons 
	   btnGenCodeDlmtoTble = new JButton("Generate Code");
	   
	   //setting layout for the form
	   SpringLayout layout = new SpringLayout();
	   pnlDlmToTble = new JPanel(layout);
	  
	   //adding components to panel
	   
	   pnlDlmToTble.add(lblTrgtSchema);
	   
	   pnlDlmToTble.add(txtTrgtSchema);
	  
	  
	   pnlDlmToTble.add(lblTrgtTableName);
	   
	   pnlDlmToTble.add(trgtTableName);
	   
	   pnlDlmToTble.add(lblDml);
	   pnlDlmToTble.add(scrollPane,cs);
	   
	   pnlDlmToTble.add(btnGenCodeDlmtoTble);
  //setting constarints for layout for lblTrgtSchema
	 
	   SpringLayout.Constraints labelCons =
           layout.getConstraints(lblTrgtSchema);
   labelCons.setX(Spring.constant(80));
   labelCons.setY(Spring.constant(100));  
   
// setting constarints for layout for txtSchema
   SpringLayout.Constraints textFieldCons =
       layout.getConstraints(txtTrgtSchema);

   textFieldCons.setX(Spring.sum(
   Spring.constant(80), labelCons.getConstraint(SpringLayout.EAST)));
   textFieldCons.setY(Spring.constant(100));
	   
// setting constarints for layout for lblTrgtTableNameCons
   SpringLayout.Constraints lblTrgtTableNameCons =
	  layout.getConstraints(lblTrgtTableName);
   lblTrgtTableNameCons.setX(Spring.constant(80));
   lblTrgtTableNameCons.setY(Spring.constant(125));
	
// setting constarints for layout for trgtTableName	   
   SpringLayout.Constraints trgtTableNameCons =
	   layout.getConstraints(trgtTableName);
   trgtTableNameCons.setX(Spring.sum(
		   Spring.constant(80), labelCons.getConstraint(SpringLayout.EAST)));
   trgtTableNameCons.setY(Spring.constant(125));
      
// setting constraints for lblDml
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
	   
//	 setting layout for  btnGenCode
	   SpringLayout.Constraints btnGenCodeCons =
		   layout.getConstraints(btnGenCodeDlmtoTble);
	   btnGenCodeCons.setX(Spring.constant(250));
	   btnGenCodeCons.setY(Spring.constant(480));
	   
	  //adding panel to container
	   
	   container1 = this.getContentPane(); 
       container1.add(pnlDlmToTble);
	  
      //     setting look and feel
       setSize(700,600);
     JFrame.setDefaultLookAndFeelDecorated(true);
     this.setVisible(true);     

     //creating object of clas whih handles events
     GuiScripterDlmToTbleEvntHandler scripterDlmToTble = new
       GuiScripterDlmToTbleEvntHandler(this); 
  
     btnGenCodeDlmtoTble.addActionListener(scripterDlmToTble);
     
     GuiScripterDlmToTbleAdapter adapterScripterDlmToTble = 
    	 new GuiScripterDlmToTbleAdapter(this);
     this.addWindowListener(adapterScripterDlmToTble); 
	   
	
	
	}


 
}
