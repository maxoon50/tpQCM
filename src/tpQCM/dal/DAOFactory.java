package tpQCM.dal;

public class DAOFactory {

public static UserDAO getUSerDAO() {
		
		return new USerDAOJdbcImpl();
		
	}
}
