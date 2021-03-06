package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.CityBean;
import dao.CityDao;

@WebServlet("/AddCity")
public class AddCity extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddCity() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>TransportBillingSystem</title>");
		out.println("<link rel=\"shortcut icon\" href=\"RESOURCE/IMG/favicon.png\" type=\"image\">");
		out.println("<link rel=\"stylesheet\" href=\"RESOURCE/CSS/billing.css\" type=\"text/css\">");
		out.println("</head>");
		out.println("<body>");

		request.getRequestDispatcher("navbar.html").include(request, response);

		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute("email") == null) {
			out.println("<h1>Not Login!</h1>");
			request.getRequestDispatcher("index.html").include(request, response);
		} else {

			request.getRequestDispatcher("addcity.jsp").include(request, response);

		}
		String city = request.getParameter("city");
		String city_code = request.getParameter("city_code");
		String state = request.getParameter("state");

		CityBean bean = new CityBean(city, city_code, state);
		int i = CityDao.save(bean);
		if (i > 0) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('City added successfully');");
			out.println("</script>");

		}

		request.getRequestDispatcher("footer.html").include(request, response);

	}

}
