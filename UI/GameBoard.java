package UI;

import javax.swing.*;
import java.awt.*;

public class GameBoard extends JFrame {
    private JPanel gamePanel;
    private JPanel shapeHolderPanel;
    private JLabel timerLabel;
    private JLabel fastestTimeLabel;

    public GameBoard() {
        // Set the title and layout of the frame
        super("Shaper Runner");
        setLayout(new BorderLayout());

        // Create the game panel and add it to the center of the frame
        gamePanel = new JPanel();
        gamePanel.setLayout(new BoxLayout(gamePanel, BoxLayout.Y_AXIS));
        add(gamePanel, BorderLayout.CENTER);

        // Create the shape holder panel and add it to the left of the frame
        shapeHolderPanel = new JPanel();
        shapeHolderPanel.setLayout(new BoxLayout(shapeHolderPanel, BoxLayout.Y_AXIS));
        add(shapeHolderPanel, BorderLayout.LINE_START);

        // Create the timer label and add it to the top of the game panel
        timerLabel = new JLabel("Time: 0");
        gamePanel.add(timerLabel);

        // Create the fastest time label and add it to the top of the game panel
        fastestTimeLabel = new JLabel("Fastest Time: N/A");
        gamePanel.add(fastestTimeLabel);

        // Set the size and visibility of the frame
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public JPanel getGamePanel() {
        return gamePanel;
    }

    public JPanel getShapeHolderPanel() {
        return shapeHolderPanel;
    }

    public JLabel getTimerLabel() {
        return timerLabel;
    }

    public JLabel getFastestTimeLabel() {
        return fastestTimeLabel;
    }
    public static void main(String[] args) {
		JFrame frame = new JFrame(); //create an object of this frame
		GameBoard test = new GameBoard(); //create an object of CatchingFlashingBall
		frame.add(test); //add JPanel into JFrame
		// Configure the frame
		frame.setTitle("Shaper Runner"); //set Title of this frame
		frame.setSize(800, 600); //set a frame's size
		frame.setLocationRelativeTo(null); //set a location at center the frame
		frame.setVisible(true); //set visibility of this frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//set default Close Operation
	}

}
