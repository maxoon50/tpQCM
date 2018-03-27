package tpQCM.dal;

import java.util.List;

import tpQCM.BusinessException;
import tpQCM.bo.Utilisateur;

public interface UserDAO {

	public void insertUser(Utilisateur user) throws BusinessException;
		
	public Utilisateur selectById(int id)throws BusinessException;
	
	public Utilisateur selectByEmail(String email)throws BusinessException;
	
	//public Utilisateur selectByEmailMotDePasse(String email,String motDePasse) throws BusinessException;
	
	public List<Utilisateur> selectByPromo (String promo)throws BusinessException;
	
	public void updateMdp(int id,String newMotDePasse)throws BusinessException;
	
	public void updateProfil(int id,String newProfil)throws BusinessException;
	
	public Utilisateur searchByName(String recherche)throws BusinessException;
	
}
