package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/EditVehicle")
public class EditVehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public EditVehicle() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>TransportBillingSystem</title>");
		out.println("<link rel=\"shortcut icon\" href=\"RESOURCE/IMG/favicon.png\" type=\"image\">");
		out.println("<link rel=\"stylesheet\" href=\"RESOURCE/CSS/billing.css\" type=\"text/css\">");
		out.println("<script src='https://kit.fontawesome.com/a076d05399.js'></script>");
		out.println("</head>");
		out.println("<body>");

		request.getRequestDispatcher("navbar.html").include(request, response);
		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute("email") == null) {

			request.getRequestDispatcher("index.html").include(request, response);
		} else {
			request.getRequestDispatcher("editvehicle.jsp").include(request, response);
		}

		request.getRequestDispatcher("footer.html").include(request, response);
	}

}
