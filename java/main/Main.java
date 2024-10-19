package main;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        // init window
        JFrame window = new JFrame();

        // set window properties
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2D Craft");

        // init and add GamePanel to window
        GamePanel gamePanel = new GamePanel();
        gamePanel.setGameThread();
        window.add(gamePanel);

        // create window
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
