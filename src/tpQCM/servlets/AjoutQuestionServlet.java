package tpQCM.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tpQCM.BusinessException;
import tpQCM.bll.ReferentielManager;
import tpQCM.bo.Theme;
import tpQCM.messages.LecteurMessage;


@WebServlet("/formateur/ajouter-questions")
public class AjoutQuestionServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public AjoutQuestionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/questionsAjouter.jsp");
		ReferentielManager manager = new ReferentielManager();
	
		try {
			List<Theme> listeTheme = manager.getAllThemes();
			request.setAttribute("themes", listeTheme);
		} catch (BusinessException e) {
			e.printStackTrace();
			request.setAttribute("error", "erreur lors de l'affichage de la page, merci de contacter l'administrateur");
		}
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ReferentielManager manager = new ReferentielManager();
		
		try {
			manager.addQuestion(request);
		} catch (BusinessException e) {
			e.printStackTrace();
			
			List<Integer> liste = e.getListeCodesErreur();
			ArrayList<String> listeErreurs = new ArrayList<>();
			
			for(Integer i : liste) {
				listeErreurs.add(LecteurMessage.getMessageErreur(i));
			}
			
			request.setAttribute("errors", listeErreurs);		
		}
		doGet(request, response);
	}

}
