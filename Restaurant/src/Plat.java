
public class Plat {
	
	public String titrePlat;
	public String prixPlat;
	
	public Plat(String titrePlat, String prixPlat) {
		setPrixPlat(prixPlat);
		setTitrePlat(titrePlat);
	}
	public Plat(String titrePlat) {
		setTitrePlat(titrePlat);
	}

	public String getTitrePlat() {
		return titrePlat;
	}

	public void setTitrePlat(String titrePlat) {
		this.titrePlat = titrePlat;
	}

	public String getPrixPlat() {
		return prixPlat;
	}

	public void setPrixPlat(String prixPlat) {
		this.prixPlat = prixPlat;
	}

	
}
