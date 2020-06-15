package action;
import javafiles.LoginBackGround;

import util.FileOperations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginAction {
	public static void setCancelButtonAction() {
		LoginBackGround.cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	public static void setLoginButtonAction() {
		LoginBackGround.loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				char passwordArray[] = LoginBackGround.passwordTextField.getPassword();
				String password = String.valueOf(passwordArray);
				if(password.equals(FileOperations.getPasswordFromFileForLogin())){
					scrollLoginScreen();
					LoginBackGround.wrongPasswordMessage.setVisible(false);
					
				}else {
					LoginBackGround.wrongPasswordMessage.setVisible(true);
				}
			}

			
		});
	}
	public static void scrollLoginScreen() {
		// TODO Auto-generated method stub
		LoginScreenOpenThread loginScreenOpenThread = new LoginScreenOpenThread();
		loginScreenOpenThread.start();
	}
	

}
