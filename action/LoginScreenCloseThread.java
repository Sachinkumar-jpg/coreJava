package action;

import javafiles.LoginBackGround;
import javafiles.MainPage;

public class LoginScreenCloseThread extends Thread{
	@Override
	public void run() {
		 for(int i=715;i>=1;i--) {
			  try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  LoginBackGround.mainBackground.setLocation(i,0);
		  }
		  MainPage.mainGround.setVisible(false);
		  try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		  System.exit(0);
	}
	

}
