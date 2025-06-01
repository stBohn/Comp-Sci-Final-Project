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
        
        ImageIcon namecardIcon = new ImageIcon(filePath+"Namecard.png");
        JLabel nameCard = new JLabel(namecardIcon);
        
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
        
        
        nameCard.setBounds(0,475,600,80);
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
                
                new HelpMenu();
                frame.dispose();
            });
        });
        helpButton.setFocusPainted(false);
        contentPanel.add(helpButton);
        
        contentPanel.add(nameCard);
        contentPanel.add(title);
        contentPanel.add(cookieLabel);
        contentPanel.add(background);
        
        frame.add(contentPanel);
        
        frame.setVisible(true);
        frame.setAlwaysOnTop(false);
        
    }
}