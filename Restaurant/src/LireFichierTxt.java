import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import outilsjava.*;


public class LireFichierTxt {
	
	public static String ENTETE_CLIENT = "Clients : ";
	public static String ENTETE_PLAT = "Plats : ";
	public static String ENTETE_COMMANDE = "Commandes : ";
	
	static ObjectInputStream ficLecture;
	static String nomFichier;
	static String texte;
	public static ArrayList<Plat> listePlats = new ArrayList<Plat>(5);
	public static int nombrePlats = 0;
	
	BufferedReader fic = new BufferedReader( new InputStreamReader( System.in ) );
	
	
	public static void lireFichierResto() throws FileNotFoundException, IOException {
		final String QUEST_NOM_FICHIER = "\nEntrez le nom du fichier qui contient les infos "
				+ "du restaurant: ";
		
		nomFichier = OutilsFichier.lireNomFichier( QUEST_NOM_FICHIER );
		
	BufferedReader reader= OutilsFichier.ouvrirFicTexteLecture( nomFichier );
	String fichier = reader.readLine();
	int indexClients = 0;
	int indexPlats = fichier.indexOf( ENTETE_PLAT );
	int indexCommandes = fichier.indexOf( ENTETE_COMMANDE );
	
	String clients = fichier.substring( indexClients,  indexPlats).trim();
	System.out.println(  clients);
	
	String plats = fichier.substring( indexPlats,  indexCommandes).trim();
	
	creerListePlats(plats);
	
	
//	System.out.println(  plats);
	
	String commandes = fichier.substring(indexCommandes).trim();
	String[] facture = commandes.split(" ");
	for (int i = 3; i < facture.length; i+= 2) {
		System.out.println(facture[i - 1] + " : " + calculerPrixFacture(facture) );
	}
	
	System.out.println(  commandes);
	
	
		  }
	public static String transformTabToString(String[] tab) {
		String texte="";
		for (int i = 0; i<tab.length;i++) {
			texte = texte+" "+tab[i];
		}
		
		return texte;
		
	}
	public static void creerListePlats(String listeDesPlats) {
		
		String[] tabPlats;
		
		tabPlats = listeDesPlats.split(" ");
		
		for (int i = 2; i < tabPlats.length; i += 2) {
			
			Plat plat = new Plat(tabPlats[i], tabPlats[i + 1]);
			
			listePlats.add(plat);
		}
	}
	public static String calculerPrixFacture(String[] tabRepas) {
		
		
		
		
		return null;
	}
	
	
	
		
}

