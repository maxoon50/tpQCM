package tpQCM.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
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
@WebServlet("/responsable/inscriptionTest")
public class InscriptionPromotionEpreuveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtilisateurManager userMger = new UtilisateurManager();
		TestManager testMger = new TestManager();
		List<String> listeCodesPromo = new ArrayList<String>();
		List<Test> listeTests = new ArrayList<Test>();
		List<Utilisateur>listeStagiaires = new ArrayList<Utilisateur>();
		
		// on récupère les données de base, codePromo et liste des tests dispo
		try {
			listeCodesPromo = userMger.getAllCodePromo();
			request.setAttribute("listeCodesPromo", listeCodesPromo);
			listeTests = testMger.getAllTests();
			request.setAttribute("listeTests", listeTests);
			
		} catch (BusinessException e) {
			e.printStackTrace();
			
		} 
		
		//si on arrive sur la servlet après selection de la promo, on récupère
		 if(request.getParameter("promotion")!=null){
			 if(request.getParameter("promotion").equals("externe")){
					try {
						listeStagiaires = userMger.getExterne();
						request.setAttribute("candidats", listeStagiaires);
						System.out.println(listeStagiaires+"dans externe");
					} catch (BusinessException e) {
						e.printStackTrace();
					}
					
			} else {
					try {
						listeStagiaires = userMger.getPromotion(request.getParameter("promotion"));
						request.setAttribute("candidats", listeStagiaires);
						System.out.println(listeStagiaires+"dans getPromotion");
					} catch (BusinessException e) {
						e.printStackTrace();
					}
			}
		 }
		// et on redirige sur la jsp
		 System.out.println(listeStagiaires);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/inscriptionTest.jsp");
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
			List<String>listeAInscrire = Arrays.asList(request.getParameterValues("selectCandidats"));
			
			String debut = request.getParameter("dateDebut");
			System.out.println(debut);
			String fin = request.getParameter("dateFin");
			System.out.println("date :"+new Date());
		
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
			Date d = sdf.parse(debut);
			Date f =sdf.parse(fin);
			System.out.println("date :"+new Date());
			System.out.println("debut :"+d);
			System.out.println("fin :"+f);
			System.out.println("debut :"+d);
			System.out.println("fin :"+f);
		
			for (String str :listeAInscrire) {
				epMger.inscrireCandidatEpreuve(Integer.parseInt(str), 
						Integer.parseInt(request.getParameter("test")), 
						d, f);
			}
			
			response.sendRedirect(request.getContextPath()+request.getServletPath());
			
		} catch (ParseException e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatServlet.ERROR_CAST_DATE);
		}
	}

	}
