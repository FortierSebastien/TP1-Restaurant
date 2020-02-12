import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;


import outilsjava.*;


public class LireFichierTxt {
	
	public static String ENTETE_CLIENT = "Clients : ";
	public static String ENTETE_PLAT = "Plats : ";
	public static String ENTETE_COMMANDE = "Commandes : ";
	
	static ObjectInputStream ficLecture;
	static String nomFichier;
	static String texte;
	
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
	System.out.println(  plats);
	
	String commandes = fichier.substring(indexCommandes).trim();
	System.out.println(  commandes);

	String[] tabClients = clients.substring( ENTETE_CLIENT.length()).split( " " );
	System.out.println( transformTabToString( tabClients ) );
	
		  }
	public static String transformTabToString(String[] tab) {
		String texte="";
		for (int i = 0; i<tab.length;i++) {
			texte = texte+" "+tab[i];
		}
		
		return texte;
		
	}
	
	
	
	
		
	}

