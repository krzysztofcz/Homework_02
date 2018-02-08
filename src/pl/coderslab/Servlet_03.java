	package pl.coderslab;

import java.io.IOException;
import java.io.Writer;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet_03
 */
@WebServlet("/Servlet_03")
public class Servlet_03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_03() {
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
		wr.append("<form action='#' method='POST'><br>");
		wr.append("<Label> 5 pol to wypelnienia : <br></Label>");
		HttpSession sess = request.getSession();
		for(int i=1;i<=5;i++) {
			if(sess.getAttribute("text"+i)!=null) {
				String temp=(String) sess.getAttribute("text"+i);
				wr.append("<Label> <input name='text"+i+"' type='text' value='"+temp+"'></Label><br>");
			} else { 
				wr.append("<Label> <input name='text"+i+"' type='text' value=''></Label><br>");
			}
		}
		wr.append("<input type='submit'>");
		wr.append("</form>");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sess = request.getSession();
		for(int i=1;i<=5;i++) {
			sess.removeAttribute("text"+i);
			sess.setAttribute("text"+i,(String) request.getParameter("text"+i));
		}
		sess.setMaxInactiveInterval(82600);
		doGet(request, response);
	}

}
