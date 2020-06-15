package action;

import javax.swing.JScrollPane;
import javax.swing.JTree;

import dialoguepanels.FilePanelDialog;
import util.FileExplorer;

public class FileExplorerThread extends Thread{
	public FilePanelDialog filePanelDialog;
	
	public FileExplorerThread(FilePanelDialog filePanelDialog) {
		this.filePanelDialog = filePanelDialog;
	}
	@Override
	public void run() {
		setFileSystem();
	}
	public void setFileSystem() {
		JScrollPane jScrollPanel = FileExplorer.getFileExplorerScrollPanel();
		filePanelDialog.fileExplorerLabel.add(jScrollPanel);
		jScrollPanel.setSize(250,200);
		jScrollPanel.setLocation(0,0);
		filePanelDialog.fileExplorerLabel.validate();
		
		JTree tree = (JTree) jScrollPanel.getViewport().getView();
		filePanelDialog.fileSystemTree = tree;
		FileExplorer.clearSelection(filePanelDialog.fileSystemTree);
	}

}
