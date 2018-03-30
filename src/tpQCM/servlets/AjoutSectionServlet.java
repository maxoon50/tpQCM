package tpQCM.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tpQCM.BusinessException;
import tpQCM.bll.ReferentielManager;
import tpQCM.bo.Question;
import tpQCM.bo.Section;
import tpQCM.bo.Theme;

/**
 * Servlet implementation class AjoutSectionServlet
 */
@WebServlet("/AjoutSection")
public class AjoutSectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Récupération des thèmes en base
		ReferentielManager rm=new ReferentielManager();
		List<Theme> listeTheme=new ArrayList<Theme>();
		
		try {
			listeTheme=rm.getAllThemes();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("theme", listeTheme);
		
		//récupération du nombre de questions par thème
		List<Integer> listeNbQuestion=new ArrayList<Integer>();
		List<Question> listeQuestion=new ArrayList<Question>();
		int i=0;
		Hashtable ht = new Hashtable();
		for(Theme t : listeTheme) {
			try {
				listeQuestion=rm.getQuestionsByTheme(t.getIdTheme());
				ht.put(t.getIdTheme(),listeQuestion.size());
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		request.setAttribute("themes", ht);


		RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/pages/sectionAjout.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Récupération de l'idTheme et du nombre de questions puis mise en session
		String theme;
		int idTheme;
		String question;
		int nbQuestion;
		ReferentielManager rm=new ReferentielManager();
		
		theme=request.getParameter("theme");
		idTheme=Integer.parseInt(theme);
		System.out.println(idTheme);
		question=request.getParameter("nbQuestion");
		nbQuestion=Integer.parseInt(question);
		
		if(nbQuestion !=0 && idTheme != 666) {
			Theme t= new Theme();
			try {
				t=rm.getThemeById(idTheme);
			} catch (BusinessException e) {
				e.printStackTrace();
			}
			Section section= new Section(nbQuestion, idTheme, t.getLibelle());
			HttpSession session = request.getSession();
			List<Section> listeLibelleSection ;
			List<Integer> listeNbQuestion= new ArrayList<Integer>();
			
		
		
			listeNbQuestion.add(nbQuestion);
			
			if(session.getAttribute("sections")==null) {
				listeLibelleSection = new ArrayList<Section>();
			}else{
				listeLibelleSection=new ArrayList<Section>();
				listeLibelleSection=(List<Section>) session.getAttribute("sections");
			}
			listeLibelleSection.add(section);
		
			//mise en session des infos
			session.setAttribute("sections", listeLibelleSection);
		}
		
		List<Theme> listeTheme=new ArrayList<Theme>();
		
		try {
			listeTheme=rm.getAllThemes();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("theme", listeTheme);
		
		//récupération du nombre de questions par thème
		List<Integer> listeNbQuestionTheme=new ArrayList<Integer>();
		List<Question> listeQuestion=new ArrayList<Question>();
		int i=0;
		Hashtable ht = new Hashtable();
		for(Theme t2 : listeTheme) {
			try {
				listeQuestion=rm.getQuestionsByTheme(t2.getIdTheme());
				ht.put(t2.getIdTheme(),listeQuestion.size());
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		request.setAttribute("themes", ht);
		
		
		RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/pages/sectionAjout.jsp");
		rd.forward(request, response);
	}

}
