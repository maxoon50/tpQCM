package tpQCM.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import tpQCM.bo.Proposition;
import tpQCM.bo.Question;

public class ReferentielDAOJdbcImpl implements ReferentielDAO {


	
	private static final String ADD_QUESTION = "INSERT INTO question (enonce, points, idTheme) values ( ? , ? , ? )";
	private static final String ADD_PROPOSITION = "INSERT INTO proposition ( enonce,estBonne, idQuestion) values (  ? , ?, ? )";
	private static final String DEL_QUESTION = "DELETE FROM question WHERE question.idQuestion=?";
	private static final String DEL_PROPOSITION = "DELETE FROM proposition WHERE proposition.idQuestion=?";

	
	
	// a ajouter le business exception
	@Override
	public Question addQuestion(Question quest) {
		
		Question retval = null;
		
		try(Connection conn = ConnectionProvider.getConnection()){
			
			conn.setAutoCommit(false);
			
			PreparedStatement pst = conn.prepareStatement(ADD_QUESTION , PreparedStatement.RETURN_GENERATED_KEYS);
			
			pst.setString(1 , quest.getEnonce());
			pst.setInt(2, quest.getPoints());
			pst.setInt(3, quest.getIdTheme());
			pst.executeUpdate();
			
			ResultSet rs = pst.getGeneratedKeys();
			
			if(rs.next()) {
				for(Proposition p : quest.getListeProp()) {
					
					pst = conn.prepareStatement(ADD_PROPOSITION);
				
					pst.setString(1,p.getEnonce());
					pst.setBoolean(2, p.isEstBonne());
					pst.setInt(3, p.getIdQuestion());
					pst.executeUpdate();
					
				}
			}
			
			conn.commit();
			conn.setAutoCommit(true);
			retval = quest;
		}catch(Exception e) {
			System.out.println(e);
		}
			return retval;
	}



	@Override
	public int removeQuestion(int id) {
		int result = 0;
		try(Connection conn = ConnectionProvider.getConnection()){
			
			conn.setAutoCommit(false);
			
			PreparedStatement pst = conn.prepareStatement(DEL_QUESTION);
			pst.setInt(1 ,id);
			result += pst.executeUpdate();
			
			pst = conn.prepareStatement(DEL_PROPOSITION);
			pst.setInt(1, id);
			result += pst.executeUpdate();
			
			conn.commit();
			conn.setAutoCommit(true);
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return result;
	}
	
	
	

}
