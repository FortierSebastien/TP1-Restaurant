

import java.io.FileNotFoundException;
import java.io.IOException;

import outilsjava.*;

public class Principal {
	private static final String MESS_FIN_PROG = "\nMerci d'avoir utilisé le programme du restaurant !";

	// Constantes pour les choix du menu principal.

	
	public Principal() throws FileNotFoundException, IOException {
	final char IMPORT_TXT = '1';
	final char AFFICHER_AUTEUR = '2';
	final char QUITTER_PROGRAMME = '3';

	// Tableau des noms de mois.

	final String MESS_BIENVENUE = "\nBienvenue au programme de gestion de Sébastien et Simon";
	
	
	
	

	// Texte du menu principal.

	final String MENU_PRINCIPAL = 
			"\nMenu Restaurant\n\n"
			+ "1 : Ouvrir fichier txt\n"
			+ "2 : Afficher auteur\n"  
			+ "3 : Quitter le programme";



	char choix;

	System.out.println( MESS_BIENVENUE );

	

		do {
			choix = OutilsAffichage.afficherChoisirMenu( MENU_PRINCIPAL, IMPORT_TXT, QUITTER_PROGRAMME );

			switch ( choix ) {
			case IMPORT_TXT:
				LireFichierTxt.lireFichierResto();
				break;

			case AFFICHER_AUTEUR:
				Cv.afficherAuteur();
				break;

			

			case QUITTER_PROGRAMME:
				
				break;
			}
		} while ( choix != QUITTER_PROGRAMME );
	

	System.out.println( MESS_FIN_PROG );
	}
}

