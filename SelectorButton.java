import javax.swing.JButton;
import javax.swing.*;
import java.awt.*;

public class SelectorButton extends JButton {
    ImageIcon shadedIcon;
    ImageIcon notShadedIcon;
    boolean isShaded;
    public SelectorButton(ImageIcon shadedIcon, ImageIcon notShadedIcon) {
        this.shadedIcon = shadedIcon;
        this.notShadedIcon = notShadedIcon;
    }
    public boolean isIconShaded(){
        return isShaded;
    }
    public void shaded(){
        setIcon(shadedIcon);
        isShaded = true;
    }
    public void notShaded(){
        setIcon(notShadedIcon);
        isShaded = false;
        repaint();
    }
}
