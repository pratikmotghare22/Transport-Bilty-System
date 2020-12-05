package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.VehicleDao;

@WebServlet("/DeleteVehicle")
public class DeleteVehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteVehicle() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		PrintWriter out = response.getWriter();
		if (session == null || session.getAttribute("email") == null) {
			out.println("<h1>Not Login!</h1>");
			request.getRequestDispatcher("index.html").include(request, response);
		} else {

			response.sendRedirect("VehiclesPanel");
		}
		VehicleDao.delete(request.getParameter("vehicleno"));

	}

}
