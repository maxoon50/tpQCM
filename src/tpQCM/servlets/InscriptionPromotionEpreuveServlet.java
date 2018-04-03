package tpQCM.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import tpQCM.bll.UtilisateurManager;
import tpQCM.bo.Test;
import tpQCM.bo.Utilisateur;
import tpQCM.messages.LecteurMessage;

/**
 * Servlet implementation class InscriptionEpreuveServlet
 */
@WebServlet("/responsable/inscriptionPromotion")
public class InscriptionPromotionEpreuveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionPromotionEpreuveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtilisateurManager userMger = new UtilisateurManager();
		TestManager testMger = new TestManager();
		List<String> listeCodesPromo = new ArrayList<String>();
		List<Test> listeTests = new ArrayList<Test>();
		try {
			listeCodesPromo = userMger.getAllCodePromo();
			request.setAttribute("listeCodesPromo", listeCodesPromo);
			listeTests = testMger.getAllTests();
			request.setAttribute("listeTests", listeTests);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
		System.out.println(listeCodesPromo);
	
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/inscriptionPromotionEpreuve.jsp");
		rd.forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Integer> listeCodesErreur=new ArrayList<>();
		EpreuveManager epMger = new EpreuveManager();
		
		UtilisateurManager userMger = new UtilisateurManager();
		
		try {	
			//on récupère les stagiaires de la promotion sélectionnée
			List<Utilisateur>listeStagiaires = userMger.getPromotion(request.getParameter("promotion"));
			String debut = request.getParameter("dateDebut");
			String fin = request.getParameter("dateFin");
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd hh:mi:ss");
			Date d = sdf.parse(debut);
			Date f =sdf.parse(fin);
			for (Utilisateur user : listeStagiaires) {
				epMger.inscrireCandidatEpreuve(user.getIdUtilisateur(), 
						Integer.parseInt(request.getParameter("idTest")), 
						d, f);
			}
			request.setAttribute("flashMessage", "Promotion inscrite");
			response.sendRedirect(request.getContextPath()+request.getServletPath());
		} catch (ParseException e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatServlet.ERROR_CAST_DATE);
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
