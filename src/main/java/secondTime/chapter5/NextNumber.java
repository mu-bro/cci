package secondTime.chapter5;

import org.apache.commons.lang.ArrayUtils;

import java.util.Arrays;

public class NextNumber {

    public static void find(int number) {
        int[] array = binaryToArray(number);
        System.out.println(findMin(ArrayUtils.clone(array)));
        System.out.println(findMax(ArrayUtils.clone(array)));
    }

    private static int findMin(int[] array) {
        int last_0_index = -1;
        for (int i = 0; i < 8; i++) {
            if (array[i] == 0) {
                last_0_index = i;
            }
            if (array[i] == 1 && last_0_index > 0) {
                array[i] = 0;
                array[last_0_index] = 1;
                break;
            }
        }
        printArray(array, "min: ");
        return arrayTobinary(array);
    }

    private static int findMax(int[] array) {
        int last_1_index = -1;
        for (int i = 0; i < 8; i++) {
            if (array[i] == 1) {
                last_1_index = i;
            }
            if (array[i] == 0 && last_1_index > 0) {
                array[i] = 1;
                array[last_1_index] = 0;
                break;
            }
        }
        printArray(array, "max: ");
        return arrayTobinary(array);
    }

    private static int arrayTobinary(int[] array) {
        int number = 0;
        for (int i = 0; i < 8; i++) {
            if (array[i] == 1) {
                number |= (1 << i);
            }
        }
        return number;
    }

    private static int[] binaryToArray(int number) {
        int[] array = new int[8];
        for (int i = 0; i < 8; i++) {
            array[i] = ((number & (1 << i)) > 0) ? 1 : 0;
        }
        printArray(array, "number: ");
        return array;
    }

    private static void printArray(int[] array, String string) {
        int[] clone = ArrayUtils.clone(array);
        ArrayUtils.reverse(clone);
        System.out.println(string + Arrays.toString(clone));
    }
}
