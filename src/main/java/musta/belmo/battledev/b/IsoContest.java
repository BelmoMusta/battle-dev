
package musta.belmo.battledev.b;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class IsoContest {
    public static void main(String[] args)   {


        Scanner sc;sc = new Scanner(System.in);

        int classement = sc.nextInt();
        int nbParticipants = 10000;
        int sommePersonneDepassees = 0;
        int sommePersonneAvantMoi = 0;

        for (int i = 0; i < 42; i++) {
            sommePersonneAvantMoi += sc.nextInt();
            sommePersonneDepassees += sc.nextInt();
        }
        String result = "KO";

        int classementFinal = classement - sommePersonneDepassees + sommePersonneAvantMoi;

        if (classementFinal <= 100) {
            result = "1000";
        } else if (classementFinal <= nbParticipants) {
            result = "100";
        }
        System.out.println(result);
    }





}