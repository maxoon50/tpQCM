package tpQCM.bo;

import java.util.List;

public class Promotion {
	
	private int codePromo;
	private String libelle;
	
	List<Utilisateur> stagiaires;
	
	
	
	
	public Promotion() {
		super();
		
	}


	/*
	 * constructeur libelle pour creation et insertion en BDD
	 */
	public Promotion(String libelle) {
		super();
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
	public Promotion(int codePromo, String libelle, List<Utilisateur> stagiaires) {
		super();
		this.codePromo = codePromo;
		this.libelle = libelle;
		this.stagiaires = stagiaires;
	}
	
}
