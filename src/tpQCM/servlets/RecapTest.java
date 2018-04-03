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
import javax.servlet.http.HttpSession;

import tpQCM.BusinessException;
import tpQCM.bll.TestManager;
import tpQCM.bo.Section;
import tpQCM.bo.Test;


@WebServlet("/formateur/test-recapitulatif")
public class RecapTest extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public RecapTest() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/recapitulatifTest.jsp");
		rd.forward(request, response);
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String libelle;
		String duree;
		int dureeTest;
		Test newTest;
		String success="yo";
		List<Section> listeSection=new ArrayList<Section>();
		HttpSession session = req.getSession();
		TestManager tm=new TestManager();
		
		libelle= req.getParameter("libelleTest");
		duree= req.getParameter("dureeTest");
		dureeTest=Integer.parseInt(duree);
		System.out.println(dureeTest);
		listeSection=(List<Section>) session.getAttribute("sections");
		for(Section s: listeSection) {
			System.out.println(s.getTheme());
		}
		newTest= new Test(libelle, dureeTest);
		newTest.setListeSections(listeSection);
		System.out.println(newTest.getSeuil_bas());
		
		/*try {
			tm.insertTest(newTest);
			
		} catch (BusinessException e) {
			e.printStackTrace();
		}*/
		
		
		req.setAttribute("success", success);
		
		req.setAttribute("test", newTest);
		
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/pages/sectionAjout.jsp");
		rd.forward(req, resp);
	}
	
	

}
