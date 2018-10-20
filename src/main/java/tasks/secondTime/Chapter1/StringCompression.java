package tasks.secondTime.Chapter1;

public class StringCompression {

    // O (n)
    public static String compress(String input) {
        char previousChar = input.charAt(0);
        int count = 0;
        StringBuilder finalString = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != previousChar) {
                finalString.append(previousChar);
                finalString.append(count);
                previousChar = input.charAt(i);
                count = 1;
            } else {
                count++;
            }
        }
        finalString.append(previousChar);
        finalString.append(count);

        return finalString.length() >= input.length() ? input : finalString.toString();

    }
}
