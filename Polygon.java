// single inheritance

// shape -> polygon

abstract class Polygon extends Shape {

    protected int sides; // unlike private and public accessor methods, protected gives you access to the same class, same package, subclass, but not everywhere.

    public Polygon(int sides) {
        if (sides >= 3) {
            this.sides = sides;
        } else {
            throw new IllegalArgumentException("A polygon must have at least 3 sides!");
        }
    }

    public int getSides(){
        return sides;
    }

    public boolean isValidPolygon(){
        return sides >= 3;
    }

}

