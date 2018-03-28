package tpQCM.bll;

import tpQCM.bo.Proposition;

public abstract class CodesResultatBLL {
	
	///////////////REGLES GENERIQUES///////////////////////////////////////////////////////////
	/**
	 *  régle pour objet passé null
	 */
	public static final int OBJET_NULL = 21000;
	
	///////////////REGLES USER///////////////////////////////////////////////////////////
	/**
	 * Echec le nom de l'article ne respecte pas les règles définies
	 */
	public static final int REGLE_USER_NOM_ERREUR=20000;
	/**
	 * Echec le nom de l'article ne respecte pas les règles définies
	 */
	public static final int REGLE_USER_PRENOM_ERREUR= 20001;
	
	public static final int REGLE_USER_EMAIL_ERREUR= 20002;
	
	public static final int REGLE_USER_PASSWORD_ERREUR= 20003;
	
	public static final int REGLE_USER_PROFIL_ERREUR= 20004;

	public static final int ERREUR_EMAIL_INCONNU=20005;
	
	public static final int ERREUR_LOGIN=20006;
	
	///////////////REGLES REFERENTIEL///////////////////////////////////////////////////////////
	
	/**
	 * Echec longueur énoncé <10
	 */
	public static final int REGLE_REFERENTIEL_ENONCE_ERREUR=20100;
	
	/**
	 * Echec il y a moins de 4 propositions à la question
	 */
	public static final int REGLE_REFERENTIEL_LISTPROP_LONG_ERREUR=20101;
	

	/**
	 * Echec le point est inf à 0 ou sup à 10 ou null
	 */
	public static final int REGLE_REFERENTIEL_POINTS_ERREUR=20102;

	/**
	 * Echec l'élément uneReponse est  null
	 */
	public static final int REGLE_REFERENTIEL_UNEREPONSE_ERREUR=20103;
	
	/**
	 * Echec la liste des propositions  est  null
	 */
	public static final int REGLE_REFERENTIEL_LISTPROP_ERREUR=20104;
	
	/**
	 * Echec la proposition est nulle ou vide
	 */
	public static final int REGLE_REFERENTIEL_PROP_LONG_ERREUR=20105;
	


}