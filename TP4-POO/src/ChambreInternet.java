import outilsjava.OutilsAffichage;
import outilsjava.OutilsLecture;

/*
 * Auteurs : Simon Manouk et Christian Mongeon,	Groupe : 65
 * Fichier : ChambreInternet.java
 * Date    : 15 avril 2019
 * Cours   : 420-ZE4-MO (TP4, Hôtel)
 */

// Package du programmeur.


/**
 * La classe ChambreInternet hérite de la classe ChambreStandard.
 * 
 * La classe ChambreInternet contient les informations et les méthodes supplémentaires
 * pour une chambre de l'hôtel qui a un accès à Internet.
 */

public class ChambreInternet extends ChambreStandard {

	// Constantes de la classe ChambreInternet.

	// Peut accéder à Internet entre 0 et 744 heures (31 jours * 24 heures).
	
	public static final double MIN_HEURES = 0;
	public static final double MAX_HEURES = ChambreStandard.MAX_JOURS * 24;

	// L'accès Internet coûte 0.50 $ de l'heure.
	
	public static final double PRIX_INTERNET = 0.50;

	// Champ d'instance privé de la classe ChambreInternet.

	private double nbHeures; // Nombre d'heures pour l'accès Internet.

	/**
	 * Le constructeur de la classe ChambreInternet permet de construire une chambre à accès Internet de base.
	 * Au début, aucun accès à Internet.
	 */

	public ChambreInternet() {
		
		initialiserChambre();
		
		/*
		 * TODO (À COMPLÉTER). Voir page 8 de l'énoncé du TP4.
		 */

		
	}

	/**
	 * Redéfinition de la méthode qui permet d'initialiser une chambre.
	 */

	@Override
	public void initialiserChambre() {
		
		super.initialiserChambre();
		
		/*
		 * TODO (À COMPLÉTER). Voir page 8 de l'énoncé du TP4.
		 */

		
	}

	/**
	 * La méthode accesseur getNbHeures() permet de retourner le nombre d'heures d'accès à Internet.
	 * 
	 * @return Le nombre d'heures d'accès à Internet.
	 */

	public double getNbHeures() {
		
		return this.nbHeures;
	}

	/**
	 * La méthode mutateur setNbHeures() permet de modifier le nombre d'heures d'accès à Internet
	 * avec celui reçu en paramètre.
	 * 
	 * @param nbHeures
	 *            Le nombre d'heures d'accès à Internet.
	 */

	public void setNbHeures( double nbHeures ) {
		
		if ( nbHeures >= ChambreInternet.MIN_HEURES && nbHeures <= ChambreInternet.MAX_HEURES ) {

			this.nbHeures = nbHeures;
		}
	}

	/**
	 * Redéfinition de la méthode qui lit les informations à la fin du séjour (lorsque le client quitte).
	 */

	@Override
	public void lireInfosDepart() {

		// Constante de la méthode.

		final String QUEST_NB_HEURES = "\nEntrez le nombre d'heures d'accès à Internet (entre " +
									   ChambreInternet.MIN_HEURES + " et " + ChambreInternet.MAX_HEURES + ") : ";

		super.lireInfosDepart();
		
		int nbHeuresInternet = OutilsLecture.lireEntierValide( QUEST_NB_HEURES, 
								(int) MIN_HEURES, (int) MAX_HEURES );
		
		this.setNbHeures( nbHeuresInternet );
		
		
		/*
		 * TODO (À COMPLÉTER). Voir page 8 de l'énoncé du TP4.
		 */

		
	}

	/**
	 * Redéfinition de la méthode qui calcule et retourne le prix total de la chambre.
	 */

	@Override
	public double calculerPrixTotal() {
		
		return this.getNbHeures() * PRIX_INTERNET + super.calculerPrixTotal();

		/*
		 * TODO (À COMPLÉTER). Voir page 8 de l'énoncé du TP4.
		 */


	}

	/**
	 * La méthode statique afficherTarifsBase() permet d'afficher les tarifs de base de la chambre.
	 */

	public static void afficherTarifsBase() {
		
		System.out.println( "Prix pour l'accès à Internet : \t\t"+
							OutilsAffichage.formaterMonetaire( PRIX_INTERNET, 2 )+" de l'heure." );
		
		/*
		 * TODO (À COMPLÉTER). Voir page 8 de l'énoncé du TP4.
		 */


	}
}