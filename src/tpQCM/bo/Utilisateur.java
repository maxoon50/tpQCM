package tpQCM.bo;

public class Utilisateur {

	private int idUtilisateur;
	private String nom;
	private String prenom;
	private String email;
	private String password;
	private int codeProfil;
	private String codePromo;//facultatif
	
	public Utilisateur() {
		super();
		
	}
	
	/*
	 * constructeur sans id pour insertion en BDD
	 */
	public Utilisateur(String nom, String prenom, String email, String password, int codeProfil, String codePromo) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.codeProfil = codeProfil;
		this.codePromo = codePromo;
	}


	public Utilisateur(int idUtilisateur, String nom, String prenom, String email, String password, int codeProfil) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.codeProfil = codeProfil;
	}
	
	public int getIdUtilisateur() {
		return idUtilisateur;
	}
	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getCodeProfil() {
		return codeProfil;
	}
	public void setCodeProfil(int codeProfil) {
		this.codeProfil = codeProfil;
	}
	public String getCodePromo() {
		return codePromo;
	}
	public void setCodePromo(String codePromo) {
		this.codePromo = codePromo;
	}
	
	
	
	
}
