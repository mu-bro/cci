package firstTime.tasks;

import firstTime.helpers.Helper;

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
                for (j = i; j < arr.length - 1 - removedElements; j++) {
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

    public static boolean isStringsAnagrams(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        int nonUniqueCharacters = 0;
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        int[] repeats = new int[256];

        // check first string
        for (int i = 0; i < str1.length(); i++) {
            int elem = arr1[i] - 'A';
            if (repeats[elem] == 0) {
                nonUniqueCharacters++;
            }
            repeats[elem]++;
        }

        // check second string
        for (int i = 0; i < str2.length(); i++) {
            int elem = arr2[i] - 'A';
            if (repeats[elem] == 0) {
                return false;
            }
            repeats[elem]--;
            if (repeats[elem] == 0) {
                nonUniqueCharacters--;
            }
            if (nonUniqueCharacters == 0 && i == str1.length() - 1 && repeats[elem] == 0) {
                return true;

            }
        }
        return false;
    }

    public static char[] replaceSpaces(char[] str, int length) {
        int newLength = length;
        for (int i = 0; i < length; i++) {
            if (str[i] == ' ') {
                newLength += 2;
            }
        }
        str[newLength] = '\0';
        int newLength2 = newLength - 1;
        for (int i = length - 1; i >= 0; i--) {
            newLength--;
            if (str[i] == ' ') {
                str[newLength--] = '0';
                str[newLength--] = '2';
                str[newLength] = '%';
            } else {
                str[newLength] = str[i];
            }
        }
        char newArr[] = new char[newLength2];
        System.arraycopy(str, 0, newArr, 0, newLength2);
        return newArr;
    }


    /**
     * Complexity - O(n2)
     */
    public static int[][] rotateImage(int[][] matrix, int n) {
        n--;
        Helper.printMatrix("Input:", matrix);
        int tmp, target_i, target_j, source_i, source_j;
        int step = 0;
        for (int i = step++; i < n - step; i++) {
            for (int j = i; j < n - i; j++) {
                tmp = matrix[i][j];
                rotateElement(i, j, matrix);
                rotateElement(n - j, i, matrix);
                rotateElement(n - i, n - j, matrix);
                matrix[j][n - i] = tmp;
            }
        }
        Helper.printMatrix("Result:", matrix);
        return matrix;
    }

    private static void rotateElement(int i, int j, int[][] matrix) {
        matrix[i][j] = matrix[matrix.length - 1 - j][i];
    }

    public static int[][] rowsAndColumnsToZero(int[][] matrix) {
        Helper.printMatrix("Input:", matrix);
        int rows = 0;
        int columns = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rows |= (1<<i);
                    columns |= (1<<j);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (((rows & (1<<i)) > 0) || ((columns & (1<<j)) > 0)) {
                    matrix[i][j] = 0;
                }
            }
        }
        Helper.printMatrix("Result:", matrix);
        return matrix;
    }

    public static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        String s1s1 = s1 + s1;
        return s1s1.contains(s2);
    }
}
