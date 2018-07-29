package secondTime.chapter1;

public class OneWayStep {

    // O(n)
    public static boolean isOneWayStep(String input1, String input2) {
        if (lengthIsDifferentOneMoreThanOne(input1, input2)) {
            return false;
        }
        if (input1.length() == input2.length()) {
            return stringsHaveOneOrLessLetterDifference(input1, input2);
        }
        if (input1.length() > input2.length()) {
            return isStringsHasOneLetterDifference(input2, input1);
        } else {
            return isStringsHasOneLetterDifference(input1, input2);
        }
    }

    private static boolean isStringsHasOneLetterDifference(String shorterString, String longString) {
        boolean hasOneDifferent = false;
        for (int i = 0; i < shorterString.length(); i++) {
            int j = hasOneDifferent ? i+1 : i;
            if (shorterString.charAt(i) != longString.charAt(j)) {
                if (hasOneDifferent) {
                    return false;
                }
                hasOneDifferent = true;
            }
        }
        return true;
    }

    private static boolean stringsHaveOneOrLessLetterDifference(String input1, String input2) {
        boolean hasOneDifferent = false;
        for (int i = 0; i < input1.length(); i++) {
            if (input1.charAt(i) != input2.charAt(i)) {
                if (hasOneDifferent) return false;
                hasOneDifferent = true;
            }
        }
        return true;
    }

    private static boolean lengthIsDifferentOneMoreThanOne(String input1, String input2) {
        return (Math.abs(input1.length() - input2.length()) > 1);
    }


}
