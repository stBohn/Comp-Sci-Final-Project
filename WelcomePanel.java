// Welcome screen panel
import javax.swing.*;
import java.awt.*;

    public class WelcomePanel extends JPanel
    {
        public WelcomePanel(CardLayout cardLayout, JPanel mainPanel )
        {
            setLayout(new GridBagLayout());
            JLabel welcomeLabel = new JLabel("Welcome to the Clicking Game! Click Play when ready.");
            welcomeLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
            welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
            
            ImageIcon icon = new ImageIcon("path/to/your/button.png");
            
            JButton playButton = new JButton("Play");
            playButton.setFont(new Font("SansSerif", Font.PLAIN, 16));
            playButton.addActionListener(e -> cardLayout.show(mainPanel, "Game"));

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10, 10, 10, 10);
            gbc.gridx = 0;
            gbc.gridy = 0;
            add(welcomeLabel, gbc);
            gbc.gridy = 1;
            add(playButton, gbc);
        }
    }