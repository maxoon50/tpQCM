package tpQCM.bll;

import tpQCM.BusinessException;
import tpQCM.bo.ReponseTirage;
import tpQCM.dal.DAOFactory;
import tpQCM.dal.ReponseDAO;

public class ReponseBLL {
	
	private ReponseDAO dao;
	
	public ReponseBLL() {
		dao=DAOFactory.getReponseDAO();
	}
	
	public void insertReponse(ReponseTirage reponse) throws BusinessException{
		BusinessException businessExc = new BusinessException();
		
		try {
			if(reponse.getIdProposition()==0 || reponse.getIdQuestion()==0 || reponse.getIdEpreuve()==0) {
				dao.insertReponse(reponse);
			}else {
				throw businessExc;
			}
		}catch (BusinessException e) {
			throw e;
		}
	}
}
