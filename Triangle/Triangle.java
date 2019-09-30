class Triangle extends GeometricObject {
    double side1;
    double side2;
    double side3;

    public Triangle() {
        this.side1 = 1.0;
        this.side2 = 1.0;
        this.side3 = 1.0;
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getArea() {
        return Math.sqrt(getPerimeter() / 2 * (getPerimeter() / 2 - this.side1) * (getPerimeter() / 2 - this.side2)
                * (getPerimeter() / 2 - this.side3));
    }

    public double getPerimeter() {
        return this.side1 + this.side2 + this.side3;
    }

    @Override
    public String toString() {
        return "Triangle: " + "side1 = " + this.side1 + " " + "side2 = " + this.side2 + " " + "side3 = " + this.side3;
    }

}
