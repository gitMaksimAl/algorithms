package Lesson_4;

public class Main {
    
    public static void main(String[] args) {
        HashTable<String, Integer> tableOne = new HashTable<>();
        tableOne.add("Hello", 12);
        tableOne.add("world", 3);
        tableOne.add("Prevet", 21);
        tableOne.add("Zdraste", 10);
    
        System.out.println(tableOne.toString());
    }
}
