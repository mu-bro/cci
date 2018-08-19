package secondTime.chapter5;

public class PairwiseSwap {

    public static int swap(int a) {
        int mask = 2 + 8 + 32 + 128;

        int even = a & mask;
        int odd = a & (mask >>> 1);

        int even_shifted = even >>> 1;
        int odd_shifted = odd << 1;
        return even_shifted | odd_shifted;
    }
}
