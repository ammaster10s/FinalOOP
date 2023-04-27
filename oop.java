import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;



public class oop extends JPanel implements ActionListener {
    Timer timer = new Timer(10,this);
    JButton start = new JButton("Start");
    JPanel set = new JPanel();
    public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.gray);
		set.add(start);
	}

    
    
    
    
    
    public static void main(String[] args) {
		JFrame frame = new JFrame(); //create an object of this frame
		oop test = new oop(); //create an object of CatchingFlashingBall
		frame.add(test); //add JPanel into JFrame
		// Configure the frame
		frame.setTitle("Shaper Runner"); //set Title of this frame
		frame.setSize(800, 600); //set a frame's size
		frame.setLocationRelativeTo(null); //set a location at center the frame
		frame.setVisible(true); //set visibility of this frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//set default Close Operation
	}
}
