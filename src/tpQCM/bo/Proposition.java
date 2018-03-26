package tpQCM.bo;

public class Proposition {
	int idProposition;
	String enonce;
	boolean estBonne;
	int idQuestion;
	
	public Proposition() {
		super();
	}

	public Proposition(int idProposition, String enonce, boolean estBonne, int idQuestion) {
		super();
		this.idProposition = idProposition;
		this.enonce = enonce;
		this.estBonne = estBonne;
		this.idQuestion = idQuestion;
	}

	public int getIdProposition() {
		return idProposition;
	}

	public void setIdProposition(int idProposition) {
		this.idProposition = idProposition;
	}

	public String getEnonce() {
		return enonce;
	}

	public void setEnonce(String enonce) {
		this.enonce = enonce;
	}

	public boolean isEstBonne() {
		return estBonne;
	}

	public void setEstBonne(boolean estBonne) {
		this.estBonne = estBonne;
	}

	public int getIdQuestion() {
		return idQuestion;
	}

	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}

	@Override
	public String toString() {
		return "Proposition [idProposition=" + idProposition + ", enonce=" + enonce + ", estBonne=" + estBonne
				+ ", idQuestion=" + idQuestion + "]";
	}
	
	
}
