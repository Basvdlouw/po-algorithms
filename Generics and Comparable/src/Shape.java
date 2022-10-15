public class Shape implements Comparable<Shape> {

    private int area;

    public int getArea() {
        return area;
    }

    @Override
    public int compareTo(Shape other) {
        if (area == other.getArea()) return 0;
        if (area > other.getArea()) return 1;
        return -1;
    }
}