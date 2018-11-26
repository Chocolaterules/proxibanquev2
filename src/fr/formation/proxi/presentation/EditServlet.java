package fr.formation.proxi.presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.proxi.metier.ClientService;

public class EditServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		ClientService service = ClientService.getInstance();
		req.setAttribute("client", service.getClient(id));
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/edit.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		String lastname = req.getParameter("lastname");
		String firstname = req.getParameter("firstname");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		ClientService service = ClientService.getInstance();
		service.updateClient(firstname, lastname, email, address, id);
		resp.sendRedirect(this.getServletContext().getContextPath() + "/index.html");
	}

}
