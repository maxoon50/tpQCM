package tpQCM.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Test implements Serializable {

	private int idTest;
	private String libelle;
	private String description;
	private int duree; //duree max de pour ce test
	private int seuil_haut;
	private int seuil_bas;
	private List<Section> listeSections ;
	

	public Test() {
		super();
		this.seuil_haut = 12;
		this.seuil_bas = 8;
		this.description = "test";
		this.listeSections = new ArrayList<Section>();
	}

	/*
	 * constructeur sans id pour insertion en base
	 */
	public Test(String libelle,int duree) {
		this();
		this.libelle = libelle;
		this.duree =dureeEnSecondes(duree);
	}


	public Test(int idTest, String libelle, int duree) {
		this();
		this.idTest = idTest;
		this.libelle = libelle;
		this.duree = dureeEnSecondes(duree);
	}

	/**
	 * Méthode en charge de  transformer les heures en secondes
	 * @param duree2
	 * @return
	 */
	private int dureeEnSecondes(int duree2) {
		return duree2*60*60;
	}
	
	public int getIdTest() {
		return idTest;
	}

	public void setIdTest(int idTest) {
		this.idTest = idTest;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public int getSeuil_haut() {
		return seuil_haut;
	}

	public void setSeuil_haut(int seuil_haut) {
		this.seuil_haut = seuil_haut;
	}

	public int getSeuil_bas() {
		return seuil_bas;
	}

	public void setSeuil_bas(int seuil_bas) {
		this.seuil_bas = seuil_bas;
	}

	public List<Section> getListeSections() {
		return listeSections;
	}

	public void setListeSections(List<Section> listeSections) {
		this.listeSections = listeSections;
	}
	
	public void addSection(Section section) {
		this.listeSections.add(section);
	}

	@Override
	public String toString() {
		return "Test [idTest=" + idTest + ", libelle=" + libelle + ", description=" + description + ", duree=" + duree
				+ ", seuil_haut=" + seuil_haut + ", seuil_bas=" + seuil_bas + ", listeSections=" + listeSections + "]";
	}
	
	
	
}
