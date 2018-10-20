package tasks;

import org.junit.Assert;
import org.junit.Test;
import tasks.firstTime.Chapter10;

import static helpers.Helper.createMatrix;
import static helpers.Helper.printMatrix;

public class TestChapter10 {

    @Test
    public void mergeSortTest() {
        int[] array = {9, 2, 4, 1, 3, 7, 10, 5, 8, 6};
        Chapter10.mergeSort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    @Test
    public void quickSortTest() {
        int[] array = {9, 2, 4, 1, 3, 7, 10, 5, 8, 6};
        Chapter10.mergeSort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    @Test
    public void radixSortTest() {
        int[] array = {9, 142, 34, 13, 34, 147, 10, 35, 88, 336};
        Chapter10.radixSort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    @Test
    public void binarySearchTest() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22};
        Integer index = Chapter10.binarySearch(array, 12);
        Assert.assertEquals(Integer.valueOf(11), index);
        index = Chapter10.binarySearch(array, 32);
        Assert.assertTrue(index == null);
    }

    @Test
    public void sortedMergeTest() {
        int[] a = new int[8];
        a[0] = 3;
        a[1] = 4;
        a[2] = 6;
        a[3] = 7;
        a[4] = 7;
        int[] b = {2, 9, 10};

        Chapter10.sortedMerge(a, b);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    @Test
    public void findInRotatedArrayTest() {
        int[] array = {7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 1, 2, 3, 4, 5, 6};
        Integer index = Chapter10.findInRotatedArray(array, 5);
        Assert.assertEquals(Integer.valueOf(20), index);

    }
    @Test
    public void rotateImageTest() {
        int[][] array = createMatrix(6);
        printMatrix("Given array", array);
        Chapter10.findElemInSortedMatrix(array, 35);
    }
}
