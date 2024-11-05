import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        Point p1 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        Point p2 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        Point p3 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        Point p4 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        if (isOverlapOrIntersect(p1, p2, p3, p4)) {
            bw.write("1");
        } else {
            bw.write("0");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean isOverlapOrIntersect(Point p1, Point p2, Point p3, Point p4) {
        int ccw1 = ccw(p1, p2, p3);
        int ccw2 = ccw(p1, p2, p4);
        int ccw3 = ccw(p3, p4, p1);
        int ccw4 = ccw(p3, p4, p2);

        if (ccw1 * ccw2 <= 0 && ccw3 * ccw4 <= 0) {
            if (ccw1 == 0 && ccw2 == 0 && ccw3 == 0 && ccw4 == 0) {
                return isOverlap(p1, p2, p3, p4);
            }
            return true;
        }
        return false;
    }

    private static boolean isOverlap(Point p1, Point p2, Point p3, Point p4) {
        return Math.min(p1.x, p2.x) <= Math.max(p3.x, p4.x) &&
               Math.min(p3.x, p4.x) <= Math.max(p1.x, p2.x) &&
               Math.min(p1.y, p2.y) <= Math.max(p3.y, p4.y) &&
               Math.min(p3.y, p4.y) <= Math.max(p1.y, p2.y);
    }

    private static int ccw(Point a, Point b, Point c) {
        long crossProduct = (long)(b.x - a.x) * (c.y - a.y) - (long)(b.y - a.y) * (c.x - a.x);
        if (crossProduct > 0) return 1;
        if (crossProduct < 0) return -1;
        return 0;
    }

    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
