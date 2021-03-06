/**
 * 
 */
package tpQCM.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import tpQCM.BusinessException;
import tpQCM.bo.Epreuve;
import tpQCM.bo.Question;
import tpQCM.bo.QuestionTirage;

/**
 * classe en charge de faire
 * @author mleroux2017
 * @date 30 mars 2018
 * @version tpQCM v1.0
 */
public class EpreuveDAOJdbcImpl implements EpreuveDAO {

	
	private static String SELECT_ALL_EPV_CDT="SELECT * FROM epreuve WHERE idUtilisateur = ? AND dateDedutValidite<=? AND dateFinValidite>=?;";
	private static String INSERT_EPREUVE="INSERT INTO epreuve(dateDedutValidite,dateFinValidite,idTest,idUtilisateur)VALUES(?,?,?,?);";
	private static String INSERT_QUESTION_TIRAGE="INSERT INTO question_tirage(estMarquee,idQuestion,numordre,idEpreuve) VALUES(?,?,?,?)";
	private static String GET_EPREUVE_ID="SELECT * FROM epreuve WHERE idEpreuve = ?;";
	private static  String GET_QUESTION_TIRAGE_BY_EPREUVE = "SELECT * FROM question_tirage WHERE idEpreuve = ?";
	
	@Override
	public List<Epreuve> getEpreuvesByCandidatByDate(int idCandidat, Date date) throws BusinessException {
		
		List<Epreuve> listeEpreuves = new ArrayList<Epreuve>();
		
		ResultSet rs = null;
		
		if (idCandidat == 0) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_OBJET_NULL);
			throw businessException;
		}

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL_EPV_CDT);
			pstmt.setInt(1, idCandidat);
			pstmt.setDate(2,new java.sql.Date(date.getTime()));
			pstmt.setDate(3,new java.sql.Date(date.getTime()));
			rs= pstmt.executeQuery();
			
			while (rs.next()){
				Epreuve epreuve = new Epreuve(rs.getInt(1),
						rs.getDate(2), rs.getDate(3), rs.getInt(4), 
						rs.getString(5),rs.getInt(6),rs.getString(7), rs.getInt(8),rs.getInt(9));
				listeEpreuves.add(epreuve);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_OBJET_ECHEC);
			throw businessException;
		}
		
		return listeEpreuves;
	}
	
	
	public void insertEpreuve(Epreuve epreuve) throws BusinessException {
	
		if (epreuve == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessException;
		}
		
		try (Connection cnx = ConnectionProvider.getConnection()) {
			
			try {
				if (epreuve.getIdEpreuve() == 0) {
					
					
					PreparedStatement pstmt = cnx.prepareStatement(INSERT_EPREUVE,PreparedStatement.RETURN_GENERATED_KEYS);
					pstmt.setDate(1, new java.sql.Date(epreuve.getDateDebutValidite().getTime()));
					pstmt.setDate(2, new java.sql.Date(epreuve.getDateFinValidite().getTime()));
					pstmt.setInt(3,epreuve.getIdTest());
					pstmt.setInt(4,epreuve.getIdUtilisateur());
					
					int nbRows = pstmt.executeUpdate();
					ResultSet rs = null;
					
					if (nbRows == 1) {
						rs = pstmt.getGeneratedKeys();
						if (rs.next()) {
							epreuve.setIdEpreuve(rs.getInt(1));
						}
						rs.close();
						pstmt.close();
					}
				}
				if(epreuve.getQuestionsTirage().size()>0)
				{
					PreparedStatement pstmt2 = cnx.prepareStatement(INSERT_QUESTION_TIRAGE,PreparedStatement.RETURN_GENERATED_KEYS);
					for (QuestionTirage questionTirage : epreuve.getQuestionsTirage()) {
						pstmt2.setBoolean(1, questionTirage.isEstMarquee());
						pstmt2.setInt(2,questionTirage.getIdQuestion());
						pstmt2.setInt(3,questionTirage.getNumOrdre());
						pstmt2.setInt(4,epreuve.getIdEpreuve());
						pstmt2.executeUpdate();
					}
						pstmt2.close();
				}
				
			}catch(Exception e)	{
					e.printStackTrace();
					throw e;
			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
			throw businessException;	
		}
	}


	/* (non-Javadoc)
	 * @see tpQCM.dal.EpreuveDAO#getEpreuveById(java.lang.String)
	 */
	@Override
	public Epreuve getEpreuveById(String id) throws BusinessException {
		
		Epreuve epreuve = null;
		ReferentielDAOJdbcImpl daoreferentiel = new ReferentielDAOJdbcImpl();
		
		try (Connection cnx = ConnectionProvider.getConnection()) {
			
			PreparedStatement pstmt = cnx.prepareStatement(GET_EPREUVE_ID);
			pstmt.setInt(1, Integer.parseInt(id));
			ResultSet rs= pstmt.executeQuery();
			
			if(rs.next()){
				epreuve = new Epreuve(rs.getInt(1),
						rs.getDate(2), rs.getDate(3), rs.getInt(4), 
						rs.getString(5),rs.getInt(6),rs.getString(7), rs.getInt(8),rs.getInt(9));
				
				PreparedStatement pst2 = cnx.prepareStatement(GET_QUESTION_TIRAGE_BY_EPREUVE);
				pst2.setInt(1,  Integer.parseInt(id));
				ResultSet rs2 = pst2.executeQuery();
				
				while(rs2.next()) {
					
					QuestionTirage questionTirage = new QuestionTirage(
							rs2.getBoolean("estMarquee"),
							rs2.getInt("idQuestion"),
							rs2.getInt("numOrdre"),
							Integer.parseInt(id)); 
					
					Question question = daoreferentiel.getQuestionById(questionTirage.getIdQuestion());
					questionTirage.setQuestion(question);
					epreuve.addQuestionTirage(questionTirage);
				}
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_OBJET_ECHEC);
			throw businessException;
		}
			
		return epreuve;
	}
}
