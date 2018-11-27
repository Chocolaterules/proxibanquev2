package fr.formation.proxi.presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.proxi.metier.AccountService;

public class CreateAccountServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		Integer id = Integer.parseInt(req.getParameter("id"));
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/createaccount.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String number = req.getParameter("number");
		Float balance = Float.parseFloat(req.getParameter("balance"));
		Boolean savings = Boolean.parseBoolean(req.getParameter("savings"));
		Integer id = Integer.parseInt(req.getParameter("id"));
		AccountService.getInstance().addAccount(number, balance, savings, id);
		resp.sendRedirect(this.getServletContext().getContextPath() + "/index.html");
	}

}
