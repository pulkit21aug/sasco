/**
 * This source file creats THe GUI for for converting dml
 * into SAS readable format
 */
package sasco;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * @author Pulkit Saxena
 * Date 16-jun-07
 * @param Title of the frame  
 */

class GuiConvertDml extends JFrame{
 public JTextArea txtAreaDml ;
 public JLabel  lblEntrDml;
 public JPanel panelDml;
 public JPanel  panelLbl;
 public Container container;
 public JButton btnConvertDml;
 public JPanel panelBtn;
 
 GuiConvertDml(String name) {
 super(name);
 
 //creating a label to show message
 lblEntrDml = new JLabel("Enter Dml in Sasco Format");
 
 //creating txtarea to write the dml
 txtAreaDml = new JTextArea();
 txtAreaDml.setEditable(false);
 //adding scroll pane
 JScrollPane scrollPane = 
	    new JScrollPane(txtAreaDml,
	                    JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	                    JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
   scrollPane.setPreferredSize(new Dimension(450, 110));

   txtAreaDml.setEditable(true);
  
   //making constraints  for adding txtarea 
   GridBagConstraints c = new GridBagConstraints();
   c.fill = GridBagConstraints.BOTH;
   c.weightx = 1.0;
   c.weighty = 1.0;

 //creating the Button to generate event for dml conversion
 btnConvertDml = new JButton("Convert DML");
 
 //creating panels components panels
  
  panelLbl = new JPanel(new FlowLayout());
  panelDml = new JPanel(new GridLayout());
  panelBtn = new JPanel(new FlowLayout()); 
  
  //adding components to panels
  panelLbl.add(lblEntrDml);
  panelDml.add(scrollPane,c);
  panelBtn.add(btnConvertDml);
  
  //creating the container and adding panels
  container = this.getContentPane();
  container.setLayout(new BorderLayout());
  container.add(panelLbl,BorderLayout.PAGE_START);
  container.add(panelDml,BorderLayout.CENTER);
  container.add(panelBtn,BorderLayout.PAGE_END);
  //setting look and feel of frame
  setSize(700,600);
  JFrame.setDefaultLookAndFeelDecorated(true);
  // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  this.setVisible(true);    
 
  //creating objectof clas whih handles events
  GuiConvertDmlEvntHandler DmlEvntHandler = new GuiConvertDmlEvntHandler(this);  
  btnConvertDml.addActionListener(DmlEvntHandler);
  
  GuiConvertDmlAdapter adapter = new GuiConvertDmlAdapter(this);
  this.addWindowListener(adapter);
  
 }

}