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
	private TestDAO testDAO;

	public EpreuveManager() {
		this.epreuveDAO = DAOFactory.getEpreuveDAO();
		this.testDAO = new TestDAOJdbcImpl();
	}
	
	public void inscrireCandidatEpreuve(int idCandidat, int idTest, Date debut, Date fin ) {
		ReferentielManager refMger = new ReferentielManager();
		List<QuestionTirage>listeQuestionTirages = new ArrayList<QuestionTirage>();
		//on récupère le test pour récupérer les sections
		Test test;
		try {
			test = testDAO.getTestByID(idTest);
			//on récupère les sections du test et on crée une hashmap avec idthem=>questionsbytheme
			for (Section section : test.getListeSections()) {
				//liste des question du theme de la section donnée
				List<Question> listeQuestion = refMger.getQuestionsByTheme(section.getIdTheme());
				Collections.shuffle(listeQuestion);
				// on ajoute à la liste générale du test les X questions nécessaires
				listeQuestion = listeQuestion.subList(0,section.getNbQuestionsATirer());
				int index =0;
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
	public List<Epreuve> getEpreuveByCandidat(int idCandidat);
	
	// getEpreuvebyId pour lancer épreuve et récupérer sa liste de questionstirage
}
