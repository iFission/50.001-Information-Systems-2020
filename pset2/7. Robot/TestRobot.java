import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GetPath {
    public ArrayList<Point> getPath(final int[][] grid) {
        if (grid == null || grid.length == 0)
            return null;
        ArrayList<Point> path = new ArrayList<>();
        if (getPath(0, 0, path, grid)) {
            return path;
        }
        return null;
    }

    //Fill in your answer for this method
    public static boolean getPath(int r, int c, ArrayList<Point> path, final int[][] grid) {
        boolean origin = (r == 0 && c == 0);
        if (c < 0 || r < 0 || grid[r][c] == 1) {
            return false;
        }
        if (origin || getPath(r, c - 1, path, grid) || getPath(r - 1, c, path, grid)) {
            Point p = new Point(r, c);
            path.add(p);
            return true;

        }
        return false;

    }

    //You do not need to change any code below.
    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }
}