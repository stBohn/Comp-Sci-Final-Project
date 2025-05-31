import javax.swing.JButton;
import javax.swing.*;
import java.awt.*;

public class UpgradeButton extends JButton {
    ImageIcon shadedIcon;
    ImageIcon notShadedIcon;
    boolean isShaded;
    double price;
    int numPurchased;
    boolean isSkinButton;
    public UpgradeButton(ImageIcon shadedIcon, ImageIcon notShadedIcon, int price,boolean isSkinButton) {
        this.shadedIcon = shadedIcon;
        this.notShadedIcon = notShadedIcon;
        this.price = price;
        setIcon(shadedIcon);
        isShaded = true;
        this.numPurchased = numPurchased;
        this.isSkinButton = isSkinButton;
    }
    public void setShadedIcon(ImageIcon shadedIcon){
        this.shadedIcon = shadedIcon;
    }
    public void setNotShadedIcon(ImageIcon notShadedIcon){
        this.notShadedIcon = notShadedIcon;
    }
    public void setPrice(int price){
        this.price = price;
        repaint();
    }
    public double getPrice(){
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
        repaint();
    }
    public void purchase(){
        numPurchased++;
        price = (price*(1.15));
    }
    public void setNumberPurchased(int numPurchased){
        this.numPurchased = numPurchased;
        repaint();
    }
    public int getNumberPurchased(){
        return numPurchased;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(price!=0){
            if(isShaded){
                g.setColor(Color.RED);
            }else{
                g.setColor(Color.GREEN);
            }
            g.setFont(new Font("Arial", Font.BOLD, 14));
            g.drawString(""+(int)price, 80, 45);
        }
        //draw number purchased
        if(numPurchased>=0&&price!=0&&!isSkinButton){
            if(isShaded){
                g.setColor(new Color(41,41,41));
            }else{
                g.setColor(new Color(255,255,255));
            }
            if(numPurchased<100){
                g.setFont(new Font("Goudy Stout", Font.BOLD, 40));
                g.drawString(""+(int)numPurchased, 230, 45);
            }else{
                g.setFont(new Font("Goudy Stout", Font.BOLD, 30));
                g.drawString(""+(int)numPurchased, 230, 40);
            }
        }
    }
}
