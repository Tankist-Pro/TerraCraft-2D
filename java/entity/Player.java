package entity;

import main.GamePanel;
import main.KeyHandler;
import world.Setting;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {

    // handlers
    KeyHandler keyHandler;

    // screen position
    public int screenX = GamePanel.WIDTH / 2 - GamePanel.HALF_BLOCK_SIZE;
    public int screenY = GamePanel.HEIGHT / 2 - GamePanel.HALF_BLOCK_SIZE;
    // skins
    BufferedImage skinLeft, skinRight;

    public Player(KeyHandler keyHandler) {
        super();
        this.keyHandler = keyHandler;
        loadSkins();
        worldX = Setting.WORLD_WIDTH / 2 - GamePanel.HALF_BLOCK_SIZE;
        worldY = Setting.WORLD_HEIGHT / 4;
    }

    public void loadSkins(){
        try {
            skinLeft = ImageIO.read(getClass().getResourceAsStream("/textures/entity/player/left.png"));
            skinRight = ImageIO.read(getClass().getResourceAsStream("/textures/entity/player/right.png"));
        }
        catch (IOException e) {
            System.err.println("skins not loaded!");
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D graphics2D) {

        switch (direction) {
            case "left":
                skin = skinLeft;
                break;

            case "right":
                skin = skinRight;
                break;
        }

        graphics2D.drawImage(skin, screenX, screenY, GamePanel.BLOCK_SIZE, GamePanel.BLOCK_SIZE, null);
    }

    public void update() {
        move();
        jump();
    }

    private void move() {
        if (keyHandler.moveRight) {
            direction = "right";
            worldX += moveSpeed;
        }
        else if (keyHandler.moveLeft) {
            direction = "left";
            worldX -= moveSpeed;
        }
    }
    private void jump() {
        if (keyHandler.jump && !inJump) {
            inJump = true;
            currentJumpStrength = -defaultJumpStrength;
        }

        if (this.inJump) {

            if (currentJumpStrength > defaultJumpStrength) {
                // currentJumpStrength = -defaultJumpStrength;
                inJump = false;
                return;
            }

            worldY += currentJumpStrength;
            currentJumpStrength += 2;
        }
    }

}
