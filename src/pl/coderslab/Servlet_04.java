package pl.coderslab;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet_04
 */
@WebServlet("/Servlet_04")
public class Servlet_04 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_04() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		Writer wr = response.getWriter();
		Cookie[] ciasteczka = request.getCookies();
		if(ciasteczka!=null) {
			for(Cookie ciastko : ciasteczka ) {
				if(ciastko.getName().equalsIgnoreCase("visits")) {
					int ileRazy = Integer.parseInt(ciastko.getValue());
					wr.append("Witaj, odwiedziłeś nas już "+ileRazy+" razy(odswiezyles strone)");
					ciastko.setValue(String.valueOf(++ileRazy));
					response.addCookie(ciastko);
				} 
				
			}
		}
		if (ciasteczka==null) {
			wr.append("Witaj pierwszy raz na naszej stronie");
			Cookie newCiastko = new Cookie("visits", "1");
			newCiastko.setMaxAge(365*60*60*24);
			response.addCookie(newCiastko);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
