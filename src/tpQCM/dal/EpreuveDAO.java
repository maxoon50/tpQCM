/**
 * 
 */
package tpQCM.dal;

import java.util.Date;
import java.util.List;

import tpQCM.BusinessException;
import tpQCM.bo.Epreuve;

/**
 * classe en charge de faire
 * @author mleroux2017
 * @date 30 mars 2018
 * @version tpQCM v1.0
 */
public interface EpreuveDAO {



	/**
	 * methode en charge de récupérer toutes les épreuves auxquelles est inscrit un candidat
	 * @param idCandidat
	 * @return
	 * @throws BusinessException 
	 */
	List<Epreuve> getEpreuvesByCandidatByDate(int idCandidat,Date date) throws BusinessException;
	
	
	/**
	 * methode en charge de insérer une nouvelle épreuve en base et ses questions_tirages associées
	 * @param epreuve
	 * @throws BusinessException
	 */
	public void insertEpreuve(Epreuve epreuve) throws BusinessException;


	/**
	 * methode en charge de 
	 * @param id
	 * @return
	 */
	public Epreuve getEpreuveById(String id)throws BusinessException;
}
