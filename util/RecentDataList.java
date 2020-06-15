package util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.RecentListModel;

public class RecentDataList { 
	
	public static List<String> recentFiles = new ArrayList<String>();
	
	public static List<String> getRecentFiles(){
		return ArrayManipulation.listRevers(recentFiles);
	}
	
	public static void populateRecentFileData() {
		try {
			RecentListModel recentListModel = FileOperations.getRecentListData();
			if(recentListModel == null ||recentListModel.getRecentList() == null ||recentListModel.getRecentList().size()==0) {
				return;
			}
			recentFiles.addAll(recentListModel.getRecentList());
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void appendRecentFiles(List<String> files) {
		if(files.size() == 0) {
		return;
		}
		recentFiles.removeAll(files);
		recentFiles.addAll(files);
		if(recentFiles.size()>4) {
			List<String> temp = recentFiles.subList(0, recentFiles.size()-4);
			recentFiles.removeAll(temp);
		}
		FileOperations.saveRecentListData(recentFiles);
	}


}
