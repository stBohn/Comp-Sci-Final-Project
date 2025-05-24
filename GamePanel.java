import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.util.ArrayList;

public class GamePanel
{
    private int ClickMult = 1;
    public GamePanel()
    {
        JFrame frame = new JFrame();
        frame.setTitle("Cookie Click Game");
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
        
        JLabel multCount = new JLabel("Mult: "+ClickMult);
        multCount.setFont(new Font("Arial", Font.PLAIN, 40));
        multCount.setForeground(Color.WHITE);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS)); //courtesy of Mr.GPT
        buttonPanel.setBackground(Color.RED);
        ArrayList<JButton> buttonList = new ArrayList<>();
        Upgrades(buttonPanel,cookieCount,CookieCount,multCount,buttonList);
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
            cookieCount[0]+= (1*ClickMult);
            CookieCount.setText("Cookie Count: "+cookieCount[0]);
            
             for (JButton b : buttonList) {
                    if ((int) b.getClientProperty("price")<=cookieCount[0]) {
                           b.setIcon(new ImageIcon("C:\\Users\\Steve\\Documents\\GitHub\\Comp-Sci-Final-Project\\ImageAssets\\UgradeButton.png"));
                    }
            }
            
            buttonAnimation(cookie);
        });
        
        scrollPane.setBounds(473,205,310,357);
        CookieCount.setBounds(75,35,550,300);
        multCount.setBounds(10,-65,300,200);
        cookie.setBounds(80,250,300,300);
        background.setBounds(0,0,800,600);
        MainGame.setBounds(0,0,800,600);
        
        contentPanel.add(scrollPane);
        contentPanel.add(CookieCount);
        contentPanel.add(multCount);
        contentPanel.add(cookie);
        contentPanel.add(MainGame);
        contentPanel.add(background);
        
        frame.add(contentPanel);
        
        frame.setVisible(true);
    }
    public void Upgrades(JPanel panel,int[] cookieCount, JLabel CookieCount, JLabel multCount, ArrayList<JButton> buttonList){
        int[] i = {0};
        for (i[0]=1; i[0] <= 50; i[0]++) {
            ImageIcon upgradeButtonIcon = new ImageIcon("C:\\Users\\Steve\\Documents\\GitHub\\Comp-Sci-Final-Project\\ImageAssets\\UpgradeButtonShaded.png");
            JButton button = new JButton(upgradeButtonIcon);
            button.setContentAreaFilled(false);
            button.setBorderPainted(false);
            button.setFocusPainted(false);
            Dimension size = new Dimension(292, 60);
            button.setPreferredSize(size);
            button.setMaximumSize(size);
            button.setMinimumSize(size); //for some reason all three of these are needed
            if(i[0]==1){
                button.putClientProperty("price", 11);
                button.addActionListener(e -> {
                    if(cookieCount[0]>=(int)button.getClientProperty("price")){
                            cookieCount[0]-=(int)button.getClientProperty("price");
                            
                            //upgrade specific stuff:
                            CookieCount.setText("Cookie Count: "+cookieCount[0]); //update cost
                            ClickMult+=1;
                            
                            multCount.setText("Mult: "+ClickMult);
                    }
                     for (JButton b : buttonList) {
                        if ((int) b.getClientProperty("price")>=cookieCount[0]) {
                            b.setIcon(new ImageIcon("C:\\Users\\Steve\\Documents\\GitHub\\Comp-Sci-Final-Project\\ImageAssets\\UpgradeButtonShaded.png"));
                        }
                    }
                });
            }
            else{
                button.putClientProperty("price", 12);
                button.addActionListener(e -> {
                    if(cookieCount[0]>=(int)button.getClientProperty("price")){
                            cookieCount[0]-=(int)button.getClientProperty("price");
                            CookieCount.setText("Cookie Count: "+cookieCount[0]); 
                    }
                     for (JButton b : buttonList) {
                        if ((int) b.getClientProperty("price")>=cookieCount[0]) {
                            b.setIcon(new ImageIcon("C:\\Users\\Steve\\Documents\\GitHub\\Comp-Sci-Final-Project\\ImageAssets\\UpgradeButtonShaded.png"));
                        }
                    }
                });
            }
            buttonList.add(button);
        }
        for(JButton j : buttonList){
            panel.add(j);
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
