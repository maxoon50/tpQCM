package tpQCM.dal;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import tpQCM.BusinessException;
import tpQCM.bo.Promotion;
import tpQCM.bo.Utilisateur;

/**
 * interface en charge de faire la liste des méthodes à implémenter pour les userDAO
 * @author mleroux2017
 * @date 29 mars 2018
 * @version tpQCM v1.0
 */
public interface UserDAO {

	/**
	 * methode en charge de insérer un utilisateur
	 * @param user
	 * @throws BusinessException
	 */
	public void insertUser(Utilisateur user) throws BusinessException;
		
	public Utilisateur selectById(int id)throws BusinessException;
	
	public Utilisateur selectByEmail(String email)throws BusinessException;
	
	//public Utilisateur selectByEmailMotDePasse(String email,String motDePasse) throws BusinessException;
	
	public List<Utilisateur> selectByPromo (String promo)throws BusinessException;
	
	public void updateMdp(int id,String newMotDePasse)throws BusinessException;
	
	public void updateProfil(int id,String newProfil)throws BusinessException;
	
	public List<Utilisateur> searchByName(String recherche)throws BusinessException;
	
	public List<Utilisateur> getRespForm() throws BusinessException;
	
	
	public void deleteUser(int id) throws BusinessException;

	/**
	 * methode en charge de récupérer les code Promo déja existant
	 * @return
	 * @throws BusinessException
	 */
	List<String> selectCodePromo() throws BusinessException;

	/**
	 * methode en charge de créer une nouvelle promotion
	 * @param promotion
	 * @throws BusinessException 
	 * @throws SQLIntegrityConstraintViolationException 
	 */
	public void insertPromotion(Promotion promotion) throws BusinessException;
	
	public List<Utilisateur> getExterne() throws BusinessException;
	
}
