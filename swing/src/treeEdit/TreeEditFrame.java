package treeEdit;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;

public class TreeEditFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    private DefaultTreeModel model;
    private JTree tree;

    public TreeEditFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        TreeNode root = makeSampleTree();
        model = new DefaultTreeModel(root);
        tree = new JTree(model);
        tree.setEditable(true);

        JScrollPane scrollPane = new JScrollPane(tree);
        add(scrollPane, BorderLayout.CENTER);

        makeButtons();
    }

    public TreeNode makeSampleTree() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("世界");
        DefaultMutableTreeNode country = new DefaultMutableTreeNode("中国");
        root.add(country);
        DefaultMutableTreeNode state = new DefaultMutableTreeNode("山东");
        country.add(state);
        DefaultMutableTreeNode city = new DefaultMutableTreeNode("济南");
        state.add(city);
        city = new DefaultMutableTreeNode("青岛");
        state.add(city);
        city = new DefaultMutableTreeNode("枣庄");
        state.add(city);
        city = new DefaultMutableTreeNode("济宁");
        state.add(city);
        country = new DefaultMutableTreeNode("美国");
        root.add(country);
        state = new DefaultMutableTreeNode("加利福尼亚");
        country.add(state);
        city = new DefaultMutableTreeNode("San Jose");
        state.add(city);
        return root;
    }

    public void makeButtons() {
        JPanel panel = new JPanel();
        JButton addSiblingButton = new JButton("Add Sibling");
        addSiblingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode)tree
                        .getLastSelectedPathComponent();

                if (selectedNode == null)   return;

                DefaultMutableTreeNode parent = (DefaultMutableTreeNode)selectedNode.getParent();

                if (parent == null)  return;

                DefaultMutableTreeNode newNode = new DefaultMutableTreeNode("New");

                int selectedIndex = parent.getIndex(selectedNode);
                model.insertNodeInto(newNode, parent, selectedIndex + 1);

                TreeNode[] nodes = model.getPathToRoot(newNode);
                TreePath path = new TreePath(nodes);
                tree.scrollPathToVisible(path);
            }
        });
        panel.add(addSiblingButton);

        JButton addChildButton = new JButton("Add Child");
        addChildButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultMutableTreeNode selectNode = (DefaultMutableTreeNode)tree
                        .getLastSelectedPathComponent();
                if (selectNode == null)  return;

                DefaultMutableTreeNode newNode = new DefaultMutableTreeNode("New");
                model.insertNodeInto(newNode, selectNode, selectNode.getChildCount());

                TreeNode[] nodes = model.getPathToRoot(newNode);
                TreePath path = new TreePath(nodes);
                tree.scrollPathToVisible(path);
            }
        });
        panel.add(addChildButton);

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultMutableTreeNode selectNode = (DefaultMutableTreeNode)tree
                        .getLastSelectedPathComponent();
                if (selectNode != null && selectNode.getParent() != null) {
                    model.removeNodeFromParent(selectNode);
                }
            }
        });
        panel.add(deleteButton);

        add(panel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            TreeEditFrame frame = new TreeEditFrame();
            frame.setTitle("可编辑树");
            frame.setVisible(true);
        });
    }
}
