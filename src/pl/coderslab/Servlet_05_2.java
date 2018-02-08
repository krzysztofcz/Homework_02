package pl.coderslab;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet_05_2
 */
@WebServlet("/Servlet_05_2")
public class Servlet_05_2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_05_2() {
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
		
		HttpSession sess = request.getSession();
		
		Map<String,Float[]> koszyk = new HashMap<String,Float[]>();

		if(sess.getAttribute("basket")==null) {
			wr.append("Koszyk jest pusty");
		}
		if(sess.getAttribute("basket")!=null) {
//			wr.append("Koszyk nie jest pusty");
			koszyk = (Map<String, Float[]>) sess.getAttribute("basket");
			Set<String> produkty = koszyk.keySet();
			float sum=0;
			wr.append("<table><thead><tr><th>[ Produkt ] </th><th> - </th><th> [ ilosc ] </th><th> x </th>"+
					"<th> [ cena ] </th> <th> = </th> <th> [ wartosc ] </th> </tr> </thead>");
			for( String produkt : produkty ) {
				wr.append("<tr><td> "+produkt+ "</td> <td> - </td> <td> "+ koszyk.get(produkt)[0] +" </td>"+
						"<td> x </td><td> "+ koszyk.get(produkt)[1] +" zł </td> <td> = </td> <td> "+
						koszyk.get(produkt)[0]*koszyk.get(produkt)[1]+" zł </td></tr>");
				sum=sum+(koszyk.get(produkt)[0]*koszyk.get(produkt)[1]);
			}
			wr.append("<tfoot> <td></td><td></td><td></td><td></td> "
					+ "<td colspan='3' align='right'> SUMA = "+sum
					+ " zł </td></tfoot>");
			wr.append("</table>");
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
