public class LevelManager {
    static BlockType[][] loadLevel(String levelName) {
        BlockType[][] level = new BlockType[MyWorld.LEVEL_SIZE][MyWorld.LEVEL_SIZE];
        if (levelName.equals("level_01")) {
            level = new BlockType[][]
                    {{BlockType.BRICK3, BlockType.NONE, BlockType.NONE, BlockType.BRICK3, BlockType.NONE},
                            {BlockType.BRICK3, BlockType.NONE, BlockType.NONE, BlockType.NONE, BlockType.NONE},
                            {BlockType.BRICK3, BlockType.NONE, BlockType.NONE, BlockType.NONE, BlockType.NONE},
                            {BlockType.BRICK3, BlockType.BRICK1, BlockType.NONE, BlockType.NONE, BlockType.BRICK1},
                            {BlockType.BRICK3, BlockType.NONE, BlockType.NONE, BlockType.NONE, BlockType.BRICK1},
                            {BlockType.BRICK3, BlockType.NONE, BlockType.NONE, BlockType.NONE, BlockType.BRICK1},
                            {BlockType.BRICK3, BlockType.NONE, BlockType.NONE, BlockType.NONE, BlockType.BRICK1},
                            {BlockType.BRICK3, BlockType.NONE, BlockType.NONE, BlockType.NONE, BlockType.BRICK1},
                            {BlockType.BRICK3, BlockType.NONE, BlockType.NONE, BlockType.NONE, BlockType.BRICK1},
                            {BlockType.BRICK3, BlockType.NONE, BlockType.NONE, BlockType.NONE, BlockType.BRICK1},
                            {BlockType.BRICK3, BlockType.NONE, BlockType.NONE, BlockType.NONE, BlockType.BRICK1},
                            {BlockType.BRICK3, BlockType.NONE, BlockType.NONE, BlockType.NONE, BlockType.BRICK1},
                            {BlockType.BRICK3, BlockType.NONE, BlockType.NONE, BlockType.NONE, BlockType.BRICK1},
                            {BlockType.BRICK3, BlockType.NONE, BlockType.NONE, BlockType.NONE, BlockType.BRICK1},
                            {BlockType.BRICK3, BlockType.NONE, BlockType.NONE, BlockType.NONE, BlockType.BRICK1},
                            {BlockType.BRICK3, BlockType.NONE, BlockType.NONE, BlockType.NONE, BlockType.BRICK1},
                            {BlockType.BRICK3, BlockType.NONE, BlockType.NONE, BlockType.NONE, BlockType.BRICK1}};
        /*    for (int x = 0; x < MyWorld.LEVEL_SIZE; x++) {
                for (int y = 0; y < MyWorld.LEVEL_SIZE; y++) {
                    if (Math.random() > 0.5f) {
                        level[x][y] = BlockType.NONE;
                        continue;
                    }
                    if (y == 2)
                        level[x][y] = BlockType.BRICK1;
                    else
                        level[x][y] = BlockType.BRICK2;
                }
            }   */
        }
        return level;
    }
}
