// Subclass of Polygon
// Inheritance: Shape -> Polygon -> Rectangle

public class Rectangle extends Polygon {

    private double length;
    private double width;

    public Rectangle(double length, double width) {
        super(4);
        this.length = length;
        this.width = width;
    }

    @Override
    public String getName() {
        return "Rectangle";
    }

    @Override
    public double getArea() {
        return length * width;
    }

    @Override
    public double getPerimeter() {
        return 2 * (length + width);
    }

    @Override
    public String toString() {
        return String.format(
                "Rectangle [length=%.2f, width=%.2f, sides=%d, perimeter=%.2f, area=%.2f]",
                length,
                width,
                getSides(),
                getPerimeter(),
                getArea()
        );
    }
}








