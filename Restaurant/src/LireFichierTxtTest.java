
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import org.junit.Test;

import outilsjava.OutilsFichier;

public class LireFichierTxtTest {

	@Test
	public void testGrosseCommande() {
		LireFichierTxt.creerListePlats("Plats : Poutine 10 Frites 2.5 Repas_Poulet 17.00 Patate 2.00");
		LireFichierTxt.creerListeClients("Client : Gilbert");
		String[] tab = { "Gilbert", "Poutine", "3", "Gilbert", "Repas_Poulet", "2" };
		LireFichierTxt.creerCommandes(tab);

		assertEquals(64.0, LireFichierTxt.montantCalculer(0), 2);

		LireFichierTxt.creerListePlats("Plats : Poutine 10 Frites 2.5 Repas_Poulet 17.00 Patate 2.00");
		LireFichierTxt.creerListeClients("Client : Gilbert");
		String[] tab4Articles = { "Gilbert", "Poutine", "3", "Gilbert", "Repas_Poulet", "2", "Gilbert", "Patate", "12",
				"Gilbert", "Frites", "20" };
		LireFichierTxt.creerCommandes(tab4Articles);

		assertEquals(138.0, LireFichierTxt.montantCalculer(0), 2);
	}

	@Test
	public void testClientNonExistant() {
		LireFichierTxt.creerListePlats("Plats : Poutine 10 Frites 2.5 Repas_Poulet 17.00 Patate 2.00");
		LireFichierTxt.creerListeClients("Client : Gilbert");
		String[] tab = { "Seb", "Poutine", "4" };
		LireFichierTxt.creerCommandes(tab);

		assertSame("Le client n'est pas enregistré", LireFichierTxt.messageErreur(tab[0]));

		LireFichierTxt.creerListePlats("Plats : Poutine 10 Frites 2.5 Repas_Poulet 17.00 Patate 2.00");
		LireFichierTxt.creerListeClients("Client : Gilbert");
		String[] tabClientExistant = { "Gilbert", "Poutine", "4" };
		LireFichierTxt.creerCommandes(tabClientExistant);

		assertSame("Aucune erreurs", LireFichierTxt.messageErreur(tabClientExistant[0]));
	}

	@Test
	public void testCreationListeClientVide() {
		LireFichierTxt.creerListePlats("Plats : Poutine 10 Frites 2.5 Repas_Poulet 17.00 Patate 2.00");
		LireFichierTxt.creerListeClients("Client : ");
		assertEquals(null, LireFichierTxt.listeClient.get(0));

		LireFichierTxt.creerListePlats("Plats : Poutine 10 Frites 2.5 Repas_Poulet 17.00 Patate 2.00");
		LireFichierTxt.creerListeClients("Client : Alfred Gerard");
		assertEquals("Alfred", LireFichierTxt.listeClient.get(0).getNom());
	}

	@Test
	public void testCreationListePLatsVide() {
		LireFichierTxt.creerListePlats("Plats = ");
		LireFichierTxt.creerListeClients("Client : Alfred Gerard");
		assertEquals(null, LireFichierTxt.listePlats.get(0));

		LireFichierTxt.creerListePlats("Plats : Poutine 10 Frites 2.5 Repas_Poulet 17.00 Patate 2.00");
		LireFichierTxt.creerListeClients("Client : Alfred Gerard");
		assertEquals("Poutine", LireFichierTxt.listePlats.get(0).getTitrePlat());
	}

	@Test
	public void calculerFactureAvecArticleGratuit() {
		LireFichierTxt.creerListePlats("Plats : Poutine 0 Frites 2.5 Repas_Poulet 17.00 Patate 2.00");
		LireFichierTxt.creerListeClients("Client : Gilbert");
		String[] tabGratuit = { "Gilbert", "Poutine", "3", "Gilbert", "Repas_Poulet", "2", "Gilbert", "Patate", "12",
				"Gilbert", "Frites", "20" };
		LireFichierTxt.creerCommandes(tabGratuit);

		assertEquals(108.0, LireFichierTxt.montantCalculer(0), 2);

		LireFichierTxt.creerListePlats("Plats : Poutine 10 Frites 2.5 Repas_Poulet 17.00 Patate 2.00");
		LireFichierTxt.creerListeClients("Client : Gilbert");
		String[] tabArticles = { "Gilbert", "Poutine", "3", "Gilbert", "Repas_Poulet", "2", "Gilbert", "Patate", "12",
				"Gilbert", "Frites", "20" };
		LireFichierTxt.creerCommandes(tabArticles);

		assertEquals(138.0, LireFichierTxt.montantCalculer(0), 2);
	}

	@Test
	public void calculerCommandeVide() {
		LireFichierTxt.creerListePlats("Plats : Poutine 0 Frites 2.5 Repas_Poulet 17.00 Patate 2.00");
		LireFichierTxt.creerListeClients("Client : Gilbert");
		String[] tabGratuit = { "Gilbert" };
		LireFichierTxt.creerCommandes(tabGratuit);

		assertEquals(0, LireFichierTxt.montantCalculer(0), 2);
	}

