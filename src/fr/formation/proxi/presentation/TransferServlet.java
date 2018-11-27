package fr.formation.proxi.presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.proxi.metier.AccountService;

/**
 * la class TransferServlet hérite de la class HttpServlet
 * elle utilise les méthode doGet() et doPost() 
 * @author Marie_Julien
 *
 */



public class TransferServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	/**
	 * La méthode doGet() de la classe TransferServlet permet à l'utilisateur d' afficher dans la jsples informations d'un Account.
	 * 
	 * @param HttpServletRequest req, HttpServletResponse resp
	 */
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		AccountService service = AccountService.getInstance();
		req.setAttribute("accounts", service.getAll(id));
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/transfer.jsp").forward(req, resp);
	}
	
	/**
	 * la méthode doPost() de la class TransfertServlet permet à l'utilisateur d'envoyer les informations nécessaires à la modification 
	 * du solde à modifier.
	 * 
	 * @param HttpServletRequest req, HttpServletResponse resp
	 */
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer compteA = Integer.parseInt(req.getParameter("account1"));
		Integer compteB = Integer.parseInt(req.getParameter("account2"));
		Float montant = Float.parseFloat(req.getParameter("amount"));
		AccountService service = AccountService.getInstance();
		Boolean result = service.transfer(compteA, compteB, montant);
		req.setAttribute("result", result);
		this.doGet(req, resp);
	}

}
