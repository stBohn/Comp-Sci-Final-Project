import javax.swing.JButton;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CookieButton extends JButton {
    ArrayList<ImageIcon> icons = new ArrayList();
    ArrayList<ImageIcon> rolloverIcons = new ArrayList();
    public CookieButton(ArrayList<ImageIcon> icons, ArrayList<ImageIcon> rolloverIcons) {
        this.icons = icons;
        this.rolloverIcons = rolloverIcons;
    }
    public void tier1(){
        setIcon(icons.get(0));
        setRolloverIcon(rolloverIcons.get(0));
    }
    public void tier2(){
        setIcon(icons.get(1));
        setRolloverIcon(rolloverIcons.get(1));
    }
    public void tier3(){
        setIcon(icons.get(2));
        setRolloverIcon(rolloverIcons.get(2));
    }
    public void tier4(){
        setIcon(icons.get(3));
        setRolloverIcon(rolloverIcons.get(3));
    }
}
