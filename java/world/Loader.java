package world;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Loader {

    public static int[][] loadWorld(String path) {
        int[][] world = new int[Setting.MAX_WORLD_ROWS][Setting.MAX_WORLD_COLUMNS];
        try {
            File file = new File(path);
            Scanner scanner = new Scanner(file);

            int column = 0;
            int row = 0;

            while (scanner.hasNextInt() && row < Setting.MAX_WORLD_ROWS) {
                world[row][column] = scanner.nextInt();

                column++;

                if (column == Setting.MAX_WORLD_COLUMNS) {
                    column = 0;
                    row++;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return world;
    }
}
