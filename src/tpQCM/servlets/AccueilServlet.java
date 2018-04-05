package tpQCM.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tpQCM.BusinessException;
import tpQCM.bll.EpreuveManager;
import tpQCM.bll.TestManager;
import tpQCM.bo.Epreuve;
import tpQCM.bo.Test;
import tpQCM.bo.Utilisateur;

/**
 * Servlet implementation class AccueilServlet
 */
@WebServlet("/candidat/accueil")
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EpreuveManager epMger = new EpreuveManager();
		epMger.inscrireCandidatEpreuve(2,1, new Date(),new Date());
		
		Utilisateur user = (Utilisateur) request.getSession().getAttribute("user");
		
		List<Epreuve> listeEpreuves = epMger.getEpreuveByCandidatByDate(user.getIdUtilisateur(), new Date());
		request.setAttribute("listeEpreuves",listeEpreuves);
		System.out.println("servlet :"+listeEpreuves);
		
		
		TestManager testMger = new TestManager();
		List<Test> listeTests = new ArrayList<Test>();
		for (Epreuve epreuve : listeEpreuves) {
			try {
				System.out.println(epreuve.getIdTest());
				listeTests.add(testMger.getTestById(epreuve.getIdTest()));
			} catch (BusinessException e) {
				e.printStackTrace();
			}
		}
		request.setAttribute("listeTests",listeTests);
		System.out.println("servlet :"+listeTests);
		
		
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/pages/accueil.jsp");
		rd.forward(request, response);
		
	}

	

}
