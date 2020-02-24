/*
 * Auteurs : Simon Manouk et Christian Mongeon,	Groupe : 65
 * Fichier : Hotel.java
 * Date    : 15 avril 2019
 * Cours   : 420-ZE4-MO (TP4, Hôtel)
 */

// Package du programmeur.

import outilsjava.*;

/**
 * La classe Hotel contient les informations et les méthodes pour un hôtel de trois étages.
 * Sur le premier étage, il y a 5 chambres standards. Sur le deuxième étage, il y a 5 chambres avec un accès à Internet
 * et sur le troisième étage, il y a 5 chambres de luxe (accès à Internet et à des repas en chambre).
 */

public class Hotel {

	// Constantes de la classe Hotel.

	// Il y a 3 types de chambres et 5 chambres par type.
	
	public static final int MAX_TYPES    = 3;
	public static final int MAX_CHAMBRES = 5;

	// Indices pour les types de chambres.
	
	public static final int STANDARD = 0;
	public static final int INTERNET = 1;
	public static final int LUXE     = 2;

	// Tableau des noms des 3 types de chambres.
	
	public static final String[] TAB_TYPES = { "standard", "Internet", "de luxe" };

	// Champs d'instance privés de la classe Hotel.

	// L'hôtel est composé d'un tableau à deux dimensions de ChambreStandard.
	// La première dimension (les lignes) représente les 3 types de chambres et
	// la deuxième dimension (les colonnes) représente les 5 chambres de chaque type.

	private ChambreStandard[][] tabChambres = new ChambreStandard[Hotel.MAX_TYPES][Hotel.MAX_CHAMBRES];

	// Tableau qui contient le nombre de chambres occupées pour chaque type de chambre.
	
	private int[] tabOccupees = new int[Hotel.MAX_TYPES];

	/**
	 * Le constructeur de la classe Hotel permet de construire toutes les chambres de l'hôtel. Le premier étage
	 * contient les chambres standards, le deuxième étage contient les chambres à accès Internet et le troisième étage
	 * contient les chambres de luxe. Au début, toutes les chambres sont disponibles.
	 */

	public Hotel() {
		
		// Créer le bon type de chambre pour chaque chambre.
		
		for(int nbChambre = 0; nbChambre < Hotel.MAX_CHAMBRES; nbChambre++) {
			
			this.tabChambres[Hotel.STANDARD][nbChambre] = new ChambreStandard();
			
			this.tabChambres[Hotel.INTERNET][nbChambre] = new ChambreInternet();
			
			this.tabChambres[Hotel.LUXE][nbChambre] = new ChambreLuxe();
		}
		
		// Initialiser le nombre de chambres occupées pour chaque type.
		
		for( int type = 0; type < Hotel.MAX_TYPES; type++) {
			this.tabOccupees[type] = 0;
		}

		/*
		 * TODO (À COMPLÉTER). Voir page 10 de l'énoncé du TP4. Mettre également les commentaires.
		 */


	}

	/**
	 * La méthode chambreDisponible() permet d'indiquer si un numéro de chambre d'un certain type est disponible.
	 * 
	 * @param type
	 *            Le type de la chambre.
	 * @param noChambre
	 *            Le numéro de la chambre.
	 * @return true si la chambre est disponible et false dans le cas contraire.
	 */

	public boolean chambreDisponible( int type, int noChambre ) {
		
		boolean chambreDisponible = false;
		
		if(tabChambres[type][noChambre].isDisponible()) {
			chambreDisponible = true;
		}
		
		return chambreDisponible;

		/*
		 * TODO (À COMPLÉTER). Voir page 10 de l'énoncé du TP4.
		 */


	}

	/**
	 * La méthode reserverChambre() permet de réserver un numéro de chambre d'un certain type.
	 * Il s'agit de modifier le champ disponible de la chambre en question pour la valeur false et
	 * de mettre à jour le nombre de chambres occupées.
	 * 
	 * @param type
	 *            Le type de la chambre.
	 * @param noChambre
	 *            Le numéro de la chambre.
	 */

