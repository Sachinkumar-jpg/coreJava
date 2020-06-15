package dialoguepanels ;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import action.FileExplorerThread;
import action.FilePanelDialogAction;
import util.RecentDataList;

public class FilePanelDialog {
	
	public JDialog filePanelDialog;
	public JLabel recentPanelHeading;
	public JLabel recentFilePanel;
	public JTable recentFileTable;
	public DefaultTableModel recentTableModel;
	
	
	public JLabel lockListPanel;
	public JTable lockFileTable;
	public DefaultTableModel lockListTableModel;
	
    public JButton addButton;
    public JButton removeButton;
    public JButton clearButton;
    public JButton okButton;
    public JButton cancelButton;
    
    public JTree fileSystemTree;
    
    public JLabel fileExplorerLabel;
	
    public FilePanelDialog() {
    	try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		} catch (ClassNotFoundException|InstantiationException|IllegalAccessException|UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
    	filePanelDialog=new JDialog();
    	filePanelDialog.setTitle("Add files and folders");
    	filePanelDialog.setSize(720,435);
    	Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x=dimension.width/2-filePanelDialog.getWidth()/2;
		int y=dimension.height/2-filePanelDialog.getHeight()/2;
    	filePanelDialog.setLocation(x,y);
    	filePanelDialog.setResizable(false);
    	filePanelDialog.setAlwaysOnTop(true);
    	//when open dialog box you don't nothing in background.
    	filePanelDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
    	filePanelDialog.setLayout(null);
    	
    	setRecentPanelHeading();
    	setRecentFilePanel();
    	setRecentFileTable();
    	populateRecentData();
    	
    	
    	setLockListPanelHeading();
    	setLockListPanel();
    	setLockFileTable();
    	
    	setAddButton();
    	FilePanelDialogAction.setAddButtonAction(this);
    	
    	setRemoveButton();
    	FilePanelDialogAction.setRemoveButtonAction(this);
    	
    	setClearButton();
    	FilePanelDialogAction.setClearButtonAction(this);
    	
    	setOkButton();
    	FilePanelDialogAction.setOkButtonAction(this);
    	setCancelButton();
    	FilePanelDialogAction.setCancelButtonAction(this);
    	
    	setFileExplorerLabel();
    	setFileSystem();
    	
    	
    	
    	filePanelDialog.setVisible(true);
    	
    }

