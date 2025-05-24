import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.util.ArrayList;


public class MainMenu
{
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
        
        ImageIcon backgroundIcon = new ImageIcon("C:\\Users\\Steve\\Documents\\GitHub\\Comp-Sci-Final-Project\\ImageAssets\\Background.png");
        JLabel background = new JLabel(backgroundIcon);
        
        ImageIcon cookieIcon = new ImageIcon("C:\\Users\\Steve\\Documents\\GitHub\\Comp-Sci-Final-Project\\ImageAssets\\Cookie.png");
        JLabel cookieLabel = new JLabel(cookieIcon);
        
        ImageIcon titleIcon = new ImageIcon("C:\\Users\\Steve\\Documents\\GitHub\\Comp-Sci-Final-Project\\ImageAssets\\Cookie Click  Game.png");
        JLabel title = new JLabel(titleIcon);
        
        ImageIcon playIcon = new ImageIcon("C:\\Users\\Steve\\Documents\\GitHub\\Comp-Sci-Final-Project\\ImageAssets\\PlayButton.png");
        ImageIcon playIconRollOver = new ImageIcon("C:\\Users\\Steve\\Documents\\GitHub\\Comp-Sci-Final-Project\\ImageAssets\\PlayRollOver.png");
        
        ImageIcon helpIcon = new ImageIcon("C:\\Users\\Steve\\Documents\\GitHub\\Comp-Sci-Final-Project\\ImageAssets\\HelpButton.png");
        ImageIcon helpIconRollOver = new ImageIcon("C:\\Users\\Steve\\Documents\\GitHub\\Comp-Sci-Final-Project\\ImageAssets\\HelpRollOver.png");
        
        
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
        helpButton.setFocusPainted(false);
        contentPanel.add(helpButton);
        
        contentPanel.add(title);
        contentPanel.add(cookieLabel);
        contentPanel.add(background);
        
        frame.add(contentPanel);
        
        frame.setVisible(true);
        frame.setAlwaysOnTop(false);
        
        //spinCookieAnimation(cookieLabel);
    }
    //# scrapped idea to make cookie spin. Had to make a custom photoshop script to export all 360 rotated pngs, just for me to realize its lame and i dont like it :(
    // public void spinCookieAnimation(JLabel cookieLabel) {
        // int[] i = {0};
        // Timer[] timer = new Timer[1];
    
        // timer[0] = new Timer(10, new ActionListener() {
            // public void actionPerformed(ActionEvent e) {
                // if (i[0] >= 360) {
                    // i[0]=0;
                // }
                
                // String frameNumber = String.format("%03d", i[0]);
                // String path = "C:\\Users\\Steve\\Documents\\GitHub\\Comp-Sci-Final-Project\\ImageAssets\\Main Menu Animations\\Cookie Spin\\frame_" + frameNumber + ".png";
                // cookieLabel.setIcon(new ImageIcon(path));
    
                // i[0]++;
            // }
        // });
    
        // timer[0].start();
    // }

}