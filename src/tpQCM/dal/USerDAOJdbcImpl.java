package tpQCM.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import tpQCM.BusinessException;
import tpQCM.bo.Utilisateur;

public class USerDAOJdbcImpl implements UserDAO {
	
	
	private static String INSERT_USER="INSERT INTO utilisateur(nom,prenom,email,password,codeProfil) VALUES(?,?,?,?,?)";
	private static String SELECT_ID="SELECT * FROM utilisateur WHERE id=?";
	private static String SELECT_EMAIL="SELECT * FROM utilisateur WHERE email=?";
	private static String SELECT_EMAIL_MDP="SELECT * FROM utilisateur WHERE email=? AND password=?";
	private static String SELECT_PROMO="SELECT * FROM utilisateur WHERE codePromo=?";
	private static String UPDATE_MDP="UDPATE Utilisateur SET paswword = ? WHERE id=?";
	private static String UDPATE_PROFIL="UPDATE Utilisateur SET codeProfil = ? WHERE id=?";
	
	
	
	

	@Override
	public void insertUser(Utilisateur user) throws BusinessException {
		
		if(user==null)
		{
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessException;
		}
		
		int nbRows;
		try(Connection cnx = ConnectionProvider.getConnection())// try(connection) permet de close automatiquement (pas à gérer le cnx.close()
		{
			PreparedStatement pstmt = cnx.prepareStatement(INSERT_USER,PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1,user.getNom());
			pstmt.setString(2, user.getPrenom());
			pstmt.setString(3,user.getEmail());
			pstmt.setString(4, user.getPassword());
			pstmt.setInt(5, user.getCodeProfil());
			nbRows = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
			throw businessException;
			
		}
	}

	@Override
	public Utilisateur selectById(int id) {
		Utilisateur user = null;
		return user;
	}

	@Override
	public Utilisateur selectByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public Utilisateur selectByEmailMotDePasse(String email, String motDePasse) {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public List<Utilisateur> selectByPromo(String promo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateMdp(int id, String newMotDePasse) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateProfil(int id, String newProfil) {
		// TODO Auto-generated method stub

	}

	@Override
	public Utilisateur searchByName(String recherche) {
		// TODO Auto-generated method stub
		return null;
	}

}
