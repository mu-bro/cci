package tasks.secondTime.Chapter1;

public class Chapter1_2 {

    // O(n)
    public static boolean isUniqueCharacters(String input) {
        int bitMask = 0;
        for (char letter : input.toCharArray()) {
            int num = (letter - 'a') + 1;
            if ((bitMask & (1 << num)) > 0) {
                return false;
            }
            bitMask |= 1 << num;
        }
        return true;
    }

    // O (n)
    public static boolean isPermutation(String input1, String input2) {
        if (input1.length() != input2.length()) return false;

        int[] counter = new int[126];
        for (char letter : input1.toCharArray()) {
            int num = letter - 'a';
            counter[num]++;
        }

        for (char letter : input2.toCharArray()) {
            int num = letter - 'a';
            counter[num]--;
        }

        for (char letter : input1.toCharArray()) {
            int num = letter - 'a';
            if (counter[num] != 0) return false;
        }
        return true;
    }
}
