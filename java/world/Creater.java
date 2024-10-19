package world;

import block.Block;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Creater {


    public static void newFlatWorld(String name) {
        int column = 0;
        int row = 0;
        int currentBlock = 0;

        try {
            File file = new File("source/worlds/" + name + ".txt");
            file.createNewFile();
            FileWriter file1 = new FileWriter("source/worlds/" + name + ".txt");

            while (row < Setting.MAX_WORLD_ROWS) {
                file1.append(currentBlock + " ");

                if (row > 8)
                    currentBlock = 2;
                if (row == 8)
                    currentBlock = 1;
                if (row == Setting.MAX_WORLD_ROWS - 1)
                    currentBlock = 3;

                column++;
                if (column == Setting.MAX_WORLD_COLUMNS) {
                    file1.append("\n");
                    column = 0;
                    row++;
                }
            }
            file1.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
