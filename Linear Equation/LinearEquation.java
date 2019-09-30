class LinearEquation {
    private double a;
    private double b;
    private double c;
    private double d;
    private double e;
    private double f;

    public LinearEquation(double a, double b, double c, double d, double e, double f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    public double getA() {
        return this.a;
    }

    public double getB() {
        return this.b;
    }

    public double getC() {
        return this.c;
    }

    public double getD() {
        return this.d;
    }

    public double getE() {
        return this.e;
    }

    public double getF() {
        return this.f;
    }

    private double getDeterminant() {
        return getA() * getD() - getB() * getC();
    }

    public boolean isSolvable() {
        return getDeterminant() != 0;
    }

    public double getX() {
        return (getD() * getE() - getB() * getF()) / getDeterminant();
    }

    public double getY() {
        return (getA() * getF() - getC() * getE()) / getDeterminant();
    }

}
