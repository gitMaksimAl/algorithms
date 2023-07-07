package Lesson_2;

import java.util.Random;

public class Main {

    public static int[] getArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) array[i] = new Random().nextInt(35);
        return array;
    }

    public static void print(int[] arr) {
        int i = 0;
        for (i = 0; i < arr.length - 1; i++)
            System.out.print(String.format("%d, ", arr[i]));
        System.out.println(arr[i]);
    }
    
    public static void main(String[] args) {
        int[] arr = getArray(10);
        int[] arr2 = getArray(10_0000);
        int index = 0;

        // value 7 by chance to stay on need place
        try {
            index = Search.binarySearch(arr, 7);
            System.out.println(arr[index]);
        } catch (IndexOutOfBoundsException err) {
            System.out.println("Cant apply binarySearch to unsorted array!");
        }

        Sort.insertSort(arr2);
        index = Search.binarySearch(arr2, 0);
        System.out.println(arr2[index]);
        index = Search.binarySearch(arr2, 3);
        System.out.println(arr2[index]);

        // binary search work on sorted array
        System.out.println(Search.binarySearch(arr, 3));
    
        // Sort.quickSort(arr, 0, arr.length - 1);
        // Sort.heapSort(arr);
        print(arr);
        Sort.insertSort(arr);
        print(arr);
    }
}
