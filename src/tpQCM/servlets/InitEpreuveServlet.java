package tpQCM.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/candidat/epreuve-start")
public class InitEpreuveServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public InitEpreuveServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//on vérifie qu'il n'y a pas de session epreuve ni timer
		//on set le timer
		//on récupère le paramètre id qui va permettre de récupèrer l' épreuve
		// on récupère l 'épreuve
		// on stocke l 'épreuve en session
		//on redirige vers la première question
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
