// super-class that defines what every shape must fulfill through its methods. 

abstract class Shape { 

    abstract String getName();

    abstract double getArea();

    abstract double getPerimeter();

    @Override
    public abstract String toString(); // Overrides toString so that each method has the ability to have its own toString for convention. 
}
