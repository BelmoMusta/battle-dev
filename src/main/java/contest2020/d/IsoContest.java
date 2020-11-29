package contest2020.d;

import java.util.Arrays;
import java.util.Scanner;

public class IsoContest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] ints = new int[256];
		int[] chifres = new int[256];
		int taille = scanner.nextInt();
		int clef = scanner.nextInt();
		for (int i = 0; i < taille; i++) {
			chifres[i] = scanner.nextInt();
		}
		for (int i = 0; i < clef; i++) {
			int li = scanner.nextInt();
			int ri = scanner.nextInt();
			int xor = 1;
			for (int j = 0; j <= ri; j++) {
				xor = xor | chifres[j];
			}
			for (int k = li; k >= 0; k--) {
				xor = xor | chifres[k];
			}
			ints[xor] = 1;
		}
		System.out.print(ints[0]);
		for (int i = 1; i < ints.length; i++) {
			
			System.out.print(" " + ints[i]);
		}
		
	}
}
