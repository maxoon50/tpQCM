package tpQCM.bll;

import tpQCM.BusinessException;
import tpQCM.bo.Test;
import tpQCM.dal.DAOFactory;
import tpQCM.dal.TestDAO;

public class TestManager {
	
	private TestDAO dao;
	
	public TestManager() {
		dao =DAOFactory.getTestDAO();
	}
	
	public void insertTest(Test test) throws BusinessException{
		BusinessException businessExc = new BusinessException();
		
		try {
			if(!test.getLibelle().equals(null)) {
				dao.insertTest(test);
				
			}else {
				throw businessExc;
				
			}
		}catch (BusinessException e) {
			throw e;
		}
	}
	
	public Test getTestById(int id) throws BusinessException{
		BusinessException businessExc = new BusinessException();
		Test test=null;
		try {
			if(id != 0 ) {
				test=dao.getTestByID(id);
				System.out.println("bll: "+test);
			}else {
				throw businessExc;
			}
		}catch (BusinessException e) {
			throw e;
		}
		return test;
	}
}
