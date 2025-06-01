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
        
        ImageIcon backgroundIcon = new ImageIcon(filePath+"HowToPlayBackground.png");
        JLabel background = new JLabel(backgroundIcon);
        
        
        ImageIcon backIcon = new ImageIcon(filePath+"BACK.png");
        ImageIcon backIconRollOver = new ImageIcon(filePath+"BACKRollOver.png");
        
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);
        contentPanel.setBackground(Color.PINK);
        
        
        
        background.setBounds(0,0,800,600);      
        
        
        JButton backButton = new JButton(backIcon);
        backButton.setRolloverIcon(backIconRollOver);
        backButton.setContentAreaFilled(false);
        backButton.setBorderPainted(false);
        backButton.setFocusPainted(false);
        backButton.setBounds(18,455,205,78);
        backButton.addActionListener(e -> {
            SwingUtilities.invokeLater(() -> {
                new MainMenu();
                frame.dispose();
            });
        });
        
        contentPanel.add(backButton);
        contentPanel.add(background);
        
        frame.add(contentPanel);
        
        frame.setVisible(true);
        frame.setAlwaysOnTop(false);
        
    }
}
