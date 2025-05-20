import javax.swing.*;
import java.awt.*;

public class ClickingGameApp extends JFrame
{
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public ClickingGameApp()
    {
        setTitle("Clicking Game");
        setSize(600, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center on screen

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Add welcome screen and game screen to main panel
        mainPanel.add(new WelcomePanel(cardLayout,mainPanel), "Welcome");
        mainPanel.add(new GamePanel(), "Game");

        add(mainPanel);
        setVisible(true);
    }
}