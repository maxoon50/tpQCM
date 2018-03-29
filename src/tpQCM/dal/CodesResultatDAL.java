package tpQCM.dal;

public class CodesResultatDAL {

	/**
	 * Echec général quand tentative d'ajouter un objet null
	 */
	public static final int INSERT_OBJET_NULL=10000;
	
	/**
	 * Echec général quand erreur non gérée à l'insertion 
	 */
	public static final int INSERT_OBJET_ECHEC=10001;
	
	
	public static final int SELECT_OBJET_ECHEC=10002;
	
	public static final int SELECT_OBJET_NULL=10003;
	
	/**** USER ***/
	public static final int SELECT_USER_ECHEC=10004;
	
	public static final int SELECT_USER_NULL=10005;
	
	public static final int DELETE_USER_ECHEC=10006;
	
	public static final int INSERT_EXIST=100007;
}

