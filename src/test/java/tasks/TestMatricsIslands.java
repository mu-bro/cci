package tasks;

import org.junit.Assert;
import org.junit.Test;

public class TestMatricsIslands {

    @Test
    public void matricsIslandsTest() {
        int[][] map1 = new int[][]{
                {1, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 0, 1},
                {0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 1},
                {1, 1, 0, 0, 0, 1},
                {1, 0, 0, 0, 1, 1}
        };
        Assert.assertEquals(5, MatricesIslands.countIslands(map1));

        int[][] map2 = new int[][]{
                {1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 1},
                {0, 1, 1, 1, 0, 1},
                {0, 1, 0, 1, 0, 1},
                {0, 1, 0, 0, 0, 1},
                {0, 1, 1, 1, 1, 1}
        };
        Assert.assertEquals(1, MatricesIslands.countIslands(map2));


        int[][] map3 = new int[][]{
                {1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1}
        };
        Assert.assertEquals(18, MatricesIslands.countIslands(map3));

        int[][] map4 = new int[][]{
                {1, 1, 1, 1, 1},
                {1, 1, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {1, 0, 0, 0, 0}
        };
        Assert.assertEquals(2, MatricesIslands.countIslands(map4));
    }
}
