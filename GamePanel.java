import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;

public class GamePanel
{
    public GamePanel()
    {
        JFrame frame = new JFrame();
        frame.setTitle("Clicking Game");
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.PINK);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ImageIcon backgroundIcon = new ImageIcon("C:\\Users\\Steve\\Documents\\GitHub\\Comp-Sci-Final-Project\\ImageAssets\\Background.png");
        JLabel background = new JLabel(backgroundIcon);
        
        ImageIcon MainGameIcon = new ImageIcon("C:\\Users\\Steve\\Documents\\GitHub\\Comp-Sci-Final-Project\\ImageAssets\\MainGame.png");
        JLabel MainGame = new JLabel(MainGameIcon);
        
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);
        contentPanel.add(MainGame);
        contentPanel.add(background);
        
        frame.add(contentPanel);
        
        background.setBounds(0,0,800,600);
        MainGame.setBounds(0,0,800,600);
        
        frame.setVisible(true);
    }
}
