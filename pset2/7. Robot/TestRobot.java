public class TestRobot {
    public static void main(String[] args) {
        final int[][] grid0 = { { 0, 0, 0, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 1 }, { 0, 1, 0, 0 } };
        ArrayList<Point> path = new ArrayList<>();
        boolean success = GetPath.getPath(3, 2, path, grid0);
        System.out.println(success);
        if (success)
            System.out.println(path);
        path.clear();
        final int[][] grid = { { 0, 0, 0, 0 }, { 0, 0, 1, 0 }, { 0, 1, 0, 1 }, { 0, 1, 0, 0 } };
        success = GetPath.getPath(3, 2, path, grid);
        System.out.println(success);
        if (success)
            System.out.println(path);
        path.clear();
    }
}

// Output:
// true
// [(0,0),(0,1),(1,1),(2,1),(2,2),(3,2)]
// false
