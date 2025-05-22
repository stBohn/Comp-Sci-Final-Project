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
        
        int[] cookieCount = {0};
        
        ImageIcon backgroundIcon = new ImageIcon("C:\\Users\\Steve\\Documents\\GitHub\\Comp-Sci-Final-Project\\ImageAssets\\Background.png");
        JLabel background = new JLabel(backgroundIcon);
        
        ImageIcon MainGameIcon = new ImageIcon("C:\\Users\\Steve\\Documents\\GitHub\\Comp-Sci-Final-Project\\ImageAssets\\MainGame.png");
        JLabel MainGame = new JLabel(MainGameIcon);
        
        ImageIcon cookieIcon = new ImageIcon("C:\\Users\\Steve\\Documents\\GitHub\\Comp-Sci-Final-Project\\ImageAssets\\Cookie.png");
        
        JLabel CookieCount = new JLabel("Cookie Count: "+cookieCount[0]);
        CookieCount.setFont(new Font("Arial", Font.PLAIN, 40));
        CookieCount.setForeground(Color.WHITE);
        
        JButton button = new JButton(cookieIcon);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);
        button.addActionListener(e -> {
            cookieCount[0]++;
            CookieCount.setText("Cookie Count: "+cookieCount[0]);
        });
        
        CookieCount.setBounds(75,35,550,300);
        button.setBounds(80,250,300,300);
        background.setBounds(0,0,800,600);
        MainGame.setBounds(0,0,800,600);
        
        contentPanel.add(CookieCount);
        contentPanel.add(button);
        contentPanel.add(MainGame);
        contentPanel.add(background);
        
        frame.add(contentPanel);
        
        frame.setVisible(true);
    }
}
