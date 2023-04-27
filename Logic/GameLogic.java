package Logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameLogic {
    
    private List<Shape> shapes; // List of shapes to match
    private List<Shape> holder; // List of shapes in the holder
    private int currentShapeIndex; // Index of the current shape to match
    private int matchCount; // Number of shapes matched
    private boolean gameActive; // Flag indicating whether the game is active
    private long startTime; // Start time of the game
    
    public GameLogic() {
        shapes = new ArrayList<>();
        holder = new ArrayList<>();
        currentShapeIndex = 0;
        matchCount = 0;
        gameActive = false;
    }
    
    public void startGame() {
        // Reset the game state
        shapes.clear();
        holder.clear();
        currentShapeIndex = 0;
        matchCount = 0;
        gameActive = true;
        startTime = System.currentTimeMillis();
        
        // Add the shapes to the list
        shapes.add(new Square());
        shapes.add(new Triangle());
        shapes.add(new Circle());
        shapes.add(new Pentagon());
        shapes.add(new Hexagon());
        
        // Shuffle the shapes to randomize their order
        Collections.shuffle(shapes);
        
        // Add the first shape to the holder
        holder.add(shapes.get(0));
    }
    
    public boolean isGameActive() {
        return gameActive;
    }
    
    public List<Shape> getShapes() {
        return shapes;
    }
    
    public List<Shape> getHolder() {
        return holder;
    }
    
    public Shape getCurrentShape() {
        return shapes.get(currentShapeIndex);
    }
    
    public boolean isShapeMatched() {
        return holder.contains(getCurrentShape());
    }
    
    public void matchShape() {
        holder.remove(getCurrentShape());
        matchCount++;
        currentShapeIndex++;
        
        // Add the next shape to the holder
        if (currentShapeIndex < shapes.size()) {
            holder.add(shapes.get(currentShapeIndex));
        }
        
        // Check if the game is over
        if (matchCount == shapes.size()) {
            gameActive = false;
        }
    }
    
    public long getElapsedTime() {
        return System.currentTimeMillis() - startTime;
    }
    
}
