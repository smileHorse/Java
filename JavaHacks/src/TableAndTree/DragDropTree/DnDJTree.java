package TableAndTree.DragDropTree;

import sun.plugin.javascript.JSClassLoader;

import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.*;
import java.io.IOException;

public class DnDJTree extends JTree implements DragSourceListener, DropTargetListener, DragGestureListener {
    static DataFlavor localObjectFlavor;
    static {
        try {
            localObjectFlavor = new DataFlavor(DataFlavor.javaJVMLocalObjectMimeType);
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
    }
    static DataFlavor[] supportedFlavors = { localObjectFlavor };
    DragSource dragSource;
    DropTarget dropTarget;
    TreeNode dropTargetNode = null;
    TreeNode draggedNode = null;

    public DnDJTree() {
        super();
        setCellRenderer(new DndTreeCellRenderer());
        setModel(new DefaultTreeModel(new DefaultMutableTreeNode("default")));
        dragSource = new DragSource();
        DragGestureRecognizer dgr = dragSource.createDefaultDragGestureRecognizer(this, DnDConstants.ACTION_MOVE,
                this);
        dropTarget = new DropTarget(this, this);
    }

    // DragGestureListener
    @Override
    public void dragGestureRecognized(DragGestureEvent dge) {
        System.out.println("dragGestureRecognized");
        // find object at this x,y
        Point clickPoint = dge.getDragOrigin();
        TreePath path = getPathForLocation(clickPoint.x, clickPoint.y);
        if (path == null) {
            System.out.println("not on a node");
            return;
        }
        draggedNode = (TreeNode)path.getLastPathComponent();
        Transferable trans = new RJLTransferable(draggedNode);
        dragSource.startDrag(dge, Cursor.getDefaultCursor(), trans, this);
    }

    // DragSourceListener events
    @Override
    public void dragDropEnd(DragSourceDropEvent dsde) {
        System.out.println("dragDropEnd()");
        dropTargetNode = null;
        draggedNode = null;
        repaint();
    }

    @Override
    public void dragEnter(DragSourceDragEvent dsde) {

    }

    @Override
    public void dragExit(DragSourceEvent dse) {

    }

    @Override
    public void dragOver(DragSourceDragEvent dsde) {

    }

    @Override
    public void dropActionChanged(DragSourceDragEvent dsde) {

    }

    // DropTargetListener events
    @Override
    public void dragEnter(DropTargetDragEvent dtde) {
        System.out.println("dragEnter");
        dtde.acceptDrag(DnDConstants.ACTION_COPY_OR_MOVE);
        System.out.println("accepted dragEnter");
    }

    @Override
    public void dragExit(DropTargetEvent dte) {

    }

    @Override
    public void dragOver(DropTargetDragEvent dtde) {
        // figure out which cell it's over, no drag to self
        Point dragPoint = dtde.getLocation();
        TreePath path = getPathForLocation(dragPoint.x, dragPoint.y);
        if (path == null) {
            dropTargetNode = null;
        } else {
            dropTargetNode = (TreeNode)path.getLastPathComponent();
        }
        repaint();
    }

    @Override
    public void drop(DropTargetDropEvent dtde) {
        System.out.println("drop()!");
        Point dropPoint = dtde.getLocation();
        TreePath path = getPathForLocation(dropPoint.x, dropPoint.y);
        System.out.println("drop path is " + path);
        boolean dropped = false;
        try {
            dtde.acceptDrop(DnDConstants.ACTION_MOVE);
            System.out.println("accepted");
            Object droppedObject = dtde.getTransferable().getTransferData(localObjectFlavor);
            MutableTreeNode droppedNode = null;
            if (droppedObject instanceof MutableTreeNode) {
                // remove from old location
                droppedNode = (MutableTreeNode)droppedObject;
                ((DefaultTreeModel)getModel()).removeNodeFromParent(droppedNode);
            } else {
                droppedNode = new DefaultMutableTreeNode(droppedObject);
            }
            // insert into spec'd path. if dropped into a parent make it last child of that parent
            DefaultMutableTreeNode dropNode = (DefaultMutableTreeNode)path.getLastPathComponent();
            if (dropNode.isLeaf()) {
                DefaultMutableTreeNode parent = (DefaultMutableTreeNode)dropNode.getParent();
                int index = parent.getIndex(dropNode);
                ((DefaultTreeModel)getModel()).insertNodeInto(droppedNode, parent, index);
            } else {
                ((DefaultTreeModel)getModel()).insertNodeInto(droppedNode, dropNode, dropNode.getChildCount());
            }
            dropped = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        dtde.dropComplete(dropped);
    }

    @Override
    public void dropActionChanged(DropTargetDragEvent dtde) {

    }

    class RJLTransferable implements Transferable {
        Object object;
        public RJLTransferable(Object o) {
            object = o;
        }

        @Override
        public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
            if (isDataFlavorSupported(flavor)) {
                return object;
            } else {
                throw new UnsupportedFlavorException(flavor);
            }
        }

        @Override
        public boolean isDataFlavorSupported(DataFlavor flavor) {
            return (flavor.equals(localObjectFlavor));
        }

        @Override
        public DataFlavor[] getTransferDataFlavors() {
            return supportedFlavors;
        }
    }

    class DndTreeCellRenderer extends DefaultTreeCellRenderer {
        boolean isTargetNode;
        boolean isTargetNodeLeaf;
        boolean isLastItem;
        int BOTTOM_PAD = 30;

        public DndTreeCellRenderer() {
            super();
        }

        @Override
        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded,
                                                      boolean leaf, int row, boolean hasFocus) {
            isTargetNode = (value == dropTargetNode);
            isTargetNodeLeaf = (isTargetNode && ((TreeNode)value).isLeaf());
            boolean showSelected = sel & (dropTargetNode == null);
            return super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
        }

        @Override
        public void paintComponents(Graphics g) {
            super.paintComponents(g);
            if (isTargetNode) {
                g.setColor(Color.black);
                if (isTargetNodeLeaf) {
                    g.drawLine(0, 0, getSize().width, 0);
                } else {
                    g.drawRect(0, 0, getSize().width - 1, getSize().height - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        JTree tree = new DnDJTree();
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("People");
        DefaultMutableTreeNode set1 = new DefaultMutableTreeNode("Set1");
        DefaultMutableTreeNode set2 = new DefaultMutableTreeNode("Set2");
        DefaultMutableTreeNode set3 = new DefaultMutableTreeNode("Set3");
        set1.add(new DefaultMutableTreeNode("Chris"));
        set1.add (new DefaultMutableTreeNode ("Kelly"));
        set1.add (new DefaultMutableTreeNode ("Keagan"));
        set2.add (new DefaultMutableTreeNode ("Joshua"));
        set2.add (new DefaultMutableTreeNode ("Kimi"));
        set3.add (new DefaultMutableTreeNode ("Michael"));
        set3.add (new DefaultMutableTreeNode ("Don"));
        set3.add (new DefaultMutableTreeNode ("Daniel"));
        root.add (set1);
        root.add (set2);
        set2.add (set3);
        DefaultTreeModel model = new DefaultTreeModel(root);
        tree.setModel(model);
        for (int i = 0; i < tree.getRowCount(); ++i) {
            tree.expandRow(i);
        }

        JScrollPane scrollPane = new JScrollPane(tree, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        JFrame frame = new JFrame("Dnd tree");
        frame.getContentPane().add(scrollPane);
        frame.pack();
        frame.setVisible(true);
    }
}
