
public class cv {
	
	public static String MESS_BIENVENUE ="Bienvenue chez la viande battue";
	
	

	public static String prenom;
	public static String formation;
	public static int experienceTravailAnnee;
	public static String[] competences;
	public static String attente;
	
	public static void affiche() {
		System.out.println( "Nom: "+nom+"\n" +"\nPrénom: "+ prenom+"\n" + "\nFormation: "+formation+"\n" 
	+ "\nAnnées d'experiences: " +experienceTravailAnnee+"\n" + "\nCompétences: "+transformTabToString( competences )
	+"\n\nAttentes: "+ attente);
	}
	public static String transformTabToString(String[] tab ) {
		String texte="";
		for (int i =0;i< tab.length;i++ ) {
			texte = texte + tab[i];
		}
		return texte;
	}
	
	public static void main() {
		System.out.println( MESS_BIENVENUE );
	}
	public static String nom;
	/**
	 * @return the mESS_BIENVENUE
	 */
	public static String getMESS_BIENVENUE() {
		return MESS_BIENVENUE;
	}
	/**
	 * @param mESS_BIENVENUE the mESS_BIENVENUE to set
	 */
	public static void setMESS_BIENVENUE( String mESS_BIENVENUE ) {
		MESS_BIENVENUE = mESS_BIENVENUE;
	}
	/**
	 * @return the nom
	 */
	public static String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public static void setNom( String nom ) {
		cv.nom = nom;
	}
	/**
	 * @return the prenom
	 */
	public static String getPrenom() {
		return prenom;
	}
	/**
	 * @param prenom the prenom to set
	 */
	public static void setPrenom( String prenom ) {
		cv.prenom = prenom;
	}
	/**
	 * @return the formation
	 */
	public static String getFormation() {
		return formation;
	}
	/**
	 * @param formation the formation to set
	 */
	public static void setFormation( String formation ) {
		cv.formation = formation;
	}
	/**
	 * @return the experienceTravailAnnee
	 */
	public static int getExperienceTravailAnnee() {
		return experienceTravailAnnee;
	}
	/**
	 * @param experienceTravailAnnee the experienceTravailAnnee to set
	 */
	public static void setExperienceTravailAnnee( int experienceTravailAnnee ) {
		cv.experienceTravailAnnee = experienceTravailAnnee;
	}
	/**
	 * @return the competences
	 */
	public static String[] getCompetences() {
		return competences;
	}
	/**
	 * @param competences the competences to set
	 */
	public static void setCompetences( String[] competences ) {
		cv.competences = competences;
	}
	/**
	 * @return the attente
	 */
	public static String getAttente() {
		return attente;
	}
	/**
	 * @param attente the attente to set
	 */
	public static void setAttente( String attente ) {
		cv.attente = attente;
	}
	
}
