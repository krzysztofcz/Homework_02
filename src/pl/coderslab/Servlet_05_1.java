package pl.coderslab;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet_05_1
 */
@WebServlet("/Servlet_05_1")
public class Servlet_05_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_05_1() {
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
		
		try {
			wr.append("<div style='float: left'>");
			wr.append("<form action='' method='POST'>");
			wr.append("<Label>Produkt name : <input name='name' type='text'> </Label> ");
			wr.append("<Label>ilosc : <input name='ilosc' type='number'> </Label> ");
			wr.append("<Label>cena : <input name='cena' type='number'> </Label> <br>");
			wr.append("<input type='submit'><br>");
			wr.append("</div>");
			wr.append("<div style='float:right'><h2><a href='Servlet_05_2'> Twoj Koszyk z produktami </a></h2></div>");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		Writer wr = response.getWriter();
		
		HttpSession sess = request.getSession();
		
		Map<String,Float[]> koszyk = new HashMap<String,Float[]>();

		
		if(sess.getAttribute("basket")!=null) {
			koszyk = (Map<String, Float[]>) sess.getAttribute("basket");
		}
		int koszykStartSize = koszyk.size(); 
		String name = request.getParameter("name");
		try {
			int ilosc = Integer.parseInt(request.getParameter("ilosc"));	
			float cena = Float.parseFloat(request.getParameter("cena"));
			Float iloscICena[] = { (float) ilosc, cena } ; 
			koszyk.put(name, iloscICena );
			sess.setAttribute("basket",koszyk);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if(koszyk.size()-koszykStartSize>0) {
			wr.append("<p>Produkt dodany</p>");
		}
		
		doGet(request, response);
	}

}
