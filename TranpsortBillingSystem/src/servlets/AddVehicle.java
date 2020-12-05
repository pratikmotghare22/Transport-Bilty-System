package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.VehicleBean;
import dao.VehicleDao;

@WebServlet("/AddVehicle")
public class AddVehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddVehicle() {
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
			request.getRequestDispatcher("addvehicle.jsp").include(request, response);
		}
		String vehicletype = request.getParameter("vehicletype");
		String vehiclename = request.getParameter("vehiclename");
		String vehiclenumber = request.getParameter("vehiclenumber");
		String ownername = request.getParameter("ownername");
		String insurance = request.getParameter("insurance");

		VehicleBean bean = new VehicleBean(vehicletype, vehiclename, vehiclenumber,  ownername, insurance);
		int i = VehicleDao.save(bean);
		if (i > 0) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Vehicle details added successfully');");
			out.println("</script>");
		}

		request.getRequestDispatcher("footer.html").include(request, response);
	}

}
