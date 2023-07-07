package Lesson_1;

public class Main {
    public static int find(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == value) return i;
        return -1;
    }

    public static void bubbleSort(int[] arr) {
        /*
        optimized bubblesort complexity = O(n^2 - n)
        basic O(n * ())
        */
        boolean isSorted = false;
        int len = arr.length;
        for (int i = 0; i < arr.length - 1 && !isSorted; i++) {
            isSorted = true;
            for (int j = 0; j < len - 1; j++)
            // this cicle is sum all nums from 1 to 'n' ->
            // with formula (1 + n) * (n / 2)
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSorted = false;
                }
            len--;
        }
    }

    public static int fibonacciLine(int n) {
        int left = 0;
        int rigth = 1;
        if (n < 3) {
            if (n == 2) return 1;
            else if (n == 1) return 0;
            else return -1;
        }
        for (int i = 1; i < n; i++) {
            rigth = left + rigth;
            left = rigth - left;
        }
        return rigth;
    }

    public static int fibonacciLineR(int n, int left, int rigth) {
        if (n == 0) return left;
        else return fibonacciLineR(n - 1, rigth, rigth + left);
    }

    public static int fibonacciLineR(int n) {
        return fibonacciLineR(n, 0, 1);
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 9, 2, 4, 7, 12};

        // constant time complexity in sorted array
        // complexity = O(7)
        // take maximal complexity
        // linear time if not sorted O(n)
        System.out.println(find(arr, 7));

        // quadratic time
        // complexity = O(n^2 - 1) -> O(n^2)
        // O(n * n) = O(n^2)
        // if array isSorted complexity = O(1)
        bubbleSort(arr);
        for (int i = 0; i < arr.length; i++)
            System.out.print(String.format("%d, ", arr[i]));
        System.out.println();

        System.out.println(fibonacciLine(20));
        System.out.println(fibonacciLineR(20));

        Node n1 = new Node(1, null);
        Node n2 = new Node(2, n1);
        Node n3 = new Node(3, n2);
        Node n4 = new Node(4, n3);
        Node n5 = new Node(5, n4);

        Node currentNode = n5;
        while (currentNode != null) {
            System.out.println(currentNode.getValue());
            currentNode = currentNode.getNext();
        }
    }
}
