public class Square extends Shape implements Comparable<Shape> {

    @Override
    public int compareTo(Shape other) {
        if (getArea() == other.getArea()) return 0;
        if (getArea() > other.getArea()) return 1;
        return -1;
    }
}