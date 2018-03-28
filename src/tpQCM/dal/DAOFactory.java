package tpQCM.dal;

public class DAOFactory {

public static UserDAO getUSerDAO() {
		
		return new UserDAOJdbcImpl();
		
	}

public static ReferentielDAO getReferentielDAO() {
	
	return new ReferentielDAOJdbcImpl();
	
}
}
