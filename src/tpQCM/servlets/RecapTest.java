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

import org.apache.catalina.Session;

import tpQCM.bo.Section;


@WebServlet("/test-recapitulatif")
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
		
		
		List<Section> listesection=new ArrayList<Section>();
		HttpSession session = req.getSession();
		
		libelle= req.getParameter("libelleTest");
		duree= req.getParameter("dureeTest");
		dureeTest=Integer.parseInt(duree);
		listesection=(List<Section>) session.getAttribute("sections");
		for(Section s: listesection) {
			System.out.println(s.getTheme());
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/pages/recapitulatifTest.jsp");
		rd.forward(req, resp);
	}
	
	

}
