package tpQCM.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tpQCM.bll.EpreuveManager;
import tpQCM.bo.Epreuve;


@WebServlet("/candidat/epreuve-start")
public class InitEpreuveServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public InitEpreuveServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//on vérifie qu'il n'y a pas de session epreuve ni timer
		
		//on set le timer
		
		// on récupère l 'épreuve avec le parametre id
		EpreuveManager epMger = new EpreuveManager();
		Epreuve epreuve = epMger.getEpreuveById(request.getParameter("id"));
		System.out.println(epreuve);
		epreuve.setEtat("EC");
		// on stocke l 'épreuve en session
		request.getSession().setAttribute("epreuve", epreuve);
		//on redirige vers la première question
		response.sendRedirect(request.getContextPath()+"/candidat/question?id=0");
		
	}

}
