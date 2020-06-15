package model;

import java.io.Serializable;
import java.util.List;

public class RecentListModel implements Serializable{
	private static final long serialVersionUID = 2L;
	
	List<String> recentList;
	public RecentListModel() {
		
	}
	public RecentListModel(List<String> recentList) {
		this.recentList = recentList;
	}
	public List<String> getRecentList(){
		return recentList;
	}
	public void setRecentList(List<String> recentList) {
		this.recentList = recentList;
	}

}
