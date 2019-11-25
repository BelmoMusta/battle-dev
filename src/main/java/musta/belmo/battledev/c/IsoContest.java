
package musta.belmo.battledev.c;

import java.util.Scanner;

public class IsoContest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int minIQ = sc.nextInt();

        for (int i = 1; i < n; i++) {

            int current = sc.nextInt();
            minIQ = Math.min(minIQ, current);
        }

        System.out.println(minIQ/n);
    }


}