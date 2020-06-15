package dialoguepanels;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;

import action.ResetPasswordDialogAction;

public class ResetPasswordDialog {
	public JDialog resetPasswordDialog;
	public JLabel resetPasswordBackground;
	public JLabel currentPasswordLabel,newPasswordLabel,confirmPasswordLabel;
	public JTextField currentPasswordLabelTextField,newPasswordLabelTextField,confirmPasswordLabelTextField;
	public JButton applyButton;
	public JLabel warnMessage;
	public ResetPasswordDialog(){
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		} catch (ClassNotFoundException|InstantiationException|IllegalAccessException|UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		resetPasswordDialog=new JDialog();
		resetPasswordDialog.setTitle("resetPassword");
		resetPasswordDialog.setSize(455,275);
    	Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x=dimension.width/2-resetPasswordDialog.getWidth()/2;
		int y=dimension.height/2-resetPasswordDialog.getHeight()/2;
		resetPasswordDialog.setLocation(x,y);
		resetPasswordDialog.setResizable(false);
		resetPasswordDialog.setAlwaysOnTop(true);
    	//when open dialog box you don't nothing in background.
		resetPasswordDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
		resetPasswordDialog.setLayout(null);
		
		setResetPasswordPanel();
		setPasswordLabel();
		setPasswordLabelTextField();
		setApplyButton();
		setWarnMessage();
		
		ResetPasswordDialogAction.setApplyButtonAction(this);
		
		resetPasswordDialog.setVisible(true);
	}
	public void setResetPasswordPanel() {
		resetPasswordBackground = new JLabel();
		resetPasswordBackground.setSize(410,210);
		resetPasswordBackground.setLocation(20,20);
		resetPasswordBackground.setBackground(Color.WHITE);
		resetPasswordBackground.setLayout(null);
		resetPasswordBackground.setBorder(new LineBorder(Color.LIGHT_GRAY));
		resetPasswordBackground.setOpaque(true);
		resetPasswordDialog.add(resetPasswordBackground);
		
	}
	public void setPasswordLabel() {
		currentPasswordLabel = new JLabel("CurrentPassword");
		currentPasswordLabel.setBounds(30, 20, 110, 30);
		resetPasswordBackground.add(currentPasswordLabel);
		newPasswordLabel = new JLabel("NewPassword");
		resetPasswordBackground.add(newPasswordLabel);
		newPasswordLabel.setBounds(30, 60, 110, 30);
		confirmPasswordLabel = new JLabel("ConfirmPassword");
		resetPasswordBackground.add(confirmPasswordLabel);
		confirmPasswordLabel.setBounds(30, 100, 110, 30);
		
	}
	public void setPasswordLabelTextField() {
		currentPasswordLabelTextField = new JTextField();
		currentPasswordLabelTextField.setBounds(150, 20, 200, 30);
		currentPasswordLabelTextField.setFont(new Font("Arial",Font.ITALIC,15));
		resetPasswordBackground.add(currentPasswordLabelTextField);
		
		newPasswordLabelTextField = new JTextField();
		newPasswordLabelTextField.setBounds(150, 60, 200, 30);
		newPasswordLabelTextField.setFont(new Font("Arial",Font.ITALIC,15));
		resetPasswordBackground.add(newPasswordLabelTextField);
		
		confirmPasswordLabelTextField = new JTextField();
		confirmPasswordLabelTextField.setBounds(150, 100, 200, 30);
		confirmPasswordLabelTextField.setFont(new Font("Arial",Font.ITALIC,15));
		resetPasswordBackground.add(confirmPasswordLabelTextField);
		
		
	}
	public void setApplyButton() {
		applyButton = new JButton("APPLY");
		applyButton.setBounds(250,150,100,30);
		applyButton.setFocusable(false);
		applyButton.setFont(new Font("Arial",Font.BOLD,20));
		resetPasswordBackground.add(applyButton);
	}
	public void setWarnMessage() {
		warnMessage = new JLabel();
		warnMessage.setForeground(Color.RED);
		warnMessage.setBounds(150,125,300,30);
		warnMessage.setFont(new Font("Arial",Font.BOLD,10));
		resetPasswordBackground.add(warnMessage);
	}

}
