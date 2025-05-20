import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel
{
    private int timeLeft = 10;
    private int score = 0;
    private JLabel timeLabel;
    private JLabel scoreLabel, message;
    private JButton clickButton;
    private Timer timer;
    private JButton replayButton;

    public GamePanel()
    {
        setLayout(new BorderLayout());
        // Top: Timer label
        timeLabel = new JLabel("Time left: 10", SwingConstants.CENTER);
        timeLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        add(timeLabel, BorderLayout.NORTH);
        // Center: Optional welcome image or drawing
        message = new JLabel("Click the button below!");
        message.setHorizontalAlignment(SwingConstants.CENTER);
        add(message, BorderLayout.CENTER);
        // Bottom: Button + Score + Replay
        JPanel bottomPanel = new JPanel();
        clickButton = new JButton("Click me!");
        clickButton.setFocusPainted(false);
        clickButton.addActionListener(e ->
                {
                    if (timeLeft > 0) {
                        score++;
                        scoreLabel.setText("Score: " + score);
                    }
            });

        scoreLabel = new JLabel("Score: 0");

        replayButton = new JButton("Replay");
        replayButton.setFocusPainted(false);
        replayButton.addActionListener(e -> resetGame());

        bottomPanel.add(clickButton);
        bottomPanel.add(scoreLabel);
        bottomPanel.add(replayButton);

        add(bottomPanel, BorderLayout.SOUTH);

        setUpTimer();
    }

    public void setUpTimer()
    {
        timer = new Timer(1000, e ->
                {
                    timeLeft--;
                    timeLabel.setText("Time left: " + timeLeft);
                    if (timeLeft <= 0) {
                        ((Timer) e.getSource()).stop();
                        clickButton.setEnabled(false);
                        if(score > 30)
                        {
                            message.setForeground(Color.GREEN);
                            message.setText("Time's up! Final score: " + score);
                        }
                        else
                        {
                            message.setForeground(Color.RED);
                            message.setText("Time's up! Final score: " + score);
                        }
                    }
            });
        timer.start();
    }

    public void resetGame()
    {
        timeLeft = 10;
        score = 0;
        timeLabel.setText("Time left: 10");
        scoreLabel.setText("Score: 0");
        clickButton.setEnabled(true);
        message.setIcon(null);
        message.setText("Welcome to the CLICKING GAME");
        timer.restart();
    }
}