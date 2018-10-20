package tasks.secondTime.Chapter8;

public class TripleStep {

    // O(n^3)
    public static int count2(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else {
            return count2(n - 1) + count2(n - 2) + count2(n - 3);
        }
    }

    public static int count(int n) {
        int[] cache = new int[n + 1];
        cache[0] = 1;
        cache[1] = 1;

        return count(n, cache);
    }
    public static int count(int n, int[] cache) {
        if (n < 0) {
            return 0;
        }
        if (cache[n] == 0) {
            cache[n] = count(n - 1, cache) + count(n - 2, cache) + count(n - 3, cache);
        }
        return cache[n];
    }
}
