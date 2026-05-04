// subclass of polygon

public class Pentagon extends Polygon {

    private double sideLength;
    private double apothem; // perpendicular distance from center to the middle of any side

    public Pentagon(double sideLength, double apothem) {
        super(5);
        this.sideLength = sideLength;
        this.apothem = apothem;
    }

    @Override
    public String getName() {
        return "Pentagon";
    }

    @Override
    public double getPerimeter() {
        return 5 * sideLength;
    }

    @Override
    public double getArea() {
        // Area of a regular polygon: (perimeter * apothem) / 2
        return 0.5 * getPerimeter() * apothem;
    }

    @Override
    public String toString() {
        return String.format(
                "Pentagon: sideLength: %.2f, Apothem: %.2f, Sides: %d, Perimeter: %.2f, Area: %.2f",
                sideLength,
                apothem,
                getSides(),
                getPerimeter(),
                getArea()
        );
    }
}
