public class MyRectangle2D {
    double x;
    double y;
    double width;
    double height;

    public MyRectangle2D() {
        this(0, 0, 1, 1);
    }

    public MyRectangle2D(double x, double y, double width, double height) {
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

    public double getArea() {
        return this.height * this.width;
    }

    public double getPerimeter() {
        return 2 * (this.height + this.width);
    }

    private double[] getVertices(MyRectangle2D r) {
        // define vertices of r
        double rxlower = r.x - .5 * r.width;
        double rxupper = r.x + .5 * r.width;
        double rylower = r.y - .5 * r.height;
        double ryupper = r.y + .5 * r.height;

        double[] rvertices = new double[] { rxlower, rxupper, rylower, ryupper };

        return rvertices;
    }

    private boolean containsPoint(double[] vertices, double x, double y) {
        // vertices:
        // [0] = xlower
        // [1] = xupper
        // [2] = ylower
        // [3] = yupper

        if (((vertices[0] <= x) && (x <= vertices[1]) && (vertices[2] <= y) && (y <= vertices[3]))) {
            return true;
        } else {
            return false;
        }
    }

    public boolean contains(double x, double y) {
        // define vertices of this
        double[] vertices = getVertices(this);

        return containsPoint(vertices, x, y);
    }

    public boolean contains(MyRectangle2D r) {
        // define vertices of this
        double[] vertices = getVertices(this);

        // define vertices of r
        double[] rvertices = getVertices(r);

        return containsPoint(vertices, rvertices[0], rvertices[2])
                && containsPoint(vertices, rvertices[0], rvertices[1])
                && containsPoint(vertices, rvertices[1], rvertices[2])
                && containsPoint(vertices, rvertices[1], rvertices[3]);
    }

    public boolean overlaps(MyRectangle2D r) {
        // define vertices of this
        double[] vertices = getVertices(this);

        // define vertices of r
        double[] rvertices = getVertices(r);

        return containsPoint(vertices, rvertices[0], rvertices[2])
                || containsPoint(vertices, rvertices[0], rvertices[3])
                || containsPoint(vertices, rvertices[1], rvertices[2])
                || containsPoint(vertices, rvertices[1], rvertices[3]);
    }

}
