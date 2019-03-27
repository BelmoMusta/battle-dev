
package musta.belmo.battledev.a;

import java.util.Scanner;

public class IsoContest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int nbWords = sc.nextInt();
        int maxLength = sc.next().length();

        for (int i = 0; i < nbWords-1; i++) {
            int currentLength = sc.next().length();
            if(maxLength<currentLength){
                maxLength=currentLength;
            }
        }

        System.out.println(maxLength);
    }


}