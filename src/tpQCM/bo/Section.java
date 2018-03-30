package tpQCM.bo;

public class Section {

	private int nbQuestionsATirer;
	private int idTest;
	private int idTheme;
	private String theme;
	
	public Section() {
		super();
		
	}
	
	public Section(int nbQuestionsATirer, int idTheme, String theme) {
		super();
		this.nbQuestionsATirer = nbQuestionsATirer;
		this.idTheme = idTheme;
		this.theme=theme;
	}

	public Section(int nbQuestionsATirer, int idTest, int idTheme) {
		super();
		this.nbQuestionsATirer = nbQuestionsATirer;
		this.idTest = idTest;
		this.idTheme = idTheme;
	}

	public int getNbQuestionsATirer() {
		return nbQuestionsATirer;
	}

	public void setNbQuestionsATirer(int nbQuestionsATirer) {
		this.nbQuestionsATirer = nbQuestionsATirer;
	}

	public int getIdTest() {
		return idTest;
	}

	public void setIdTest(int idTest) {
		this.idTest = idTest;
	}

	public int getIdTheme() {
		return idTheme;
	}

	public void setIdTheme(int idTheme) {
		this.idTheme = idTheme;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	@Override
	public String toString() {
		return "Section [nbQuestionsATirer=" + nbQuestionsATirer + ", idTest=" + idTest + ", idTheme=" + idTheme
				+ ", theme=" + theme + "]";
	}
	
	
	
	
	
	
}
