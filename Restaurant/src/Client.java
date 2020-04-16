
public class Client {

	public String nom;
	public String[][] commande = new String[100][2];
	int i = 0;
	
	public Client(String nom) {
		setNom(nom);
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String[][] getCommande() {
		return commande;
	}
	public void setCommande(String[] commande) {
		
		this.commande[i] = commande;
		
		i+=1;
	}
	
}
