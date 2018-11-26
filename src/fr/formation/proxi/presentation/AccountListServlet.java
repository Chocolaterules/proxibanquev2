package fr.formation.proxi.presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.proxi.metier.AccountService;
import fr.formation.proxi.metier.ClientService;

public class AccountListServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String strId = req.getParameter("id");
		Integer id = Integer.parseInt(strId);
		AccountService service = AccountService.getInstance();
		req.setAttribute("accounts", service.getAll(id));
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/accountList.jsp").forward(req, resp);
	}
	

}
