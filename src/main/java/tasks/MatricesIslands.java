package tasks;

public class MatricesIslands {

    public static int[][] MAP = new int[][]{
            {1, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 0, 1},
            {0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 1, 1},
            {1, 1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1, 1}
    };

    // O(n*m)
    public static int countIslands(int[][] map) {
        int result = 0;
        boolean[][] graph = new boolean[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++) {
                if(!graph[i][j]) {
                    if (map[i][j] == 1) {
                        result++;
                        traversIsland(map, graph, i, j);
                    } else {
                        graph[i][j] = true;
                    }
                }
            }
        }

        return result;
    }

    private static void traversIsland(int[][] map, boolean[][] graph, int i, int j) {
        if (graph[i][j]) {
            return;
        }
        graph[i][j] = true;
        if (map[i][j] == 0) {
            return;
        }

        if (j != map[0].length-1) { // →
            traversIsland(map, graph, i, j+1);
        }
        if (j != 0) { // ←
            traversIsland(map, graph, i, j-1);
        }
        if (i != map.length-1) { // ↓
            traversIsland(map, graph, i+1, j);
        }
        if (i != 0) { // ↑
            traversIsland(map, graph, i-1, j);
        }
    }


}
