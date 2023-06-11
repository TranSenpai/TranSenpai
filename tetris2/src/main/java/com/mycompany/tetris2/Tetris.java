package com.mycompany.tetris2;
// Class contain methods to border the frame
import java.awt.BorderLayout;
// Class contain methods to create a frame
import javax.swing.JFrame;
// Class contain methods to display a label by a text or image or both 
import javax.swing.JLabel;
// Collection of utilities for swing
import javax.swing.SwingUtilities;
 

public class Tetris extends JFrame {
 
    private JLabel statusbar;
 
    public Tetris() {
         
        initUI();
   }
     
    private void initUI() {
        // Create a variable statusbar to record point player
        statusbar = new JLabel("Begin");
        // Set it in the bootom of container (south direction)
        add(statusbar, BorderLayout.SOUTH);
        // Create a object board from class board to add to game area
        Board board = new Board(this);
        add(board);
        // Create a thread for the game to execute multiple methods at the same time
        board.start();
        // Set the size of frame
        setSize(200, 400);
        // Set frame's name
        setTitle("Tetris");
        // Add close button
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // center the gui (graphic user inferface) on the screen (responsive design layout)
        setLocationRelativeTo(null);       
    }
    // Getter
    public JLabel getStatusBar() {
        
        return statusbar;
    }
 
    public static void main(String[] args) {
        // Run thread
        SwingUtilities.invokeLater(new Runnable() {
             
            @Override
            public void run() {
                 
                Tetris game = new Tetris();
                game.setVisible(true);
            }
        });                
    } 
}