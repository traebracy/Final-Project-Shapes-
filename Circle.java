// subclass of shape, 

// it is the only geometric shape that is not a polygon, which is why it inherits from shape and also why shape is the super class of polygon despite them both being abstract classes.

public class Circle extends Shape {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public String getName() {
        return "Circle";
    }

    @Override
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
                "Circle [radius=%.2f, diameter=%.2f, circumference=%.2f, area=%.2f]",
                radius,
                getDiameter(),
                getPerimeter(),
                getArea()
        );
    }
}
