package pl.coderslab;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet_02
 */
@WebServlet("/Servlet_02")
public class Servlet_02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_02() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		String binary = (request.getParameter("value"));
		int dec = ifBinary(binary);
		if(dec==-1) {
			response.getWriter().append("to nie jest jest liczba binarna !!! ");
		} else {
			response.getWriter().append(binary+" to liczba : "+dec);
		}
		
	}
	

	private int ifBinary(String binary) {
		int answer=0;
		char[] charArray=binary.toCharArray();
		for(int i=charArray.length-1;i>=0;i--) {
			if ((charArray[i]=='0') || (charArray[i]=='1')) {
				answer = (int) Math.pow(2, charArray.length-i-1);
			} else {
				return -1;
			}
		}
		return answer;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