	public void reserverChambre( int type, int noChambre ) {
		
		if( chambreDisponible( type, noChambre ) ) {
			tabChambres[type][noChambre].setDisponible( false );
			
			tabOccupees[type]++;
			
		}
		
		/*
		 * TODO (À COMPLÉTER). Voir page 10 de l'énoncé du TP4.
		 */


	}

	/**
	 * La méthode libererChambre() permet de libérer un numéro de chambre d'un certain type.
	 * Il s'agit de régler la chambre en question et de mettre à jour le nombre de chambres occupées.
	 * 
	 * @param type
	 *            Le type de la chambre.
	 * @param noChambre
	 *            Le numéro de la chambre.
	 */

	public void libererChambre( int type, int noChambre ) {
		
		if(!chambreDisponible( type, noChambre )) {
			tabChambres[type][noChambre].reglerChambre();
			
			tabOccupees[type]--;
		}
		
		/*
		 * TODO (À COMPLÉTER). Voir page 10 de l'énoncé du TP4.
		 */


	}

	/**
	 * La méthode typePlein permet d'indiquer si toutes les chambres d'un certain type sont occupées.
	 * 
	 * @param type
	 *            Le type de la chambre.
	 * @return true si toutes les chambres du type sont occupées et false dans le cas contraire.
	 */

	public boolean typePlein( int type ) {
		
		boolean typePlein = false;
		
		if(tabOccupees[type] == Hotel.MAX_CHAMBRES) {
			typePlein = true;
		}
		return typePlein;
		/*
		 * TODO (À COMPLÉTER). Voir page 11 de l'énoncé du TP4.
		 */
	}

	/**
	 *La méthode typeVide() permet d'indiquer si toutes les chambres d'un certain type sont vides.
	 * 
	 * @param type
	 *            Le type de la chambre.
	 * @return true si toutes les chambres du type sont vides et false dans le cas contraire.
	 */

	public boolean typeVide( int type ) {
		
		boolean typeVide = false;
		
		if(tabOccupees[type]  == 0) {
			typeVide = true;
		}
		return typeVide;
		
		
		/*
		 * TODO (À COMPLÉTER). Voir page 11 de l'énoncé du TP4.
		 */


	}

	/**
	 * La méthode estPlein() permet d'indiquer si toutes les chambres de l'hôtel sont occupées.
	 * 
	 * @return true si toutes les chambres de l'hôtel sont occupées et false dans le cas contraire.
	 */

	public boolean estPlein() {
		
		boolean toutPlein = false;
		
		if(typePlein( Hotel.STANDARD ) && typePlein( Hotel.INTERNET ) && typePlein( Hotel.LUXE )) {
			toutPlein = true;
		}
		
		return toutPlein;
		
		/*
		 * TODO (À COMPLÉTER). Voir page 11 de l'énoncé du TP4.
		 */


	}

	/**
	 * La méthode estVide() permet d'indiquer si toutes les chambres de l'hôtel sont vides.
	 * 
	 * @return true si toutes les chambres de l'hôtel sont vides et false dans le cas contraire.
	 */

	public boolean estVide() {
		
	boolean toutVide = false;
		
		if(typeVide( Hotel.STANDARD ) && typeVide( Hotel.INTERNET ) && typeVide( Hotel.LUXE )) {
			toutVide = true;
		}
		
		return toutVide;

		/*
		 * TODO (À COMPLÉTER). Voir page 11 de l'énoncé du TP4.
		 */


	}

	/**
	 * La méthode afficherDisponibilite() permet d'afficher la disponibilité d'une chambre en particulier.
	 * 
	 * @param type
	 *            Le type de la chambre.
	 * @param noChambre
	 *            Le numéro de la chambre.
	 */

