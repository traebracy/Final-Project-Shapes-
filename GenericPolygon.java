// multileve inheritance, abstract class shape --> polygon --> genericpolygon 

// Catches any polygon that doesn't have its own dedicated class (6+ sides).

public class GenericPolygon extends Polygon {

    private double sideLength;
    private double apothem; // perpendicular distance from center to middle of any side

    public GenericPolygon(int sides, double sideLength, double apothem) {
        super(sides);
        this.sideLength = sideLength;
        this.apothem = apothem;
    }

    @Override
    public String getName() {
        return switch (sides) {
            case 6 -> "Hexagon";
            case 7 -> "Heptagon";
            case 8 -> "Octagon";
            default -> "Polygon with " + sides + " sides";
        };
    }

    @Override
    public double getPerimeter() {
        return sides * sideLength;
    }

    @Override
    public double getArea() {
        // Area of a regular polygon: (perimeter * apothem) / 2
        return 0.5 * getPerimeter() * apothem;
    }

    @Override
    public String toString() {
        return String.format(
                "%s [sideLength=%.2f, apothem=%.2f, sides=%d, perimeter=%.2f, area=%.2f]",
                getName(),
                sideLength,
                apothem,
                getSides(),
                getPerimeter(),
                getArea()
        );
    }
}
