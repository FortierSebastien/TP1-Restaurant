
import static org.junit.Assert.*;
import org.junit.Test;

public class LireFichierTxtTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testGrosseCommande() {
		LireFichierTxt.creerListePlats("Plats : Poutine 10 Frites 2.5 Repas_Poulet 15.75 Patate 2.00");
		LireFichierTxt.creerListeClients("Gilbert");
		String[] tab = {"Gilbert","Poutine","3","Gilbert","Repas_Poulet","2"};
		LireFichierTxt.creerCommandes(tab);
		
	}
	

}
