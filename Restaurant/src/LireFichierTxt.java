import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


import outilsjava.*;



public class LireFichierTxt {
	
	public static String ENTETE_CLIENT = "Clients : ";
	public static String ENTETE_PLAT = "Plats : ";
	public static String ENTETE_COMMANDE = "Commandes : ";
	static boolean espacement = false;
	static boolean plats = false;
	static boolean client = false;
	
	static ObjectInputStream ficLecture;
	static String nomFichier;
	static String texte;
	public static ArrayList<Client> listeClient = new ArrayList<Client>();
	public static ArrayList<Plat> listePlats = new ArrayList<Plat>();
	public static int nombrePlats = 0;
	public static final double TPS = 0.05;
	public static final double TVQ = 0.09975;
	public static String DEUX_ESPACES = "  ";
	public static SimpleDateFormat DATE_HEURE = new SimpleDateFormat("YYYY-MM-dd-HHmmss");
	
	
	public final static String FILE_NAME ="Facture-du-";
	
	BufferedReader fic = new BufferedReader( new InputStreamReader( System.in ) );
	
	
	public static void lireFichierResto() throws FileNotFoundException, IOException {
		final String QUEST_NOM_FICHIER = "\nEntrez le nom du fichier qui contient les infos "
					+ "du restaurant: ";
			
			nomFichier = OutilsFichier.lireNomFichier( QUEST_NOM_FICHIER );
			
		BufferedReader reader= OutilsFichier.ouvrirFicTexteLecture( nomFichier );
		String fichier = reader.readLine();
		if(fichier.contains(DEUX_ESPACES)) {
			espacement = true;
		}
		int indexClients = 0;
		int indexPlats = fichier.indexOf( ENTETE_PLAT );
		int indexCommandes = fichier.indexOf( ENTETE_COMMANDE );
		
		creerListeClients(fichier.substring(indexClients, indexPlats).trim());
		
		String plats = fichier.substring( indexPlats,  indexCommandes).trim();
		
		creerListePlats(plats);
		
		String commandes = fichier.substring(indexCommandes).trim();
		commandes = commandes.substring(commandes.indexOf(": ") + 2, commandes.indexOf(" Fin"));
		creerCommandes(commandes.split(" "));
		
		calculerPrixFacture();
		
	}
	public static void creerCommandes(String[] facture) {
		String commande = null;

		for (int i = 0; i < facture.length; i += 3) {
			for (int j = 0; j < listeClient.size(); j++) {
				if (listeClient.get(j).getNom().equals(facture[i])) {
					commande = facture[i + 1] + " " + facture[i + 2];
					listeClient.get(j).setCommande(commande.split(" "));
				} else {
					client = true;
				}

			}

		}
	}
	public static void creerListeClients(String clients) {
		listeClient.clear();

		String[] listeClients = clients.split(" ");
		clients = clients.substring(clients.indexOf(listeClients[2]));
		listeClients = clients.split(" ");
		for (int i = 0; i < listeClients.length; i++) {
			Client client = new Client(listeClients[i]);
			listeClient.add(client);
		}
	}
	public static void creerListePlats(String listeDesPlats) {
		listePlats.clear();
		String[] tabPlats;
		if (espacement) {

		} else {
			tabPlats = listeDesPlats.split(" ");

			for (int i = 2; i < tabPlats.length; i += 2) {

				Plat plat = new Plat(tabPlats[i], tabPlats[i + 1]);

				listePlats.add(plat);
			}
		}
	}
	public static void calculerPrixFacture() {
		LireFichierTxt.ecrireFichier();
		System.out.println("\nBienvenue au restaurant Simon & co.");
		System.out.println("Factures : ");
		if(espacement) {
		}else {
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
						} else {
							if(j2 == listePlats.size() - 1 ) {
								System.out.println("\nLe plat: "+ commandeClientliste[j][0] +" n'existe pas dans le menu");
								OutilsLecture.lireEntree("\nAppuyez sur entrée pour poursuivre vers la facture");
							}
						}
					}
				} else {
					if(montant != 0) {
						
						System.out.println("\nClient : " + listeClient.get(i).getNom() + "\n\tSous-total: "
							   + outilsjava.OutilsAffichage.formaterMonetaire(montant, 2) + "\n\tTaxes: "
										   + outilsjava.OutilsAffichage.formaterMonetaire((montant * (TPS + TVQ)), 2) + "\n\tTotal: " 
										   + outilsjava.OutilsAffichage.formaterMonetaire(montant *= (TPS + TVQ + 1), 2));
					}
					break;
					
				}
			}
			
			
		}
		}
		
			
		
		
		
	
	
	}
	
	public static void ecrireFichier(){
		
		
		
		 try {
	            FileWriter writer = new FileWriter(FILE_NAME+ DATE_HEURE.format(new Date())+".txt", true);
	           
	            
	            writer.write("\nBienvenue au restaurant Simon & co.\n");
	            
	            writer.write("Factures : ");
	    		if(espacement){
	    			System.out.println("\nIl y a un problème d'espacement à corriger dans le ficher texte utilisé");
	    
	    		}else {
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
	    						} else {
	    							if(j2 == listePlats.size() - 1 ) {
	    								 writer.write("\n\nLe plat: "+ commandeClientliste[j][0] +" n'existe pas dans le menu");
	    								plats = true;
	    							}
	    						}
	    					}
	    				} else {
	    					if(montant != 0) {
	    						
	    						 writer.write("\n\nClient : " + listeClient.get(i).getNom() + "\n\tSous-total: "
	    							   + outilsjava.OutilsAffichage.formaterMonetaire(montant, 2) + "\n\tTaxes: "
	    										   + outilsjava.OutilsAffichage.formaterMonetaire((montant * (TPS + TVQ)), 2) + "\n\tTotal: " 
	    										   + outilsjava.OutilsAffichage.formaterMonetaire(montant *= (TPS + TVQ + 1), 2));
	    					}
	    					break;
	    					
	    				}
	    			}
	    		}
	    			
	    			
	    		}
	    		writer.write("\n\nErreur : \n");
	    		
	    			if(plats) {
	    				 writer.write("\n*	Il y a un ou plusieurs plats qui n'existe pas.\n");
	    			}
	    			if(client) {
	    				writer.write("\n*	Il y a un ou plusieurs clients qui n'existe pas.\n");
	    			}
	    			if(espacement) {
	    				writer.write("\n*	Il y a un ou plusieurs espacements dans le fichier texte qui ne sont pas conforme au norme soit d'un espace entre chaque mot.\n");
	    			}
	            
	            
	          
	            writer.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
	}
		
}

