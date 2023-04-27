import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CannonBall extends JPanel implements ActionListener {
	Timer timer = new Timer(10,this);
	JFrame f = new JFrame("Cannon Ball");
	JButton b1 = new JButton("Fire");
	JButton b2 = new JButton("Reset");
	JTextField tf1 = new JTextField("0",2);
	JTextField tf2 = new JTextField("10",2);
	JLabel l1 = new JLabel("theta = ");
	JLabel l2 = new JLabel("degree(s), ");
	JLabel l3 = new JLabel("u = ");
	JLabel l4 = new JLabel("m/s");
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p = new JPanel();
	int cw = 40;
	int ch = 16;
	double cd = Math.sqrt(cw*cw + ch*ch);
	double beta = Math.atan((double)ch/(double)cw);
	int x1 = 20;
	int y1 = 300;
	int r = 7;
	int bx = x1;
	int by = y1-ch/2-r;
	int bXCenter, bYCenter;
	int[] xarray = {x1, x1+cw, x1+cw, x1};
	int[] yarray = {y1, y1, y1-ch, y1-ch};
	double tof; //time of flight
	double u; // initial velocity in m/s
	double theta = 0;
	double g = 9.8; // gravitational acceleration in m/s^2
	double maxHeight;
	int step = 1;
	String tofMessage = "TOF";
	String dMessage = "Distance";
	String maxHMessage;
	boolean fire = false;
	boolean showMaxHeight = false;
	CannonBall(){
		this.setBackground(Color.black);
		p1.add(l1); p1.add(tf1); p1.add(l2);
		p1.add(l3); p1.add(tf2); p1.add(l4);
		p2.add(b1); p2.add(b2);
		p.setLayout(new GridLayout(1,2));
		p.add(p1); p.add(p2);
		f.add(p,BorderLayout.SOUTH);
		f.add(this);
		tf1.addActionListener(this);
		tf2.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		f.setSize(500,400);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(new Color(100,200,100));
		g.fillPolygon(xarray, yarray, 4);
		g.setColor(new Color(200,0,0));
		g.fillOval(bx, by , 2*r, 2*r);
		g.setColor(new Color(50,100,50));
		g.drawPolygon(xarray, yarray, 4);
		g.fillArc(10, y1-10, 20, 20, 0, 180);
		g.setColor(new Color(100,200,100));
		g.drawLine(0, y1, 500, y1);
		g.drawLine(470, y1-10, 470, y1+10);
		if(fire) {
			g.setColor(new Color(100,250,100));
			g.drawString(tofMessage, 350, 100);
			g.drawString(dMessage, 350, 115);
			if(showMaxHeight) {
				g.drawString("Max Height = " + Math.round(maxHeight*100.0)/100.0 + " m.", 350, 130);
				showMaxHeight = false;
			}
		}
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == tf1) {
			setCannon();
			fire = false;
		} else if(e.getSource() == tf2) {
			u = Double.parseDouble(tf2.getText());
			setCannon();
			fire = false;
		}
		else if (e.getSource() == timer) {
			//tof = 2*u*Math.sin(theta)/g;
			//maxHeight = u*u*Math.pow(Math.sin(theta), 2)/(2*g);
			double t = 0.01*step;
			double sx = u*Math.cos(theta)*t; // in m
			double sy = u*Math.sin(theta)*t - g*t*t/2; // in m
			bx = bXCenter + toPixel(sx) - r;
			by = bYCenter - toPixel(sy) - r;
			step++;
			tofMessage = "TOF = " + Math.round(t*100.0)/100.0 + " s.";
			dMessage = "Distance = " + Math.round(sx*100.0)/100.0 + " m.";
			if(0.01*step > tof) {
				timer.stop();
				tofMessage = "TOF = " + Math.round(tof*100.0)/100.0 + " s.";
				dMessage = "Distance = " + Math.round(100.0*u*u*Math.sin(2*theta)/g)/100.0 + " m.";
				showMaxHeight = true;
			}
		} else if (e.getSource() == b1) {
			setCannon();
			u = Double.parseDouble(tf2.getText());
			step = 1;
			tof = 2*u*Math.sin(theta)/g;
			maxHeight = u*u*Math.pow(Math.sin(theta), 2)/(2*g);
			timer.start();
			fire = true;
		} else if (e.getSource() == b2) {
			timer.stop();
			tf1.setText("0");
			tf2.setText("10");
			setCannon();
			fire = false;
		}
		repaint();
	}
	int toPixel(Double distance) {
		return (int)Math.round(distance*(470-bXCenter)/(u*u/g));
	}
	void setCannon() {
		theta = Math.toRadians(Double.parseDouble(tf1.getText()));
		double d = Math.sqrt(Math.pow(ch/2, 2) + Math.pow(r, 2));
		double alpha = Math.atan(2*(double)r/(double)ch);
		bXCenter = x1 - (int)Math.round(d*Math.cos(Math.PI/2-theta+alpha));
		bYCenter = y1 - (int)Math.round(d*Math.sin(Math.PI/2-theta+alpha));
		bx = bXCenter - r;
		by = bYCenter - r;
		xarray[1] = x1 + (int)Math.round(cw*Math.cos(theta));
		yarray[1] = y1 - (int)Math.round(cw*Math.sin(theta));
		xarray[3] = x1 - (int)Math.round(ch*Math.cos(Math.PI/2-theta));
		yarray[3] = y1 - (int)Math.round(ch*Math.sin(Math.PI/2-theta));
		xarray[2] = x1 + (int)Math.round(cd*Math.cos(beta+theta));
		yarray[2] = y1 - (int)Math.round(cd*Math.sin(beta+theta));
	}
	public static void main(String[] args) {
		new CannonBall();

		hello
		dawdadwaa
	}
}