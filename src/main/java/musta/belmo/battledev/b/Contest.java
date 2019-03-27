
package musta.belmo.battledev.b;

import musta.belmo.battledev.Common;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Contest {
    public static void main(String[] args) throws IOException, URISyntaxException {
        solution();
    }

    public static void solution(String file) throws IOException, URISyntaxException {

        Scanner sc;
        if (file == null) {
            sc = new Scanner(System.in);
        } else {
            sc = new Scanner(Common.readFromFile(6, file));
        }
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


    public static void solution() throws IOException, URISyntaxException {
        solution(null);
    }


}