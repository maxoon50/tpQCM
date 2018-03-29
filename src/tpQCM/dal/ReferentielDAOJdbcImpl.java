package tpQCM.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tpQCM.BusinessException;
import tpQCM.bo.Proposition;
import tpQCM.bo.Question;
import tpQCM.bo.Theme;

public class ReferentielDAOJdbcImpl implements ReferentielDAO {


	private static final String ADD_QUESTION = "INSERT INTO question (enonce, points, idTheme) values ( ? , ? , ? )";
	private static final String ADD_PROPOSITION = "INSERT INTO proposition ( enonce,estBonne, idQuestion) values (  ? , ?, ? )";
	private static final String DEL_QUESTION = "DELETE FROM question WHERE question.idQuestion=?";
	private static final String DEL_PROPOSITION = "DELETE FROM proposition WHERE proposition.idQuestion=?";
	private static final String GET_QUESTIONS_AND_RESPONSE_BY_THEMEID = "SELECT * FROM question WHERE idTheme = ?";
	private static final String GET_PROPOSITIONS_BY_QUESTIONSID = "SELECT * FROM proposition WHERE idQuestion=?";
	private static final String ADD_THEME= "INSERT INTO theme(libelle) values ( ? )";
	private static final String GET_ALL_THEMES= "SELECT * FROM theme";
	private static final String GET_THEME_BY_ID="SELECT libelle FROM THEME WHERE idTheme=?";

//////////////////addQuestion////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public Question addQuestion(Question quest) throws BusinessException {
		
		if(quest == null) {
			BusinessException businessExc = new BusinessException();
			businessExc.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessExc;
		}
		
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
					pst.setInt(3, rs.getInt(1));
					pst.executeUpdate();			
				}
			}
			
			conn.commit();
			conn.setAutoCommit(true);
			retval = quest;
		}catch(Exception e) {
		      e.printStackTrace();
		      BusinessException businessException = new BusinessException();
		      businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
		      throw businessException;
		}
			return retval;
	}


//////////////////removeQuestion////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public int removeQuestion(int id) throws BusinessException {
		
		if(id == 0) {
			BusinessException businessExc = new BusinessException();
			businessExc.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessExc;
		}
		
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
		      e.printStackTrace();
		      BusinessException businessException = new BusinessException();
		      businessException.ajouterErreur(CodesResultatDAL.DELETE_USER_ECHEC);
		      throw businessException;
		}
		return result;
	}


////////////////// addTheme////////////////////////////////////////////////////////////////////////////////////////
	/* 
	 *  ajoute un thème
	 */
	@Override
	public void addTheme(String str) throws BusinessException {
		
		BusinessException businessExc = new BusinessException();
		
		if(str == null || str.length() == 0) {
			businessExc.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessExc;
		}
		
		try(Connection conn = ConnectionProvider.getConnection()){			
			
			PreparedStatement pst = conn.prepareStatement(ADD_THEME);
			pst.setString(1, str);
			pst.executeUpdate();
			
		}catch(Exception e) {
			
			e.printStackTrace();
			businessExc.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
			throw businessExc;
			
		}	
	}
	
//////////////////get all Themes////////////////////////////////////////////////////////////////////////////////////////
	
	/*
	 * récupère tous les thèmes
	 */
	@Override
	public List<Theme> getAllThemes() throws BusinessException {
		List<Theme> listeTheme = new ArrayList<Theme>();
		
		try(Connection conn = ConnectionProvider.getConnection()){
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(GET_ALL_THEMES);
			while(rs.next()) {
				listeTheme.add(new Theme(rs.getInt("idTheme"),rs.getString("libelle")));
			}
		}catch(Exception e) {
			BusinessException businessExc = new BusinessException();
			businessExc.ajouterErreur(CodesResultatDAL.SELECT_OBJET_ECHEC);
			throw businessExc;
		}
		return listeTheme;
	}
	
//////////////////addQuestion////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public List<Question> getQuestionsByTheme(int idTheme) throws BusinessException {
		
		List<Question> listeQuestion = new ArrayList<Question>();
		BusinessException businessExc = new BusinessException();
		
		try(Connection conn = ConnectionProvider.getConnection()){
			PreparedStatement pst = conn.prepareStatement(GET_QUESTIONS_AND_RESPONSE_BY_THEMEID);
			pst.setInt(1, idTheme);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()){
				Question q = new Question(
						rs.getInt("idQuestion"),
						rs.getString("enonce"),
						rs.getInt("points"),
						rs.getInt("idTheme"));
						/*rs.getBoolean("uneReponse"));*/
				
				pst = conn.prepareStatement(GET_PROPOSITIONS_BY_QUESTIONSID);
				pst.setInt(1, rs.getInt("idQuestion"));
				ResultSet rs2 = pst.executeQuery();
				
				while(rs2.next()) {
					q.addProposition(new Proposition(
							rs2.getInt("idProposition"),
							rs2.getString("enonce"),
							rs2.getBoolean("estBonne"),
							rs.getInt("idQuestion")));
				}
				
				listeQuestion.add(q);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			businessExc.ajouterErreur(CodesResultatDAL.SELECT_OBJET_ECHEC);
			throw businessExc;
		}
		
		return listeQuestion;
	}

//////////////////GET_THEME_BY_ID////////////////////////////////////////////////////////////////////////////////////////	

	@Override
	public Theme getThemeById(int idTheme)throws BusinessException{
		Theme t = null;
		BusinessException businessExc = new BusinessException();
		
		try(Connection con= ConnectionProvider.getConnection()){
			PreparedStatement pst= con.prepareStatement(GET_THEME_BY_ID);
			pst.setInt(1, idTheme);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				t = new Theme(
						rs.getString("libelle"));						
			}
		}catch(Exception e) {
			e.printStackTrace();
			businessExc.ajouterErreur(CodesResultatDAL.SELECT_OBJET_ECHEC);
			throw businessExc;
		}
		return t;
	}



}
