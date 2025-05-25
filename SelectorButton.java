import javax.swing.JButton;
import javax.swing.*;
import java.awt.*;

public class SelectorButton extends JButton {
    static boolean isGrandmaSelector;
    ImageIcon shadedIcon;
    ImageIcon notShadedIcon;
    boolean isShaded;
    public SelectorButton(ImageIcon shadedIcon, ImageIcon notShadedIcon, boolean isGrandma) {
        this.shadedIcon = shadedIcon;
        this.notShadedIcon = notShadedIcon;
        if(isGrandma){
            isGrandmaSelector = true;
            setIcon(notShadedIcon);
            addActionListener(e -> {
                if(isShaded){
                    notShaded();
                    isGrandmaSelector = false;
                    isShaded = false;
                }
            });
            isShaded = false;
        }
        else if(!isGrandma){
            isGrandmaSelector = false;
            setIcon(shadedIcon);
            addActionListener(e -> {
                if(isShaded){
                    notShaded();
                    isGrandmaSelector = false;
                    isShaded = false;
                }
            });
            isShaded = true;
            
        }
    }
    public void oneOfTheButtonsWasClickedDawg(){
        
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
