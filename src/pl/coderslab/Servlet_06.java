package pl.coderslab;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet_06
 */
@WebServlet("/Servlet_06")
public class Servlet_06 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_06() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		Writer wr = response.getWriter();
		wr.append("Liczby:<br>");
		
		String[] numbersInString = request.getParameterValues("num");
		float sum=0,multi=1;
		for (String num : numbersInString) {
			wr.append(" - "+num+"<br>");
			float temp = Float.parseFloat(num);
			sum=sum+temp;
			multi=multi*temp;
		}
		wr.append("Średnia: <br> - "+(sum/4.)+"<br>");
		wr.append("Suma: <br> - "+(sum)+"<br>");
		wr.append("Iloczyn: <br> - "+(multi)+"<br>"); 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
