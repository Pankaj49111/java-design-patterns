/**
What is the Factory Pattern?
The Factory Pattern is a creational design pattern that provides an interface for creating objects in a super class, 
but allows subclasses to alter the type of objects that will be created.
Instead of directly instantiating objects using the new keyword, 
the Factory Pattern introduces a factory method to create objects, making the code more flexible and scalable.

Why use the Factory Pattern?
It decouples the client class from the class it needs to instantiate.
It promotes flexibility, as you can change or extend the types of objects without changing the client code.
It helps with managing object creation, especially when the creation process is complex.
*/

interface Shape {
    void draw();
}

class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

class Rectangle implements Shape {
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

class Square implements Shape {
    public void draw() {
        System.out.println("Drawing a Square");
    }
}

class ShapeFactory {
    public Shape getShape(String shapeType) {
        if (shapeType != null) {
            if (shapeType.equalsIgnoreCase("CIRCLE")) {
                return new Circle();
            } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
                return new Rectangle();
            } else if (shapeType.equalsIgnoreCase("SQUARE")) {
                return new Square();
            }
        }
        return null;
    }
}

public class FactoryPattern {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape shape1 = shapeFactory.getShape("CIRCLE");
        shape1.draw();

        Shape shape2 = shapeFactory.getShape("RECTANGLE");
        shape2.draw();

        Shape shape3 = shapeFactory.getShape("SQUARE");
        shape3.draw();
    }
}
