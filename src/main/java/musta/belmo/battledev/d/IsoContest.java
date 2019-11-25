
package musta.belmo.battledev.d;

import java.util.Scanner;

public class IsoContest {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        final int p = sc.nextInt();
        final int n = sc.nextInt();
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            final String c = sc.next();
            final int q = sc.nextInt();

            if (q >= p / 2) {
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
    }
}