package longList;

import javax.swing.*;

public class WordListModel extends AbstractListModel<String> {
    private int length;
    public static final char FIRST = 'a';
    public static final char LAST = 'z';

    public WordListModel(int n) {
        length = n;
    }

    @Override
    public int getSize() {
        return (int)Math.pow(LAST - FIRST + 1, length);
    }

    @Override
    public String getElementAt(int index) {
        StringBuilder r = new StringBuilder();
        for (int i = 0; i < length; ++i) {
            char c = (char)(FIRST + index % (LAST - FIRST + 1));
            r.insert(0, c);
            index = index / (LAST - FIRST + 1);
        }
        return r.toString();
    }
}
