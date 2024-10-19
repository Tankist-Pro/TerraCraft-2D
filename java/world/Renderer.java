package world;

import block.Block;
import main.GamePanel;

import java.awt.*;

public class Renderer {

    public static void draw(int[][] world, Block[] blocks, Graphics2D graphics2D, GamePanel gamePanel) {
        int worldColumn = 0;
        int worldRow = 0;


        while (worldRow != Setting.MAX_WORLD_ROWS) {
            int worldX = worldColumn * GamePanel.BLOCK_SIZE;
            int worldY = worldRow * GamePanel.BLOCK_SIZE;
            int screenX = worldX - (gamePanel.player.worldX - gamePanel.player.screenX);
            int screenY = worldY - (gamePanel.player.worldY - gamePanel.player.screenY);

            if (worldX > (gamePanel.player.worldX - gamePanel.player.screenX - GamePanel.BLOCK_SIZE) &&
                    worldX < (gamePanel.player.worldX + gamePanel.player.screenX + GamePanel.BLOCK_SIZE) &&
                    worldY > (gamePanel.player.worldY - gamePanel.player.screenY - GamePanel.BLOCK_SIZE) &&
                    worldY < (gamePanel.player.worldY + gamePanel.player.screenY + GamePanel.BLOCK_SIZE)) {

                Block block = blocks[world[worldRow][worldColumn]];
                block.draw(graphics2D, screenX, screenY);
            }


            worldColumn++;
            if (worldColumn == Setting.MAX_WORLD_COLUMNS) {
                worldColumn = 0;
                worldRow++;
            }
        }
    }
}
