package tree;

import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;

public class SimpleTreeFrame extends JFrame{
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 400;

    public SimpleTreeFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("World");
        DefaultMutableTreeNode country = new DefaultMutableTreeNode("USA");
        root.add(country);
        DefaultMutableTreeNode state = new DefaultMutableTreeNode("California");
        country.add(state);
        DefaultMutableTreeNode city = new DefaultMutableTreeNode("San Jose");
        state.add(city);
        city = new DefaultMutableTreeNode("Cupertino");
        state.add(city);
        state = new DefaultMutableTreeNode("Michigan");
        country.add(state);
        city = new DefaultMutableTreeNode("Ann Arbor");
        state.add(city);
        country = new DefaultMutableTreeNode("German");
        root.add(country);
        state = new DefaultMutableTreeNode("Schleswig-Holstein");
        country.add(state);
        city = new DefaultMutableTreeNode("Kiel");
        city.setAllowsChildren(false);
        state.add(city);

        JTree tree = new JTree(root, true);
        // tree.putClientProperty("JTree.lineStyle", "None");
        tree.putClientProperty("JTree.lineStyle", "Angled");
        tree.setShowsRootHandles(true);
        tree.setRootVisible(false);
        add(new JScrollPane(tree));
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            SimpleTreeFrame frame = new SimpleTreeFrame();
            frame.setTitle("树");
            frame.setVisible(true);
        });
    }
}
