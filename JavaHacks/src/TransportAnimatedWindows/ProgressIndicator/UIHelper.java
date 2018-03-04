package TransportAnimatedWindows.ProgressIndicator;

import java.awt.Toolkit;
import java.net.URL;

import javax.swing.ImageIcon;

public final class UIHelper
{
    public static ImageIcon readImageIcon(String filename)
    {
        URL url = UIHelper.class.getResource("./image/" + filename);
        if (url == null)
            return null;

        return new ImageIcon(Toolkit.getDefaultToolkit().getImage(url));
    }
}
