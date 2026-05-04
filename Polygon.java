// single inheritance; abstract class shape --> class polygon 

// abst — concrete polygon shapes extend this.

// abstract class shape --> abstract class polygon, allows for a hierarchy of shared behavior. 

abstract class Polygon extends Shape {

    // protected so subclasses can read sides directly (e.g. GenericPolygon's getName switch)
    protected int sides;

    public Polygon(int sides) {
        if (sides >= 3) {
            this.sides = sides;
        } else {
            throw new IllegalArgumentException("A polygon must have at least 3 sides!");
        }
    }

    public int getSides() {
        return sides;
    }
}
