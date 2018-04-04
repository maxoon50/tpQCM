package tpQCM.dal;

import tpQCM.BusinessException;
import tpQCM.bo.ReponseTirage;

public interface ReponseDAO {
	
	public void insertReponse(ReponseTirage reponse)throws BusinessException;
	public void deleteReponse(ReponseTirage reponse)throws BusinessException;
}
