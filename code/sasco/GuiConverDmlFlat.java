/**
 * This java file consists a class to create the GUI for 
 * converting DML fo flat AIF to SAS Format
 */
package sasco;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This class creates the GUI for converting the
 * DML of Flat AIF to SAS format
 * @author Pulkit Saxena
 * @version 1.0
 * Date 4-Jul-2007
 */
class GuiConverDmlFlat extends JFrame {
	 JTextArea txtAreaDmlFlat ;
	 JLabel  lblEntrDmlFlat;
	 JPanel panelDmlFlat;
	 JPanel  panelLblFlat;
	 Container containerFlat;
	 JButton btnConvertDmlFlat;
	 JPanel panelBtnFlat;
	
	 /**
	 * This constructor initialises the components of the 
	 * the class to create the GUI 
	 * @param name :String title of the form
	 */
	public GuiConverDmlFlat(String name) {
		super(name);
		// TODO Creating the components to be added to panel
		

		//creating a label to show message
		 lblEntrDmlFlat = new JLabel("Enter Dml in Sasco Format");

		 //creating txtarea to write the dml
		 txtAreaDmlFlat = new JTextArea();
		 txtAreaDmlFlat.setEditable(false);
		 //adding scroll pane
		 JScrollPane scrollPane = 
			    new JScrollPane(txtAreaDmlFlat,
			                    JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			                    JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		   scrollPane.setPreferredSize(new Dimension(450, 110));

		   txtAreaDmlFlat.setEditable(true);
		  
		   //making constraints  for adding txtarea 
		   GridBagConstraints c = new GridBagConstraints();
		   c.fill = GridBagConstraints.BOTH;
		   c.weightx = 1.0;
		   c.weighty = 1.0;
	

		   //creating the Button to generate event for dml conversion
		   btnConvertDmlFlat = new JButton("Convert DML");

		   // creating panels components panels
		   
		   panelLblFlat = new JPanel(new FlowLayout());
		   panelDmlFlat = new JPanel(new GridLayout());
		   panelBtnFlat = new JPanel(new FlowLayout()); 
		   

		   //adding components to panels
		   panelLblFlat.add(lblEntrDmlFlat);
		   panelDmlFlat.add(scrollPane,c);
		   panelBtnFlat.add(btnConvertDmlFlat);
		   

		   //creating the container and adding panels
		   containerFlat = this.getContentPane();
		   containerFlat.setLayout(new BorderLayout());
		   containerFlat.add(panelLblFlat,BorderLayout.PAGE_START);
		   containerFlat.add(panelDmlFlat,BorderLayout.CENTER);
		   containerFlat.add(panelBtnFlat,BorderLayout.PAGE_END);
	       

		   //setting look and feel of frame
		   setSize(700,600);
		   JFrame.setDefaultLookAndFeelDecorated(true);
	      
		   this.setVisible(true);    
		   
		   //creating objectof class whih handles events
		   GuiConvertDmlFlatEvntHandler DmlEvntHandler = new GuiConvertDmlFlatEvntHandler(this);  
		  btnConvertDmlFlat.addActionListener(DmlEvntHandler);
		   
		   GuiConvertDmlFlatAdapter adapter = new GuiConvertDmlFlatAdapter(this);
		  this.addWindowListener(adapter);
		   
	
	}

}