	@Test
	public void testEcrireErreurPlats() throws IOException {
		String nomFichier = "TestBon.txt";

		BufferedReader reader = OutilsFichier.ouvrirFicTexteLecture(nomFichier);
		String fichier = reader.readLine();
		if (fichier.contains(LireFichierTxt.DEUX_ESPACES)) {
			LireFichierTxt.espacement = true;
		}
		int indexClients = 0;
		int indexPlats = fichier.indexOf(LireFichierTxt.ENTETE_PLAT);
		int indexCommandes = fichier.indexOf(LireFichierTxt.ENTETE_COMMANDE);

		LireFichierTxt.creerListeClients(fichier.substring(indexClients, indexPlats).trim());

		String plats = fichier.substring(indexPlats, indexCommandes).trim();

		LireFichierTxt.creerListePlats(plats);

		String commandes = fichier.substring(indexCommandes).trim();
		commandes = commandes.substring(commandes.indexOf(": ") + 2, commandes.indexOf(" Fin"));
		LireFichierTxt.creerCommandes(commandes.split(" "));

		LireFichierTxt.calculerPrixFacture();

		// ne devrait etre false

		assertFalse(LireFichierTxt.plats);

	}

	@Test
	public void testEcrireErreurClient() throws IOException {

		// TEST FALSE

		String nomFichier = "TestBon.txt";

		BufferedReader reader = OutilsFichier.ouvrirFicTexteLecture(nomFichier);
		String fichier = reader.readLine();
		if (fichier.contains(LireFichierTxt.DEUX_ESPACES)) {
			LireFichierTxt.espacement = true;
		}
		int indexClients = 0;
		int indexPlats = fichier.indexOf(LireFichierTxt.ENTETE_PLAT);
		int indexCommandes = fichier.indexOf(LireFichierTxt.ENTETE_COMMANDE);

		LireFichierTxt.creerListeClients(fichier.substring(indexClients, indexPlats).trim());

		String plats = fichier.substring(indexPlats, indexCommandes).trim();

		LireFichierTxt.creerListePlats(plats);

		String commandes = fichier.substring(indexCommandes).trim();
		commandes = commandes.substring(commandes.indexOf(": ") + 2, commandes.indexOf(" Fin"));
		LireFichierTxt.creerCommandes(commandes.split(" "));

		LireFichierTxt.calculerPrixFacture();

		// devrait etre false

		assertFalse(LireFichierTxt.client);

	}

	@Test
	public void testEcrireErreurEspacement() throws IOException {
		String nomFichier = "TestBon.txt";

		BufferedReader reader = OutilsFichier.ouvrirFicTexteLecture(nomFichier);
		String fichier = reader.readLine();
		if (fichier.contains(LireFichierTxt.DEUX_ESPACES)) {
			LireFichierTxt.espacement = true;
		}

		assertFalse(LireFichierTxt.espacement);

		String nomFichier2 = "TestErreurEspace.txt";
		Boolean espacement = false;
		BufferedReader reader2 = OutilsFichier.ouvrirFicTexteLecture(nomFichier2);
		String fichier2 = reader2.readLine();
		if (fichier2.contains(LireFichierTxt.DEUX_ESPACES)) {
			espacement = true;
		}

		assertTrue(espacement);
	}

	@Test
	public void testAucuneErreur() throws IOException {

		String nomFichier = "TestBon.txt";

		BufferedReader reader = OutilsFichier.ouvrirFicTexteLecture(nomFichier);
		String fichier = reader.readLine();
		if (fichier.contains(LireFichierTxt.DEUX_ESPACES)) {
			LireFichierTxt.espacement = true;
		}
		int indexClients = 0;
		int indexPlats = fichier.indexOf(LireFichierTxt.ENTETE_PLAT);
		int indexCommandes = fichier.indexOf(LireFichierTxt.ENTETE_COMMANDE);

		LireFichierTxt.creerListeClients(fichier.substring(indexClients, indexPlats).trim());

		String plats = fichier.substring(indexPlats, indexCommandes).trim();

		LireFichierTxt.creerListePlats(plats);

		String commandes = fichier.substring(indexCommandes).trim();
		commandes = commandes.substring(commandes.indexOf(": ") + 2, commandes.indexOf(" Fin"));
		LireFichierTxt.creerCommandes(commandes.split(" "));

		LireFichierTxt.calculerPrixFacture();

		// devrait etre false

		assertFalse(LireFichierTxt.erreur());

	}

	@Test
	public void TestTransformTabToString() {
		String table[] = { "1", "2", "3" };

		String texte = "";
		for (int i = 0; i < table.length; i++) {
			texte = texte + table[i];
		}
		assertEquals("123", texte);

	}

	@Test
	public void TestAfficherAuteur() {
		Cv.afficherAuteur();
		String tab[] = { "Programmation", "Analyse" };

		Cv sebastien = new Cv();

		sebastien.setInfo("Fortier", "Sébastien", "Technique en programation", 2, tab, "None");

		String text = sebastien.getNom() + sebastien.getPrenom() + sebastien.getFormation()
				+ sebastien.getExperienceTravailAnnee() + Cv.transformTabToString(sebastien.getCompetences())
				+ sebastien.getAttente();
		String resultatattendu = "FortierSébastienTechnique en programation2ProgrammationAnalyseNone";

		assertEquals(resultatattendu, text);

	}

	@Test
	public void testMainPrincipal() throws FileNotFoundException, IOException {
		new Main();
		new Principal();
		LireFichierTxt.lireFichierResto();
	}

	@Test
	public void testEcrire() throws IOException {
		FileWriter writer = new FileWriter(
				LireFichierTxt.FILE_NAME + LireFichierTxt.DATE_HEURE.format(new Date()) + ".txt", true);

		LireFichierTxt.ecrireErreurPlats(writer);
		LireFichierTxt.ecrireErreurClient(writer);
		LireFichierTxt.ecrireErreurEspacement(writer);
	}
}
