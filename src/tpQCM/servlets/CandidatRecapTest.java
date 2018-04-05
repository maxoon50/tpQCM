package tpQCM.servlets;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tpQCM.bo.Epreuve;
import tpQCM.bo.QuestionTirage;

/**
 * Servlet implementation class CandidatRecapTest
 */
@WebServlet("/candidat/recap-Test")
public class CandidatRecapTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Epreuve epreuve=(Epreuve) session.getAttribute("epreuve");
		int nbQuestions=epreuve.getQuestionsTirage().size();
		List<QuestionTirage> listeQuestion=epreuve.getQuestionsTirage();
		listeQuestion.sort(Comparator.comparing(QuestionTirage::getNumOrdre));
		request.setAttribute("listeQuestion", listeQuestion);
		request.setAttribute("nbQuestions", nbQuestions);


		RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/pages/candidatRecapTest.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
