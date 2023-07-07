package Lesson_1.House;

/**
 * House
 */
public class House {

    enum Color {White, Black, Red, Yellow, Green};
    private int floorCount;
    private Color color;
    private int height;

    public House(int floors, int height, Color color) {
        this.floorCount = floors;
        this.height = height;
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("%s, %d levels, %d height, %s color",
            this.getClass().getName(),
            this.floorCount,
            this.height,
            this.color);
    }

    public void Burn() {
        this.floorCount = 1;
        this.color = Color.Black;
        this.height = 3;
    }

    public Color getColor() {
        return color;
    }
}