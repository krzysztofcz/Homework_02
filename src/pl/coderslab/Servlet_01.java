package pl.coderslab;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet_01
 */
@WebServlet("/Servlet_01")
public class Servlet_01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_01() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		float money = Float.parseFloat(request.getParameter("value"));
		String exchangeType = request.getParameter("exchangeType");
		Map<String,Float> rates = new HashMap<>();
		float eurotopln = (float) 4.3728 ;
		float usdtopln = (float) 4.1103 ;
		rates.put("EURtoUSD", eurotopln/usdtopln); 
		rates.put("USDtoEUR", usdtopln/eurotopln);
		rates.put("EURtoPLN", eurotopln);
		rates.put("PLNtoEUR", 1/eurotopln);
		rates.put("USDtoPLN", usdtopln);
		rates.put("PLNtoUSD", 1/usdtopln);
		float youCanBuy = money * rates.get(exchangeType);
		response.getWriter().append("Wymiana "+money+" "+exchangeType+" . Możesz kupic za to : "+youCanBuy);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
