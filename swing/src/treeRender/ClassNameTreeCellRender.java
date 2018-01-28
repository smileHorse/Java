package treeRender;

import java.awt.*;
import java.lang.reflect.*;
import javax.swing.*;
import javax.swing.tree.*;

public class ClassNameTreeCellRender extends DefaultTreeCellRenderer {
    private Font plainFont = null;
    private Font italicFont = null;

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded,
                                                  boolean leaf, int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

        DefaultMutableTreeNode node = (DefaultMutableTreeNode)value;
        Class<?> c = (Class<?>)node.getUserObject();

        if (plainFont == null) {
            plainFont = getFont();
            if (plainFont != null)  italicFont = plainFont.deriveFont(Font.ITALIC);
        }

        if ((c.getModifiers() & Modifier.ABSTRACT) == 0)    setFont(plainFont);
        else    setFont(italicFont);
        return  this;
    }
}
