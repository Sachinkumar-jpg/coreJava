package dialoguepanels;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;

public class RegistrationDialog {
	public JDialog registrationDialog;
	public JLabel registrationBackground;
	public JLabel simpleMessage;
	
	public RegistrationDialog(){
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		} catch (ClassNotFoundException|InstantiationException|IllegalAccessException|UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		registrationDialog=new JDialog();
		registrationDialog.setTitle("registration window");
		registrationDialog.setSize(455,275);
    	Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x=dimension.width/2-registrationDialog.getWidth()/2;
		int y=dimension.height/2-registrationDialog.getHeight()/2;
		registrationDialog.setLocation(x,y);
		registrationDialog.setResizable(false);
		registrationDialog.setAlwaysOnTop(true);
    	//when open dialog box you don't nothing in background.
		registrationDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
		registrationDialog.setLayout(null);
		
		setResetPasswordPanel();
		setSimpleMessage();
		
		
		
		registrationDialog.setVisible(true);
	}
	public void setResetPasswordPanel() {
		registrationBackground = new JLabel();
		registrationBackground.setSize(410,210);
		registrationBackground.setLocation(20,20);
		registrationBackground.setBackground(Color.WHITE);
		registrationBackground.setLayout(null);
		registrationBackground.setBorder(new LineBorder(Color.LIGHT_GRAY));
		registrationBackground.setOpaque(true);
		registrationDialog.add(registrationBackground);
		
	}
	public void setSimpleMessage() {
		simpleMessage = new JLabel("project under construction");
		simpleMessage.setSize(300,30);
		simpleMessage.setLocation(75, 100);
		simpleMessage.setFont(new Font("Arial",Font.BOLD,20));
		registrationBackground.add(simpleMessage);
	}
	
}
