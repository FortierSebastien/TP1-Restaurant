/*
 * Auteurs : Simon Manouk et Christian Mongeon,	Groupe : 65
 * Fichier : Arrivee.java
 * Date    : 15 avril 2019
 * Cours   : 420-ZE4-MO (TP4, Hôtel)
 */

// Package du programmeur.

import outilsjava.*;

/**
 * La classe Arrivee permet de gérer les arrivées des clients à l'hôtel. Les clients réservent des chambres de l'hôtel.
 */

public class Arrivee {

	/**
	 * Le constructeur de la classe Arrivee permet de faire la gestion des arrivées des clients à l'hôtel.
	 * Les clients réservent des chambres de l'hôtel, tant qu'ils le désirent.
	 * 
	 * @param hotel
	 *            Objet qui gère l'hôtel pour consulter et mettre à jour la disponibilité des chambres.
	 */

	public Arrivee( Hotel hotel ) {
		
		// Constantes du constructeur.
		
		final char OUI = 'O';
		final char NON = 'N';

		final String TITRE_ARRIVEE = "\nArrivée d'un client.";
		final String MESS_PLEIN = "\nDésolé, il n'y a aucune chambre de libre à l'hôtel Montmotel.";
		final String MESS_DEVENU_PLEIN = "\nIl ne reste plus de chambres de disponibles à l'hôtel Montmotel.";
		final String MESS_BEAU_SEJOUR = "\nPassez un beau séjour à l'hôtel Montmotel.";
		final String QUEST_AUTRE_ARRIVEE = "\nVoulez-vous réserver une autre chambre (O ou N) ? ";

		if ( hotel.estPlein() ) {
			System.out.println( MESS_PLEIN );
		} else {
			
			int type, noChambre;
			char recommencer;

			do {
				System.out.println( TITRE_ARRIVEE );
				
				type = Hotel.lireTypeChambre();

				if ( hotel.typePlein( type ) ) {
					System.out.println(
							"Désolé, il n'y a aucune chambre de libre pour le type " + Hotel.TAB_TYPES[type] );
				} else {
					hotel.afficherDisponibilite( type );

					noChambre = Hotel.lireNoChambre();

					if ( !hotel.chambreDisponible( type, noChambre ) ) {

						System.out.println( "\nDésolé, la chambre numéro " + ( noChambre + 1 ) + " de type "
								+ Hotel.TAB_TYPES[type] + " n'est pas disponible.");

					} else {

						hotel.reserverChambre( type, noChambre );

						System.out.println( "\nLa chambre numéro " + ( noChambre + 1 ) + " de type "
								+ Hotel.TAB_TYPES[type] + " est maintenant réservée." );

						System.out.println( MESS_BEAU_SEJOUR );

					}
				}
				
				if ( hotel.estPlein() ) {
					System.out.println( MESS_DEVENU_PLEIN );
					recommencer = NON;
				} else {
					recommencer = OutilsLecture.lireOuiNon( QUEST_AUTRE_ARRIVEE );
				}
			} while ( recommencer == OUI );
		}
	}
}