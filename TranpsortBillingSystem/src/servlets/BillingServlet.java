package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BillingDao;

@WebServlet("/BillingServlet")

public class BillingServlet extends HttpServlet {

	private static final long serialVersionUID = -5961766976095055039L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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

		request.getRequestDispatcher("billing.jsp").include(request, response);
		request.getRequestDispatcher("footer.html").include(request, response);

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

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		if (BillingDao.authenticate(email, password)) {
			HttpSession session = request.getSession();
			session.setAttribute("email", email);

			request.getRequestDispatcher("navbar.html").include(request, response);
			request.getRequestDispatcher("billing.jsp").include(request, response);

		} else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('UserEmail or Password is incorrect');");
			out.println("location='index.html';");
			out.println("</script>");
			out.close();
		}
		request.getRequestDispatcher("footer.html").include(request, response);

	}

}
