public class Circle extends Shape {
    private double radius;
    public Circle(double radius) {
        this.radius = radius;
    }
    public double getPerimeter() { // circumference
        return 2 * Math.PI * radius;
    }
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