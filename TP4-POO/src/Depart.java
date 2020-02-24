/*
 * Auteurs : Simon Manouk et Christian Mongeon,	Groupe : 65
 * Fichier : Depart.java
 * Date    : 15 avril 2019
 * Cours   : 420-ZE4-MO (TP4, Hôtel)
 */

// Package du programmeur.

import outilsjava.*;

/**
 * La classe Depart permet de gérer les départs des clients de l'hôtel Montmotel.
 */

public class Depart {

	/**
	 * Le constructeur de la classe Depart permet de faire la gestion des départs des clients de l'hôtel Montmotel. Les
	 * clients payent et libèrent des chambres de l'hôtel, tant qu'ils le désirent.
	 * 
	 * @param hotel
	 *            Objet qui gère l'hôtel pour consulter et mettre à jour la disponibilité des chambres.
	 */

	public Depart( Hotel hotel ) {
		
		// Constantes du constructeur.
		
		final char OUI = 'O';
		final char NON = 'N';

		final String TITRE_DEPART = "\nDépart d'un client.";
		final String MESS_VIDE = "\nAucun départ possible, toutes les chambres de l'hôtel Montmotel sont libres.";
		final String MESS_DEVENU_VIDE = "\nToutes les chambres de l'hôtel Montmotel ont été libérées.";
		final String MESS_MERCI = "\nMerci d'avoir séjourné à l'hôtel Montmotel.";
		final String QUEST_AUTRE_DEPART = "\nVoulez-vous libérer une autre chambre (O ou N) ? ";

		if ( hotel.estVide() ) {
			System.out.println( MESS_VIDE );
		} else {

			int type, noChambre;
			char recommencer;

			do {
				System.out.println( TITRE_DEPART );
				
				type = Hotel.lireTypeChambre();
				
				if(hotel.typeVide( type )) {
					
					System.out.println( "Erreur, toutes les chambres de type " + Hotel.TAB_TYPES[type] +
										" sont déjà libre");
					
				} else {
					
					hotel.afficherDisponibilite( type );
					
					noChambre = Hotel.lireNoChambre();
							
					if(hotel.chambreDisponible( type, noChambre ) ) {
						
						System.out.println( "Erreur, la chambre numéro" + (noChambre + 1) + 
											"de type " + Hotel.TAB_TYPES[type] + " est déjà libre" );
						
					} else {
						
						hotel.libererChambre( type, noChambre );
						
						System.out.println( "\nLa chambre numéro " + (noChambre + 1) + 
								" de type " + Hotel.TAB_TYPES[type] + " est maintenant libre.");
						
						System.out.println( MESS_MERCI );
						
					}
					
				}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				

				/*
				 * TODO (À COMPLÉTER). Voir page 14 de l'énoncé du TP4.
				 */


				
				// Les chambres de l'hôtel ont-elles été toutes libérées ?
				
				if ( hotel.estVide() ) {
					System.out.println( MESS_DEVENU_VIDE );
					recommencer = NON;
				} else {
					recommencer = OutilsLecture.lireOuiNon( QUEST_AUTRE_DEPART );
				}
			} while ( recommencer == OUI );
		}
	}
}