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
	
	public Question addQuestion(Question quest) {
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
			e.printStackTrace();
		}
		return question;
	}
	
	
	public int removeQuestion(int id) {
		int retval = 0;
		try {
			if(id != 0) {
				retval = dao.removeQuestion(id);
			}else {
				BusinessException businessExc = new BusinessException();
				// ajouter le code
				throw businessExc;
			}
			
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return retval;
	}
	
	private  void checkQuestion(Question question, BusinessException businessExc) {
		if(question.getEnonce() == null || question.getEnonce().length() < 10) {
			// ajouter le code
		}
		if(question.isUneReponse() == null) {
			// ajouter le code
		}
		if(question.getListeProp() == null) {
			// ajouter le code
		}
		if(question.getListeProp().size() < 4) {
			// ajouter le code
		}
		if(question.getPoints() == 0 || question.getPoints()<0 || question.getPoints()>10) {
			// ajouter le code
		}
		for(Proposition p : question.getListeProp()) {
			if(p.getEnonce().length() == 0) {
				// ajouter le code
			}
		}
		
	}

}
