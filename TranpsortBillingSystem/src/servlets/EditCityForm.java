package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.CityBean;
import dao.CityDao;

@WebServlet("/EditCityForm")
public class EditCityForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditCityForm() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute("email") == null) {

			request.getRequestDispatcher("index.html").include(request, response);
		} else {
			System.out.print(1);
			String sid = request.getParameter("cityid");
			int id = Integer.parseInt(sid);
			String city = request.getParameter("city");
			String city_code = request.getParameter("city_code");
			String state = request.getParameter("state");
			System.out.print(2);
			CityBean bean = new CityBean(id, city, city_code, state);
			System.out.print(3);
			CityDao.update(bean);
			System.out.print(4);
			response.sendRedirect("CityPanel");

		}

	}
}
