abstract class Shape {

    abstract double getPerimeter();

    abstract double getArea();
}

class Triangle extends Shape {
    double a;
    double b;
    double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    double getPerimeter() {
        return a + b + c;
    }

    double getArea() {
        return (double) 1 / 4 * Math.sqrt((a + b + c) * (-a + b + c) * (a - b + c) * (a + b - c));
    }
}

class Rectangle extends Shape {

    double a;
    double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    double getPerimeter() {
        return 2 * (a + b);
    }

    double getArea() {
        return a * b;
    }
}

class Circle extends Shape {
    double a;

    public Circle(double a) {
        this.a = a;
    }

    double getPerimeter() {
        return 2 * Math.PI * a;
    }

    double getArea() {
        return Math.PI * a * a;
    }
}