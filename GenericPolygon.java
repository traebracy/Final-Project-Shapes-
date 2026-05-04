// multilevel inheritance

// shape -> polygon -> generic-polygon

public class GenericPolygon extends Polygon {

    // this is the generic polygon so no shape actually extends it.

    // this class exists to account for shapes that don't extend the polygon class but are still polygons.

    GenericPolygon(int sides) {
        super(sides);
    }

    @Override
    public String toString() {
        return "";
    }

    @Override
    String getName() {
        return switch (sides) {

            case 6 -> "Hexagon";
            case 7 -> "Heptagon";
            case 8 -> "Octagon";
            default -> "Polygon w/" + " " + sides + " " + "sides";

        };
    }

    @Override
    double getArea() {
        return 0;
    }

    @Override
    double getPerimeter() {
        return 0;
    }
}


