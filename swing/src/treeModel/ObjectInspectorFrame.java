package treeModel;

import java.awt.*;
import javax.swing.*;

public class ObjectInspectorFrame extends JFrame {
    private JTree tree;
    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 300;

    public ObjectInspectorFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        Variable v = new Variable(getClass(), "this",  this);
        ObjectTreeModel model = new ObjectTreeModel();
        model.setRoot(v);

        tree = new JTree(model);
        add(new JScrollPane(tree), BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            ObjectInspectorFrame frame = new ObjectInspectorFrame();
            frame.setTitle("对象监视树");
            frame.setVisible(true);
        });
    }
}
