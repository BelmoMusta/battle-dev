
package musta.belmo.battledev.e;

import java.util.Scanner;

public class IsoContest {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        final int p = sc.nextInt();

        Point aFake = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
        Point bFake = new Point(Integer.MIN_VALUE, Integer.MIN_VALUE);

        for (int i = 0; i < p; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();

            aFake.x = Math.min(aFake.x, x1);
            aFake.y = Math.min(aFake.y, y1);


            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            bFake.x = Math.max(bFake.x, x2);
            bFake.y = Math.max(bFake.y, Math.max(y1, y2));


        }

        System.out.println(new Rectangle(aFake, bFake));
    }

    static class Point {
        int x, y;

        Point(int xx, int yy) {
            x = xx;
            y = yy;
        }
    }

    static class Rectangle {
        Point a;
        Point b;
        Point c;
        Point d;

        Rectangle(Point xy, Point xxyy) {
            a = xy;
            c = xxyy;
            b = new Point(a.x, c.y);
            d = new Point(c.x, a.y);
        }

        @Override
        public String toString() {
            return
                    a.x + " " + a.y + " " +
                            b.x + " " + b.y + " " +
                            d.x + " " + d.y + " " +
                            c.x + " " + c.y + " ";
        }
    }
}