
package musta.belmo.battledev.b;

import java.util.Scanner;

public class IsoContest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int classement = sc.nextInt();
        int nbParticipants = 10000;
        int diff = 0;
        for (int i = 0; i < 42; i++) {
            diff += (sc.nextInt() - sc.nextInt());

        }
        String result = "KO";

        int classementFinal = classement + diff;

        if (classementFinal <= 100) {
            result = "1000";
        } else if (classementFinal <= nbParticipants) {
            result = "100";
        }
        System.out.println(result);
    }


}