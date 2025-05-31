import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.util.ArrayList;


public class MainMenu
{
    String filePath = "ImageAssets\\";
    public MainMenu()
    {
        JFrame frame = new JFrame();
        frame.setTitle("Main Menu");
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.PINK);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setAlwaysOnTop(true);
        
        ImageIcon backgroundIcon = new ImageIcon(filePath+"Background.png");
        JLabel background = new JLabel(backgroundIcon);
        
        ImageIcon cookieIcon = new ImageIcon(filePath+"Cookie.png");
        JLabel cookieLabel = new JLabel(cookieIcon);
        
        ImageIcon titleIcon = new ImageIcon(filePath+"Cookie Click  Game.png");
        JLabel title = new JLabel(titleIcon);
        
        ImageIcon playIcon = new ImageIcon(filePath+"PlayButton.png");
        ImageIcon playIconRollOver = new ImageIcon(filePath+"PlayRollOver.png");
        
        ImageIcon helpIcon = new ImageIcon(filePath+"HelpButton.png");
        ImageIcon helpIconRollOver = new ImageIcon(filePath+"HelpRollOver.png");
        
        
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);
        contentPanel.setBackground(Color.PINK);
        
        
        
        background.setBounds(0,0,800,600);
        cookieLabel.setBounds(75,200,300,300);
        title.setBounds(200,30,553,256);
        
        JButton playButton = new JButton(playIcon);
        playButton.setRolloverIcon(playIconRollOver);
        playButton.setContentAreaFilled(false);
        playButton.setBorderPainted(false);
        playButton.setFocusPainted(false);
        playButton.setBounds(400,300,340,114);
        int i = 0;
        playButton.addActionListener(e -> {
            SwingUtilities.invokeLater(() -> {
                
                new GamePanel();
                frame.dispose();
            });
        });
        playButton.setFocusPainted(false);
        contentPanel.add(playButton);
        
        JButton helpButton = new JButton(helpIcon);
        helpButton.setRolloverIcon(helpIconRollOver);
        helpButton.setContentAreaFilled(false);
        helpButton.setBorderPainted(false);
        helpButton.setFocusPainted(false);
        helpButton.setBounds(400,400,340,114);
        int[] timesClicked = {0};
        helpButton.addActionListener(e -> {
            SwingUtilities.invokeLater(() -> {
                if(timesClicked[0]<=0){
                    SaveGame.saveToFile("Save Data\\Save.txt", ""+0+"a"+0+"b"+0+"c"+0+"d"+0+"e"+0+"f"+0+"g"+0+"h"+0+"i"+1+"j");
                    timesClicked[0]++;
                }
                else{
                    SaveGame.saveToFile("Save Data\\Save.txt", ""+1000+"a"+0+"b"+1+"c"+10+"d"+100+"e"+1000+"f"+0+"g"+0+"h"+1+"i"+4+"j");
                    timesClicked[0]++;
                }
            });
        });
        helpButton.setFocusPainted(false);
        contentPanel.add(helpButton);
        
        contentPanel.add(title);
        contentPanel.add(cookieLabel);
        contentPanel.add(background);
        
        frame.add(contentPanel);
        
        frame.setVisible(true);
        frame.setAlwaysOnTop(false);
        
    }
}