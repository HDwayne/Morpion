import java.util.Scanner;

public class Jeu {
	public static void afficherTableau(String[] tableau) {
		System.out.print("|");
		for (int i=0; i<9; i++) {
			if (i==2 || i==5) {
				System.out.println(tableau[i]);
				System.out.println("-------------");
				System.out.print("|");
			} else {
				System.out.print(tableau[i]);				
			}
		}
		System.out.println("");
	}
	
	
	public static int posFinder (int ligne, int colonne) {
		int pos = 0;
		switch (ligne) {
			case 1: { pos=colonne-1; break; }
			case 2: { pos=colonne+2; break; }
			case 3: { pos=colonne+5; break; }
			default: { break; }
		}
		return pos;
	}
	
	
	public static void entrerCoordonnee (Boolean joueurO, String[] tableau, int ligne, int colonne) {
		int pos = posFinder(ligne, colonne);
		
		if (joueurO) {
			tableau[pos]=" O |";
		} else {
			tableau[pos]=" X |";
		}
		afficherTableau(tableau);
	}
	
	
	public static int lireEntier() {
		int entier;
		Scanner clavier = new Scanner(System.in);
		entier = clavier.nextInt();
		return entier;
	}
	
	
	public static Boolean joueurSwitch (Boolean joueurO) {
		if (joueurO) {
			joueurO = false;
		} else {
			joueurO = true;
		}
		return joueurO;
	}
	
	
	public static Boolean validEntrer (String[] tableau, int x, int y) {
		if (x<0 || y<0 || x>3 || y>3 || !tableau[posFinder(x, y)].equals("   |")) {
			System.out.println("Coordonnées invalides !");
			return false;
		}
		return true;
	}
	
	
	public static Boolean win (String[] tableau) {
		if ((tableau[0].equals(tableau[1]) && tableau[1].equals(tableau[2]) && (tableau[0].equals(" O |") || tableau[0].equals(" X |"))) ||
			(tableau[3].equals(tableau[4]) && tableau[4].equals(tableau[5]) && (tableau[3].equals(" O |") || tableau[3].equals(" X |")))  ||
			(tableau[6].equals(tableau[7]) && tableau[7].equals(tableau[8]) && (tableau[6].equals(" O |") || tableau[6].equals(" X |")))  ||
			
			(tableau[0].equals(tableau[3]) && tableau[3].equals(tableau[6]) && (tableau[0].equals(" O |") || tableau[0].equals(" X |")))  ||
			(tableau[1].equals(tableau[4]) && tableau[4].equals(tableau[7]) && (tableau[1].equals(" O |") || tableau[1].equals(" X |")))  ||
			(tableau[2].equals(tableau[5]) && tableau[5].equals(tableau[8]) && (tableau[2].equals(" O |") || tableau[2].equals(" X |")))  ||
			
			(tableau[0].equals(tableau[4]) && tableau[4].equals(tableau[8]) && (tableau[0].equals(" O |") || tableau[0].equals(" X |")))  ||
			(tableau[6].equals(tableau[4]) && tableau[4].equals(tableau[2]) && (tableau[6].equals(" O |") || tableau[6].equals(" X |")))
			) {	return true; }
		return false;
	}
	
	
	public static String extractWinner(String winner) {
		if ( winner.equals(" O |")) {
			return "O";
		}
		return "X";
	}
	
	
	public static String getWinner (String[] tableau) {
		String winner;
		
		if (tableau[0].equals(tableau[1]) && tableau[1].equals(tableau[2]) && (tableau[0].equals(" O |") || tableau[0].equals(" X |"))) { winner = tableau[0]; }
		else if (tableau[3].equals(tableau[4]) && tableau[4].equals(tableau[5]) && (tableau[3].equals(" O |") || tableau[3].equals(" X |"))) { winner = tableau[3]; }
		else if (tableau[6].equals(tableau[7]) && tableau[7].equals(tableau[8]) && (tableau[6].equals(" O |") || tableau[6].equals(" X |"))) { winner = tableau[6]; }
		else if (tableau[0].equals(tableau[3]) && tableau[3].equals(tableau[6]) && (tableau[0].equals(" O |") || tableau[0].equals(" X |"))) { winner = tableau[0]; }
		else if (tableau[1].equals(tableau[4]) && tableau[4].equals(tableau[7]) && (tableau[1].equals(" O |") || tableau[1].equals(" X |"))) { winner = tableau[1]; }
		else if (tableau[2].equals(tableau[5]) && tableau[5].equals(tableau[8]) && (tableau[2].equals(" O |") || tableau[2].equals(" X |"))) { winner = tableau[2]; }
		else if (tableau[0].equals(tableau[4]) && tableau[4].equals(tableau[8]) && (tableau[0].equals(" O |") || tableau[0].equals(" X |"))) { winner = tableau[0]; }
		else { winner = tableau[6]; }
		
		return extractWinner(winner);
	}
	
	
	public static void main(String[] args) {
//		System.out.println("EXO 1:");
		System.out.println("Jeu du morpion");
		
//		
//		System.out.println("EXO 2:");
		Boolean joueurO = true;
//		
//		if (joueurO) {
//			System.out.println("| O |");
//		} else {
//			System.out.println("| X |");
//		}
//		
//		
//		System.out.println("EXO 3:");
		String tableau[] = new String[9];
		for (int i=0; i<9; i++) {
			tableau[i]="   |";
		}
//		
//		System.out.print("|");
//		for (int i=0; i<9; i++) {
//			System.out.print(tableau[i]);
//		}
//		System.out.println("");
//		
//		
//		System.out.println("EXO 4:");
//		System.out.print("|");
//		for (int i=0; i<9; i++) {
//			if (i==2 || i==5) {
//				System.out.println(tableau[i]);
//				System.out.println("-------------");
//				System.out.print("|");
//			} else {
//				System.out.print(tableau[i]);				
//			}
//		}
//		System.out.println("");
//		
//		
//		System.out.println("EXO 5:");
//		afficherTableau(tableau);
//		
//		
//		System.out.println("EXO 6:");
		int reponsex;
		int reponsey;
		int cpt=0;
		while (!win(tableau) && cpt < 9) {
			do {
				reponsex=lireEntier();
				reponsey=lireEntier();
			} while (!validEntrer(tableau, reponsex, reponsey));
			
			entrerCoordonnee(joueurO, tableau, reponsex, reponsey);
			joueurO = joueurSwitch(joueurO);
			cpt++;
		}
		System.out.print("Jeu terminé ! ");
		if (win(tableau)) {
			System.out.println("Avec un gagnant. (" + getWinner(tableau) + ")");
		} else {
			System.out.println("Sans gagnant.");
		}
	}
}
