package tasks;

public class ChickenNuggetsMaxim {
    public static int[] calculateBottomUp(int n) {
        int[] boxSizes = new int[]{6, 10, 15};
        return bottomUp(n, boxSizes);
    }

    private static int[] bottomUp(int n, int[] boxSizes) {
        int[] result = new int[boxSizes.length];

        for (int i = boxSizes.length - 1; i >= 0 && n > 0; i--) {
            int currentBoxSize = boxSizes[i];
            int nextBoxSize = i == 0 ? 0 : boxSizes[i - 1];
            result[i] += n / currentBoxSize;
            n %= currentBoxSize;
            // We need at least 2 boxes of lower size to fit leftovers, so just use one more bigger box instead
            if (n > nextBoxSize) {
                result[i]++;
                break;
            }
        }

        return result;
    }
}
