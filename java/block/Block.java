package block;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Block {

    public String name;
    public BufferedImage image;
    public boolean hasCollision;

    public Block(String pathToImage, boolean hasCollision, String name) {
        this.hasCollision = hasCollision;
        this.name = name;
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(pathToImage)));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D graphics2D, int x, int y) {
        graphics2D.drawImage(image, x, y, GamePanel.BLOCK_SIZE, GamePanel.BLOCK_SIZE, null);
    }
}