	public void afficherDisponibilite( int type, int noChambre ) {
		
		if(tabChambres[type][noChambre].isDisponible()) {
			System.out.println( "\nLa chambre numéro "+ noChambre + " de type " + type + " est disponible." );
		}else {
			System.out.println( "\nLa chambre numéro "+ noChambre + " de type " + type + " est occupée." );
		}
		

		/*
		 * TODO (À COMPLÉTER). Voir page 11 de l'énoncé du TP4.
		 */


	}

	/**
	 * La méthode afficherDisponibilite() permet d'afficher la disponibilité de toutes les chambres d'un certain type.
	 * 
	 * @param type
	 *            Le type de la chambre.
	 */

	public void afficherDisponibilite( int type ) {
		
		System.out.println( "\nDisponibilité des chambres de type "+ Hotel.TAB_TYPES[type] + " : \n" );
		
		for(int noChambre = 0; noChambre < Hotel.MAX_CHAMBRES; noChambre++) {
			
			if(tabChambres[type][noChambre].isDisponible() ) {
			
				System.out.print( (noChambre + 1) + " : Disponible  " );
			} else {
				System.out.print( (noChambre + 1) + " : Occupée " );
	
			}
		}
		
		System.out.print( "\n" );

		/*
		 * TODO (À COMPLÉTER). Voir page 12 de l'énoncé du TP4.
		 */

		
	}

	/**
	 * La méthode afficherDisponibilite() permet d'afficher la disponibilité de toutes les chambres de l'hôtel.
	 */

	public void afficherDisponibilite() {
		
		System.out.println( "Disponibilité de toutes les chambres de l'hôtel Montmotel." );
		
		for(int type = 0; type < Hotel.MAX_TYPES; type++) {
			
			afficherDisponibilite(type);
			
		}

		/*
		 * TODO (À COMPLÉTER). Voir page 12 de l'énoncé du TP4.
		 */
		

	}

	/**
	 * La méthode statique afficherTarifsBase() permet d'afficher les tarifs de base de chaque type de chambre.
	 */

	public static void afficherTarifsBase() {
		
		ChambreStandard.afficherTarifsBase();
		
		ChambreInternet.afficherTarifsBase();
		
		ChambreLuxe.afficherTarifsBase();

		/*
		 * TODO (À COMPLÉTER). Voir page 12 de l'énoncé du TP4.
		 */
		

	}

	/**
	 * La méthode statique lireTypeChambre() permet de lire un type de chambre et de le retourner.
	 * 
	 * @return Une valeur entre 0 et MAX_TYPES - 1 pour faciliter l'accès au tableau.
	 */

	public static int lireTypeChambre() {
		
		// Constantes de la méthode.
		
		final String QUEST_TYPE_CHAMBRE = "\nEntrez le type de la chambre ([S]tandard, [I]nternet ou [L]uxe) : ";

		final String TYPES_POSSIBLES = "SIL";

		int type;
		char carType;

		carType = OutilsLecture.lireCaractereDisparate( QUEST_TYPE_CHAMBRE,	TYPES_POSSIBLES );

		// Type contiendra 0 si S, 1 si I ou 2 si L.
		
		type = TYPES_POSSIBLES.indexOf( carType );

		return type;
	}

	/**
	 * La méthode statique lireNoChambre() permet de lire un numéro de chambre et de le retourner.
	 * 
	 * @return Une valeur entre 0 et MAX_CHAMBRES - 1 pour faciliter l'accès au tableau.
	 */

	public static int lireNoChambre() {

		// Constante de la méthode.

		final String QUEST_NO_CHAMBRE = "\nEntrez le numéro de la chambre (entre 1 et " + Hotel.MAX_CHAMBRES + ") : ";

		int noChambre;

		noChambre = OutilsLecture.lireEntierValide( QUEST_NO_CHAMBRE, 1, Hotel.MAX_CHAMBRES );

		return noChambre - 1;
	}
}