package util;

import javax.swing.*;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeWillExpandListener;
import javax.swing.filechooser.FileSystemView;
import javax.swing.tree.*;
import java.awt.*;
import java.io.File;
import java.util.Enumeration;

class FileBrowserModel {

    private FileSystemView fileSystemView;


    public FileBrowserModel() {
        this.fileSystemView = FileSystemView.getFileSystemView();
    }

    public DefaultTreeModel createTreeModel() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode();

        for (File file : File.listRoots()){
            /*if(file.getPath().contains("C:")){
                continue;
            }*/
            File[] driveFiles = fileSystemView.getFiles(file, false);
            if (driveFiles.length == 0){
                continue;
            }
            root.add(new DefaultMutableTreeNode(new FileNode1(driveFiles[0].getParentFile())));
        }
        addChildNodes(root);
        addGrandchildNodes(root);

        return new DefaultTreeModel(root);
    }

    public void addGrandchildNodes(DefaultMutableTreeNode root) {
        Enumeration<?> enumeration = root.children();
        while (enumeration.hasMoreElements()) {
            DefaultMutableTreeNode node =
                    (DefaultMutableTreeNode) enumeration.nextElement();
            addChildNodes(node);
        }
    }

    private void addChildNodes(DefaultMutableTreeNode root) {
        Enumeration<?> enumeration = root.children();
        while (enumeration.hasMoreElements()) {
            DefaultMutableTreeNode node =
                    (DefaultMutableTreeNode) enumeration.nextElement();
            FileNode1 fileNode = (FileNode1) node.getUserObject();
            File file = fileNode.getFile();
            /*if (!drives.contains(file.getName())){
                continue;
            }*/
            if (file.isDirectory()) {
                for (File child : file.listFiles()) {
                    node.add(new DefaultMutableTreeNode(
                            new FileNode1(child)));
                }
            }
        }
    }

    public FileSystemView getFileSystemView() {
        return fileSystemView;
    }

    public Icon getFileIcon(File file) {
        return fileSystemView.getSystemIcon(file);
    }

    public String getFileText(File file) {
        return fileSystemView.getSystemDisplayName(file);
    }

}



class FileNode1 {

    private boolean generateGrandchildren;

    private File file;

    public FileNode1(File file) {
        this.file = file;
        this.generateGrandchildren = true;
    }

    public File getFile() {
        return file;
    }

    public boolean isGenerateGrandchildren() {
        return generateGrandchildren;
    }

    public void setGenerateGrandchildren(boolean generateGrandchildren) {
        this.generateGrandchildren = generateGrandchildren;
    }

    @Override
    public String toString() {
        String name = file.getName();
        if (name.equals("")) {
            return file.getAbsolutePath();
        } else {
            return name;
        }
    }
}


public class FileExplorer {

    private FileBrowserModel model;

    private JFrame frame;

    //private JPanel mainPanel;

    private TreeScrollPane treeScrollPane;

    public FileExplorer() {
        model = new FileBrowserModel();
        setLookAndFeel();
        createPartControl();
    }

    private void createPartControl() {
        createMainPanel();
    }

    private void createMainPanel() {
        treeScrollPane = new TreeScrollPane(this, model);
    }

    public static JScrollPane getFileExplorerScrollPanel(){
        FileExplorer fileBrowserFrame = new FileExplorer();
        return fileBrowserFrame.treeScrollPane.getScrollPane();
    }
    
    public static String getSelectedFiles() {
    	return FileSelectionListener.getPath();
    }
    
   

    public void exitProcedure() {
        frame.dispose();
        System.exit(0);
    }

    public void updateFileDetail(FileNode1 fileNode) {
        /*fileDetailPanel.setFileNode(fileNode, model);*/
    }

    public void setDefaultTableModel(DefaultMutableTreeNode node) {

    }

    public void clearDefaultTableModel() {
        /*tableScrollPane.clearDefaultTableModel();*/
    }

    public void setDesktopButtonFileNode(FileNode1 fileNode) {
       /*desktopButtonPanel.setFileNode(fileNode);*/
    }

    private void setLookAndFeel() {
        try {
            // Significantly improves the look of the output in
            // terms of the file names returned by FileSystemView!
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch(Exception weTried) {
            weTried.printStackTrace();
        }
    }

	public static void clearSelection(JTree tree) {
		
		    	tree.clearSelection();
		    	FileSelectionListener.fileNode = null;
		    
		
	}

}

class TreeScrollPane {

