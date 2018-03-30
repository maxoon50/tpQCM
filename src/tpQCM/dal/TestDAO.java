/**
 * 
 */
package tpQCM.dal;

import tpQCM.BusinessException;
import tpQCM.bo.Test;

/**
 * @author mdesfoux2017
 *
 */
public interface TestDAO {

	public Test insertTest(Test test) throws BusinessException;
	
	public Test getTestByID(int id) throws BusinessException;
		
}
