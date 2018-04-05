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
import tpQCM.bll.ReponseBLL;
import tpQCM.bo.Epreuve;
import tpQCM.bo.Proposition;
import tpQCM.bo.Question;
import tpQCM.bo.ReponseTirage;


@WebServlet("/candidat/question")
public class QuestionServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
   
    public QuestionServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("numQuestion", request.getParameter("id"));
		Epreuve epreuve =  (Epreuve) request.getSession().getAttribute("epreuve");
		List<Proposition> listeProp = epreuve.getQuestionsTirage().get(Integer.parseInt(request.getParameter("id"))).getQuestion().getListeProp();
		Question question = epreuve.getQuestionsTirage().get(Integer.parseInt(request.getParameter("id"))).getQuestion();
		
		request.setAttribute("question",question);
		request.setAttribute("propositions",listeProp);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/question.jsp");
		rd.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ReponseBLL reponseManager = new ReponseBLL();
		String nextQuestion = request.getParameter("question");
		String idQuestion  =  request.getParameter("idQuestion");
		String lastQuestion = request.getParameter("lastQuestion");

		int idEpreuve = ((Epreuve) request.getSession().getAttribute("epreuve")).getIdEpreuve();
		ReponseTirage reponseTirage = null;
		List<ReponseTirage> listePropositionSelectionnees = new ArrayList<ReponseTirage>();
		
		System.out.println("lastQuestion:"+lastQuestion);
		System.out.println("question:" + idQuestion);
		System.out.println("proposition-radio"+request.getParameter("proposition-radio"));
		System.out.println("proposition-0  "+request.getParameter("proposition-0"));
		System.out.println("proposition-1  "+request.getParameter("proposition-1"));
		System.out.println("proposition-2  "+request.getParameter("proposition-2"));
		System.out.println("proposition-3  "+request.getParameter("proposition-3"));
		
		String propositionRadio= request.getParameter("proposition-radio");

		String proposition0 = request.getParameter("proposition-0");
		String proposition1 = request.getParameter("proposition-1");
		String proposition2 = request.getParameter("proposition-2");
		String proposition3 = request.getParameter("proposition-3");

		if(propositionRadio != null) {
			 listePropositionSelectionnees.add(new ReponseTirage(Integer.parseInt(propositionRadio), Integer.parseInt(idQuestion), idEpreuve));
		}else {
			if(proposition0 != null) {
				 listePropositionSelectionnees.add(new ReponseTirage(Integer.parseInt(proposition0), Integer.parseInt(idQuestion), idEpreuve));
			}
			if(proposition1 != null) {
				 listePropositionSelectionnees.add(new ReponseTirage(Integer.parseInt(proposition1), Integer.parseInt(idQuestion), idEpreuve));
			}
			if(proposition2 != null) {
				 listePropositionSelectionnees.add(new ReponseTirage(Integer.parseInt(proposition2), Integer.parseInt(idQuestion), idEpreuve));
			}
			if(proposition3 != null) {
				 listePropositionSelectionnees.add(new ReponseTirage(Integer.parseInt(proposition3), Integer.parseInt(idQuestion), idEpreuve));
			}	
		}
		
		try {
			reponseManager.deleteReponse(new ReponseTirage(idEpreuve,Integer.parseInt(idQuestion)));
		} catch (BusinessException e1) {
			e1.printStackTrace();
		}
		
		for(ReponseTirage r : listePropositionSelectionnees) {
			try {
				System.out.println(r);
				reponseManager.insertReponse(r);
			} catch (BusinessException e) {
				e.printStackTrace();
			}
			
		}
		if(lastQuestion != null && lastQuestion.equals("true")) {
			response.sendRedirect(request.getContextPath()+"/candidat/recap-Test");

		}else {
			response.sendRedirect(request.getContextPath()+"/candidat/question?id="+nextQuestion);

		}

	}

}
