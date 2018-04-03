package tpQCM.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Epreuve implements Serializable{
	
	int idEpreuve;
	Date dateDebutValidite;
	Date dateFinValidite;
	int tempsEcoule;
	String etat;
	float noteObtenue;
	String niveauObtenu;
	int idTest;
	int idUtilisateur;	
	List<QuestionTirage> questionsTirage;
	
	public Epreuve() {
		super();
	}

	public Epreuve(int idEpreuve, Date dateDebutValidite, Date dateFinValidite, int tempsEcoule, String etat,
			float noteObtenue, String niveauObtenu, int idTest, int idUtilisateur) {
		super();
		this.idEpreuve = idEpreuve;
		this.dateDebutValidite = dateDebutValidite;
		this.dateFinValidite = dateFinValidite;
		this.tempsEcoule = tempsEcoule;
		this.etat = etat;
		this.noteObtenue = noteObtenue;
		this.niveauObtenu = niveauObtenu;
		this.idTest = idTest;
		this.idUtilisateur = idUtilisateur;
		this.questionsTirage = new ArrayList<QuestionTirage>();
	}

	/**
	 * constucteur pour Epreuve.java
	 * @param idCandidat
	 * @param idTest2
	 * @param debut
	 * @param fin
	 */
	public Epreuve(int idCandidat, int idTest, Date debut, Date fin) {
		this.dateDebutValidite = debut;
		this.dateFinValidite = fin;
		this.idTest = idTest;
		this.idUtilisateur = idCandidat;
		this.questionsTirage = new ArrayList<QuestionTirage>();
	}

	public int getIdEpreuve() {
		return idEpreuve;
	}

	public void setIdEpreuve(int idEpreuve) {
		this.idEpreuve = idEpreuve;
	}

	public Date getDateDebutValidite() {
		return dateDebutValidite;
	}

	public void setDateDebutValidite(Date dateDebutValidite) {
		this.dateDebutValidite = dateDebutValidite;
	}

	public Date getDateFinValidite() {
		return dateFinValidite;
	}

	public void setDateFinValidite(Date dateFinValidite) {
		this.dateFinValidite = dateFinValidite;
	}

	public int getTempsEcoule() {
		return tempsEcoule;
	}

	public void setTempsEcoule(int tempsEcoule) {
		this.tempsEcoule = tempsEcoule;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public float getNoteObtenue() {
		return noteObtenue;
	}

	public void setNoteObtenue(float noteObtenue) {
		this.noteObtenue = noteObtenue;
	}

	public String getNiveauObtenu() {
		return niveauObtenu;
	}

	public void setNiveauObtenu(String niveauObtenu) {
		this.niveauObtenu = niveauObtenu;
	}

	public int getIdTest() {
		return idTest;
	}

	@Override
	public String toString() {
		return "Epreuve [idEpreuve=" + idEpreuve + ", dateDebutValidite=" + dateDebutValidite + ", dateFinValidite="
				+ dateFinValidite + ", tempsEcoule=" + tempsEcoule + ", etat=" + etat + ", noteObtenue=" + noteObtenue
				+ ", niveauObtenu=" + niveauObtenu + ", idTest=" + idTest + ", idUtilisateur=" + idUtilisateur
				+ ", questionsTirage=" + questionsTirage + "]";
	}

	public void setIdTest(int idTest) {
		this.idTest = idTest;
	}

	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}



	public List<QuestionTirage> getQuestionsTirage() {
		return questionsTirage;
	}
	
	public void addQuestionTirage(QuestionTirage q){
		this.questionsTirage.add(q);
	}

	public void setQuestionsTirage(List<QuestionTirage> questionsTirage) {
		this.questionsTirage = questionsTirage;
	}
	
	
}
