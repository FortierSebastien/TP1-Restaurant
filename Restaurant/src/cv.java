
public class Cv {
	
	static String tab[] = {"Programmation","Analyse"};
	
	public static String MESS_BIENVENUE ="\nBienvenue chez la viande battue";
	
	
	public static String nom;
	public static String prenom;
	public static String formation;
	public static int experienceTravailAnnee;
	public static String[] competences;
	public static String attente;
	

	public static void affiche(Cv unObjet) {
		System.out.println( "\n\nNom: "+unObjet.getNom()+"\n" +"\nPrénom: "+ unObjet.getPrenom()+"\n" + "\nFormation: "
	+unObjet.getFormation()+"\n" + "\nAnnées d'experiences: " +unObjet.getExperienceTravailAnnee()+"\n" 
				+ "\nCompétences: "
		+transformTabToString( unObjet.getCompetences() )+"\n\nAttentes: "+ unObjet.getAttente());
		
	}
	public static String transformTabToString(String[] tab ) {
		String texte="";
		for (int i =0;i< tab.length;i++ ) {
			texte = texte + tab[i];
		}
		return texte;
	}
	


	
	
	
	public static void afficherAuteur() {
		System.out.println( MESS_BIENVENUE );
		Cv sebastien = new Cv();
		sebastien.setNom( "Fortier" );
		sebastien.setPrenom( "Sébastien" );
		sebastien.setFormation( "Technique en programation" );
		sebastien.setExperienceTravailAnnee( 2 );
		sebastien.setCompetences( tab );
		sebastien.setAttente( "None" );
		
		affiche( sebastien );
		
		Cv anthony = new Cv();
		anthony.setNom( "Bassal" );
		anthony.setPrenom( "Anthony" );
		anthony.setFormation( "Technique en programation" );
		anthony.setExperienceTravailAnnee( 2 );
		anthony.setCompetences( tab );
		anthony.setAttente( "None" );
		
		affiche( anthony );
		
	}
	public static Cv setInfo(String nom, String prenom, String formation,int experienceInt,String []competence,String attente ) {
		
		Cv temp = new Cv();
		temp.setNom( nom );
		temp.setPrenom( prenom);
		temp.setFormation( formation );
		temp.setExperienceTravailAnnee( experienceInt );
		temp.setCompetences( competence );
		temp.setAttente( attente );
		
		return temp;
		
		
	}
	
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom( String nom ) {
		Cv.nom = nom;
	}
	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom( String prenom ) {
		Cv.prenom = prenom;
	}
	/**
	 * @return the formation
	 */
	public String getFormation() {
		return formation;
	}
	/**
	 * @param formation the formation to set
	 */
	public void setFormation( String formation ) {
		Cv.formation = formation;
	}
	/**
	 * @return the experienceTravailAnnee
	 */
	public int getExperienceTravailAnnee() {
		return experienceTravailAnnee;
	}
	/**
	 * @param experienceTravailAnnee the experienceTravailAnnee to set
	 */
	public void setExperienceTravailAnnee( int experienceTravailAnnee ) {
		Cv.experienceTravailAnnee = experienceTravailAnnee;
	}
	/**
	 * @return the competences
	 */
	public String[] getCompetences() {
		return competences;
	}
	/**
	 * @param competences the competences to set
	 */
	public void setCompetences( String[] competences ) {
		Cv.competences = competences;
	}
	/**
	 * @return the attente
	 */
	public String getAttente() {
		return attente;
	}
	/**
	 * @param attente the attente to set
	 */
	public void setAttente( String attente ) {
		Cv.attente = attente;
	}
	

	
}
