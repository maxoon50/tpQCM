package tpQCM.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tpQCM.bll.EpreuveManager;

/**
 * Servlet implementation class AccueilServlet
 */
@WebServlet("/candidat/accueil")
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EpreuveManager epMger = new EpreuveManager();
		epMger.inscrireCandidatEpreuve(1,1, new Date(),new Date());
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/pages/accueil.jsp");
		rd.forward(request, response);
		
	}



}
