package tpQCM.dal;

import tpQCM.BusinessException;
import tpQCM.bo.Question;

public interface ReferentielDAO {

	public Question addQuestion(Question q) throws BusinessException;
	
	public int removeQuestion(int id) throws BusinessException;
	
	public void addTheme(String str)throws BusinessException;
	
}
