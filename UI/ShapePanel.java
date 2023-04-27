package UI;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Logic.Shape;

public class ShapePanel extends JPanel {

    private List<Shape> shapes;

    public ShapePanel(List<Shape> shapes) {
        this.shapes = shapes;
        setPreferredSize(new Dimension(300, 300));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (Shape shape : shapes) {
            g2d.setColor(shape.getColor());
            g2d.fill(shape.getShape());
        }

        g2d.dispose();
    }
    public static void main(String[] args) {
		JFrame frame = new JFrame(); //create an object of this frame
		ShapePanel test = new ShapePanel(); //create an object of CatchingFlashingBall
		frame.add(test); //add JPanel into JFrame
		// Configure the frame
		frame.setTitle("Shaper Runner"); //set Title of this frame
		frame.setSize(800, 600); //set a frame's size
		frame.setLocationRelativeTo(null); //set a location at center the frame
		frame.setVisible(true); //set visibility of this frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//set default Close Operation
	}


}
