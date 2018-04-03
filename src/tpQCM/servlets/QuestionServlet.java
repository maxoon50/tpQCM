package tpQCM.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tpQCM.bo.Epreuve;


@WebServlet("/candidat/question")
public class QuestionServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
   
    public QuestionServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("numQuestion", request.getParameter("id"));
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/question.jsp");
		rd.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("yo");
	}

}
