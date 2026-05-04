// subclass of Shape (NOT Polygon)

public class Circle extends Shape {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    String getName() {
        return "Circle";
    }

    public double getPerimeter() { // circumference
        return 2 * Math.PI * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getDiameter() {
        return 2 * radius;
    }

    @Override
    public String toString() {
        return String.format(
                "Circle [radius=%.2f, diameter=%.2f, perimeter=%.2f, area=%.2f]",
                radius,
                getDiameter(),
                getPerimeter(),
                getArea()
        );
    }
}
