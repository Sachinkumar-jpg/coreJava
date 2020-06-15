package util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafiles.MainPage;
import model.LockedListModel;

public class LockedFilesDataList {

	public static List<String> lockedFiles = new ArrayList<>() ;
	
	public static void appendLockedFiles(List<String> files) {
		if(files.size() == 0) {
		return;
		}
		lockedFiles.addAll(files);
		FileOperations.saveLockedListData(lockedFiles);
	}
	
	public static void  populateLockedFileData() {
		try {
			LockedListModel lockedListModel = FileOperations.getLockedListData();
			if(lockedListModel ==null ||lockedListModel.getLockedList() == null ||lockedListModel.getLockedList().size()==0) {
				return;
			}
			lockedFiles.addAll(lockedListModel.getLockedList());
			for(String data:lockedFiles) {
				MainPage.tableModel.addRow(new Object[] {data, "Active"});
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void removeLockedFiles(List<String> files) {
		if(files.size() == 0) {
		return;
		}
		lockedFiles.removeAll(files);
		FileOperations.saveLockedListData(lockedFiles);
	}
	
}
