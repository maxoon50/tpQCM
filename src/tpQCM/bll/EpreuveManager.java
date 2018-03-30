/**
 * 
 */
package tpQCM.bll;

import tpQCM.dal.DAOFactory;
import tpQCM.dal.EpreuveDAO;

/**
 * classe en charge de faire
 * @author mleroux2017
 * @date 30 mars 2018
 * @version tpQCM v1.0
 */
public class EpreuveManager {

	private EpreuveDAO epreuveDAO;

	public EpreuveManager() {
		this.epreuveDAO = DAOFactory.getEpreuveDAO();
	}
	
	
	
}
