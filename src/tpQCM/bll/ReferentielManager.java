package tpQCM.bll;

import tpQCM.BusinessException;
import tpQCM.bo.Proposition;
import tpQCM.bo.Question;
import tpQCM.dal.ReferentielDAO;
import tpQCM.dal.ReferentielDAOJdbcImpl;

public class ReferentielManager {

	private ReferentielDAO dao ;
	
	public ReferentielManager() {
		 dao = new ReferentielDAOJdbcImpl();
	}
	
	public Question addQuestion(Question quest) throws BusinessException {
		
		Question question = null;
		BusinessException businessExc = new BusinessException();
		
		try {
			checkQuestion(quest, businessExc);
			if(!businessExc.hasErreurs())	{
				question = dao.addQuestion(quest);
			}
			
			if(businessExc.hasErreurs()){
				throw businessExc;
			}
			
		} catch (BusinessException e) {
			throw e;
		}
		return question;
	}
	
	
	public int removeQuestion(int id) throws BusinessException{
		
		BusinessException businessExc = new BusinessException();
		int retval = 0;
		
		try {
			if(id != 0) {
				retval = dao.removeQuestion(id);
			}else {		
				businessExc.ajouterErreur(CodesResultatBLL.OBJET_NULL);
				throw businessExc;
			}
			
		} catch (BusinessException e) {
			throw e;
		}
		return retval;
	}
	
	private  void checkQuestion(Question question, BusinessException businessExc) {
		
		if(question.getEnonce() == null || question.getEnonce().length() < 10) {
			businessExc.ajouterErreur(CodesResultatBLL.REGLE_REFERENTIEL_ENONCE_ERREUR);
		}
		if(question.isUneReponse() == null) {
			businessExc.ajouterErreur(CodesResultatBLL. REGLE_REFERENTIEL_UNEREPONSE_ERREUR);
		}
		if(question.getListeProp() == null) {
			businessExc.ajouterErreur(CodesResultatBLL. REGLE_REFERENTIEL_LISTPROP_ERREUR);
		}
		if(question.getListeProp().size() < 4) {
			businessExc.ajouterErreur(CodesResultatBLL.REGLE_REFERENTIEL_LISTPROP_LONG_ERREUR);
		}
		if(question.getPoints() == 0 || question.getPoints()<0 || question.getPoints()>10) {
			businessExc.ajouterErreur(CodesResultatBLL. REGLE_REFERENTIEL_POINTS_ERREUR);
		}
		for(Proposition p : question.getListeProp()) {
			if(p.getEnonce().length() == 0) {
				businessExc.ajouterErreur(CodesResultatBLL.REGLE_REFERENTIEL_PROP_LONG_ERREUR);
			}
		}
		
	}

}