    private FileExplorer frame;

    private FileBrowserModel model;

    private JScrollPane scrollPane;

    private JTree tree;

    public TreeScrollPane(FileExplorer frame,
                          FileBrowserModel model) {
        this.frame = frame;
        this.model = model;
        createPartControl();
    }

    private void createPartControl() {
        tree = new JTree(model.createTreeModel());
        tree.addTreeSelectionListener(
                new FileSelectionListener(frame, model));
        tree.addTreeWillExpandListener(
                new TreeExpandListener(model));
        //tree.expandRow(1);
        tree.setRootVisible(true);
        tree.setCellRenderer(new FileTreeCellRenderer(model));
        tree.setShowsRootHandles(true);
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

        scrollPane = new JScrollPane(tree);

        Dimension preferredSize = scrollPane.getPreferredSize();
        Dimension widePreferred = new Dimension(
                300, (int) preferredSize.getHeight());
        scrollPane.setPreferredSize( widePreferred );
    }

    public JTree getTree() {
        return tree;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

}

class FileSelectionListener implements TreeSelectionListener {

    private FileExplorer frame;

    private FileBrowserModel model;

    static  FileNode1 fileNode;

    public FileSelectionListener(FileExplorer frame,
                                 FileBrowserModel model) {
        this.frame = frame;
        this.model = model;
    }

    @Override
    public void valueChanged(TreeSelectionEvent event) {
        DefaultMutableTreeNode node =
                (DefaultMutableTreeNode)
                        event.getPath().getLastPathComponent();
        fileNode = (FileNode1) node.getUserObject();

        AddNodes addNodes = new AddNodes(model, node);
        new Thread(addNodes).start();
        if(fileNode == null){
            return;
        }
        File file = fileNode.getFile();
        frame.updateFileDetail(fileNode);
        frame.setDesktopButtonFileNode(fileNode);
        if (file.isDirectory()) {
            frame.setDefaultTableModel(node);
        } else {
            frame.clearDefaultTableModel();
        }
    }

    public static String getPath()
    {   
    	if(fileNode   == null) {
    		return null;
    	}
        return fileNode.getFile().getAbsolutePath();
    }

}



class TreeExpandListener implements TreeWillExpandListener {

    private FileBrowserModel model;

    public TreeExpandListener(FileBrowserModel model) {
        this.model = model;
    }

    @Override
    public void treeWillCollapse(TreeExpansionEvent event)
            throws ExpandVetoException {
    }

    @Override
    public void treeWillExpand(TreeExpansionEvent event)
            throws ExpandVetoException {
        TreePath path = event.getPath();
        DefaultMutableTreeNode node =
                (DefaultMutableTreeNode) path.getLastPathComponent();

        AddNodes addNodes = new AddNodes(model, node);
        new Thread(addNodes).start();
    }

}


class FileTreeCellRenderer implements TreeCellRenderer {

    private FileBrowserModel model;

    private JLabel label;

    public FileTreeCellRenderer(FileBrowserModel model) {
        this.model = model;
        this.label = new JLabel(" ");
        label.setOpaque(true);
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree,
                                                  Object value, boolean selected, boolean expanded,
                                                  boolean leaf, int row, boolean hasFocus) {

        DefaultMutableTreeNode node =
                (DefaultMutableTreeNode) value;
        FileNode1 fileNode = (FileNode1) node.getUserObject();
        if (fileNode != null) {
            File file = fileNode.getFile();
            label.setIcon(model.getFileIcon(file));
            label.setText(model.getFileText(file));
        } else {
            label.setText(value.toString());
        }

        if (selected) {
            label.setBackground(Color.BLUE);
            label.setForeground(Color.WHITE);
        } else {
            label.setBackground(Color.WHITE);
            label.setForeground(Color.BLACK);
        }

        return label;
    }

}

class AddNodes implements Runnable {

    private DefaultMutableTreeNode node;

    private FileBrowserModel model;

    public AddNodes(FileBrowserModel model, DefaultMutableTreeNode node) {
        this.model = model;
        this.node = node;
    }

    @Override
    public void run() {
        FileNode1 fileNode1 = (FileNode1) node.getUserObject();
        if(fileNode1 == null){
            return;
        }
        if (fileNode1.isGenerateGrandchildren()) {
            model.addGrandchildNodes(node);
            fileNode1.setGenerateGrandchildren(false);
        }
    }

}