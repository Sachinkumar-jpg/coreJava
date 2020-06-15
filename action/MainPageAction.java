package action;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import dialoguepanels.FilePanelDialog;
import dialoguepanels.RegistrationDialog;
import dialoguepanels.ResetPasswordDialog;
import javafiles.MainPage;
import util.ArrayManipulation;
import util.FileOperations;
import util.LockedFilesDataList;
import util.RecentDataList;
import util.UrlOpener;

public class MainPageAction {
	public static void setAddButtonAction() {
		MainPage.addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new FilePanelDialog();
			}
		});
	}
	public static Boolean isRowAlreadyExit(String rowValue) {
		@SuppressWarnings({ "rawtypes", "unchecked" })
		Vector<Vector> data = MainPage.tableModel.getDataVector();
		for(Vector<?> vectorValue :data) {
			if(vectorValue.get(0).equals(rowValue))
				return true;
			
		}
		return false;
	}
	public static void setUnlockButtonAction() {
		MainPage.unlockButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int[] rowIndex = MainPage.table.getSelectedRows();
				List<String> dataList = new ArrayList<>();
				if(rowIndex.length == 0) {
					return;
				}
				ArrayManipulation.reverseArray(rowIndex);
				
				for(int rowNumber : rowIndex) {
					String value = (String) MainPage.table.getValueAt(rowNumber, 0);
					if(FileOperations.unhideFileFromSystem(value)) {
						dataList.add(value);
						MainPage.tableModel.removeRow(rowNumber);
					}
				}
				RecentDataList.appendRecentFiles(dataList);
				LockedFilesDataList.removeLockedFiles(dataList);
			}
		});
	}
	public static void setInnerButton() {
		MainPage.innerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OpenPopupMenu();
			}
		});
	}
	public static void OpenPopupMenu() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException|InstantiationException|IllegalAccessException|UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		JPopupMenu popupMenu = new JPopupMenu();
		
		for(String itemValue : RecentDataList.getRecentFiles()) {
			JMenuItem item = new JMenuItem(itemValue);
			popupMenu.add(item);
			item.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
						if(FileOperations.isValidFile(itemValue)) {
						if(!MainPageAction.isRowAlreadyExit(itemValue)) {
						if(FileOperations.hideFileFromSystem(itemValue)) {
							MainPage.tableModel.addRow(new Object[]{itemValue, "Active"});
							List<String> temp = new ArrayList<>();
							temp.add(itemValue);
							LockedFilesDataList.appendLockedFiles(temp);

						}
						  }
						}
					}
			});
		}
		popupMenu.show(MainPage.innerButton,10,33);

		
	}
	public static void setExitButtonAction() {
		MainPage.exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginScreenCloseThread thread = new LoginScreenCloseThread();
				thread.start();
			}
		});
	}
	public static void setOptionButtonAction() {
		MainPage.optionButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ResetPasswordDialog();
			}
		});
	}
	public static void setSupporButtonAction() {
		MainPage.supportButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UrlOpener.openWebPage("https://www.google.co.in");
			}
		});
	}
	public static void setRegistrationButtonAction() {
		MainPage.registerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new RegistrationDialog();
			}
		});
		
	}


}
