import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.util.ArrayList;


public class DebugMenu
{
    String filePath = "ImageAssets\\";
    public DebugMenu()
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
        
        JButton cookie = new JButton();
        
        cookie.setBounds(300,300,300,300);
        
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
        backButton.setBounds(18,425,205,78);
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
