package Lesson_2;

public class Search {
    public static int getIndexOf(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == value) return i;
        return -1;
    }

    private static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++)
            if (arr[i + 1] < arr[i]) return false;
        return true;
    }

    private static int binarySearch(int[] arr, int value, int min, int max) {
        if (!isSorted(arr)) return -1;// check unsorted array
        int point;
        if (max < min) return -1;
        else point = (max - min) / 2 + min;
        if (arr[point] < value) return binarySearch(arr, value, point + 1, max);
        else if (arr[point] > value)
            return binarySearch(arr, value, min, point - 1);
        else return point;
    }

    public static int binarySearch(int[] arr, int value) {
        return binarySearch(arr, value, 0, arr.length - 1);
    }
}
