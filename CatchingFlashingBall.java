import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class CatchingFlashingBall extends JPanel{
	
	Random random = new Random();
	public int xCenter = 0;
	public int yCenter = 0;
	public int r = 15;
	public int x, y;
	
	Timer timer = new Timer(1000, new TimerListener());
	
	Catcher ctch = new Catcher();

	CatchingFlashingBall(){
		this.addMouseListener(ctch);
		timer.start();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.BLACK);
		g.setColor(Color.ORANGE);
		g.fillOval(xCenter-r, yCenter-r, r*2, r*2);
	}
	
	public int randomPosX() {
		return random.nextInt(getWidth());
	}
	
	public int randomPosY() {
		return random.nextInt(getHeight());
	}
	
	public class TimerListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			xCenter = randomPosX();
			yCenter = randomPosY();
			repaint();
		}
	}
	
	public class Catcher implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {
			double distance = calculateDistance(e.getX(), e.getY(), xCenter, yCenter);
			if (distance <= r) {
				timer.stop();
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {}

		@Override
		public void mouseExited(MouseEvent e) {}
		
		public double calculateDistance(int x1, int y1, int x2, int y2) {
			return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
		}
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame(); //create an object of this frame
		CatchingFlashingBall catchBall = new CatchingFlashingBall(); //create an object of CatchingFlashingBall
		frame.add(catchBall); //add JPanel into JFrame
		// Configure the frame
		frame.setTitle("My Catching FlashBall"); //set Title of this frame
		frame.setSize(600, 400); //set a frame's size
		frame.setLocationRelativeTo(null); //set a location at center the frame
		frame.setVisible(true); //set visibility of this frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//set default Close Operation
	}

}