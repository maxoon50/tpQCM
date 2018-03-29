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
import tpQCM.bll.UtilisateurManager;
import tpQCM.messages.LecteurMessage;

/**
 * Servlet implementation class InscriptionServlet
 */
@WebServlet("/Inscription")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtilisateurManager userMger = new UtilisateurManager();
		
		try {
			List<String> listeCodePromo = userMger.getAllCodePromo();
			request.setAttribute("codesPromo",listeCodePromo);
		} catch (BusinessException e) {
			e.printStackTrace();
			request.setAttribute("erreur","Erreur lors de la récupération des codes Promotion");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/inscription.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom=request.getParameter("nom");
		System.out.println(nom);
		String prenom=request.getParameter("prenom");
		System.out.println(prenom);
		String email=request.getParameter("email");
		System.out.println(email);
		String password=request.getParameter("password");
		System.out.println(password);
		String role=request.getParameter("profil");
		System.out.println(role);
		String promo=request.getParameter("promo");
		System.out.println(promo);
		List<Integer> listeCodesErreur=new ArrayList<>();
		UtilisateurManager userMger = new UtilisateurManager();
		try {
			userMger.insererUtilisateur(request);		
			response.sendRedirect(request.getContextPath()+request.getServletPath());
			
		} catch (BusinessException e ) {
			e.printStackTrace();
			listeCodesErreur = e.getListeCodesErreur();
			ArrayList<String>listeErreurs = new ArrayList<String>();
			
			for (Integer code : listeCodesErreur) {
				listeErreurs.add(LecteurMessage.getMessageErreur(code));
			}
			request.setAttribute("errors",listeErreurs );
			doGet(request,response);
		}
		
		
	}

}
