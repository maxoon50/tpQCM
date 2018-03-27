package tpQCM.bll;

import tpQCM.BusinessException;
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
		try {
			question = dao.addQuestion(quest);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return question;
	}
	
	
	public int removeQuestion(int id) {
		int retval = 0;
		try {
			retval = dao.removeQuestion(id);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return retval;
	}

}
