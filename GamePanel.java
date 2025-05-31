import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.text.DecimalFormat;
import java.nio.file.*;
public class GamePanel
{
    double[] cookieCount = {0};
    
    int millions = 0;
    int billions = 0;
    int trillions = 0;
    int quadrillions = 0;
    
    double cps = 0;
    
    int numAutoClickers = 0;
    int[] numGrans = {0,0,0,0,0,0,0};
    
    int cookieTier = 4;
    
    String fileLocation = "C:\\Users\\Steve\\Documents\\GitHub\\Comp-Sci-Final-Project\\";
    String filePath = fileLocation+"ImageAssets\\";
    public GamePanel()
    {
        getSaveData();
        
        JFrame frame = new JFrame();
        frame.setTitle("Cookie Click Game");
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.PINK);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ImageIcon backgroundIcon = new ImageIcon(filePath+"Background.png");
        JLabel background = new JLabel(backgroundIcon);
        
        ImageIcon MainGameIcon = new ImageIcon(filePath+"MainGame.png");
        JLabel MainGame = new JLabel(MainGameIcon);
        
        ImageIcon cookieIcon = new ImageIcon(filePath+"Cookie.png");
        
        JLabel CookieCount = new JLabel("Cookies: "+String.format("%.1f", cookieCount[0]));
        CookieCount.setFont(new Font("Arial", Font.PLAIN, 40));
        CookieCount.setForeground(Color.WHITE);
        DecimalFormat df = new DecimalFormat("#.###");
        JLabel cpsCount = new JLabel();
        cpsCount.setText("per second: "+df.format(cps));
        cpsCount.setFont(new Font("Arial", Font.PLAIN, 30));
        cpsCount.setForeground(Color.WHITE);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS)); //courtesy of Mr.GPT
        buttonPanel.setBackground(Color.RED);
        ArrayList<UpgradeButton> buttonList = new ArrayList<>();
        Upgrades(buttonPanel,cookieCount,CookieCount,buttonList);
        JScrollPane scrollPane = new JScrollPane(buttonPanel);
        
        JPanel upgradesButtonPanel = new JPanel();
        upgradesButtonPanel.setLayout(new BoxLayout(upgradesButtonPanel, BoxLayout.Y_AXIS));
        upgradesButtonPanel.setBackground(Color.RED);
        ArrayList<UpgradeButton> upgradesButtonList = new ArrayList<>();
        actualUpgrades(upgradesButtonPanel,cookieCount,CookieCount,upgradesButtonList);
        JScrollPane UpgradesScrollPane = new JScrollPane(upgradesButtonPanel);
        UpgradesScrollPane.hide();
        
        JPanel selectorPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        selectorPanel.setOpaque(false);
        buttonPanel.setBackground(Color.RED);
        
        SelectorButton grandmasSelect = new SelectorButton(new ImageIcon(filePath+"GrandmasSelectorShaded.png"), new ImageIcon(filePath+"GrandmasSelector.png"));
        Dimension size = new Dimension(163, 50);
        grandmasSelect.setPreferredSize(size);
        grandmasSelect.setRolloverIcon(new ImageIcon(filePath+"GrandmasSelectRollover.png"));
        grandmasSelect.setMaximumSize(size);
        grandmasSelect.setMinimumSize(size);
        grandmasSelect.setContentAreaFilled(false);
        grandmasSelect.setBorderPainted(false);
        grandmasSelect.setFocusPainted(false);
        grandmasSelect.notShaded();
        
        SelectorButton upgradesSelect = new SelectorButton(new ImageIcon(filePath+"UpgradesSelectorShaded.png"), new ImageIcon(filePath+"UpgradesSelector.png"));
        upgradesSelect.setPreferredSize(size);
        upgradesSelect.setRolloverIcon(new ImageIcon(filePath+"UpgradesSelectRollover.png"));
        upgradesSelect.setMaximumSize(size);
        upgradesSelect.setMinimumSize(size);
        upgradesSelect.setContentAreaFilled(false);
        upgradesSelect.setBorderPainted(false);
        upgradesSelect.setFocusPainted(false);
        upgradesSelect.shaded();
        
        boolean[] currentlyGrandma = {true};
        
        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                if (source == upgradesSelect) {
                    if(currentlyGrandma[0]){
                        grandmasSelect.shaded();
                        upgradesSelect.notShaded();
                        currentlyGrandma[0] = false;
                        scrollPane.hide();
                        UpgradesScrollPane.show();
                    }
                } else if (source == grandmasSelect) {
                    if(!currentlyGrandma[0]){
                        grandmasSelect.notShaded();
                        upgradesSelect.shaded();
                        currentlyGrandma[0] = true;
                        scrollPane.show();
                        UpgradesScrollPane.hide();
                    }
                }
            }
        };
        //^ freaky ahh way of handling this
        grandmasSelect.addActionListener(listener);
        upgradesSelect.addActionListener(listener);
        
        selectorPanel.add(grandmasSelect);
        selectorPanel.add(upgradesSelect);
        
        ArrayList<ImageIcon> cookieIcons = new ArrayList();
        cookieIcons.add(new ImageIcon(filePath+"Cookie.png"));
        cookieIcons.add(new ImageIcon(filePath+"CookieTier2.png"));
        cookieIcons.add(new ImageIcon(filePath+"CookieTier3.png"));
        cookieIcons.add(new ImageIcon(filePath+"FinalCookie.png"));
        ArrayList<ImageIcon> rolloverIcons = new ArrayList();
        rolloverIcons.add(new ImageIcon(filePath+"RollOverCookie.png"));
        rolloverIcons.add(new ImageIcon(filePath+"CookieTier2Rollover.png"));
        rolloverIcons.add(new ImageIcon(filePath+"CookieTier3Rollover.png"));
        rolloverIcons.add(new ImageIcon(filePath+"FinalCookieRollover.png"));
        CookieButton cookie = new CookieButton(cookieIcons,rolloverIcons);
        if(cookieTier == 1){
            cookie.tier1();
        }
        else if(cookieTier == 2){
            cookie.tier2();
        }
        else if(cookieTier == 3){
            cookie.tier3();
        }
        else if(cookieTier == 4){
            cookie.tier4();
        }
        cookie.setContentAreaFilled(false);
        cookie.setBorderPainted(false);
        cookie.setFocusPainted(false);
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
            
             for (UpgradeButton b : buttonList) {
                    if (b.getPrice()<=cookieCount[0]) {
                           b.notShaded();
                    }
            }
            
            buttonAnimation(cookie);
        });
        
        selectorPanel.setBounds(465,145,340,53);
        cpsCount.setBounds(480,60,300,100);
        UpgradesScrollPane.setBounds(473,205,310,357);
        scrollPane.setBounds(473,205,310,357);
        CookieCount.setBounds(65,35,550,300);
        cookie.setBounds(80,250,300,300);
        background.setBounds(0,0,800,600);
        MainGame.setBounds(0,0,800,600);
        
        contentPanel.add(selectorPanel);
        contentPanel.add(cpsCount);
        contentPanel.add(UpgradesScrollPane);
        contentPanel.add(scrollPane);
        contentPanel.add(CookieCount);
        contentPanel.add(cookie);
        contentPanel.add(MainGame);
        contentPanel.add(background);
        
        frame.add(contentPanel);
        
        frame.setVisible(true);
        gameLoop(CookieCount, buttonList, cpsCount);
    }
    public void Upgrades(JPanel panel,double[] cookieCount, JLabel CookieCount, ArrayList<UpgradeButton> buttonList){
        int[] i = {0};
        for (i[0]=1; i[0] <= 8; i[0]++) {
            ImageIcon upgradeButtonIcon = new ImageIcon(filePath+"UpgradeButtonShaded.png");
            UpgradeButton button = new UpgradeButton(upgradeButtonIcon, new ImageIcon(filePath+"UgradeButton.png"), 16);
            button.setContentAreaFilled(false);
            button.setBorderPainted(false);
            button.setFocusPainted(false);
            Dimension size = new Dimension(292, 60);
            button.setPreferredSize(size);
            button.setMaximumSize(size);
            button.setMinimumSize(size); //for some reason all three of these are needed
            if(i[0]==1){
                button.setPrice(15);
                button.setNotShadedIcon(new ImageIcon(filePath+"AutoClicker.png"));
                button.setShadedIcon(new ImageIcon(filePath+"AutoClickerShaded.png"));
                button.shaded();
                button.setRolloverIcon(new ImageIcon(filePath+"AutoClickerRollover.png"));
                
                button.setForeground(Color.RED);
                button.addActionListener(e -> {
                    if(cookieCount[0]>=button.getPrice()){
                        cookieCount[0]-=button.getPrice();
                        button.purchase();
                        numAutoClickers++;
                        button.setNumberPurchased(numAutoClickers);
                            for (UpgradeButton b : buttonList) {
                        if (button.getPrice()>=cookieCount[0]) {
                            b.shaded();
                        }
                     }
                    }
                });
            }
            else if(i[0]==2){
                button.setPrice(100);
                button.setNotShadedIcon(new ImageIcon(filePath+"ThumbsUpGran.png"));
                button.setShadedIcon(new ImageIcon(filePath+"ThumbsUpGranShaded.png"));
                button.shaded();
                button.setRolloverIcon(new ImageIcon(filePath+"ThumbsUpGranRollover.png"));
                button.setForeground(Color.RED);
                button.addActionListener(e -> {
                    if(cookieCount[0]>=button.getPrice()){
                            cookieCount[0]-=button.getPrice();
                            button.purchase();
                            numGrans[0]++;
                             for (UpgradeButton b : buttonList) {
                        if (button.getPrice()>=cookieCount[0]) {
                            b.shaded();
                        }
                        }
                    }
                });
            }
            else if(i[0]==3){
                button.setPrice(1100);
                button.setNotShadedIcon(new ImageIcon(filePath+"CoolGran.png"));
                button.setShadedIcon(new ImageIcon(filePath+"CoolGranShaded.png"));
                button.shaded();
                button.setRolloverIcon(new ImageIcon(filePath+"CoolGranRollover.png"));
                button.setForeground(Color.RED);
                button.addActionListener(e -> {
                    if(cookieCount[0]>=button.getPrice()){
                            cookieCount[0]-=button.getPrice();
                            button.purchase();
                            numGrans[1]++;
                             for (UpgradeButton b : buttonList) {
                        if (button.getPrice()>=cookieCount[0]) {
                            b.shaded();
                        }
                        }
                    }
                });
            }
            else if(i[0]==4){
                button.setPrice(12000);
                button.setNotShadedIcon(new ImageIcon(filePath+"StrongGran.png"));
                button.setShadedIcon(new ImageIcon(filePath+"StrongGranShaded.png"));
                button.shaded();
                button.setRolloverIcon(new ImageIcon(filePath+"StrongGranRollover.png"));
                button.setForeground(Color.RED);
                button.addActionListener(e -> {
                    if(cookieCount[0]>=button.getPrice()){
                            cookieCount[0]-=button.getPrice();
                            button.purchase();
                            numGrans[2]++;
                             for (UpgradeButton b : buttonList) {
                        if (button.getPrice()>=cookieCount[0]) {
                            b.shaded();
                        }
                        }
                    }
                });
            }
            else if(i[0]==5){
                button.setPrice(50000);
                button.setNotShadedIcon(new ImageIcon(filePath+"SpookedGran.png"));
                button.setShadedIcon(new ImageIcon(filePath+"SpookedGranShaded.png"));
                button.shaded();
                button.setRolloverIcon(new ImageIcon(filePath+"SpookedGranRollover.png"));
                button.setForeground(Color.RED);
                button.addActionListener(e -> {
                    if(cookieCount[0]>=button.getPrice()){
                            cookieCount[0]-=button.getPrice();
                            button.purchase();
                            numGrans[3]++;
                             for (UpgradeButton b : buttonList) {
                        if (button.getPrice()>=cookieCount[0]) {
                            b.shaded();
                        }
                        }
                    }
                });
            }
            else if(i[0]==6){
                button.setPrice(100000);
                button.setNotShadedIcon(new ImageIcon(filePath+"JumpscareGran.png"));
                button.setShadedIcon(new ImageIcon(filePath+"JumpscareGranShaded.png"));
                button.shaded();
                button.setRolloverIcon(new ImageIcon(filePath+"JumpscareGranRollover.png"));
                button.setForeground(Color.RED);
                button.addActionListener(e -> {
                    if(cookieCount[0]>=button.getPrice()){
                            cookieCount[0]-=button.getPrice();
                            button.purchase();
                            numGrans[4]++;
                             for (UpgradeButton b : buttonList) {
                        if (button.getPrice()>=cookieCount[0]) {
                            b.shaded();
                        }
                        }
                    }
                });
            }
            else if(i[0]==7){
                button.setPrice(130000);
                button.setNotShadedIcon(new ImageIcon(filePath+"GrandpaGran.png"));
                button.setShadedIcon(new ImageIcon(filePath+"GrandpaGranShaded.png"));
                button.shaded();
                button.setRolloverIcon(new ImageIcon(filePath+"GrandpaGranRollover.png"));
                button.setForeground(Color.RED);
                button.addActionListener(e -> {
                    if(cookieCount[0]>=button.getPrice()){
                            cookieCount[0]-=button.getPrice();
                            button.purchase();
                            numGrans[5]++;
                             for (UpgradeButton b : buttonList) {
                        if (button.getPrice()>=cookieCount[0]) {
                            b.shaded();
                        }
                        }
                    }
                });
            }
            else if(i[0]==8){
                button.setPrice(1000000);
                button.setNotShadedIcon(new ImageIcon(filePath+"PartyGran.png"));
                button.setShadedIcon(new ImageIcon(filePath+"PartyGranShaded.png"));
                button.shaded();
                button.setRolloverIcon(new ImageIcon(filePath+"PartyGranRollover.png"));
                button.setForeground(Color.RED);
                button.addActionListener(e -> {
                    if(cookieCount[0]>=button.getPrice()){
                            cookieCount[0]-=button.getPrice();
                            button.purchase();
                            numGrans[6]++;
                             for (UpgradeButton b : buttonList) {
                            if (button.getPrice()>=cookieCount[0]) {
                            b.shaded();
                            }
                        }
                    }
                });
            }
            else{
                button.addActionListener(e -> {
                    if(cookieCount[0]>=button.getPrice()){
                            cookieCount[0]-=button.getPrice();
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
    public void actualUpgrades(JPanel panel,double[] cookieCount, JLabel CookieCount, ArrayList<UpgradeButton> buttonList){
        int[] i = {0};
        for (i[0]=1; i[0] <= 8; i[0]++) {
            ImageIcon upgradeButtonIcon = new ImageIcon(filePath+"UpgradeButtonShaded.png");
            UpgradeButton button = new UpgradeButton(upgradeButtonIcon, new ImageIcon(filePath+"UgradeButton.png"), 16);
            button.setContentAreaFilled(false);
            button.setBorderPainted(false);
            button.setFocusPainted(false);
            Dimension size = new Dimension(292, 60);
            button.setPreferredSize(size);
            button.setMaximumSize(size);
            button.setMinimumSize(size); //for some reason all three of these are needed
            if(i[0]==9){
                button.setPrice(15);
                button.setNotShadedIcon(new ImageIcon(filePath+"AutoClicker.png"));
                button.setShadedIcon(new ImageIcon(filePath+"AutoClickerShaded.png"));
                button.shaded();
                button.setRolloverIcon(new ImageIcon(filePath+"AutoClickerRollover.png"));
                
                button.setForeground(Color.RED);
                button.addActionListener(e -> {
                    if(cookieCount[0]>=button.getPrice()){
                            cookieCount[0]-=button.getPrice();
                            button.purchase();
                            cps++;
                            for (UpgradeButton b : buttonList) {
                        if (button.getPrice()>=cookieCount[0]) {
                            b.shaded();
                        }
                     }
                    }
                });
            }
            else{
                button.addActionListener(e -> {
                    if(cookieCount[0]>=button.getPrice()){
                            cookieCount[0]-=button.getPrice();
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
    public void buttonAnimation(CookieButton cookie){
        int[] i = {0};
        Timer[] timer = new Timer[1];
        timer[0] = new Timer(10,new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(i[0]>=3){
                    timer[0].stop();
                }
                        if(cookieTier == 1){
                    cookie.tier1();
                }
                else if(cookieTier == 2){
                    cookie.tier2();
                }
                else if(cookieTier == 3){
                    cookie.tier3();
                }
                else if(cookieTier == 3){
                    cookie.tier4();
                }
                i[0]++;
            }
        });
        timer[0].start();
    }
    public void gameLoop(JLabel CookieCount, ArrayList<UpgradeButton> buttonList, JLabel cpsCount){
        //20fps
        int[] saveTimer = {0};
        Timer[] timer = new Timer[1];
        timer[0] = new Timer(50, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(saveTimer[0]>=1000){
                    //do this once a second
                    SaveGame.saveToFile(fileLocation+"Save Data\\Save.txt", ""+cookieCount[0]+"a"+numAutoClickers+"b"+numGrans[0]+"c"+numGrans[1]+"d"+numGrans[2]+"e"+numGrans[3]+"f"+numGrans[4]+"g"+numGrans[5]+"h"+numGrans[6]+"i");
                    saveTimer[0]=0;
                }
                cookieCount[0]+=((double)cps/20);
                CookieCount.setText("Cookies: "+String.format("%.1f", cookieCount[0])); 
                 for (UpgradeButton b : buttonList) {
                    if (b.getPrice()<=cookieCount[0]) {
                           b.notShaded();
                    }
                }
                DecimalFormat df = new DecimalFormat("#.###");
                cpsCount.setText("per second: "+df.format(cps));
                saveTimer[0]+=50;
                 for (int i = 0; i<buttonList.size();i++) {
                    if (i==0) {
                        buttonList.get(i).setNumberPurchased(numAutoClickers);
                    }
                    else{
                        buttonList.get(i).setNumberPurchased(numGrans[i-1]);
                    }
                }
            }
        });
        
        timer[0].start();
    }
    public void getSaveData(){
        String data = LoadGame.loadFromFile(fileLocation+"Save Data\\Save.txt");
        
        cookieCount[0] = Double.parseDouble(data.substring(0,data.indexOf('a')));
        
        System.out.println(data);
        //System.out.println(data.substring(data.indexOf('a')+1,data.indexOf('b')));
        numAutoClickers = Integer.parseInt(data.substring(data.indexOf("a")+1,data.indexOf("b"))); //stored in save data after "a" before "b"
        numGrans[0] = Integer.parseInt(data.substring(data.indexOf("b")+1,data.indexOf("c")));
        numGrans[1] = Integer.parseInt(data.substring(data.indexOf("c")+1,data.indexOf("d"))); 
        numGrans[2] = Integer.parseInt(data.substring(data.indexOf("d")+1,data.indexOf("e"))); 
        numGrans[3] = Integer.parseInt(data.substring(data.indexOf("e")+1,data.indexOf("f"))); 
        numGrans[4] = Integer.parseInt(data.substring(data.indexOf("f")+1,data.indexOf("g"))); 
        numGrans[5] = Integer.parseInt(data.substring(data.indexOf("g")+1,data.indexOf("h"))); 
        numGrans[6] = Integer.parseInt(data.substring(data.indexOf("h")+1,data.indexOf("i"))); 
        
    }
}
