import java.io.*;


public class Main {
	public static void main( String[] args ) throws FileNotFoundException, IOException {
	/*	boolean peutContinuer = true;

		String nomFicTest;

		// Assume lire les données du clavier.

		BufferedReader fic = new BufferedReader( new InputStreamReader( System.in ) );

		OutilsLecture.fic = fic;

		char type = OutilsLecture.lireCaractereDisparate(
									"\nEntrez le type de test du programme (C avec clavier, F avec Fichier) : ", "CF" );

		if ( type == OutilsLecture.LECTURE_FICHIER ) {

			nomFicTest = OutilsFichier
					.lireNomFichier( "\nEntrez le nom du fichier qui contient les jeux d'essai : " );

			if ( nomFicTest.equalsIgnoreCase( "test1.txt" ) ) {
				
				// Supprimer le fichier ficJeu avant de tester.
				
				try {
					Files.delete( Paths.get( "ficJeu" ) );
				}
				
				catch ( IOException errIO ) {
				}
			}

			fic = OutilsFichier.ouvrirFicTexteLecture( nomFicTest );

			if ( fic == null ) {
				peutContinuer = false;
			}
		}

		if ( peutContinuer ) {

			// Lire du clavier ou d'un fichier.
			
			OutilsLecture.fic = fic;
			OutilsLecture.type = type;

			/**
			 * Une instance de la classe PrincipalTp7 permet de gérer l'affectation des joueurs à des avatars.
			 */

			new Principal();

		//} else {
			//System.out.println( "\nImpossible de tester le programme." );
		}
	}
//}
