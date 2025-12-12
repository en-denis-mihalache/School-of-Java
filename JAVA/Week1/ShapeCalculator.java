public class ShapeCalculator {
    public abstract class Shape {
        public abstract double area();
        public abstract double perimeter();
    }
    public class Circle extends Shape {
        private double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public double area() {
            return Math.PI * radius * radius;
        }

        @Override
        public double perimeter() {
            return 2 * Math.PI * radius;
        }
    }
    public class Rectangle extends Shape {
        private double width;
        private double height;
        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }
        @Override
        public double area() {
            return width * height;
        }
        @Override
        public double perimeter() {
            return 2 * (width + height);
        }
    }
    public class Triangle extends Shape {
        private double baseLength;
        private double height;

        public Triangle(double baseLength, double height) {
            this.baseLength = baseLength;
            this.height = height;
        }

        @Override
        public double area() {
            return 0.5 * baseLength * height;
        }

        @Override
        public double perimeter() {
            // Assuming an equilateral triangle for simplicity
            return 3 * baseLength;
        }

    }
}
