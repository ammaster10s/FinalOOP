package Logic;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape {
    private int x;
    private int y;
    private Color color;
    
    public Shape(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public Color getColor() {
        return color;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public void setColor(Color color) {
        this.color = color;
    }
    
    public abstract boolean matches(Shape other);

    public void paintComponent(Graphics g) {
    }

    public java.awt.Shape getShape() {
        return null;
    }
}
