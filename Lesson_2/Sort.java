package Lesson_2;

/**
 * Sort
 */
public class Sort {

    public static void insertSort(int[] arr) {
        System.out.println("Start insertion sort...");
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int left = i - 1;
            while (left >= 0 && value < arr[left]) {
                arr[left + 1] = arr[left];
                left--;
            } arr[left + 1] = value;
        }
    }

    private static void quickSortR(int[] arr, int startPosition, int endPosition) {
        System.out.println("Start quick sort...");
        int leftPosition = startPosition;
        int rightPosition = endPosition;
        int pivot = arr[(startPosition + endPosition) / 2];
        do {
            while (arr[leftPosition] < pivot) leftPosition++;
            while (arr[rightPosition] > pivot) rightPosition--;
            if (leftPosition <= rightPosition) {
                if (leftPosition < rightPosition) {
                    int temp = arr[leftPosition];
                    arr[leftPosition] = arr[rightPosition];
                    arr[rightPosition] = temp;
                }
                leftPosition++;
                rightPosition--;
            }
        } while (leftPosition <= rightPosition);
        if (leftPosition < endPosition)
            quickSortR(arr, leftPosition, endPosition);
        if (startPosition < rightPosition)
            quickSortR(arr, startPosition, rightPosition);
    }

    private static void quickSortR2(int[] arr, int leftBorder, int rightBorder) {
        System.out.println("Start quick sort...");
        int leftPosition = leftBorder;
        int rightPosition = rightBorder;
        int pivot = arr[(leftPosition + rightPosition) / 2];
        while (leftPosition <= rightPosition) {
            while (arr[leftPosition] < pivot) leftPosition++;
            while (arr[leftPosition] > pivot) rightPosition--;
            if (leftPosition <= rightPosition) {
                if (leftPosition < rightPosition) {
                    int temp = arr[leftPosition];
                    arr[leftPosition] = arr[rightPosition];
                    arr[rightPosition] = temp;
                } leftPosition++;
                rightPosition--;
            }
        }
        if (leftBorder < rightPosition)
            quickSortR(arr, leftBorder, rightPosition);
        if (leftPosition < rightBorder)
            quickSortR(arr, leftPosition, rightBorder);
    }

    public static void quickSort(int[] arr) {
        quickSortR(arr, 0, arr.length - 1);
    }

    private static void heapify(int[] arr, int heapSize, int rootIndex) {
        int largest = rootIndex;
        int leftChild = 2 * rootIndex + 1;
        int rightChild = 2 * rootIndex + 2;
    
        if (leftChild < heapSize && arr[leftChild] > arr[largest])
            largest = leftChild;
        if (rightChild < heapSize && arr[rightChild] > arr[largest])
            largest = rightChild;

        if (largest != rootIndex) {
            int temp = arr[rootIndex];
            arr[rootIndex] = arr[largest];
            arr[largest] = temp;
            heapify(arr, heapSize, largest);
        }
    }

    public static void heapSort(int[] arr) {
        // build heap, regroup array
        // find a largest item
        System.out.println("Make a binary heap...");
        for (int i = arr.length / 2 - 1; i>= 0; i--)
            heapify(arr, arr.length, i);
    
        // extract items from heap
        // largest item to the end
        System.out.println("Start binary sort...");
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            // call heapify on shrunked heap
            // w/o last item
            heapify(arr, i, 0);
        }

    }
}