package tasks;

public class Chapter1 {

    public static boolean isUniqueCharacters(String input) {
        int checker = 0;
        for (int i = 0; i < input.length(); ++i) {
            int val = input.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) return false;
            checker |= (1 << val);
        }
        return true;
    }

    public static String reverseString(String input) {
        char[] inputArr = input.toCharArray();
        char tmp;
        for (int i = 0; i < inputArr.length / 2; i++) {
            int returnElementIndex = inputArr.length - 1 - i;
            tmp = inputArr[returnElementIndex];
            inputArr[returnElementIndex] = inputArr[i];
            inputArr[i] = tmp;
        }
        return new String(inputArr);
    }


    public static String removeDuplicatedCharacters(String input) {
        long bitFlag = 0;
        int removedElements = 0;
        char[] arr = input.toCharArray();
        for (int i = 0; i < arr.length - removedElements; i++) {
            int elem = arr[i] - 'A';
            if ((bitFlag & (1 << elem)) > 0) {
                int j;
                for (j = i; j < arr.length - 1- removedElements; j++) {
                    arr[j] = arr[j + 1];
                }
                removedElements++;
                i--;
            } else {
                bitFlag |= (1 << elem);
            }
        }
        char[] newArr = new char[arr.length - removedElements];
        System.arraycopy(arr, 0, newArr, 0, newArr.length);
        return new String(newArr);
    }
}
