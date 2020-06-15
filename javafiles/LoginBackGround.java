package javafiles;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import action.LoginAction;

public class LoginBackGround {
	public static JLabel mainBackground;
	public static JLabel lockCloseImage;
	public static JLabel loginImage;
	public static JButton loginButton;
	public static JButton cancelButton;
	public static JPasswordField passwordTextField;
	public static JLabel enterPasswordMessage;
	public static JLabel wrongPasswordMessage;
	public static void setMainBackGroundImage() {
		mainBackground = new JLabel();
		mainBackground.setSize(712, 390);
		mainBackground.setLocation(0, 0);
		mainBackground.setLayout(null);
		MainApplication.protectedMainFrame.add(mainBackground);
		ImageIcon loginBckgroundIcon = new ImageIcon(MainApplication.class
				.getResource("/resources/login.png"));
		mainBackground.setIcon(loginBckgroundIcon);
		
		setLockCloseImage();
		setMainLoginScreen();
		setMainLoginButton();
		setMainCancelButton();
        setTextField();
        setPasswordMassege();
        enterPasswordShowAndHide();
        LoginAction.setCancelButtonAction();
        LoginAction.setLoginButtonAction();
        wrongPasswordMessage();
        loginByEnterKey();
	}


	public static void setLockCloseImage() {
		lockCloseImage = new JLabel();
		
		
		lockCloseImage.setLayout(null);
		ImageIcon lockBackgroundIcon = new ImageIcon(MainApplication.class
				.getResource("/resources/lockclose.png"));
		lockCloseImage.setIcon(lockBackgroundIcon);
		lockCloseImage.setSize(lockBackgroundIcon.getIconWidth(),lockBackgroundIcon.getIconHeight() );
		int x=MainApplication.protectedMainFrame.getWidth()/2-lockCloseImage.getWidth()/2;
		int y=20;
		lockCloseImage.setLocation(x, y);
		
		mainBackground.add(lockCloseImage);
		
		
	}
	public static void setMainLoginScreen() {
       loginImage = new JLabel();
		
		
		loginImage.setLayout(null);
		ImageIcon lockBackgroundIcon = new ImageIcon(MainApplication.class
	            .getResource("/resources/login2.png"));
		loginImage.setIcon(lockBackgroundIcon);
		loginImage.setSize(lockBackgroundIcon.getIconWidth(),lockBackgroundIcon.getIconHeight() );
		int x=MainApplication.protectedMainFrame.getWidth()/2-loginImage.getWidth()/2;
		int y=57+lockBackgroundIcon.getIconHeight();
		loginImage.setLocation(x, y);
		
		mainBackground.add(loginImage);	
		
	}
	public static void setMainLoginButton() {
		 loginButton = new JButton("login");
			
			loginButton.setLayout(null);
			loginButton.setSize(80,20);
			loginButton.setLocation(260,97);
			
			loginImage.add(loginButton);	
		
	}
	public static void setMainCancelButton() {
		 cancelButton = new JButton("cancel");
			
		 cancelButton.setLayout(null);
		 cancelButton.setSize(80,20);
		 cancelButton.setLocation(350,97);
			
			loginImage.add(cancelButton);	
		
	}

   public static void setTextField() {
	   passwordTextField =new JPasswordField();
	   passwordTextField.setSize(373, 28);
	   passwordTextField.setLocation(50,61);
	   passwordTextField.setBackground(new Color(204,204,204,255));
	   passwordTextField.setLayout(null);
	   passwordTextField.setBorder(null);
	   passwordTextField.setFont(new Font("Arial",Font.PLAIN, 25));
	   loginImage.add(passwordTextField);
   }
   public static void setPasswordMassege() {
	   enterPasswordMessage = new JLabel("Enter Password here......");
	   enterPasswordMessage.setSize(373,28);
	   passwordTextField.add(enterPasswordMessage);
   }
   public static void enterPasswordShowAndHide() {
	   passwordTextField.addKeyListener(new KeyListener() {
		@Override
		public void keyTyped(KeyEvent e) {
			showAndHide();	
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			showAndHide();
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			showAndHide();
		}
	   });
   }
   public static void showAndHide() {
	   char pass[] = passwordTextField.getPassword();
	   if(pass.length == 0) {
		   enterPasswordMessage.setVisible(true);
	   }else {
		   enterPasswordMessage.setVisible(false);
	   }
   }
   public static void wrongPasswordMessage() {
	   wrongPasswordMessage =new JLabel("wrong password");
	   wrongPasswordMessage.setSize(120,28);
	   wrongPasswordMessage.setVisible(false);
	   wrongPasswordMessage.setLocation(53,93);
	   loginImage.add(wrongPasswordMessage);
	   wrongPasswordMessage.setForeground(Color.PINK);
	   wrongPasswordMessage.setFont(new Font("Arial", Font.PLAIN, 13));
	   
   }
   public static void loginByEnterKey() {
	   passwordTextField.addKeyListener(new KeyListener() {
		   @Override
		   public void keyTyped(KeyEvent e) {
			
		   }
		   @Override
		   public void keyPressed(KeyEvent e) {
			   int code= e.getKeyCode();
				 if(code ==KeyEvent.VK_ENTER) {
					loginButton.doClick(); 
				 }  
		   }
		   @Override
		   public void keyReleased(KeyEvent e) {
			   
		   }
	   });
   }
}
