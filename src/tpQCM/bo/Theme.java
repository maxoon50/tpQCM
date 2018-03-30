package tpQCM.bo;

import java.io.Serializable;

public class Theme implements Serializable {

	private int idTheme;
	private String libelle;

	public Theme() {
		super();
		
	}

	/*
	 * constructeur sans id pour insertion en BDD
	 */
	public Theme(String libelle) {
		super();
		this.libelle = libelle;
	}
	

	public Theme(int idTheme, String libelle) {
		super();
		this.idTheme = idTheme;
		this.libelle = libelle;
	}
	
	public int getIdTheme() {
		return idTheme;
	}
	public void setIdTheme(int idTheme) {
		this.idTheme = idTheme;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
}
