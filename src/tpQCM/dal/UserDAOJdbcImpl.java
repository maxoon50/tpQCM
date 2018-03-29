package tpQCM.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import tpQCM.BusinessException;
import tpQCM.bo.Utilisateur;

public class UserDAOJdbcImpl implements UserDAO {

	private static String INSERT_USER = "INSERT INTO utilisateur(nom,prenom,email,password,codeProfil) VALUES(?,?,?,?,?)";
	private static String SELECT_ID = "SELECT * FROM utilisateur WHERE idUtilisateur=?";
	private static String SELECT_EMAIL = "SELECT * FROM utilisateur WHERE email=?";
	// private static String SELECT_EMAIL_MDP="SELECT * FROM utilisateur WHERE
	// email=? AND password=?";
	private static String SELECT_PROMO = "SELECT * FROM utilisateur WHERE codePromo=?";
	private static String SELECT_RESP_FORM = "SELECT * FROM utilisateur WHERE codeProfil=102 OR codeProfil=103";
	private static String UPDATE_MDP = "UPDATE utilisateur SET password=?WHERE idUtilisateur=?";
	private static String UPDATE_PROFIL = "UPDATE utilisateur SET codeProfil=? WHERE idUtilisateur=?";
	private static String RECHERCHE_NOM = "SELECT * FROM utilisateur WHERE nom LIKE ? ORDER BY nom ASC";
	private static String DELETE_USER="DELETE FROM utilisateur WHERE idUtilisateur=?";
	private static String SELECT_CODEPROMO="SELECT codePromo FROM promotion";
	
	@Override
	public void insertUser(Utilisateur user) throws BusinessException {

		if (user == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessException;
		}

		int nbRows;
		try (Connection cnx = ConnectionProvider.getConnection())
		// try(connection) permet de close automatiquement (pas à gérer le cnx.close()
		{
			PreparedStatement pstmt = cnx.prepareStatement(INSERT_USER, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, user.getNom());
			pstmt.setString(2, user.getPrenom());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getPassword());
			pstmt.setInt(5, user.getCodeProfil());
			nbRows = pstmt.executeUpdate();
			ResultSet rs = null;
			if (nbRows == 1) {
				rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
					user.setIdUtilisateur(rs.getInt(1));
				}
				rs.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
			throw businessException;

		}
	}

	@Override
	public Utilisateur selectById(int id) throws BusinessException {
		Utilisateur user = null;
		if (id == 0) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_OBJET_NULL);
			throw businessException;
		}

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ID);
			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				user =new Utilisateur(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6));
				
				if (rs.getString(7) != null) {
					user.setCodePromo(rs.getString(7));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_OBJET_ECHEC);
			throw businessException;
		}

		return user;
	}

	@Override
	public Utilisateur selectByEmail(String email) throws BusinessException {
		Utilisateur user = null;

		if (email == null || email.trim().equals("")) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_OBJET_NULL);
			throw businessException;
		}
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_EMAIL);
			pstmt.setString(1, email);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				user =new Utilisateur(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6));
				
				if (rs.getString(7) != null) {
					user.setCodePromo(rs.getString(7));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_OBJET_ECHEC);
			throw businessException;
		}

		return user;
	}

	/*
	 * @Override public Utilisateur selectByEmailMotDePasse(String email, String
	 * motDePasse) { // TODO Auto-generated method stub return null; }
	 */

	@Override
	public List<Utilisateur> selectByPromo(String promo) throws BusinessException {
		List<Utilisateur> promotion = new ArrayList<Utilisateur>();

		if (promo == null || promo.trim().equals("")) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_OBJET_NULL);
			throw businessException;
		}

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_PROMO);
			pstmt.setString(1, promo);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Utilisateur user = new Utilisateur(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6));
				if (rs.getString(7) != null) {
					user.setCodePromo(rs.getString(7));
				}
				promotion.add(user);
			}

		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_OBJET_ECHEC);
			throw businessException;
		}
		return promotion;
	}

	@Override
	public void updateMdp(int id, String newMotDePasse) throws BusinessException {

		if (id == 0 || newMotDePasse == null || newMotDePasse.trim().equals("")) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessException;
		}
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(UPDATE_MDP);
			pstmt.setString(1, newMotDePasse);
			pstmt.setInt(2, id);
			int nbRows = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
			throw businessException;
		}

	}

	@Override
	public void updateProfil(int id, String newProfil) throws BusinessException {

		if (id == 0 || newProfil == null || newProfil.trim().equals("")) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessException;
		}
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(UPDATE_PROFIL);
			pstmt.setString(1, newProfil);
			pstmt.setInt(2, id);
			int nbRows = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
			throw businessException;
		}

	}

	@Override
	public List<Utilisateur> searchByName(String recherche) throws BusinessException {

		if (recherche == null || recherche.trim().equals("")) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_OBJET_NULL);
			throw businessException;
		}

		List<Utilisateur> listeRecherche = new ArrayList<Utilisateur>();
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(RECHERCHE_NOM);
			pstmt.setString(1, recherche + "%");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Utilisateur user = new Utilisateur(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6));
				if (rs.getString(7) != null) {
					user.setCodePromo(rs.getString(7));
				}
				listeRecherche.add(user);
			}
		}catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_OBJET_ECHEC);
			throw businessException;
		}
		return listeRecherche;
	}

	@Override
	public List<Utilisateur> getRespForm() throws BusinessException {
		List<Utilisateur> liste = new ArrayList<Utilisateur>();
	try (Connection cnx = ConnectionProvider.getConnection()) {
		PreparedStatement pstmt = cnx.prepareStatement(SELECT_RESP_FORM);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next())
		{
			liste.add(new Utilisateur(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getInt(6)));
			//comme ce sont des responsables et des formateurs, ils n'ont pas de code Promo
		}
	}catch (Exception e) {
		e.printStackTrace();
		BusinessException businessException = new BusinessException();
		businessException.ajouterErreur(CodesResultatDAL.SELECT_OBJET_ECHEC);
		throw businessException;
	}
		return liste;
	}

	@Override
	public void deleteUser(int id) throws BusinessException {
		if (id == 0) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessException;
		}
		
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(DELETE_USER);
			pstmt.setInt(1, id);
			int nbRows = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
			throw businessException;
		}

		
	}
	
	
	@Override
	public List<String> selectCodePromo() throws BusinessException {
		List<String> codesPromo = new ArrayList<String>();

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_CODEPROMO);
		
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				
				codesPromo.add(rs.getString(1));
			}

		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_OBJET_ECHEC);
			throw businessException;
		}
		return codesPromo;
	}
}
