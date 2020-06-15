package javafiles;

import java.awt.*;  

import javax.swing.*;

import util.FileOperations;
import util.LockedFilesDataList;
import util.RecentDataList;

public class MainApplication {
	public static JFrame protectedMainFrame;
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		protectedMainFrame= new JFrame("protected folder");
		protectedMainFrame.setSize(720, 422);
		protectedMainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		protectedMainFrame.setLayout(null);
		protectedMainFrame.setResizable(false);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x=dimension.width/2-protectedMainFrame.getWidth()/2;
		int y=dimension.height/2-protectedMainFrame.getHeight()/2;
		protectedMainFrame.setLocation(x,y);
		
		//set login background
		LoginBackGround.setMainBackGroundImage();
		
		//set main page
		MainPage.setMainPage();
		
		
		//Check app directory
		FileOperations.checkDirectory();
		
		//Populate recent file data
		RecentDataList.populateRecentFileData();
		
		//populate Locked Files Data into main page table
		LockedFilesDataList.populateLockedFileData();
		
		
		
		
		//new FilePanelDialog();
		//new ResetPasswordDialog();
		//new RegistrationDialog();
		protectedMainFrame.setVisible(true);
		
	}

}
