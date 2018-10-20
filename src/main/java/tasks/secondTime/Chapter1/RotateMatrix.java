package tasks.secondTime.Chapter1;

public class RotateMatrix {

    // O (n)
    public static int[][] rotate(int[][] input) {
        if (input.length != input[0].length) throw new RuntimeException("matrix should be N*N");
        int N = input.length - 1;

        for (int i = 0; i < input.length / 2; i++) {
            for (int j = i; j < N - i; j++) {
                int tmp = input[i][j];
                rotateElement(input, N - j, i);
                rotateElement(input, N - i, N - j);
                rotateElement(input, j, N - i);
                input[j][N - i] = tmp;
            }
        }

        return input;
    }

    private static void rotateElement(int[][] input, int i, int j) {
        int new_i = j;
        int new_j = (input.length - 1) - i;
        input[new_i][new_j] = input[i][j];
    }
}
