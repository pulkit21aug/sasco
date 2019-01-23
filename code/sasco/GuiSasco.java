
/**
 * This source file contains a class GuiSasco  which creates
 * the GUI of SasEditor -SASCO -SAS CODER
 */

package sasco;

import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * This class contains methods and variables to create
 * GUI of the SASCO
 * @author Pulkit_Saxena
 * @version 1.0
 */
class GuiSasco  extends JFrame{
 //variables declaraion
  public	JTextArea txtAreaSasEditor;
  public	Container container;
  public    JPanel panelTextArea; 	
  public   JPanel panelMenuBar;
  /*
  * This is constructor for GuiSasco and
  * initialises the variables to create 
  * the GUI of Sasco
  */	
 GuiSasco(String nameTitle)
 { 
	 super(nameTitle);
	 //creating the menubar 
	 JMenuBar sasEditMenuBar = new JMenuBar();
     //creating the menu 
	 JMenu  fileMenu = new JMenu("File");
	 JMenu  editMenu = new JMenu("Edit");
	 JMenu  genrteCode =  new JMenu("Scripter");
	 JMenu  convertDml = new JMenu("Convert DML");
	 JMenu  help =new JMenu("Help");
	 
	 //creating the menu items for menu File
	 JMenuItem  fileMenuNew =    new JMenuItem("New");
	 fileMenuNew.setAccelerator(KeyStroke.getKeyStroke('N',
			 Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(),false));
	 JMenuItem  fileMenuOpen=    new JMenuItem("Open");
	 fileMenuOpen.setAccelerator(KeyStroke.getKeyStroke('O',
			 Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(),false));
	 JMenuItem  fileMenuSave =   new JMenuItem("Save");
	 fileMenuSave.setAccelerator(KeyStroke.getKeyStroke('S',
			 Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(),false));
	 JMenuItem  fileMenuSaveAs = new JMenuItem("Save As");
	 JMenuItem  fileMenuExit =   new JMenuItem("Exit");
	 
	 
	 //adding menu items to menu File
	 fileMenu.add(fileMenuNew);
	 fileMenu.add(fileMenuOpen);
	 fileMenu.add(fileMenuSave);
	 fileMenu.add(fileMenuSave);
	 fileMenu.add(fileMenuSaveAs);
	 fileMenu.add(fileMenuExit);
	 
	 //creating menu items to  menu Edit
	 JMenuItem editMenuCut = new JMenuItem("Cut");
	 editMenuCut.setAccelerator(KeyStroke.getKeyStroke('X',
			 Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(),false));
	 JMenuItem editMenuCopy = new JMenuItem("Copy");
	 editMenuCopy.setAccelerator(KeyStroke.getKeyStroke('C',
			 Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(),false));
	 JMenuItem editMenuPaste = new JMenuItem("Paste");
	 editMenuPaste.setAccelerator(KeyStroke.getKeyStroke('V',
			 Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(),false ));
	 
	 
	 //adding menu items for menu Edit
	   editMenu.add(editMenuCut);
	   editMenu.add(editMenuCopy);
	   editMenu.add(editMenuPaste);
	   
	 //creatig  menu items for menu Scripter
	 JMenuItem genrteCodeTableToDlm =  new JMenuItem("Table to DLM_File");
	 JMenuItem genrteCodeDlmToTable =  new JMenuItem("DLM_File to Table");
	 JMenuItem genrteCodeDlmToDLM   =  new JMenuItem("DLM_File to DLM_File");
	 JMenuItem genrteCodeTableToFlat = new JMenuItem("Table to Flat_File");
	 JMenuItem genrteCodeFlatToTable = new JMenuItem("Flat_File to Table");
	 JMenuItem genrteCodeFlatToFlat  = new JMenuItem("Flat_File to Flat_File");
	 
	 
	 //adding menu items for menu Scripter
	  genrteCode.add(genrteCodeTableToDlm);
	  genrteCode.add(genrteCodeDlmToTable);
	  genrteCode.add(genrteCodeDlmToDLM);
	  genrteCode.add(genrteCodeTableToFlat);
	  genrteCode.add(genrteCodeFlatToTable);
	  genrteCode.add(genrteCodeFlatToFlat);
	  
	  
	  //creating Menu Items for Convert DML
	  JMenuItem  convertDmlDelimitedFile = new JMenuItem("Delimited File"); 
	  JMenuItem  convertDmlFlatFile = new JMenuItem("Flat File"); 
	  //adding Menu Item  for Convert DML
	  convertDml.add(convertDmlDelimitedFile);
	  convertDml.add(convertDmlFlatFile);
	 
	  //creating Menu Items for Help
	  JMenuItem helpTopics = new JMenuItem("SAS Reference");
	  JMenuItem aboutSasco = new JMenuItem("About Sasco 1.1");
	  
	  //adding Menu Items for Help
	  help.add(helpTopics);
	  help.add(aboutSasco);
	  
	  
	  //adding Menu To MenuBar 
	  sasEditMenuBar.add(fileMenu);
	  sasEditMenuBar.add(editMenu);
	  sasEditMenuBar.add(genrteCode);
	  sasEditMenuBar.add(convertDml);
	  sasEditMenuBar.add(help);
	  
	  //creating panel and text area
	   panelTextArea = new JPanel(new  GridBagLayout());
	 
	  txtAreaSasEditor = new JTextArea(699,599);
	  txtAreaSasEditor.setEditable(false);
	  //adding scroll pane
	  JScrollPane scrollPane = 
		    new JScrollPane(txtAreaSasEditor,
		                    JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		                    JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	    scrollPane.setPreferredSize(new Dimension(450, 110));
	   
	    txtAreaSasEditor.setEditable(true);
	    
	    GridBagConstraints c = new GridBagConstraints();
       
	    //adding componets to panel
	    
	  c.fill = GridBagConstraints.BOTH;
      c.weightx = 1.0;
      c.weighty = 1.0;
      panelTextArea.add(scrollPane,c);
	 
	  //creating panel to add menubar
	  panelMenuBar = new JPanel(new GridLayout());
	  panelMenuBar.add(sasEditMenuBar);

	  
	  //adding panels to container
	  container = this.getContentPane();
	  container.setLayout(new BorderLayout());
	  container.add(panelMenuBar,BorderLayout.PAGE_START);
	  container.add(panelTextArea,BorderLayout.CENTER);
	  
	  //setting look and feel of frame
	  setSize(700,600);
	  JFrame.setDefaultLookAndFeelDecorated(true);
	 // setLocationRelativeTo(null);
     // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setVisible(true);    
   
      //creating object to handle events
      GuiSascoEvntHander  evntHandler = new   GuiSascoEvntHander(this);
      fileMenuNew.addActionListener(evntHandler);
      fileMenuOpen.addActionListener(evntHandler);
      fileMenuSave.addActionListener(evntHandler);
      fileMenuSaveAs.addActionListener(evntHandler); 
      fileMenuExit.addActionListener(evntHandler); 
      
      editMenuCut.addActionListener(evntHandler);
      editMenuCopy.addActionListener(evntHandler);
      editMenuPaste.addActionListener(evntHandler);
      
      convertDmlDelimitedFile.addActionListener(evntHandler);
      convertDmlFlatFile.addActionListener(evntHandler); 
      
      genrteCodeTableToDlm.addActionListener(evntHandler);
      genrteCodeDlmToTable.addActionListener(evntHandler); 
      genrteCodeDlmToDLM.addActionListener(evntHandler); 
      genrteCodeTableToFlat.addActionListener(evntHandler);
      genrteCodeFlatToTable.addActionListener(evntHandler);
      genrteCodeFlatToFlat.addActionListener(evntHandler);
 
      helpTopics.addActionListener(evntHandler) ;
      aboutSasco.addActionListener(evntHandler);
  
      GuiSascoAdapter objGuiSascoAdapter = new GuiSascoAdapter(this);
      this.addWindowListener(objGuiSascoAdapter);
 }




}
