package tpQCM.bll;

import tpQCM.BusinessException;
import tpQCM.dal.DAOFactory;
import tpQCM.dal.UserDAO;

public class UtilisateurManager {
	
	
	private UserDAO userDAO;
	
	public UtilisateurManager() {
		this.userDAO = DAOFactory.getUSerDAO();
		
	}
	
	
	private void validerIdUser(int id) {
		if(id==0) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_USER_NOM_ERREUR);
		}
	}
	
	private void validerNomUser(String nom, BusinessException businessException) {
		if(nom==null || nom.trim().length()>250)
		{
			businessException.ajouterErreur(CodesResultatBLL.REGLE_USER_NOM_ERREUR);
		}
	}
	
	private void validerPrenomUser(String prenom, BusinessException businessException) {
		if(prenom==null || prenom.trim().length()>250)
		{
			businessException.ajouterErreur(CodesResultatBLL.REGLE_USER_PRENOM_ERREUR);
		}
	}
	
	private void validerEmailUser(String email, BusinessException businessException) {
		if(email==null || email.trim().length()>50)
		{
			businessException.ajouterErreur(CodesResultatBLL.REGLE_USER_EMAIL_ERREUR);
		}
	}
	
	private void validerPasswordUser(String password, BusinessException businessException) {
		if(password==null || password.trim().length()>20)
		{
			businessException.ajouterErreur(CodesResultatBLL.REGLE_USER_PASSWORD_ERREUR);
		}
	}
	private void validerCodeProfilUser(int profil, BusinessException businessException) {
		if(profil<100 || profil>104)
		{
			businessException.ajouterErreur(CodesResultatBLL.REGLE_USER_PROFIL_ERREUR);
		}
	}
}
