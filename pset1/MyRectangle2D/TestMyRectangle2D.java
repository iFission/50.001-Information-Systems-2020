public class TestMyRectangle2D {

    public static void main(String[] args) {
        MyRectangle2D rectangle1 = new MyRectangle2D(1, 2, 3, 4);
        MyRectangle2D rectangle2 = new MyRectangle2D(1, 2, 2, 3);
        MyRectangle2D rectangle3 = new MyRectangle2D(3, 4, 2, 3);

        // test case 1
        System.out.println("should be true: " + rectangle1.contains(1.5, 3.5));
        System.out.println("should be true: " + rectangle1.contains(1, 2));
        System.out.println("should be true: " + rectangle1.contains(4, 2));
        System.out.println("should be true: " + rectangle1.contains(4, 6));
        System.out.println("should be false: " + rectangle2.contains(2, 6));
        System.out.println("should be false: " + rectangle3.contains(2, 6));
        System.out.println("should be true: " + rectangle1.contains(rectangle2));
        System.out.println("should be false: " + rectangle1.contains(rectangle3));
        System.out.println("should be true: " + rectangle1.overlaps(rectangle3));
        System.out.println("should be true: " + rectangle1.overlaps(rectangle2));

    }
}