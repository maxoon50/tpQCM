package tpQCM.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;

import tpQCM.BusinessException;
import tpQCM.bo.ReponseTirage;

public class ReponseDAOJdbcImpl implements ReponseDAO{
	
	private static final String INSERT_REPONSE="INSERT INTO reponse_tirage (idProposition, idQuestion, idEpreuve) values(?,?,?)";
	private static final String DELETE_REPONSE="DELETE FROM reponse_tirage WHERE idQuestion=? AND idEpreuve=?;";

	
//////////////////insertReponse////////////////////////////////////////////////////////////////////////////////////////
	
	
	@Override
	public void insertReponse(ReponseTirage reponse) throws BusinessException {
		
		if(reponse == null) {
			BusinessException businessExc = new BusinessException();
			throw businessExc;
		}
		
		try(Connection conn = ConnectionProvider.getConnection()){
			
			
			
			conn.setAutoCommit(true);
			PreparedStatement pst = conn.prepareStatement(INSERT_REPONSE);
			
			pst.setInt(1, reponse.getIdProposition());
			pst.setInt(2, reponse.getIdQuestion());
			pst.setInt(3, reponse.getIdEpreuve());
			pst.executeUpdate();			

		}catch(Exception e) {
		      e.printStackTrace();
		      BusinessException businessException = new BusinessException();
		      businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
		      throw businessException;
		}
	}
	
	//on supprime les propositions déjà existante pour cette épreuve et cette question
	public void deleteReponse(ReponseTirage reponse)throws BusinessException {
		if(reponse == null) {
			BusinessException businessExc = new BusinessException();
			throw businessExc;
		}
		
		try(Connection conn = ConnectionProvider.getConnection()){
			PreparedStatement pst = conn.prepareStatement(DELETE_REPONSE);
			
			pst.setInt(1, reponse.getIdQuestion());
			pst.setInt(2, reponse.getIdEpreuve());
			pst.executeUpdate();			

		}catch(Exception e) {
		      e.printStackTrace();
		      BusinessException businessException = new BusinessException();
		      businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
		      throw businessException;
		}
	}
	
}
