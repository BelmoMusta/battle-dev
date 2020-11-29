
package contest2020.a;

import java.util.Scanner;

public class IsoContest {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count = 0;
		for (int i = 0; i < N; i++) {
			String compte = sc.next();
			if(estSuspect(compte)) {
				count++;
			}
		}
		System.out.println(count);
		 
    }
	
	private static boolean estSuspect(String compte) {
		String substring = new StringBuilder(compte).reverse().substring(0, 5);
		for (int i = 0; i < substring.length(); i++) {
			if(Character.isAlphabetic(substring.charAt(i))) return false;
		}
		return true;
	}
	
	
}