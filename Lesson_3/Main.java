package Lesson_3;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        System.out.println(list);
        list.add("12");
        list.add("9");
        list.add("Compare");
        list.add("?");
        list.add("3");
        list.add("Me");

        System.out.println("\033[H\033[2J" + list);
        // list.remove(3);
        // System.out.println(list);
        // list.remove(6);
        // System.out.println(list);
        // list.remove(1);
        // System.out.println(list);
        list.removeAt(3);
        System.out.println(list);
        list.removeAt(0);
        System.out.println(list);
        list.removeAt(5);
        System.out.print("Get value of 3-st: ");
        System.out.println(list.getValue(3));
        list.addAt(4, "Nice");
        System.out.println(list);
        list.swapValue(0, 3);
        System.out.println(list);
        list.quickSort();
        System.out.println(list);
    }
}
