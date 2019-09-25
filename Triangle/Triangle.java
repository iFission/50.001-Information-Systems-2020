class Triangle extends GeometricObject {
    double x;
    double y;

    double width;
    double height;

    public Triangle() {
    }

    public Triangle(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public double getX() {
        return this.x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getWidth() {
        return this.width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Triangle x(double x) {
        this.x = x;
        return this;
    }

    public Triangle y(double y) {
        this.y = y;
        return this;
    }

    public Triangle width(double width) {
        this.width = width;
        return this;
    }

    public Triangle height(double height) {
        this.height = height;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Triangle)) {
            return false;
        }
        Triangle triangle = (Triangle) o;
        return x == triangle.x && y == triangle.y && width == triangle.width && height == triangle.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, width, height);
    }

    @Override
    public String toString() {
        return "{" + " x='" + getX() + "'" + ", y='" + getY() + "'" + ", width='" + getWidth() + "'" + ", height='"
                + getHeight() + "'" + "}";
    }
}
