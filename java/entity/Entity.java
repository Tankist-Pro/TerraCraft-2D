package entity;

import java.awt.image.BufferedImage;

// base entity class
public class Entity {

    // world position
    public int worldX;
    public int worldY;

    public boolean inJump;
    public String direction;
    public int moveSpeed;
    public int defaultJumpStrength;
    public int currentJumpStrength;

    // skin
    BufferedImage skin;

    public Entity() {
        this.worldX = 0;
        this.worldY = 0;

        this.inJump = false;
        this.direction = "left";
        this.moveSpeed = 4;
        this.defaultJumpStrength = 12;
    }
}
