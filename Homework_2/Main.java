package Homework_2;

import java.util.Random;

public class Main {
    public static int[] getArray(int members, int maxValue) {
        int[] arr = new int[members];
        for (int i = 0; i < members; i++)
            arr[i] = new Random().nextInt(maxValue);
        return arr;
    }

    public static void printArray(int[] arr) {
        int i = 0;
        for (i = 0; i < arr.length - 1; i++)
            System.out.print(String.format("%d, ", arr[i]));
        System.out.println(arr[i]);
    }

    public static void main(String[] args) {
        int[] array1 = getArray(22, 17);

        printArray(array1);
        HeapSort.sort(array1);
        printArray(array1);
    }
}
