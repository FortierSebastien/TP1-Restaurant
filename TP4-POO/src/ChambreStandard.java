/*
 * Auteurs : Simon Manouk et Christian Mongeon,	Groupe : 65
 * Fichier : ChambreStandard.java
 * Date    : 15 avril 2019
 * Cours   : 420-ZE4-MO (TP4, Hôtel)
 */

// Package du programmeur.

import outilsjava.*;

/**
 * La classe ChambreStandard contient les informations et les méthodes pour une chambre de type standard.
 */

public class ChambreStandard {

	// Constantes de la classe ChambreStandard.

	// Durée du séjour entre 1 et 31 jours.
	
	public static final int MIN_JOURS = 1;
	public static final int MAX_JOURS = 31;

	// 120.00 $ par jour, taxes et frais de services inclus.
	
	public static final double PRIX_BASE = 120.00;

	// Champs d'instance privés de la classe ChambreStandard.

	// Nombre de jours du séjour.
	
	private int nbJours;

	// true, la chambre est disponible et false, la chambre n'est pas disponible.
	
	private boolean disponible;

	/**
	 * Le constructeur de la classe ChambreStandard permet de construire une chambre de type standard de base.
	 * Au début, nombre de jours à 0 et la chambre est disponible.
	 */

	public ChambreStandard() {

		/*
		 * TODO (À COMPLÉTER). Voir page 7 de l'énoncé du TP4.
		 */
		initialiserChambre();

	}

	/**
	 * La méthode initialiserChambre() permet d'initialiser une chambre.
	 * Nombre de jours à 0 et la chambre est disponible.
	 */

	public void initialiserChambre() {

		/*
		 * TODO (À COMPLÉTER). Voir page 7 de l'énoncé du TP4.
		 */
		this.setDisponible( true );
		this.setNbJours( 0 );

	}

	/**
	 * La méthode accesseur getNbJours() permet de retourner le nombre de jours du séjour.
	 * 
	 * @return Le nombre de jours du séjour.
	 */

	public int getNbJours() {
		
		return this.nbJours;
	}

	/**
	 * La méthode accesseur isDisponible() permet de retourner la disponiblité de la chambre. Remarque : le nom est
	 * isDisponible au lieu de getDisponible, car l'accesseur retourne un booléen.
	 * 
	 * @return true, la chambre est disponible et false, la chambre n'est pas disponible.
	 */

	public boolean isDisponible() {
		
		return this.disponible;
	}

	/**
	 * La méthode mutateur setNbJours() permet de modifier le nombre de jours du séjour
	 * avec celui reçu en paramètre.
	 * 
	 * @param nbJours
	 *            Le nombre de jours du séjour.
	 */

	public void setNbJours( int nbJours ) {
		
		if ( nbJours >= 0 && nbJours <= ChambreStandard.MAX_JOURS ) {
			this.nbJours = nbJours;
		}
	}

	/**
	 * La méthode mutateur setDisponible() permet de modifier la disponibilité de la chambre
	 * avec celle reçue en paramètre.
	 * 
	 * @param disponible
	 *            La disponibilité de la chambre (true ou false).
	 */

	public void setDisponible( boolean disponible ) {
		
		this.disponible = disponible;
	}

	/**
	 * La méthode lireInfosDepart() permet de lire les informations à la fin du séjour (lorsque le client quitte).
	 */

	public void lireInfosDepart() {
		
		// Constante de la méthode.
		
		final String QUEST_NB_JOURS = "\nEntrez le nombre de jours du séjour (entre " +
									  ChambreStandard.MIN_JOURS + " et " + ChambreStandard.MAX_JOURS + ") : ";

		int nbJoursSejour = OutilsLecture.lireEntierValide( QUEST_NB_JOURS, MIN_JOURS, MAX_JOURS );
		
		
		this.setNbJours( nbJoursSejour );
		/*
		 * TODO (À COMPLÉTER). Voir page 7 de l'énoncé du TP4.
		 */


	}

	/**
	 * La méthode calculerPrixTotal() permet de calculer et de retourner le prix total de la chambre.
	 * 
	 * @return Le prix total de la chambre.
	 */

	public double calculerPrixTotal() {

		return this.getNbJours() * PRIX_BASE;
		
		/*
		 * TODO (À COMPLÉTER). Voir page 7 de l'énoncé du TP4.
		 */


	}

	/**
	 * La méthode reglerChambre() permet de régler la chambre à la fin du séjour à l'hôtel. La méthode
	 * lit les informations nécessaires pour calculer la facture et réinitialise la chambre.
	 */

	public void reglerChambre() {
		
		lireInfosDepart();
		
		System.out.println( "\nPrix total pour la chambre : " +
							OutilsAffichage.formaterMonetaire(calculerPrixTotal(), 2 ) + "\n");
		
		initialiserChambre();

		/*
		 * TODO (À COMPLÉTER). Voir page 7 de l'énoncé du TP4.
		 */


	}

	/**
	 * La méthode statique afficherTarifsBase() permet d'afficher les tarifs de base de la chambre.
	 */

	public static void afficherTarifsBase() {
		
		System.out.println( "Prix pour la chambre : \t\t\t" + OutilsAffichage.formaterMonetaire(PRIX_BASE, 2) + 
							" par jour (taxes et frais de services inclus)." );	
		
		/*
		 * TODO (À COMPLÉTER). Voir page 7 de l'énoncé du TP4.
		 */


	}
}