	public void setRecentFilePanel() {
		recentFilePanel=new JLabel();
		recentFilePanel.setSize(250,100);
		recentFilePanel.setLocation(10,40);
		recentFilePanel.setBackground(new Color(250,255,255,255));
		recentFilePanel.setOpaque(true);
		recentFilePanel.setBorder(new LineBorder(new Color(10,10,10),1));
		
		filePanelDialog.add(recentFilePanel);
		
	}
	public void setRecentFileTable() {
		recentTableModel = new DefaultTableModel();
		recentTableModel.addColumn("recent files");
		
		 recentFileTable = new JTable(recentTableModel) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row,int column) {
				return false;
			}
		};
		JScrollPane scrollPane =new JScrollPane(recentFileTable);
		scrollPane.setLocation(3,3);
		scrollPane.setSize(244,94);
		scrollPane.setViewportBorder(new LineBorder(new Color(200,200,200),1));
		scrollPane.getViewport().setBackground(new Color(250,255,255,255));
		recentFilePanel.add(scrollPane);
		
		recentFileTable.setBackground(new Color(250,255,255,255));
		recentFileTable.setRowHeight(20);
		
		recentFileTable.setShowVerticalLines(false);
		recentFileTable.setFocusable(false);
		
		recentFileTable.getTableHeader().setReorderingAllowed(false);
		recentFileTable.getTableHeader().setBackground(new Color(250,255,255,255));
		recentFileTable.getTableHeader().setResizingAllowed(false);

	}
	public void populateRecentData() {
		for(String fileString : RecentDataList.getRecentFiles()) {
			recentTableModel.addRow(new Object[]{fileString});
		}
	}
	public void setLockListPanelHeading() {
	   recentPanelHeading = new JLabel("Recent Unlocked Files");
	   filePanelDialog.add(recentPanelHeading);
	   recentPanelHeading.setSize(200,30);
	   recentPanelHeading.setLocation(10,10);
   }
	
	public void setRecentPanelHeading() {
		   recentPanelHeading = new JLabel("Lock File Path");
		   filePanelDialog.add(recentPanelHeading);
		   recentPanelHeading.setSize(200,30);
		   recentPanelHeading.setLocation(420,10);
	   }
	public void setLockListPanel() {
		lockListPanel=new JLabel();
		lockListPanel.setSize(283,310);
		lockListPanel.setLocation(420,40);
		lockListPanel.setBackground(new Color(250,255,255,255));
		lockListPanel.setOpaque(true);
		lockListPanel.setBorder(new LineBorder(new Color(10,10,10),1));
		
		filePanelDialog.add(lockListPanel);
		
	}
	public void setLockFileTable() {
		lockListTableModel = new DefaultTableModel();
		lockListTableModel.addColumn("Locked files");
		
		 lockFileTable = new JTable(lockListTableModel) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row,int column) {
				return false;
			}
		};
		JScrollPane scrollPane =new JScrollPane(lockFileTable);
		scrollPane.setLocation(3,3);
		scrollPane.setSize(277,304);
		scrollPane.setViewportBorder(new LineBorder(new Color(200,200,200),1));
		scrollPane.getViewport().setBackground(new Color(250,255,255,255));
		lockListPanel.add(scrollPane);
		
		lockFileTable.setBackground(new Color(250,255,255,255));
		lockFileTable.setRowHeight(30);
		
		lockFileTable.setShowVerticalLines(false);
		lockFileTable.setFocusable(false);
		
		lockFileTable.getTableHeader().setReorderingAllowed(false);
		lockFileTable.getTableHeader().setBackground(new Color(250,255,255,255));
		lockFileTable.getTableHeader().setResizingAllowed(false);

	}
	
	public void setAddButton() {
		addButton = new JButton("ADD >>");
		addButton.setSize(100,35);
		addButton.setLocation(290,180);
		addButton.setBackground(new Color(250,255,255,255));
		addButton.setFocusable(false);
		addButton.setFont(new Font("Arial",Font.BOLD,16));
		filePanelDialog.add(addButton);
		
	}
	public void setRemoveButton() {
		removeButton = new JButton("REMOVE <<");
		removeButton.setSize(100,35);
		removeButton.setLocation(290,230);
		removeButton.setBackground(new Color(250,255,255,255));
		removeButton.setFocusable(false);
		removeButton.setFont(new Font("Arial",Font.BOLD,12));
		filePanelDialog.add(removeButton);
		
	}
	
	public void setClearButton() {
		clearButton = new JButton("CLEAR");
		clearButton.setSize(100,35);
		clearButton.setLocation(290,280);
		clearButton.setBackground(new Color(250,255,255,255));
		clearButton.setFocusable(false);
		clearButton.setFont(new Font("Arial",Font.BOLD,16));
		filePanelDialog.add(clearButton);
	}
	public void setOkButton() {
		okButton = new JButton("OK");
		okButton.setSize(100,35);
		okButton.setLocation(495,360);
		okButton.setBackground(new Color(250,255,255,255));
        okButton.setFocusable(false);
		okButton.setFont(new Font("Arial",Font.BOLD,18));
		filePanelDialog.add(okButton);
		
	}
	public void setCancelButton() {
		cancelButton = new JButton("CANCEL");
		cancelButton.setSize(100,35);
		cancelButton.setLocation(600,360);
		cancelButton.setBackground(new Color(250,255,255,255));
		cancelButton.setFocusable(false);
		cancelButton.setFont(new Font("Arial",Font.BOLD,16));
		filePanelDialog.add(cancelButton);
		
	}
	public void setFileExplorerLabel() {
		fileExplorerLabel = new JLabel();
		fileExplorerLabel.setSize(250,200);
		fileExplorerLabel.setLocation(10,150);
		fileExplorerLabel.setBackground(new Color(250,255,255,255));
		fileExplorerLabel.setOpaque(true);
		fileExplorerLabel.setBorder(new LineBorder(new Color(10,10,10),1));
		filePanelDialog.add(fileExplorerLabel);
	}
	public void setFileSystem() {
		FileExplorerThread fileExplorerThread = new FileExplorerThread(this);
		fileExplorerThread.start();
	}
}
