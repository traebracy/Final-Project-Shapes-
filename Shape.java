// Abstract superclass — all shapes inherit from this.
// Defines the contract every shape must fulfill.

abstract class Shape {

    abstract String getName();

    abstract double getArea();

    abstract double getPerimeter();

    @Override
    public abstract String toString();
}
