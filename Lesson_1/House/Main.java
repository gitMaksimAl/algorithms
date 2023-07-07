package Lesson_1.House;

import Lesson_1.House.House.Color;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        House Igoshina8 = new House(9, 210, Color.Yellow);

        System.out.println(Igoshina8);
        Igoshina8.Burn();
        System.out.println(Igoshina8);
        System.out.println(String.format("%d \n", Color.Black));
    }
}