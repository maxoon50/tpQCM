/**
 * 
 */
package tpQCM.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import tpQCM.BusinessException;
import tpQCM.bo.Section;
import tpQCM.bo.Test;

/**
 * @author mdesfoux2017
 *
 */
public class TestDAOJdbcImpl implements TestDAO {

	
	private static final String INSERT_TEST = "INSERT INTO test (libelle, description, duree, seuil_haut, seuil_bas) values ( ?,?,?,?,?)";
	private static final String INSERT_SECTION= "INSERT INTO section_test (nbQuestionsATirer, idTest, idTheme ) values ( ?,?,?)";
	private static final String GET_TEST_BYID = "SELECT * FROM test WHERE idTest = ?";
	private static final String GET_SECTIONS_TEST = "SELECT * FROM section_test WHERE idTest = ?";
	private static final String GET_ALL="SELECT * FROM test;";
	/**
	 * Constructeur
	 */
	public TestDAOJdbcImpl() {
	}

	//////////////////add Test////////////////////////////////////////////////////////////////////////////////////////
	/* 
	 * insère un test en bdd
	 */
	@Override
	public Test insertTest(Test test) throws BusinessException {
		
		Test retval = null;
		
		if(test == null) {
			BusinessException businessExc = new BusinessException();
			businessExc.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessExc;
		}
		
		try(Connection  conn = ConnectionProvider.getConnection()){
			
			conn.setAutoCommit(false);
			PreparedStatement pst = conn.prepareStatement(INSERT_TEST , PreparedStatement.RETURN_GENERATED_KEYS);
			
			pst.setString(1, test.getLibelle());
			pst.setString(2, test.getDescription());
			pst.setInt(3, test.getDuree());
			pst.setInt(4, test.getSeuil_haut());
			pst.setInt(5, test.getSeuil_bas());
			
			pst.executeUpdate();
			ResultSet rs = pst.getGeneratedKeys();
			
			if(rs.next()) {
				for(Section s : test.getListeSections()) {
					PreparedStatement pst2 = conn.prepareStatement(INSERT_SECTION);
					pst2.setInt(1, s.getNbQuestionsATirer());
					pst2.setInt(2, rs.getInt(1));
					pst2.setInt(3, s.getIdTheme());
					pst2.executeUpdate();
				}
				retval = test;
			}
			conn.commit();
			conn.setAutoCommit(true);
			
		}catch(Exception e) {
		      e.printStackTrace();
		      BusinessException businessException = new BusinessException();
		      businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
		      throw businessException;
		}
		return retval;
	}

	
	//////////////////get test by id////////////////////////////////////////////////////////////////////////////////////////
	/* 
	 * Récupère un test par id
	 */
	@Override
	public Test getTestByID(int id) throws BusinessException {
		
		Test test = null;
		BusinessException businessExc = new BusinessException();
		
		try(Connection conn = ConnectionProvider.getConnection()){
			
			PreparedStatement pst = conn.prepareStatement(GET_TEST_BYID);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				
				test = new Test(id,rs.getString("libelle"),rs.getInt("duree"));
				System.out.println("boucle test :"+test);
				pst = conn.prepareStatement(GET_SECTIONS_TEST);
				pst.setInt(1, id);
				ResultSet rs2 = pst.executeQuery();
				
				while(rs2.next()) {
					Section section = new Section(rs2.getInt("nbQuestionsATirer"), id , rs2.getInt("idTheme"));
					test.addSection(section);
				}
				
			}else {
				businessExc.ajouterErreur(CodesResultatDAL.SELECT_OBJET_ECHEC);
				throw businessExc;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			businessExc.ajouterErreur(CodesResultatDAL.SELECT_OBJET_ECHEC);
			throw businessExc;
		}
		System.out.println("dal :"+test);
		return test;
	}

//////////////////get all tests ////////////////////////////////////////////////////////////////////////////////////////
	/* (non-Javadoc)
	 * @see tpQCM.dal.TestDAO#getAllTests()
	 */
	@Override
	public List<Test> getAllTests() throws BusinessException {
		
		List<Test> listeTests=new ArrayList<Test>();
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(GET_ALL);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next())
			{	//on crée le test
				Test test = new Test(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
						rs.getInt(5), rs.getInt(6));
				
				//il faut récupérer les sections du test pour compléter l'objet JAVA
				PreparedStatement pst = cnx.prepareStatement(GET_SECTIONS_TEST);
				pst.setInt(1, test.getIdTest());
				ResultSet rs2 = pst.executeQuery();
					while(rs2.next()) {
						// on récupère les sections et on les ajoute aux tests
						Section section = new Section(rs2.getInt("nbQuestionsATirer"), rs2.getInt("idTest"), rs2.getInt("idTheme"));
						test.addSection(section);
					}
				//on ajoue le test après lui avoir ajouté les sections
				listeTests.add(test);
			}
		}catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_OBJET_ECHEC);
			throw businessException;
		}
		
		return listeTests;
	}

}
