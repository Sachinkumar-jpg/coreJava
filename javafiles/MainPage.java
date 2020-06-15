package javafiles;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

import action.MainPageAction;
public class MainPage {
	public static JLabel mainGround;
	
	public static JLabel topGround;
	public static JButton topRight_TopGround;
	public static JButton optionButton;
	public static JLabel optionImage;
	public static JButton supportButton;
	public static JLabel supportImage;
	
	public static JLabel midGroundSupporter;
	public static JLabel midGround;
	public static DefaultTableModel tableModel;
	public static JTable table;
	
	public static JLabel bottumGround;
	public static JButton registerButton;
	public static JButton addButton;
	public static JButton unlockButton;
	public static JButton exitButton;
	public static JButton innerButton;
	
	public static JLabel mainGroundImage;
	
   public static void setMainPage(){
	    mainGround = new JLabel();
	    mainGround.setSize(713, 390);
	    mainGround.setLocation(0,0);
	    mainGround.setBackground(Color.PINK);
	    mainGround.setLayout(null);
	    mainGround.setOpaque(true);
	    mainGround.setVisible(false);
	    MainApplication.protectedMainFrame.add(mainGround);
	
	    setTopGround();
	    
	    setMainGroundImage();
	    setTopRightButton();
	    setOptionButton();
	    MainPageAction.setOptionButtonAction();
	    setSupportButon();
	    MainPageAction.setSupporButtonAction();
	    setOptionImage();
	    setSupportImage();
	    
	    setMidGroundSupporter();
	    setMidGround();
	    setTable();
	    
	    setBottumGround();
	    setRegisterButton();
	    MainPageAction.setRegistrationButtonAction();
	    setAddButton();
	    MainPageAction.setAddButtonAction();
	    setUnlockButton();
	    MainPageAction.setUnlockButtonAction();
	    setExitButton();
	    MainPageAction.setExitButtonAction();
	    setAddInnerButton();
	    MainPageAction.setInnerButton();
	    
	    
}
       
public static void setTopGround() {
	topGround = new JLabel();
	topGround.setSize(713,40);
	topGround.setLocation(0,0);
	topGround.setBackground(Color.GRAY);
	topGround.setLayout(null);
	topGround.setOpaque(true);
	mainGround.add(topGround);
	
}

public static void setMainGroundImage() {
	 mainGroundImage = new JLabel();
	 mainGroundImage.setSize(50,35);
	 mainGroundImage.setLocation(10,2);
	 mainGroundImage.setLayout(null);
    ImageIcon supportImageIcon = new ImageIcon(MainApplication.class
			.getResource("/resources/lockopen.png"));
    mainGroundImage.setIcon(supportImageIcon);
    mainGroundImage.setOpaque(false);
   topGround.add(mainGroundImage);

}

public static void setTopRightButton() {
   topRight_TopGround = new JButton();
   topRight_TopGround.setSize(240,25);
   topRight_TopGround.setLocation(450,7);
   topRight_TopGround.setBackground(new Color(204,204,204,255));
   topRight_TopGround.setEnabled(false);
   topRight_TopGround.setLayout(null);
   topGround.add(topRight_TopGround);

}
public static void setOptionButton() {
	 optionButton = new JButton("Option");
	 optionButton.setSize(108,15);
	 optionButton.setLocation(10,5);
	 optionButton.setBackground(Color.WHITE);
	 optionButton.setLayout(null);
	 optionButton.setFocusPainted(false);
	 optionButton.setFont(new Font("Arial",Font.PLAIN,12));
	 topRight_TopGround.add(optionButton);

}
public static void setSupportButon() {
	 supportButton = new JButton("support");
	 supportButton.setSize(108,15);
	 supportButton.setLocation(122,5);
	 supportButton.setBackground(Color.white);
	 supportButton.setLayout(null);
	 supportButton.setFocusPainted(false);
	 supportButton.setFont(new Font("Arial",Font.PLAIN,12));
	 topRight_TopGround.add(supportButton);

}

public static void setOptionImage() {
	    optionImage = new JLabel();
	    optionImage.setSize(12,10);
	    optionImage.setLocation(10,2);
	    optionImage.setLayout(null);
	    ImageIcon optionImageIcon = new ImageIcon(MainApplication.class
				.getResource("/resources/options.png"));
		optionImage.setIcon(optionImageIcon);
	    optionImage.setOpaque(false);
		optionButton.add(optionImage); 
}

public static void setSupportImage() {
    supportImage = new JLabel();
    supportImage.setSize(12,10);
    supportImage.setLocation(10,2);
    supportImage.setLayout(null);
    ImageIcon supportImageIcon = new ImageIcon(MainApplication.class
			.getResource("/resources/support.png"));
	supportImage.setIcon(supportImageIcon);
    supportImage.setOpaque(false);
    supportButton.add(supportImage);
}
public static void setMidGroundSupporter() {
	midGroundSupporter= new JLabel();
	midGroundSupporter.setLocation(0,40);
	midGroundSupporter.setSize(713,350);
	midGroundSupporter.setBackground(new Color(233,239,236,255));
	midGroundSupporter.setOpaque(true);
	midGroundSupporter.setBorder(new LineBorder(new Color(10,10,10), 3));
	midGroundSupporter.setLayout(null);
	mainGround.add(midGroundSupporter);
	
}
public static void setMidGround() {
	midGround=new JLabel();
	midGround.setLocation(3,3);
	midGround.setSize(707, 284);
	midGround.setBackground(Color.WHITE);
	midGround.setOpaque(true);
    midGroundSupporter.add(midGround);
}
public static void setTable() {
	tableModel = new DefaultTableModel();
	tableModel.addColumn("File Path");
	tableModel.addColumn("Status");
	
	table = new JTable(tableModel) {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public boolean isCellEditable(int row,int column) {
			return false;
		}
	};
	JScrollPane scrollPane =new JScrollPane(table);
	scrollPane.setLocation(3,3);
	scrollPane.setSize(702,278);
	scrollPane.getViewport().setBackground(new Color(233,239,236,255));
	midGround.add(scrollPane);
	
	table.setBackground(new Color(233,239,236,255));
	table.setRowHeight(38);
	
	table.setShowVerticalLines(false);
	table.setFocusable(false);
	table.setSelectionBackground(new Color(87,255,152,155));
	table.getColumnModel().getColumn(0).setPreferredWidth(480);
	
	table.getTableHeader().setReorderingAllowed(false);
	table.getTableHeader().setBackground(Color.LIGHT_GRAY);
	
	
}

public static void setBottumGround() {
	bottumGround = new JLabel();
	bottumGround.setLocation(3,287);
	bottumGround.setSize(707,60);
	bottumGround.setBackground(Color.GRAY);
	bottumGround.setOpaque(true);
	bottumGround.setLayout(null);
	midGroundSupporter.add(bottumGround);
	
}
public static void setRegisterButton() {
	   registerButton = new JButton("Register");
	   registerButton.setSize(100,30);
	   registerButton.setLocation(10,17);
	   registerButton.setForeground(Color.WHITE);
	   registerButton.setBackground(new Color(63,187,73,255));
	   registerButton.setFont(new Font("Arial",Font.BOLD, 12));
	   registerButton.setFocusable(false);
	   registerButton.setLayout(null);
	   bottumGround.add(registerButton);
}
public static void setAddButton() {
	   addButton = new JButton();
	   addButton.setSize(105,32);
	   addButton.setLocation(300,15);
	   addButton.setFocusable(false);
	   addButton.setLayout(null);
	   ImageIcon buttonImage=new ImageIcon(MainApplication.class
				.getResource("/resources/ADD.png"));
	   //ImageIcon buttonImage2=new ImageIcon(MainApplication.class
				//.getResource("/resources/combo.png"));
	   addButton.setIcon(buttonImage);
	   addButton.setContentAreaFilled(false);
	   //buttonImage.setImage(buttonImage2);
	   bottumGround.add(addButton);
}
public static void setUnlockButton() {
	   unlockButton = new JButton();
	   unlockButton.setSize(105,32);
	   unlockButton.setLocation(410,15);
	   unlockButton.setFocusable(false);
	   unlockButton.setLayout(null);
	   ImageIcon buttonImage=new ImageIcon(MainApplication.class
				.getResource("/resources/unlockImage.png"));
	   unlockButton.setIcon(buttonImage);
	   unlockButton.setContentAreaFilled(false);
	   bottumGround.add(unlockButton);
}
public static void setExitButton() {
	   exitButton = new JButton();
	   exitButton.setSize(115,32);
	   exitButton.setLocation(580,15);
	   exitButton.setFocusable(false);
	   exitButton.setLayout(null);
	   ImageIcon buttonImage=new ImageIcon(MainApplication.class
				.getResource("/resources/lockexit.png"));
	   exitButton.setIcon(buttonImage);
	   exitButton.setContentAreaFilled(false);
	   bottumGround.add(exitButton);
}
public static void  setAddInnerButton() {
	   innerButton =new JButton();
	   innerButton.setSize(52,32);
	   innerButton.setLocation(53,0);
	   innerButton.setFocusable(false);
	   innerButton.setLayout(null);
	   ImageIcon buttonImage=new ImageIcon(MainApplication.class
				.getResource("/resources/combo.png"));
	   innerButton.setIcon(buttonImage);
	   innerButton.setContentAreaFilled(false);
	   addButton.add(innerButton);
	
}

}
