package contest2020.c;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class PlageHoraire {
	Horaire debut;
	Horaire fin;
	
	private PlageHoraire() {}
	
	public PlageHoraire(String line) {
		String[] firstSplit = line.split("-");
		debut = new Horaire(firstSplit[0]);
		fin = new Horaire(firstSplit[1]);
	}
	
	int duration() {
		return fin.heure * 100 + fin.minute -
				debut.heure * 100 + debut.minute;
	}
	
	public PlageHoraire merge(PlageHoraire other) {
		final PlageHoraire result = new PlageHoraire();
		if (debut.compareTo(other.debut) < 0) {
			result.debut = debut;
		} else {
			result.debut = other.debut;
		}
		
		if (fin.compareTo(other.fin) > 0) {
			result.fin = fin;
		} else {
			result.fin = other.fin;
		}
		return result;
		
	}
	
	public PlageHoraire complementaire() {
		PlageHoraire journeeEntiere = new PlageHoraire("00:01-23:59");
		PlageHoraire plageHoraire = new PlageHoraire();
		
		return plageHoraire;
	}
	
	@Override
	public String toString() {
		return "PlageHoraire{" +
				"debut=" + debut +
				", fin=" + fin +
				'}';
	}
	
	public static void main(String[] args) {
		/*
		07:00-14:00
		09:00-16:00
		14:00-23:00
		 */
		List<String> strings = Arrays.asList(
				"00:07-00:13",
				"00:28-01:06",
				"01:37-02:36",
				"03:45-03:59",
				"04:35-05:42",
				"05:07-05:58",
				"06:24-07:20",
				"08:20-09:00",
				"09:14-09:21",
				"10:12-10:46",
				"10:57-11:54",
				"14:14-15:21",
				"15:40-15:59",
				"19:33-20:33",
				"21:23-22:33",
				"22:20-22:51",
				"21:59-22:01",
				"23:02-23:37",
				"23:34-00:07");
		String s = strings.get(0);
		
		PlageHoraire horaire = new PlageHoraire(s);
		
		for (String string : strings) {
			PlageHoraire plageHoraire = new PlageHoraire(string);
			horaire = horaire.merge(plageHoraire);
		}
		System.out.println(horaire);
		
		
	}
	
	
	class Horaire implements Comparable<Horaire> {
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
		
		@Override
		public String toString() {
			return String.format("%02d:%02d", heure, minute);
		}
	}
}
