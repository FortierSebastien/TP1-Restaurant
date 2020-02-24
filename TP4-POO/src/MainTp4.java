/*
 * Auteur  : Christian Mongeon
 * Fichier : MainTp4.java
 * Date    : 15 avril 2019
 * Cours   : 420-ZE4-MO (TP4, Hôtel)
 */

// Package du système.

import java.io.*;

// Package du programmeur.

import outilsjava.*;

// La classe MainTp4 contient la méthode principale du TP4 qui permet de faire la gestion des chambres d'un hôtel.

public class MainTp4 {

	public static void main( String[] args ) {

		boolean peutContinuer = true;

		String nomFicTest;

		// On suppose une lecture des données du clavier.

		BufferedReader fic = new BufferedReader( new InputStreamReader( System.in ) );

		char type = OutilsLecture.lireCaractereDisparate(
						"\nEntrez le type de test du programme (C avec clavier, F avec fichier) : ", "CF" );

		if ( type == OutilsLecture.LECTURE_FICHIER ) {

			nomFicTest = OutilsFichier.lireNomFichier( "\nEntrez le nom du fichier qui contient les jeux d'essai : " );

			fic = OutilsFichier.ouvrirFicTexteLecture( nomFicTest );

			if ( fic == null ) {
				peutContinuer = false;
			}
		}

		if ( peutContinuer ) {

			// Lire du clavier ou d'un fichier.

			OutilsLecture.fic = fic;
			OutilsLecture.type = type;

			// Une instance de la classe PrincipalTp4 permet de faire la gestion des chambres d'un hôtel.

			new PrincipalTp4();

		} else {
			System.out.println( "\nImpossible de tester le programme." );
		}
	}
}