package tpQCM.dal;

import tpQCM.bo.Question;

public interface ReferentielDAO {

	public Question addQuestion(Question q);
	
	public int removeQuestion(int id);
	
}
