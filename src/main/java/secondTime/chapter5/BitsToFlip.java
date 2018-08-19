package secondTime.chapter5;

public class BitsToFlip {

    public static int find(int a, int b) {
        int count = 0;
        for (int c = a ^ b; c > 0; c = c >> 1) {
            if ((c & 1) > 0) {
                count++;
            }
        }
        return count;
    }
}
