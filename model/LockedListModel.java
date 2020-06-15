package model;

import java.io.Serializable;
import java.util.List;

public class LockedListModel implements Serializable {
	private static final long serialVersionUID = 2L;
	List<String> lockedList;
	
	public LockedListModel(List<String> lockedList) {
		this.lockedList = lockedList;
	}
	public LockedListModel() {
		
	}
	public List<String> getLockedList(){
		return lockedList;
	}
	public void setLockedList(List<String> lockedList) {
		this.lockedList = lockedList;
	}

}
