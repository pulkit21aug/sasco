/**
 * This java file consists a class which generates the GUI 
 * for the case when data is moving  from flat file to 
 * table.
 */
package sasco;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import javax.swing.SpringLayout;
import javax.swing.Spring;
import javax.swing.*;
/**
 * This class creates the GUI for the case when data  is moving from
 * a flar AIF to table
 * @author Pulkit Saxena
 * @version 1.0
 * Date :-15 Jul-2007
 */
public class GuiScripterFlatToTable extends JFrame {
	 //declaring components
	public JLabel lblTrgtSchema;
	public JLabel lblTrgtTableName;
	public JLabel lblDml;
	public JTextField txtTrgtSchema;
	public JTextField trgtTableName;
	public JTextArea  txtAreaSrcDmlAif;
	public JButton btnGenCodeFlattoTble;
	public JPanel pnlFlatToTble;
	public Container container1;
	/**
	 * Thsi constructor initialises the components of the
	 * form.
	 * @param Title
	 */
	public GuiScripterFlatToTable(String Title) {
		super(Title);
		// TODO initialinng the form components
//		initialising the variables
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
	   btnGenCodeFlattoTble = new JButton("Generate Code");
	   
	   //setting layout for the form
	   SpringLayout layout = new SpringLayout();
	   pnlFlatToTble = new JPanel(layout);
	  
	   //adding components to panel
	   
	   pnlFlatToTble.add(lblTrgtSchema);
	   
	   pnlFlatToTble.add(txtTrgtSchema);
	  
	  
	   pnlFlatToTble.add(lblTrgtTableName);
	   
	   pnlFlatToTble.add(trgtTableName);
	   
	   pnlFlatToTble.add(lblDml);
	   pnlFlatToTble.add(scrollPane,cs);
	   
	   pnlFlatToTble.add(btnGenCodeFlattoTble);
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
		   layout.getConstraints(btnGenCodeFlattoTble);
	   btnGenCodeCons.setX(Spring.constant(250));
	   btnGenCodeCons.setY(Spring.constant(480));
	   
	  //adding panel to container
	   
	   container1 = this.getContentPane(); 
       container1.add(pnlFlatToTble);
	  
      //     setting look and feel
       setSize(700,600);
     JFrame.setDefaultLookAndFeelDecorated(true);
     this.setVisible(true);     

     //creating object of clas whih handles events
      GuiScripterFlatToTableEvntHandler scripterFlatToTable = new
      GuiScripterFlatToTableEvntHandler(this); 
  
      btnGenCodeFlattoTble.addActionListener(scripterFlatToTable);
     
     GuiScripterFlatToTableAdapter adapterScripterFlatToTble = 
     new GuiScripterFlatToTableAdapter(this);
    this.addWindowListener(adapterScripterFlatToTble); 
	   
	
	
	}


 
}

	
	
	
