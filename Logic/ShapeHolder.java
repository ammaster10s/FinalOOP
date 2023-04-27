package Logic;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ShapeHolder extends Shape {
    private Shape currentShape;
    private int x, y;
    
    public ShapeHolder(int x, int y) {
        this.x = x;
        this.y = y;
        this.currentShape = null;
    }
    
    public Shape getCurrentShape() {
        return currentShape;
    }
    
    public void setCurrentShape(Shape shape) {
        currentShape = shape;
    }
    
    public void removeShape() {
        currentShape = null;
    }
    
    public boolean hasShape() {
        return currentShape != null;
    }
    
    public boolean isShapeMatched() {
        if (currentShape == null) {
            return false;
        }
        
        return currentShape.getShape() == getShape();
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        if (currentShape != null) {
            currentShape.paintComponent(g2d, x, y);
        }
    }

    @Override
    public boolean matches(Shape other) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'matches'");
    }
}
