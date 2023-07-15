package Lesson_4;

public class Main {
    
    public static void main(String[] args) {
        HashTable<String, Integer> tableOne = new HashTable<>();
        tableOne.add("Hello", 12);
        tableOne.add("world", 3);
        tableOne.add("Prevet", 21);
        tableOne.add("Zdraste", 10);
    
        System.out.println(tableOne.toString());

        BinTree treeOne = new BinTree();
        treeOne.add(5);
        treeOne.add(3);
        treeOne.add(12);
        treeOne.add(7);
        treeOne.add(1);
        treeOne.add(13);

        System.out.println(treeOne.contains(7));
    }
}
