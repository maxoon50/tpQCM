/**
 * 
 */
package tpQCM.bll;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import tpQCM.BusinessException;
import tpQCM.bo.Epreuve;
import tpQCM.bo.Question;
import tpQCM.bo.QuestionTirage;
import tpQCM.bo.Section;
import tpQCM.bo.Test;
import tpQCM.dal.DAOFactory;
import tpQCM.dal.EpreuveDAO;
import tpQCM.dal.TestDAO;
import tpQCM.dal.TestDAOJdbcImpl;

/**
 * classe en charge de faire
 * @author mleroux2017
 * @date 30 mars 2018
 * @version tpQCM v1.0
 */
public class EpreuveManager {

	private EpreuveDAO epreuveDAO;
	
	// TODO Enlever le test DAO et créer un appel au TEST manager
	private TestDAO testDAO;

	public EpreuveManager() {
		this.epreuveDAO = DAOFactory.getEpreuveDAO();
		this.testDAO = new TestDAOJdbcImpl();
	}
	
	/**
	 * methode en charge de créer l'épreuve et le tirage de questions
	 * @param idCandidat
	 * @param idTest
	 * @param debut
	 * @param fin
	 */
	public void inscrireCandidatEpreuve(int idCandidat, int idTest, Date debut, Date fin ) {
		ReferentielManager refMger = new ReferentielManager();
		List<QuestionTirage>listeQuestionTirages = new ArrayList<QuestionTirage>();
		//on récupère le test pour récupérer les sections
		TestManager testMger = new TestManager();
		Test test;
		try {
			
			test = testMger.getTestById(idTest);
			//On initialise l'index numordre des questions ici pour qu'il ne revienne pas à 1 à chaque nouvelle section
			int index =0;
			//on récupère les sections du test et on crée une hashmap avec idthem=>questionsbytheme
			for (Section section : test.getListeSections()) {
				//liste des question du theme de la section donnée
				List<Question> listeQuestion = refMger.getQuestionsByTheme(section.getIdTheme());
				Collections.shuffle(listeQuestion);
				// on ajoute à la liste générale du test les X questions nécessaires
				listeQuestion = listeQuestion.subList(0,section.getNbQuestionsATirer());
				
				for (Question question : listeQuestion) {
					QuestionTirage questTir = new QuestionTirage(question.getIdQuestion(),index);
					index++;
					listeQuestionTirages.add(questTir);
				}
			}
			System.out.println(listeQuestionTirages);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
	
		Epreuve epreuve = new Epreuve(idCandidat,idTest,debut,fin);
		epreuve.setQuestionsTirage(listeQuestionTirages);
		try {
			this.epreuveDAO.insertEpreuve(epreuve);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	/**
	 * methode en charge de récupérer toutes les épreuves auxquelles est inscrit un candidat
	 * @param idCandidat
	 * @return
	 */
	public List<Epreuve> getEpreuveByCandidatByDate(int idCandidat, Date date){
		List<Epreuve> liste = new ArrayList<Epreuve>();
		try {
			liste =this.epreuveDAO.getEpreuvesByCandidatByDate(idCandidat,date);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return liste;
	}

	/**
	 * methode en charge de 
	 * @param parameter
	 * @return
	 */
	public Epreuve getEpreuveById(String id) {
		Epreuve  epreuve = null;
		try {
			epreuve = this.epreuveDAO.getEpreuveById(id);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return epreuve;
	}
	

}
