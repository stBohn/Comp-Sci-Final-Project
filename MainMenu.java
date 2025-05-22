import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;

public class MainMenu
{
    public MainMenu()
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
        
        ImageIcon cookieIcon = new ImageIcon("C:\\Users\\Steve\\Documents\\GitHub\\Comp-Sci-Final-Project\\ImageAssets\\Cookie.png");
        JLabel cookie = new JLabel(cookieIcon);
        
        ImageIcon titleIcon = new ImageIcon("C:\\Users\\Steve\\Documents\\GitHub\\Comp-Sci-Final-Project\\ImageAssets\\Cookie Click  Game.png");
        JLabel title = new JLabel(titleIcon);
        
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);
        contentPanel.setBackground(Color.PINK);
        
        contentPanel.add(title);
        contentPanel.add(cookie);
        contentPanel.add(background);
        
        background.setBounds(0,0,800,600);
        cookie.setBounds(75,200,300,300);
        title.setBounds(200,30,553,256);
        
        JButton playButton = new JButton("PLAY");
        playButton.setBounds(400,300,300,75);
        int i = 0;
        playButton.addActionListener(e -> {
            SwingUtilities.invokeLater(() -> {
                new GamePanel(); // Open the new frame
                frame.dispose(); // Close the old frame
            });
        });
        contentPanel.add(playButton);
        
        JButton helpButton = new JButton("HELP");
        helpButton.setBounds(400,400,300,75);
        contentPanel.add(helpButton);
        
        frame.add(contentPanel);
        
        frame.setVisible(true);
    }
}