package tpQCM;

public class User {

	private int idUser;
	private String nom;
	private String motPasse;
	private String role;
	
	
	public User() {
		super();
	}

	public User(String nom, String motPasse, String role) {
		super();
		this.nom = nom;
		this.motPasse = motPasse;
		this.role = role;
	}
	
	public User(int idUser, String nom, String motPasse, String role) {
		super();
		this.idUser = idUser;
		this.nom = nom;
		this.motPasse = motPasse;
		this.role = role;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getMotPasse() {
		return motPasse;
	}
	public void setMotPasse(String motPasse) {
		this.motPasse = motPasse;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}
