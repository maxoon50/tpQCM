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
import tpQCM.bo.Question;
import tpQCM.bo.Theme;

/**
 * Servlet implementation class AccueilFormateurServlet
 */
@WebServlet("/formateur/accueil-formateur")
public class AccueilFormateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//instanciation du manager
		ReferentielManager rm= new ReferentielManager();
		
		//instanciation d'une liste pour charger les thèmes 
		List<Theme> listeTheme=new ArrayList<Theme>();
		try {
			listeTheme=rm.getAllThemes();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		request.setAttribute("theme", listeTheme);
		
		RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/pages/accueilFormateur.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//instanciation du manager
		ReferentielManager rm= new ReferentielManager();
				
		//instanciation d'une liste pour charger les thèmes 
		List<Theme> listeTheme=new ArrayList<Theme>();
		try {
			listeTheme=rm.getAllThemes();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		request.setAttribute("theme", listeTheme);
		
		
		//Récupération de l'idTheme selectionnée par l'utilisateur
		String theme;
		int idTheme;
		theme=request.getParameter("theme");
		idTheme=Integer.parseInt(theme);
		
		//Récupération d'une liste de question en fonction du thème
		List<Question>listeQuestion=new ArrayList<Question>();
		try {
			listeQuestion=rm.getQuestionsByTheme(idTheme);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		request.setAttribute("questions", listeQuestion);
		
		
		RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/pages/accueilFormateur.jsp");
		rd.forward(request, response);
	}

}
