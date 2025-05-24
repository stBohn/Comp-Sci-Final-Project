import javax.swing.JButton;
import javax.swing.*;
import java.awt.*;

public class UpgradeButton extends JButton {
    ImageIcon shadedIcon;
    ImageIcon notShadedIcon;
    boolean isShaded;
    int price;
    public UpgradeButton(ImageIcon shadedIcon, ImageIcon notShadedIcon, int price) {
        this.shadedIcon = shadedIcon;
        this.notShadedIcon = notShadedIcon;
        this.price = price;
        setIcon(shadedIcon);
        isShaded = true;
    }
    public void setShadedIcon(ImageIcon shadedIcon){
        this.shadedIcon = shadedIcon;
    }
    public void setNotShadedIcon(ImageIcon notShadedIcon){
        this.notShadedIcon = notShadedIcon;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public int getPrice(){
        return price;
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
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(isShaded){
            g.setColor(Color.RED);
        }else{
            g.setColor(Color.GREEN);
        }
        g.setFont(new Font("Arial", Font.BOLD, 14));
        g.drawString(""+price, 80, 45); // x=30, y=40
    }
}
