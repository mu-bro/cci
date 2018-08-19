package secondTime.chapter1;

import java.util.ArrayList;
import java.util.List;

public class ZeroMatrix {

    public static int[][] zero(int[][] input) {
        int zeroRows = 0;
        int zeroCols = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                if (input[i][j]==0) {
                    zeroRows |= (1 << j);
                    zeroCols |= (1 << i);
                }
            }
        }
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
               if (
                       ((zeroRows & (1<<j)) > 0)
                        ||
                        ((zeroCols & (1<<i)) > 0)
               ) {
                    input[i][j] = 0;
               }
            }
        }
        return input;
    }
}
