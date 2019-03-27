
package musta.belmo.battledev.a;

import musta.belmo.battledev.Common;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
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
            sc = new Scanner(Common.readFromFile(3, file));
        }

        int nbWors = sc.nextInt();
        List<String> wordArray = new ArrayList<>();
        for (int i = 0; i < nbWors; i++) {
            wordArray.add(sc.next());
        }

        System.out.println(
                wordArray.stream()
                        .map(String::length)
                        .mapToInt(Integer::valueOf)
                        .max().orElse(0));
    }


    public static void solution() throws IOException, URISyntaxException {
        solution(null);
    }


}