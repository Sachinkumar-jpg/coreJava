package action;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import dialoguepanels.FilePanelDialog;
import javafiles.MainPage;
import util.ArrayManipulation;
import util.FileExplorer;
import util.FileOperations;
import util.LockedFilesDataList;

public class FilePanelDialogAction {
	public static void setAddButtonAction(FilePanelDialog dialogObject) {
		dialogObject.addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//get select files from recent files
				int[] selectedRows = dialogObject.recentFileTable.getSelectedRows();
				for(int rowNumber : selectedRows) {
					String rowValue = (String) dialogObject.recentFileTable.getValueAt(rowNumber,0);
					if(FileOperations.isValidFile(rowValue)) {
						if(!isRowAlreadyExits(rowValue,dialogObject)) {
						  
						     dialogObject.lockListTableModel.addRow(new Object[]{rowValue});
					    }
					
					}
				}
				//get selected files from file Explorer
				String filePath = FileExplorer.getSelectedFiles();
				if(FileOperations.isValidFile(filePath)) {
				if(!isRowAlreadyExits(filePath,dialogObject)) {
					dialogObject.lockListTableModel.addRow(new Object[]{filePath});
				   }
				}
				
			}
		});
	}
	public static Boolean isRowAlreadyExits(String rowValue,FilePanelDialog dialogObject) {
		@SuppressWarnings({ "rawtypes", "unchecked" })
		Vector<Vector> data = dialogObject.lockListTableModel.getDataVector();
		for(Vector<?> vectorValue :data) {
			if(vectorValue.get(0).equals(rowValue))
				return true;
			
		}
		return false;
	}

	public static void setRemoveButtonAction(FilePanelDialog dialogObject) {
		dialogObject.removeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int[] rowIndex = dialogObject.lockFileTable.getSelectedRows();
				if(rowIndex.length == 0) {
					return;
				}
				ArrayManipulation.reverseArray(rowIndex);
				
				for(int rowNumber : rowIndex) {
					dialogObject.lockListTableModel.removeRow(rowNumber);
				}
			}
		});
		
	}
	public static void setClearButtonAction(FilePanelDialog dialogObject) {
		dialogObject.clearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialogObject.recentFileTable.clearSelection();
				dialogObject.lockFileTable.clearSelection();
				if(dialogObject.fileSystemTree != null) {
				FileExplorer.clearSelection(dialogObject.fileSystemTree);
					
			   }
				
			}
		});
		
		
	}
	
	public static void setCancelButtonAction(FilePanelDialog dialogObject) {
		dialogObject.cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialogObject.filePanelDialog.dispose();
			}
		});
		
	}
	public static void setOkButtonAction(FilePanelDialog dialogObject) {
		dialogObject.okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings({ "rawtypes", "unchecked" })
				Vector<Vector> dataVector = dialogObject.lockListTableModel.getDataVector();
				List<String> files = new ArrayList<>();
				for(Vector<?> data : dataVector) {
					String str = data.get(0).toString();
					if(!MainPageAction.isRowAlreadyExit(str)) {
					if(FileOperations.hideFileFromSystem(str)) {
						MainPage.tableModel.addRow(new Object[]{str, "Active"});
						files.add(str);
					}
					}
				}
				LockedFilesDataList.appendLockedFiles(files);
				dialogObject.filePanelDialog.dispose();
				
			}
		});
		
	}
}
