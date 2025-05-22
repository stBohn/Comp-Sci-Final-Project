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
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS)); //courtesy of Mr.GPT
        buttonPanel.setBackground(Color.RED);
        Upgrades(buttonPanel);
        JScrollPane scrollPane = new JScrollPane(buttonPanel);
        
        
        JButton cookie = new JButton(cookieIcon);
        cookie.setContentAreaFilled(false);
        cookie.setBorderPainted(false);
        cookie.setFocusPainted(false);
        ImageIcon rollover = new ImageIcon("C:\\Users\\Steve\\Documents\\GitHub\\Comp-Sci-Final-Project\\ImageAssets\\RollOverCookie.png");
        cookie.setRolloverIcon(rollover);
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);
        //stuff for making the button animated when clicked
        int ogWidth = 300;
        int ogHeight = 300;
        int scaleAmount = 20;
        int animationSteps = 5;
        int delay = 20; //in miliseconds
        cookie.addActionListener(e -> {
            cookieCount[0]++;
            CookieCount.setText("Cookie Count: "+cookieCount[0]);
            
            buttonAnimation(cookie);
        });
        
        scrollPane.setBounds(473,205,310,357);
        CookieCount.setBounds(75,35,550,300);
        cookie.setBounds(80,250,300,300);
        background.setBounds(0,0,800,600);
        MainGame.setBounds(0,0,800,600);
        
        contentPanel.add(scrollPane);
        contentPanel.add(CookieCount);
        contentPanel.add(cookie);
        contentPanel.add(MainGame);
        contentPanel.add(background);
        
        frame.add(contentPanel);
        
        frame.setVisible(true);
    }
    public void Upgrades(JPanel panel){
        for (int i = 1; i <= 50; i++) {
            JButton button = new JButton("Button " + i);
            panel.add(button);
        }
    }
    public void buttonAnimation(JButton cookie){
        int[] i = {0};
        int[] sizes = {300,300};
        Timer[] timer = new Timer[1];
        timer[0] = new Timer(10,new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(i[0]>=3){
                    timer[0].stop();
                    buttonSmallerAnimation(cookie);
                }
                sizes[0]+=5; 
                sizes[1]+=5;
                cookie.setSize(sizes[0],sizes[1]);
                
                i[0]++;
            }
        });
        timer[0].start();
    }
    public void buttonSmallerAnimation(JButton cookie){
        int[] i = {0};
        int[] sizes = {315,315};
        Timer[] timer = new Timer[1];
        timer[0] = new Timer(10,new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(i[0]>=3){
                    timer[0].stop();
                    
                }
                sizes[0]-=5; 
                sizes[1]-=5;
                cookie.setSize(sizes[0],sizes[1]);
                
                i[0]++;
            }
        });
        timer[0].start();
    }
}
