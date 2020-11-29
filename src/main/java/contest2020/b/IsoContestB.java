
package contest2020.b;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class IsoContestB {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Horaire> listeDesHoraires = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			listeDesHoraires.add(new Horaire(sc.next()));
		}
		
		int count = 0;
		for (Horaire horaire : listeDesHoraires) {
			if (horaire.estDansLaNuit()) {
				count++;
			}
		}
		
		double percent = count / ((double) n);
		if (percent > 0.5D) {
			System.out.println("SUSPICIOUS");
		} else {
			System.out.println("OK");
		}
		
		
	}
	
	static class Horaire implements Comparable<Horaire> {
		int heure;
		int minute;
		
		@Override
		public int compareTo(Horaire o) {
			return Objects.compare(heure * 100 + minute,
					o.heure * 100 + o.minute,
					Integer::compareTo);
		}
		
		Horaire(String line) {
			String[] horaireDebutSplit = line.split(":");
			heure = Integer.parseInt(horaireDebutSplit[0]);
			minute = Integer.parseInt(horaireDebutSplit[1]);
		}
		
		public boolean estDansLaNuit() {
			return heure * 100 + minute >= 2000 || heure * 100 + minute <= 759;
		}
	}
}