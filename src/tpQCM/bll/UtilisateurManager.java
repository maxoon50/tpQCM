package tpQCM.bll;

import java.util.ArrayList;
import java.util.List;

import tpQCM.BusinessException;
import tpQCM.bo.Utilisateur;
import tpQCM.dal.CodesResultatDAL;
import tpQCM.dal.DAOFactory;
import tpQCM.dal.UserDAO;



/**
 * classe en charge de faire
 * @author mleroux2017
 * @date 27 mars 2018
 * @version tpQCM v1.0
 */
/**
 * classe en charge de faire
 * @author mleroux2017
 * @date 28 mars 2018
 * @version tpQCM v1.0
 */
public class UtilisateurManager {
	
	/*
	 * Constructeur
	 */
	private UserDAO userDAO;
	
	public UtilisateurManager() {
		this.userDAO = DAOFactory.getUSerDAO();
		
	}
	
	
	/**
	 * methode en charge d'ajouter en base un utilisateur
	 * @param user
	 * @throws BusinessException
	 */
	public void insererUtilisateur(Utilisateur user)throws BusinessException{
		BusinessException businessException = new BusinessException();
		
		this.valider(user,businessException);
		
		if(!businessException.hasErreurs()) {
			this.userDAO.insertUser(user);
		} else {
			throw businessException;
		}
	}
	
	
	
	/**
	 * methode en charge de récupérer un user par son id
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public Utilisateur getUserById(int id)throws BusinessException{
		Utilisateur user = this.userDAO.selectById(id);
		return user;
	}
	
	/**
	 * methode pour se connecter sur l'application via email et mot de passe
	 * Renvoi l'utilisateur si password correspond à celui enregistré en base pour l'email donné.
	 * @param email
	 * @param password
	 * @return utilisateur
	 * @throws BusinessException
	 */
	public Utilisateur login(String email,String password)throws BusinessException{
		BusinessException businessException = new BusinessException();
		this.validerEmailUser(email,businessException);
		Utilisateur user = null;
		if(!businessException.hasErreurs()) {
			try{
				user = this.userDAO.selectByEmail(email);
				if(!user.getPassword().equals(password)){
					businessException.ajouterErreur(CodesResultatBLL.ERREUR_LOGIN);
					throw businessException;
				}
			}catch(BusinessException be){
				be.printStackTrace();
				businessException.ajouterErreur(CodesResultatBLL.ERREUR_EMAIL_INCONNU);
				throw businessException;
			}
		}
		return user;
	}
	
	//public Utilisateur selectByEmailMotDePasse(String email,String motDePasse) throws BusinessException;
	
	/*
	 * 
	 */
	public List<Utilisateur>getPromotion(String promo) throws BusinessException{
		List<Utilisateur> liste = new ArrayList<Utilisateur>();
		if(promo!=null&&!promo.trim().equals("")) {
			liste = this.userDAO.selectByPromo(promo);
		}
		return liste;
	}
	
	
	
	/**
	 * methode en charge de modifier le mot de passe d'un user 
	 * @param id
	 * @param newMotDePasse
	 * @throws BusinessException
	 */
	public void modifierMdp(int id,String newMotDePasse)throws BusinessException{
		BusinessException businessException = new BusinessException();
		this.validerPasswordUser(newMotDePasse,businessException);
		
		if(!businessException.hasErreurs()) {
			this.userDAO.updateMdp(id, newMotDePasse);
		}else {
			throw businessException;
		}
	}
	
	/**
	 * methode en charge de mosdifier le profil d'un user
	 * ex : externer passe en stagiaire, formateur passe en responsable
	 * @param id
	 * @param newProfil
	 * @throws BusinessException
	 */
	public void modifierProfil(int id,String newProfil)throws BusinessException {
		BusinessException businessException = new BusinessException();
		this.validerPasswordUser(newProfil,businessException);
		
		if(!businessException.hasErreurs()) {
			this.userDAO.updateMdp(id, newProfil);
		}else {
			throw businessException;
		}
	};
	
	
	/**
	 * methode en charge de rechercher un user par son nom
	 * @param recherche
	 * @return
	 * @throws BusinessException
	 */
	public List<Utilisateur> rechercher(String recherche)throws BusinessException {
		BusinessException businessException = new BusinessException();
		return this.userDAO.searchByName(recherche);
	};
	
	
	/**
	 * methode en charge de récupérer la liste des responsable et formateur pour la partie admin
	 * @return
	 * @throws BusinessException
	 */
	public List<Utilisateur> getRespForm() throws BusinessException{
		return this.userDAO.getRespForm();
	};
	
	/**
	 * methode en charge de supprimer un utilisateur
	 * @param id
	 * @throws BusinessException
	 */
	public void supprimerUtilisateur(int id) throws BusinessException{
		this.userDAO.deleteUser(id);
	}
	
	
	/**
	 * methode en charge de valider les données
	 * @param user
	 * @param businessException
	 */
	private void valider(Utilisateur user, BusinessException businessException) {
		
		if(user.getNom()==null || user.getNom().trim().length()>250){
			businessException.ajouterErreur(CodesResultatBLL.REGLE_USER_NOM_ERREUR);
		}
	
		if(user.getPrenom()==null || user.getPrenom().trim().length()>250){
			businessException.ajouterErreur(CodesResultatBLL.REGLE_USER_NOM_ERREUR);
		}
		
		validerEmailUser(user.getEmail(),businessException);
		validerPasswordUser(user.getPassword(),businessException);
		validerCodeProfilUser(user.getCodeProfil(),businessException);
	}
	
	
	private void validerEmailUser(String email, BusinessException businessException) {
		if(email==null || email.trim().length()>50){
			businessException.ajouterErreur(CodesResultatBLL.REGLE_USER_EMAIL_ERREUR);
		}
	}
	
	private void validerPasswordUser(String password, BusinessException businessException) {
		if(password==null || password.trim().length()>20){
			businessException.ajouterErreur(CodesResultatBLL.REGLE_USER_PASSWORD_ERREUR);
		}
	}
	private void validerCodeProfilUser(int profil, BusinessException businessException) {
		if(profil<100 || profil>104){
			businessException.ajouterErreur(CodesResultatBLL.REGLE_USER_PROFIL_ERREUR);
		}
	}
}
