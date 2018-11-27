package fr.formation.proxi.presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.proxi.metier.AccountService;


public class TransferServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		AccountService service = AccountService.getInstance();
		req.setAttribute("accounts", service.getAll(id));
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/transfer.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		Integer id = Integer.parseInt(req.getParameter("id"));
		
		Integer compteA = Integer.parseInt(req.getParameter("account1"));
		Integer compteB = Integer.parseInt(req.getParameter("account2"));
		Float montant = Float.parseFloat(req.getParameter("amount"));
		System.out.println("compteA" + compteA);
		System.out.println("compteB" + compteB);
		AccountService service = AccountService.getInstance();
		service.transfer(compteA, compteB, montant);
		resp.sendRedirect(this.getServletContext().getContextPath() + "/index.html");
	}

}
