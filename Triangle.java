// subclass of Polygon
// Shape -> Polygon -> Triangle

public class Triangle extends Polygon {

    private double side1, side2, side3;
    private double angle1, angle2, angle3;

    public Triangle(double side1, double side2, double side3,
                    double angle1, double angle2, double angle3) {

        super(3); // triangle always has 3 sides

        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;

        this.angle1 = angle1;
        this.angle2 = angle2;
        this.angle3 = angle3;
    }

    public boolean isValidTriangle() {
        // check triangle inequality
        if (side1 + side2 <= side3 ||
                side1 + side3 <= side2 ||
                side2 + side3 <= side1) {
            return false;
        }

        // check if angles add to 180
        return Math.abs((angle1 + angle2 + angle3) - 180) < 0.001;
    }

    public double getPerimeter() {
        if (!isValidTriangle()) {
            return 0;
        }

        return side1 + side2 + side3;
    }

    @Override
    String getName() {
        return "Triangle";
    }

    @Override
    double getArea() {
        if (!isValidTriangle()) {
            return 0;
        }

        // Heron's formula
        double s = getPerimeter() / 2.0;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    public String getTriangleType() {
        if (!isValidTriangle()) {
            return "Invalid triangle";
        }

        if (angle1 == 90 || angle2 == 90 || angle3 == 90) {
            return "Right triangle";
        } else if (angle1 > 90 || angle2 > 90 || angle3 > 90) {
            return "Obtuse triangle";
        } else {
            return "Acute triangle";
        }
    }

    @Override
    public String toString() {
        if (!isValidTriangle()) {
            return "Wrong inputs, not a triangle";
        }

        return String.format(
                "Triangle [type=%s, sides=%d, perimeter=%.2f, area=%.2f]",
                getTriangleType(),
                getSides(),
                getPerimeter(),
                getArea()
        );
    }
}
