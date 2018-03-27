package tpQCM.bo;

import java.util.List;

public class Question {
	
	private int idQuestion;
	private String enonce;
	private String media;
	private int points;
	private int idTheme;
	private List<Proposition> listeProp;

	
	public Question() {
		super();
	}

	public Question(int idQuestion, String enonce, String media, int points, int idTheme) {
		super();
		this.idQuestion = idQuestion;
		this.enonce = enonce;
		this.media = media;
		this.points = points;
		this.idTheme = idTheme;
	}

	public int getIdQuestion() {
		return idQuestion;
	}

	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}

	public String getEnonce() {
		return enonce;
	}

	public void setEnonce(String enonce) {
		this.enonce = enonce;
	}

	public String getMedia() {
		return media;
	}

	public void setMedia(String media) {
		this.media = media;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getIdTheme() {
		return idTheme;
	}

	public void setIdTheme(int idTheme) {
		this.idTheme = idTheme;
	}

	public List<Proposition> getListeProp() {
		return listeProp;
	}

	public void setListeProp(List<Proposition> listeProp) {
		this.listeProp = listeProp;
	}

	@Override
	public String toString() {
		return "Question [idQuestion=" + idQuestion + ", enonce=" + enonce + ", media=" + media + ", points=" + points
				+ ", idTheme=" + idTheme + "]";
	}
	
	
	
}
