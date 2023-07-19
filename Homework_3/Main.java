package Homework_3;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("мама");
        list.add("мыла");
        list.add("раму");
        
        System.out.println(list.toString());
        list.revert();
        System.out.println(list.toString());
    }
}
