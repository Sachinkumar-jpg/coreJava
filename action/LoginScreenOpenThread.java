package action;

import javafiles.LoginBackGround;
import javafiles.MainPage;

public class LoginScreenOpenThread extends Thread{
   @Override
   public void run() {
	   MainPage.mainGround.setVisible(true);
	  for(int i=0;i<715;i++) {
		  try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		  LoginBackGround.mainBackground.setLocation(i,0);
	  }
	 
   }
}
