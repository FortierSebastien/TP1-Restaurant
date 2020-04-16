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
	public static ArrayList<Client> listeClient = new ArrayList<Client>();
	public static ArrayList<Plat> listePlats = new ArrayList<Plat>();
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
		String[] listeClients = clients.split(" ");
		clients = clients.substring(clients.indexOf(listeClients[2]));
		listeClients = clients.split(" ");
		for (int i = 0; i < listeClients.length; i++) {
			Client client = new Client(listeClients[i]);
			listeClient.add(client);
		}
		
		String plats = fichier.substring( indexPlats,  indexCommandes).trim();
		
		creerListePlats(plats);
		
		
		String commandes = fichier.substring(indexCommandes).trim();
		commandes = commandes.substring(commandes.indexOf(": ") + 2, commandes.indexOf(" Fin"));
		
		
		String[] facture = commandes.split(" ");
		
		for (int i = 0; i < facture.length; i+=3) {
			for (int j = 0; j < listeClient.size(); j++) {
				if(listeClient.get(j).getNom().equals(facture[i])) {
					String commande = facture[i + 1] + " " + facture[i + 2];
					listeClient.get(j).setCommande(commande.split(" "));
				}
			}
		}
		
		calculerPrixFacture();
		
	}
	public static String transformTabToString(String[] tab) {
		String texte="";
		for (int i = 0; i<tab.length;i++) {
			texte = texte+" "+tab[i];
		}
		
		return texte;
		
	}
	public static void creerListePlats(String listeDesPlats) {
		listePlats.clear();
		String[] tabPlats;
		
		tabPlats = listeDesPlats.split(" ");
		
		for (int i = 2; i < tabPlats.length; i += 2) {
			
			Plat plat = new Plat(tabPlats[i], tabPlats[i + 1]);
			
			listePlats.add(plat);
		}
	}
	public static void calculerPrixFacture() {
		
		System.out.println("\nBienvenue au restaurant Simon & co.");
		System.out.println("Factures : ");
		
		double montant = 0.00;
		for (int i = 0; i < listeClient.size(); i++) {
			montant = 0;
			String[][] commandeClientliste = listeClient.get(i).getCommande();
			for (int j = 0; j < commandeClientliste.length; j++) {
				if (commandeClientliste[j][0] != null) {
					for (int j2 = 0; j2 < listePlats.size(); j2++) {
						if (commandeClientliste[j][0].equals(listePlats.get(j2).getTitrePlat())) {

							montant += Double.parseDouble(listePlats.get(j2).getPrixPlat())
									* Integer.parseInt(commandeClientliste[j][1]);
							break;
						}
					}
				} else {
					System.out.println("\n" + listeClient.get(i).getNom() + " " + outilsjava.OutilsAffichage.formaterMonetaire(montant, 2));
					break;
				}
			}
			
			
		}
			
		
		
		
	}
	
	
	
		
}

