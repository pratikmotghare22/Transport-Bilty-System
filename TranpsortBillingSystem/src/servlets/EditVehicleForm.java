package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.VehicleBean;
import dao.VehicleDao;

@WebServlet("/EditVehicleForm")
public class EditVehicleForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditVehicleForm() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute("email") == null) {

			request.getRequestDispatcher("index.html").include(request, response);
		} else {
			String sid=request.getParameter("vehicleid");  
		    int id=Integer.parseInt(sid);  
			String vehicletype = request.getParameter("vehicletype");
			String vehiclename = request.getParameter("vehiclename");
			String vehiclenumber = request.getParameter("vehiclenumber");
			String ownername = request.getParameter("ownername");
			String insurance = request.getParameter("insurance");
			VehicleBean bean = new VehicleBean(id,vehicletype, vehiclename, vehiclenumber, ownername, insurance);
			VehicleDao.update(bean);

			response.sendRedirect("VehiclesPanel");
		}
	}

}
