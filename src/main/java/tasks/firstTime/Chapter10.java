package tasks.firstTime;

import java.util.LinkedList;
import java.util.Queue;

public class Chapter10 {

    public static void mergeSort(int[] array) {
        mergeSort(array, new int[array.length], 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int[] temp, int startLeft, int rightEnd) {
        if (startLeft >= rightEnd) {
            return;
        }
        int middle = (startLeft + rightEnd) / 2;
        mergeSort(array, temp, startLeft, middle);
        mergeSort(array, temp, middle + 1, rightEnd);
        mergeHalfs(array, temp, startLeft, rightEnd);
    }

    private static void mergeHalfs(int[] array, int[] temp, int leftStart, int rightEnd) {
        int leftEnd = (rightEnd + leftStart) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = left;

        while (left <= leftEnd && right <= rightEnd) {
            if (array[left] <= array[right]) {
                temp[index] = array[left];
                left++;
            } else {
                temp[index] = array[right];
                right++;
            }
            index++;
        }
        System.arraycopy(array, left, temp, index, leftEnd - left + 1);
        System.arraycopy(array, right, temp, index, rightEnd - right + 1);
        System.arraycopy(temp, leftStart, array, leftStart, size);
    }

    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = (end + start) / 2;
        partition(array, start, end);
        quickSort(array, start, pivot);
        quickSort(array, pivot + 1, end);
    }

    private static void partition(int[] array, int start, int end) {
        int pivot = (end + start) / 2;

        while (start < end) {
            while (array[start] <= array[pivot]) start++;
            while (array[end] > array[pivot]) end--;


            if (array[start] > array[end]) {
                swap(array, start, end);
                start++;
                end--;
            }
        }
    }

    private static void swap(int[] array, int start, int end) {
        int tmp = array[start];
        array[start] = array[end];
        array[end] = tmp;
    }

    public static void radixSort(int[] array) {
        Queue<Integer>[] buckets = new Queue[10];
        for (int j = 0; j < 10; j++) {
            buckets[j] = new LinkedList<>();
        }

        int n, m, bucket;
        for (int i = 1; i <= 3; i++) {
            n = (int) Math.pow(10, i);
            m = n / 10;
            for (int j = 0; j < array.length; j++) {
                bucket = (array[j] % n) / m;
                buckets[bucket].add(array[j]);
            }

            int elemNum = 0;
            for (int j = 0; j < 10; j++) {
                while (!buckets[j].isEmpty()) {
                    array[elemNum++] = buckets[j].poll();
                }
            }
        }
    }

    public static Integer binarySearch(int[] array, int elem) {
        int low = 0;
        int high = array.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;

            if (elem > array[mid]) {
                low = mid + 1;
            } else if (elem < array[mid]) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return null;
    }

    public static void sortedMerge(int[] a, int[] b) {
        int a_index = a.length - b.length - 1;
        int b_index = b.length - 1;
        int index = a.length - 1;
        while (index >= 0) {
            if (a_index >= 0 && a[a_index] > b[b_index]) {
                a[index] = a[a_index];
                a_index--;
            } else {
                a[index] = b[b_index];
                b_index--;
                if (b_index < 0) {
                    break;
                }
            }
            index--;
        }
    }

    public static Integer findInRotatedArray(int[] array, int elem) {
        int compareInt = array[0];
        return findInRotatedArray(array, 0, array.length - 1, elem);
    }
    public static Integer findInRotatedArray(int[] array, int start, int end, int elem) {
        int mid = (start + end) / 2;
        if (array[mid] == elem) return mid;
        if (start > end) return -1;
        if (array[start] < array[mid]) { // left half correct
            if (elem < array[mid] && elem > array[start]) {
                return findInRotatedArray(array, start, mid - 1, elem);
            } else {
                return findInRotatedArray(array, mid + 1, end, elem);
            }
        } else if (array[mid] < array[end]) {
            if (elem > array[mid] && elem < array[end]) {
                return findInRotatedArray(array, mid + 1, end, elem);
            } else {
                return findInRotatedArray(array, start, mid - 1, elem);
            }
        }
        return -1;
    }

    public static void findInUnlimitedArray(int[] a, int b) {
        int pivot = 2;
        while (a[pivot] <= b && a[pivot] > 0) {
            pivot *= 2;
        }
//        binarySearch(a, b , pivot / 2, pivot);
    }

    public static int sparseSearch(String[] a, String search) {
        int start = 0;
        int end = a.length;
        while (a[start].isEmpty() && start < a.length) {
            start++;
        }
        while (a[end].isEmpty() && end >= start) {
            end--;
        }
        if (start >= end) {
            return -1;
        }
        return sparseSearch(a, search, start, end);
    }

    private static int sparseSearch(String[] a, String search, int start, int end) {
        int mid = (start + end) / 2;
        while (a[mid].isEmpty() && mid <= end) {
            mid++;
        }
        if (a[mid].equals(search)) return mid;
        if (isBigger(a[mid], search)) {
            if (mid == end) {
                return -1;
            }
            return sparseSearch(a, search, mid+1, end);
        } else {
            return sparseSearch(a, search, start, mid - 1);
        }
    }

    public static boolean isBigger(String a, String b) {
        return true;
    }

    public static void findDuplicates(int[] a) {
        byte[] buffer = new byte[32000 / 8];
        for (int element : a) {
            if ((buffer[element / 8] & 1 << (element % 8)) != 0) {
                System.out.println(element);
            } else {
                buffer[element / 8] |= 1 << (element % 8);
            }
        }
    }

    public static void findElemInSortedMatrix(int[][] matrix, int elem) {
        int m = matrix.length - 1;

        int row = findRow(matrix, 0 , m , elem);
        int column = binarySearch(matrix[row], elem);
        System.out.println("i = " + row + ", j = " + column);
    }

    private static int findRow(int[][] matrix, int start, int end, int elem) {
        if (start == end) {
            return start;
        }
        if (start > end) {
            return -1;
        }
        int mid_m = (start + end) / 2;
        if (elem >= matrix[mid_m][0]) {
            if (elem < matrix[mid_m + 1][0]) {
                return mid_m;
            } else {
                return findRow(matrix, mid_m + 1, end, elem);
            }
        } else {
            return findRow(matrix, start , mid_m - 1, elem);
        }
    }




}


