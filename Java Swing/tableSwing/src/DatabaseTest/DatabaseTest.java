package DatabaseTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DatabaseTest extends JFrame {

    JTextField hostField;
    JTextField queryField;
    QueryTableModel qtm;

    public DatabaseTest( ) {
        super("Database Test Frame");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350, 200);

        qtm = new QueryTableModel( );
        JTable table = new JTable(qtm);
        JScrollPane scrollpane = new JScrollPane(table);
        JPanel p1 = new JPanel( );
        p1.setLayout(new GridLayout(3, 2));
        p1.add(new JLabel("Enter the Host URL: "));
        p1.add(hostField = new JTextField( ));
        p1.add(new JLabel("Enter your query: "));
        p1.add(queryField = new JTextField( ));
        p1.add(new JLabel("Click here to send: "));

        hostField.setText("jdbc:mysql://localhost/gzlb-3000?user=root&password=root&useUnicode=true");
        queryField.setText("select * from t_lines;");

        JButton jb = new JButton("Search");
        jb.addActionListener(new ActionListener( ) {
            public void actionPerformed(ActionEvent e) {
                qtm.setHostURL(hostField.getText( ).trim( ));
                qtm.setQuery(queryField.getText( ).trim( ));
            }
        } );
        p1.add(jb);
        getContentPane( ).add(p1, BorderLayout.NORTH);
        getContentPane( ).add(scrollpane, BorderLayout.CENTER);
    }

    public static void main(String args[]) {
        DatabaseTest tt = new DatabaseTest( );
        tt.setVisible(true);
    }
}
