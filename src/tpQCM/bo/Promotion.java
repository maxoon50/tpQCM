package tpQCM.bo;

import java.io.Serializable;
import java.util.List;

public class Promotion implements Serializable {
	
	private String codePromo;
	private String libelle;
	
	List<Utilisateur> stagiaires;
	
	
	
	
	public Promotion() {
		super();
		
	}


	/*
	 * constructeur libelle pour creation et insertion en BDD
	 */
	public Promotion(String codePromo, String libelle) {
		this.codePromo = codePromo;
		this.libelle = libelle;
	}

	
	/*
	 * constructeur sans id mais avec stagiaires /BDD
	 */
	public Promotion(String libelle, List<Utilisateur> stagiaires) {
		super();
		this.libelle = libelle;
		this.stagiaires = stagiaires;
	}


	/*
	 * constructeur total
	 */
	public Promotion(String codePromo, String libelle, List<Utilisateur> stagiaires) {
		super();
		this.codePromo = codePromo;
		this.libelle = libelle;
		this.stagiaires = stagiaires;
	}


	public String getCodePromo() {
		return codePromo;
	}


	public void setCodePromo(String codePromo) {
		this.codePromo = codePromo;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	public List<Utilisateur> getStagiaires() {
		return stagiaires;
	}


	public void setStagiaires(List<Utilisateur> stagiaires) {
		this.stagiaires = stagiaires;
	}
	
	
	
	
}
