package tpQCM.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tpQCM.BusinessException;
import tpQCM.bll.UtilisateurManager;
import tpQCM.bo.Section;
import tpQCM.bo.Test;
import tpQCM.bo.Utilisateur;
import tpQCM.dal.TestDAOJdbcImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/login.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Utilisateur user = null;
		UtilisateurManager userMger = new UtilisateurManager();
		RequestDispatcher rd;
		
		try {
			user = userMger.login(email, password);
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			
			switch (user.getCodeProfil()) {
			  case 100: response.sendRedirect(request.getContextPath()+"/candidat/accueil");
	                     break;
              case 101: response.sendRedirect(request.getContextPath()+"/candidat/accueil");
	                     break;
              case 102:response.sendRedirect(request.getContextPath()+"/formateur/accueil-formateur");  
	                     break;
              case 103:response.sendRedirect(request.getContextPath()+"/responsable/accueilresponsable");
                		break;
              case 104:response.sendRedirect(request.getContextPath()+"/responsable/accueilresponsable");
                		break;
              default:response.sendRedirect(request.getContextPath()+"/login");        
			}

		} catch (BusinessException e) {
			e.printStackTrace();
			request.setAttribute("erreur", e.getListeCodesErreur());
			doGet(request, response);
		}
		// a remplacer par le retour du manager 
		//Utilisateur user = new Utilisateur();
		
	}

}
