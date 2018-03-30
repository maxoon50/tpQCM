package tpQCM.bo;

import java.io.Serializable;

public class QuestionTirage implements Serializable {
	boolean estMarquee;
	int idQuestion;
	int numOrdre;
	int idEpreuve;
	
	
	public QuestionTirage() {
		super();
	}

	public QuestionTirage(boolean estMarquee, int idQuestion, int numOrdre, int idEpreuve) {
		super();
		this.estMarquee = estMarquee;
		this.idQuestion = idQuestion;
		this.numOrdre = numOrdre;
		this.idEpreuve = idEpreuve;
	}
	
	/**
	 * constucteur pour QuestionTirage.java
	 * @param idQuestion2
	 * @param index
	 */
	public QuestionTirage(int idQuestion2, int index) {
		this.estMarquee = false;
		this.idQuestion = idQuestion2;
		this.numOrdre = index;
	}
	

	public boolean isEstMarquee() {
		return estMarquee;
	}
	public void setEstMarquee(boolean estMarquee) {
		this.estMarquee = estMarquee;
	}
	public int getIdQuestion() {
		return idQuestion;
	}
	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}
	public int getNumOrdre() {
		return numOrdre;
	}
	public void setNumOrdre(int numOrdre) {
		this.numOrdre = numOrdre;
	}
	public int getIdEpreuve() {
		return idEpreuve;
	}
	public void setIdEpreuve(int idEpreuve) {
		this.idEpreuve = idEpreuve;
	}

	@Override
	public String toString() {
		return "QuestionTirage [estMarquee=" + estMarquee + ", idQuestion=" + idQuestion + ", numOrdre=" + numOrdre
				+ ", idEpreuve=" + idEpreuve + "]";
	}
	
	
}
