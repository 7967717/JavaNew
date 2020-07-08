package io.rr.javapuzzlers._6classypuzzlers.puzzle51;

class Point {
    protected final int x, y;
    private /*final*/ String name; // Cached at construction time

    Point(int x, int y) {
        this.x = x;
        this.y = y;
        //never call an overridable method from a constructor under any circumstances
//        name = makeName();
    }

    protected String makeName() {
        return "[" + x + "," + y + "]";
    }

    // Lazily computes and caches name on first use
    public final synchronized String toString() {
        if (name == null) {
            name = makeName();
        }
        return name;
    }
}

public class ColorPoint extends Point {
    private final String color;

    ColorPoint(int x, int y, String color) {
        super(x, y);
        this.color = color;
    }

    protected String makeName() {
        return super.makeName() + ":" + color;
    }

    public static void main(String[] args) {
        System.out.println(new ColorPoint(4, 2, "purple"));
    }
}
