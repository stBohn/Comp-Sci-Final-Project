import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.util.ArrayList;

public class GamePanel
{
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
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS)); //courtesy of Mr.GPT
        buttonPanel.setBackground(Color.RED);
        ArrayList<UpgradeButton> buttonList = new ArrayList<>();
        Upgrades(buttonPanel,cookieCount,CookieCount,buttonList);
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
            cookieCount[0]+= (1);
            CookieCount.setText("Cookie Count: "+cookieCount[0]);
            
             for (UpgradeButton b : buttonList) {
                    if (b.getPrice()<=cookieCount[0]) {
                           b.notShaded();
                    }
            }
            
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
    public void Upgrades(JPanel panel,int[] cookieCount, JLabel CookieCount, ArrayList<UpgradeButton> buttonList){
        int[] i = {0};
        for (i[0]=1; i[0] <= 50; i[0]++) {
            ImageIcon upgradeButtonIcon = new ImageIcon("C:\\Users\\Steve\\Documents\\GitHub\\Comp-Sci-Final-Project\\ImageAssets\\UpgradeButtonShaded.png");
            UpgradeButton button = new UpgradeButton(upgradeButtonIcon, new ImageIcon("C:\\Users\\Steve\\Documents\\GitHub\\Comp-Sci-Final-Project\\ImageAssets\\UgradeButton.png"), 16);
            button.setContentAreaFilled(false);
            button.setBorderPainted(false);
            button.setFocusPainted(false);
            Dimension size = new Dimension(292, 60);
            button.setPreferredSize(size);
            button.setMaximumSize(size);
            button.setMinimumSize(size); //for some reason all three of these are needed
            if(i[0]==1){
                button.setPrice(15);
                button.setNotShadedIcon(new ImageIcon("C:\\Users\\Steve\\Documents\\GitHub\\Comp-Sci-Final-Project\\ImageAssets\\AutoClicker.png"));
                button.setShadedIcon(new ImageIcon("C:\\Users\\Steve\\Documents\\GitHub\\Comp-Sci-Final-Project\\ImageAssets\\AutoClickerShaded.png"));
                button.shaded();
                button.setRolloverIcon(new ImageIcon("C:\\Users\\Steve\\Documents\\GitHub\\Comp-Sci-Final-Project\\ImageAssets\\AutoClickerRollover.png"));
                
                button.setForeground(Color.RED);
                button.addActionListener(e -> {
                    if(cookieCount[0]>=button.getPrice()){
                            cookieCount[0]-=button.getPrice();
                            button.purchase();
                            CookieCount.setText("Cookie Count: "+cookieCount[0]); //update cost
                    }
                     for (UpgradeButton b : buttonList) {
                        if (button.getPrice()>=cookieCount[0]) {
                            b.shaded();
                        }
                    }
                });
            }
            else{
                button.putClientProperty("price", 12);
                button.addActionListener(e -> {
                    if(cookieCount[0]>=button.getPrice()){
                            cookieCount[0]-=button.getPrice();
                            CookieCount.setText("Cookie Count: "+cookieCount[0]); 
                    }
                     for (UpgradeButton b : buttonList) {
                        if (button.getPrice()>=cookieCount[0]) {
                            b.shaded();
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
        Timer[] timer = new Timer[1];
        timer[0] = new Timer(10,new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(i[0]>=3){
                    timer[0].stop();
                }
                ImageIcon clickedIcon = new ImageIcon("C:\\Users\\Steve\\Documents\\GitHub\\Comp-Sci-Final-Project\\ImageAssets\\Cookie.png");
                cookie.setIcon(clickedIcon);
                i[0]++;
            }
        });
        timer[0].start();
    }
}
