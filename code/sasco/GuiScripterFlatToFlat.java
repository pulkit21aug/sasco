/**
 * This java file consists a class which creates the GUI for the
 * case when data is moving from a Flat AIF to another Flat AIF.
 */
package sasco;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Panel;

import javax.swing.*;
import javax.swing.plaf.PanelUI;
/**
 * This class creates the GUI for the case when data is moving from 
 * a flat AIF to another Flat AIF.
 * @author Pulkit Saxena
 * @version 1.0
 * Date 15-Jul-2007
 */
public class GuiScripterFlatToFlat extends JFrame{
	 JLabel lblSrcDml;
	    JLabel lblTrgDml;
	    JTextArea txtAreaSrcDml;
	    JTextArea txtAreaTrgDml;
	    JButton btnGenCodeFlatToFlat;
		JPanel panel;
		Container cnt;
		/**
		 * This constructor creates initiales the Variabes
		 * @param title: name for the title of the GUI form
		 */
		public GuiScripterFlatToFlat(String Title){
			super(Title);
		
			//initialising the components
		
			lblSrcDml = new JLabel("Enter DML for souce Delimited AIF");
			lblTrgDml = new JLabel("Enter DML for target Delimited AIF");
			
			txtAreaSrcDml = new JTextArea();
			txtAreaSrcDml.setEditable(false);
			//adding scrollpane to txtAreaSrcDml
			JScrollPane scrolPaneTxtSrc = 
				new JScrollPane(txtAreaSrcDml,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	                    JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			scrolPaneTxtSrc.setPreferredSize(new Dimension(250, 250));
			txtAreaSrcDml.setEditable(true);
			   //setting constraints for scrolllpane
			   

			// making constraints  for adding txtarea 
			   GridBagConstraints cs = new GridBagConstraints();
			   cs.fill = GridBagConstraints.BOTH;
			   cs.weightx = 1.0;
			   cs.weighty = 1.0;
		   
			   txtAreaTrgDml = new JTextArea();
			   txtAreaTrgDml.setEditable(false);
			   //adding scrollpane
			   JScrollPane scrolPaneTxtTrgt =
				    new JScrollPane(txtAreaTrgDml,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				    		JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			   scrolPaneTxtTrgt.setPreferredSize(new Dimension(250,250));
			   txtAreaTrgDml.setEditable(true);
			   //setting constraints for scrolllpane
			   

			   //making constraints  for adding txtarea 
				   GridBagConstraints ct = new GridBagConstraints();
				   ct.fill = GridBagConstraints.BOTH;
				   ct.weightx = 1.0;
				   ct.weighty = 1.0;
				   
		 //adding button 
		  btnGenCodeFlatToFlat = new JButton("Generate Code");
			
		  SpringLayout layout = new SpringLayout();
		  panel = new JPanel(layout);
		  //adding componets to panel
		  panel.add(lblSrcDml);
		  panel.add(scrolPaneTxtSrc,cs);
		  panel.add(lblTrgDml);
		  panel.add(scrolPaneTxtTrgt,ct);
		  panel.add(btnGenCodeFlatToFlat);
		
		  //setting constraints for the components
		  
		  //setting constraints for the layout of lblSrcDml
		  
		  SpringLayout.Constraints lblSrcDmlCons = 
			  layout.getConstraints(lblSrcDml);
		  
		  lblSrcDmlCons.setX(Spring.constant(50));
		  lblSrcDmlCons.setY(Spring.constant(50));  
		  
		  //setting constraints for the scrolPaneTxtSrc
		  SpringLayout.Constraints scrolPaneTxtSrcCons =
			  layout.getConstraints(scrolPaneTxtSrc);
		  scrolPaneTxtSrcCons.setX(Spring.sum(
				   Spring.constant(50), lblSrcDmlCons.getConstraint(SpringLayout.EAST)));
		  scrolPaneTxtSrcCons.setY(Spring.constant(50));
		  
		  //setting constraints for lblTrgDml
		  SpringLayout.Constraints lblTrgDmlCons =
			  layout.getConstraints(lblTrgDml);
		  lblTrgDmlCons.setX(Spring.constant(50));
		  lblTrgDmlCons.setY(Spring.constant(340));
		  
		  //setting constraint for scrolPaneTxtTrgt
		  SpringLayout.Constraints scrolPaneTxtTrgtCons =
			  layout.getConstraints(scrolPaneTxtTrgt);
		  scrolPaneTxtTrgtCons.setX(Spring.sum(
				   Spring.constant(50), lblTrgDmlCons.getConstraint(SpringLayout.EAST)));
		  scrolPaneTxtTrgtCons.setY(Spring.constant(340));
		  
		  

		  //setting layout for  btnGenCode
		   SpringLayout.Constraints btnGenCodeCons =
			   layout.getConstraints(btnGenCodeFlatToFlat);
		   btnGenCodeCons.setX(Spring.constant(235));
		   btnGenCodeCons.setY(Spring.constant(10));
		 
		   //adding panel to container
		   cnt =this.getContentPane();
		   cnt.add(panel);
		   
		   //setting look and feel
		   setSize(700,650);
		     JFrame.setDefaultLookAndFeelDecorated(true);
		     this.setVisible(true);     

		     //creating object of class whih handles events
		     GuiScripterFlatToFlatEvntHandler scripterFlatToFlat = new
		      GuiScripterFlatToFlatEvntHandler(this); 
		  
		     btnGenCodeFlatToFlat.addActionListener(scripterFlatToFlat);
		     
		     GuiScripterFlatToFlatAdapter adapterScripterFlatToFlat = 
		   	 new GuiScripterFlatToFlatAdapter(this);
		    this.addWindowListener(adapterScripterFlatToFlat); 
			   
		  
		}

	}
