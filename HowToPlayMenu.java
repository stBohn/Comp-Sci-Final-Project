import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.util.ArrayList;


public class HowToPlayMenu
{
    String filePath = "ImageAssets\\";
    public HowToPlayMenu()
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
        
        ImageIcon titleIcon = new ImageIcon(filePath+"Help Menu Title.png");
        JLabel title = new JLabel(titleIcon);
        
        ImageIcon howToPlayButtonIcon = new ImageIcon(filePath+"HowToPlay.png");
        ImageIcon howToPlayButtonRollOver = new ImageIcon(filePath+"HowToPlayRollover.png");
        
        ImageIcon debugIcon = new ImageIcon(filePath+"Debug.png");
        ImageIcon debugIconRollOver = new ImageIcon(filePath+"DebugRollOver.png");
        
        ImageIcon backIcon = new ImageIcon(filePath+"BACK.png");
        ImageIcon backIconRollOver = new ImageIcon(filePath+"BACKRollOver.png");
        
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);
        contentPanel.setBackground(Color.PINK);
        
        
        
        background.setBounds(0,0,800,600);
        cookieLabel.setBounds(450,250,300,300);
        title.setBounds(10,30,575,155);
        
        JButton howToPlayButton = new JButton(howToPlayButtonIcon);
        howToPlayButton.setRolloverIcon(howToPlayButtonRollOver);
        howToPlayButton.setContentAreaFilled(false);
        howToPlayButton.setBorderPainted(false);
        howToPlayButton.setFocusPainted(false);
        howToPlayButton.setBounds(18,225,600,120);
        howToPlayButton.addActionListener(e -> {
            SwingUtilities.invokeLater(() -> {
                
                new GamePanel();
                frame.dispose();
            });
        });
        howToPlayButton.setFocusPainted(false);
        contentPanel.add(howToPlayButton);
        
        JButton debugButton = new JButton(debugIcon);
        debugButton.setRolloverIcon(debugIconRollOver);
        debugButton.setContentAreaFilled(false);
        debugButton.setBorderPainted(false);
        debugButton.setFocusPainted(false);
        debugButton.setBounds(10,300,600,120);
        int[] timesClicked = {0};
        debugButton.addActionListener(e -> {
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
        debugButton.setFocusPainted(false);
        contentPanel.add(debugButton);
        
        JButton backButton = new JButton(backIcon);
        backButton.setRolloverIcon(backIconRollOver);
        backButton.setContentAreaFilled(false);
        backButton.setBorderPainted(false);
        backButton.setFocusPainted(false);
        backButton.setBounds(18,425,205,78);
        backButton.addActionListener(e -> {
            SwingUtilities.invokeLater(() -> {
                new MainMenu();
                frame.dispose();
            });
        });
        howToPlayButton.setFocusPainted(false);
        contentPanel.add(howToPlayButton);
        
        contentPanel.add(title);
        contentPanel.add(backButton);
        contentPanel.add(cookieLabel);
        contentPanel.add(background);
        
        frame.add(contentPanel);
        
        frame.setVisible(true);
        frame.setAlwaysOnTop(false);
        
    }
}
