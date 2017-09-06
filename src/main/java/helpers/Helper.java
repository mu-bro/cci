package helpers;

import java.util.Random;

public class Helper {

    private static Random rand = new Random();

    public static int[][] createMatrix(int length) {
        int elem = 0;
        int[][] arr = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                arr[i][j] = elem++;
            }
        }
        return arr;
    }

    public static int[][] createRandomMatrix(int n, int m) {
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = rand.nextInt(20);
            }
        }
        return arr;
    }

    public static void printMatrix(String title, int[][] arr) {
        System.out.println(title);
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(String.format("%3d", arr[i][j]));
            }
            System.out.println();
        }
    }
}


