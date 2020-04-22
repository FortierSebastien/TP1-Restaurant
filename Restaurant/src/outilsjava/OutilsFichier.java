package outilsjava;
/**
 * Auteure : Soti
 * Fichier : OutilsFichier.java
 * Package : outilsjava
 * Date    : Automne 2019
 * Cours   : Programmation avec Java
 */

// La classe OutilsFichier fait partie du package outilsjava.


// Packages du système.

import java.io.*;
import java.nio.file.*;
import java.nio.charset.*;

/**
 * Classe qui contient certaines méthodes utilitaires pour les fichiers.
 */

public class OutilsFichier implements OutilsConstantes {

	private static final int MAX_CAR_FICHIER = 250;

	/**
	 * On définit le constructeur private pour empêcher la création d'instances de la classe OutilsFichier.
	 */

	private OutilsFichier() {
	}

	/**
	 * La méthode publique lireNomFichier() permet d'afficher une question et de lire une chaîne de caractères
	 * représentant un nom physique de fichier.
	 * 
	 * @param question
	 *            La question à afficher.
	 * 
	 * @return La chaîne de caractères représentant un nom physique de fichier.
	 */

	public static String lireNomFichier( String question ) {
		String nomFic;

		nomFic = OutilsLecture.lireChaineValide( question, 1, MAX_CAR_FICHIER );

		return nomFic;
	}

	/**
	 * La méthode publique ouvrirFicTexteLecture() permet d'ouvrir un fichier texte en mode lecture bufferisée.
	 * 
	 * @param nomFichier
	 *            Le nom physique du fichier.
	 * 
	 * @return le nom logique du fichier si l'ouverture est un succès ou null dans le cas contraire.
	 */

	public static BufferedReader ouvrirFicTexteLecture( String nomFichier ) {
		boolean valide = true;
		Path chemin = null;
		String cheminAbsolu;
		BufferedReader ficLecture = null;

		// Création du chemin.

		try {
			chemin = Paths.get( nomFichier );
		}

		catch ( InvalidPathException errNomFichier ) {
			System.out.println( "\nErreur, le fichier " + nomFichier + " contient des caractères illégaux." );
			valide = false;
		}

		// Si la création du chemin est valide, on peut poursuivre.

		if ( valide ) {
			cheminAbsolu = chemin.toAbsolutePath().toString();

			// Vérifier l'existence du fichier.

			if ( Files.notExists( chemin ) ) {
				// Le fichier n'existe pas.

				System.out.println( "\nErreur, le fichier " + cheminAbsolu + " n'existe pas." );
				valide = false;

			} else if ( Files.exists( chemin ) ) {
				// Le fichier existe. Est-ce un fichier ordinaire ?

				if ( !Files.isRegularFile( chemin ) ) {

					System.out.println( "\nErreur, le fichier " + cheminAbsolu + " n'est pas un fichier ordinaire." );
					valide = false;
				} else {
					// C'est un fichier ordinaire. Est-ce un fichier permis en lecture ?

					if ( !Files.isReadable( chemin ) ) {

						System.out.println( "\nErreur, le fichier " + cheminAbsolu + " n'est pas permis en lecture." );
						valide = false;
					} else {
						// Le fichier existe, est ordinaire et permis en lecture.

						// Ouverture du fichier texte en mode lecture.

						try {
							ficLecture = Files.newBufferedReader( chemin, Charset.defaultCharset() );
						}

						catch ( IOException errIO ) {
							System.out.println( "\nErreur, impossible d'ouvrir le fichier " + cheminAbsolu
									+ " en mode lecture texte." );
							valide = false;
						}
					}
				}
			} else {
				System.out.println( "\nErreur, impossible de vérifier l'existence du fichier " + cheminAbsolu + "." );
				valide = false;
			}
		}

		return ficLecture;
	}
}