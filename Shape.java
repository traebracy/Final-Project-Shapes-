// super-class that defines what every shape needs to fufill through the use of the defined methods. 

abstract class Shape { 

    abstract String getName();

    abstract double getArea();

    abstract double getPerimeter();

    @Override
    public abstract String toString(); // ovverides toString so that each method has the ability to have its own toString for convention. 
}
