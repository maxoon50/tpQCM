package tpQCM.dal;

import java.util.List;

import tpQCM.BusinessException;
import tpQCM.bo.Question;
import tpQCM.bo.Theme;

public interface ReferentielDAO {
	
	public List<Question> getQuestionsByTheme(int idTheme) throws BusinessException;

	public Question addQuestion(Question q) throws BusinessException;
	
	public int removeQuestion(int id) throws BusinessException;
	
	public void addTheme(String str)throws BusinessException;
	
	public List<Theme> getAllThemes() throws BusinessException;

	Theme getThemeById(int idTheme) throws BusinessException;
	
}
