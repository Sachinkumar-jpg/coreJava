package action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dialoguepanels.ResetPasswordDialog;
import util.FileOperations;

public class ResetPasswordDialogAction {
	public static void setApplyButtonAction(ResetPasswordDialog resetPasswordDialogObject) {
		resetPasswordDialogObject.applyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String currentPassword =resetPasswordDialogObject.currentPasswordLabelTextField.getText(); 
			    String newPassword = resetPasswordDialogObject.newPasswordLabelTextField.getText(); 
				String confirmPassword = resetPasswordDialogObject.confirmPasswordLabelTextField.getText(); 
				if(currentPassword == null ||newPassword == null||confirmPassword == null||
						currentPassword.trim().isEmpty()||newPassword.trim().isEmpty()||confirmPassword.trim().isEmpty()) {
					resetPasswordDialogObject.warnMessage.setText("Please do not leave any text field empty");
				}else if(!newPassword.equals(confirmPassword)) {
					resetPasswordDialogObject.warnMessage.setText("new and confirm password does not match");
				}else if(currentPassword.equals(newPassword)||currentPassword.equals(confirmPassword)){
					resetPasswordDialogObject.warnMessage.setText("current and new password can not be same");
				}else if(!currentPassword.equals(FileOperations.getPasswordFromFileForLogin())) {
					resetPasswordDialogObject.warnMessage.setText("current password is incorrect");
				}else {
					FileOperations.savePasswordInFile(newPassword);
					resetPasswordDialogObject.warnMessage.setText("");
					resetPasswordDialogObject.resetPasswordDialog.dispose();
				}
					
				}
				
		});
	}

}
