package Homework_4;

public class Main {
    public static void main(String[] args) {
        RBTree<String> tree = new RBTree<>();
        tree.add("Mikola");
        tree.add("Arseni");
        tree.add("Petr");
        tree.add("Rustem");
        tree.add("Botat");
        tree.add("Dmitri");
        tree.add("Evgeni");
        tree.add("Inokenti");
        tree.add("Konstantin");
        tree.add("Vladimir");
        tree.add("Georgi");
        tree.add("Tamerlan");
        tree.add("Leonid");
        tree.add("Nikola");
        tree.add("Stepan");
        tree.add("Hasan");
        tree.add("Oleg");
        tree.add("Zamir");

        RBTree<Integer> treeOne = new RBTree<>();
        treeOne.add(10);
        treeOne.add(6);
        treeOne.add(3);
        treeOne.add(8);
        treeOne.add(0);
        treeOne.add(5);
        treeOne.add(9);
        treeOne.add(2);
        treeOne.add(4);
        tree.print();
        treeOne.print();
    }
}
