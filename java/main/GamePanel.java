package main;

import block.BlockLoader;
import entity.Player;
import world.Creater;
import world.Loader;
import world.Renderer;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    // default game properties
    private static final int IMAGE_SIZE = 16;
    public static final int SCALE = 2;
    public static final int BLOCK_SIZE = IMAGE_SIZE * SCALE;
    public static final int HALF_BLOCK_SIZE = BLOCK_SIZE / 2;

    // window properties
    public static final int COLUMNS = 30;
    public static final int ROWS = 18;
    public static final int WIDTH = COLUMNS * BLOCK_SIZE;
    public static final int HEIGHT = ROWS * BLOCK_SIZE;
    private static final int FPS = 50;

    // Handlers
    KeyHandler keyHandler = new KeyHandler();
    MouseHandler mouseHandler = new MouseHandler();

    // init Player
    public Player player = new Player(keyHandler);
    // blocks
    BlockLoader blockLoader = new BlockLoader();
    int[][] world;
    // game Thread
    Thread gameThread;

    // init GamePanel
    public GamePanel() {
        // set default properties
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        // adds handlers
        this.addKeyListener(keyHandler);
        this.addMouseListener(mouseHandler);
        this.addMouseMotionListener(mouseHandler);
    }

    // set's gameThread method
    public void setGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    // run game method
    @Override
    public void run() {

        float interval = (float) 1_000_000_000 / FPS; //  1s / fps
        float delta = 0;
        long oldTime = System.nanoTime();
        long newTime;

        Creater.newFlatWorld("new");
        world = Loader.loadWorld("source/worlds/new.txt");

        // game loop
        while (gameThread != null) {

            newTime = System.nanoTime();
            delta += (newTime - oldTime) / interval;
            oldTime = System.nanoTime();


            if (delta >= 1) {
                //System.out.println("fps: " + (FPS * delta));
                update();
                repaint();

                delta--;
            }
        }
    }

    // update game info method
    public void update() {
        player.update();
    }

    // draw elements on screen method
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;

        Renderer.draw(world, blockLoader.blocks, graphics2D, this);
        player.draw(graphics2D);
    }
}
