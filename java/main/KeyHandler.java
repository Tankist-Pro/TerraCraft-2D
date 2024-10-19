package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean moveLeft = false;
    public boolean moveRight = false;
    public boolean jump = false;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_D)
            moveRight = true;
        else if (keyCode == KeyEvent.VK_A)
            moveLeft = true;
        else if (keyCode == KeyEvent.VK_SPACE)
            jump = true;

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_D)
            moveRight = false;
        else if (keyCode == KeyEvent.VK_A)
            moveLeft = false;
        else if (keyCode == KeyEvent.VK_SPACE)
            jump = false;
    }
}
