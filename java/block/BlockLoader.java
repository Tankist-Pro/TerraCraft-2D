package block;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class BlockLoader {
    public Block[] blocks;

    public BlockLoader() {
        blocks = new Block[5];
        loadBlocks();
    }

    private void loadBlocks() {

        try {
            File file = new File("source/blocks.txt");
            Scanner scanner = new Scanner(file);
            int index = 0;

            while (scanner.hasNextLine()) {
                String[] properties = scanner.nextLine().split(" ");
                String blockName = properties[0];
                boolean collision = Objects.equals(properties[1], "true");
                String path = properties[2];

                blocks[index] = new Block(path, collision, blockName);
                index++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
