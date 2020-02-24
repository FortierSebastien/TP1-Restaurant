/*
 * Auteurs : Simon Manouk et Christian Mongeon,	Groupe : 65
 * Fichier : PrincipalTp4.java
 * Date    : 15 avril 2019
 * Cours   : 420-ZE4-MO (TP4, Hôtel)
 */

// Package du programmeur.

import outilsjava.*;

/**
 * La classe PrincipalTp4 permet de faire la gestion des chambres d'un hôtel.
 */

public class PrincipalTp4 {

	/**
	 * Le constructeur de la classe PrincipalTp4 permet de faire la gestion
	 * des chambres d'un hôtel avec l'aide d'un menu.
	 */

	public PrincipalTp4() {
		
		// Constante pour le texte du menu principal.
		
		final String MENU_PRINCIPAL = 
			"\nMenu principal pour la gestion des chambres de l'hôtel Montmotel\n\n" +
			"1. Arrivée d'un client\n" +
			"2. Départ d'un client\n" +
			"3. Afficher les tarifs de base\n" +
			"4. Afficher la disponibilité d'une chambre quelconque\n" +
			"5. Afficher la disponibilité de toutes les chambres\n" +
			"6. Afficher la disponibilité de toutes les chambres standards\n" +
			"7. Afficher la disponibilité de toutes les chambres qui ont un accès Internet\n" +
			"8. Afficher la disponibilité de toutes les chambres de luxe (accès Internet et repas en chambre)\n" +
			"9. Quitter le programme";

		// Constantes pour les choix du menu.
		
		final char ARRIVEE         = '1';
		final char DEPART          = '2';
		final char TARIFS          = '3';
		final char UNE_CHAMBRE     = '4';
		final char TOUTES_CHAMBRES = '5';
		final char STANDARD        = '6';
		final char INTERNET        = '7';
		final char LUXE            = '8';
		final char QUITTER         = '9';

		final String MESS_BIENVENUE = "\nBienvenue au programme de gestion des chambres de l'hôtel Montmotel.";

		final String MESS_FIN = "\nFin du programme.\n";

		char choix; // Choix du menu principal.

		System.out.println( MESS_BIENVENUE );
		
		Hotel hotel = new Hotel();

		/*
		 * TODO (À COMPLÉTER).
		 * 
		 * Créer un objet de la classe Hotel. Voir en haut de la page 5 de l'énoncé du TP4.
		 */


		
		do {
			choix = OutilsAffichage.afficherChoisirMenu( MENU_PRINCIPAL, ARRIVEE, QUITTER );

			switch ( choix ) {

			case ARRIVEE:
				
				
				new Arrivee(hotel);
				
				/*
				 * TODO (À COMPLÉTER). Créer une instance de la classe Arrivee
				 * (Vous devez envoyer le bon paramètre au constructeur).
				 */

				
				break;

			case DEPART:
				
				new Depart(hotel);
				/*
				 * TODO (À COMPLÉTER). Créer une instance de la classe Depart
				 * (Vous devez envoyer le bon paramètre au constructeur).
				 */


				break;

			case TARIFS:
				
				Hotel.afficherTarifsBase();
				
				/*
				 * TODO (À COMPLÉTER). Exécuter la méthode statique de la classe
				 * Hotel qui permet d'afficher les tarifs de base.
				 */


				break;

			case UNE_CHAMBRE:
				
				afficherUneChambre( hotel );
				
				/*
				 * TODO (À COMPLÉTER). Exécuter la méthode privée de cette classe, afficherUneChambre().
				 * Vous devez envoyer le bon paramètre à la méthode.
				 */


				break;

			case TOUTES_CHAMBRES:
				
				hotel.afficherDisponibilite();
				
				/*
				 * TODO (À COMPLÉTER). Exécuter la méthode appropriée de l'objet hotel qui permet
				 * d'afficher la disponibilité de toutes les chambres de l'hôtel.
				 */


				break;

			case STANDARD:
				
				hotel.afficherDisponibilite( Hotel.STANDARD );
				
				/*
				 * TODO (À COMPLÉTER). Exécuter la méthode appropriée de l'objet hotel qui permet
				 * d'afficher la disponibilité des chambres de type Hotel.STANDARD.
				 */


				break;

			case INTERNET:
				
				hotel.afficherDisponibilite( Hotel.INTERNET );
				
				/*
				 * TODO (À COMPLÉTER). Exécuter la méthode appropriée de l'objet hotel qui permet
				 * d'afficher la disponibilité des chambres de type Hotel.INTERNET.
				 */


				break;

			case LUXE:
				
				hotel.afficherDisponibilite( Hotel.LUXE );
				
				/*
				 * TODO (À COMPLÉTER). Exécuter la méthode appropriée de l'objet hotel qui permet
				 * d'afficher la disponibilité des chambres de type Hotel.LUXE.
				 */


				break;

			case QUITTER:
				System.out.println( MESS_FIN );
				break;
			}
		} while ( choix != QUITTER );
	}

	/**
	 * La méthode privée afficherUneChambre() permet d'afficher la disponibilité d'une seule chambre quelconque.
	 * 
	 * @param hotel
	 *            Objet qui gère l'hôtel.
	 */

	private void afficherUneChambre( Hotel hotel ) {
		
		// Constantes.

		final char OUI = 'O';

		final String TITRE_DISPO = "\nDisponibilité d'une chambre quelconque.";
		final String QUEST_AUTRE_DISPO = "\nVoulez-vous consulter la disponibilité d'une autre chambre (O ou N) ? ";
		
		int type, noChambre;
		char recommencer;

		do {
			System.out.println( TITRE_DISPO );
			
			type = Hotel.lireTypeChambre();
			
			noChambre = Hotel.lireNoChambre();
			
			hotel.afficherDisponibilite( type, noChambre );

			/*
			 * TODO (À COMPLÉTER). Voir page 13 de l'énoncé du TP4.
			 */


			
			recommencer = OutilsLecture.lireOuiNon( QUEST_AUTRE_DISPO );
		} while ( recommencer == OUI );
	}
}