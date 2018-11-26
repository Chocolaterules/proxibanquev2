package fr.formation.proxi.metier;

import java.util.List;

import fr.formation.proxi.metier.entity.Account;
import fr.formation.proxi.persistance.AccountDao;


public class AccountService {
	
	public static final AccountService INSTANCE = new AccountService();
	
	public static AccountService getInstance() {
		return AccountService.INSTANCE;
	}
	
	private final AccountDao dao;

	public AccountService() {
		this.dao = new AccountDao();
	}
	
	public List<Account> getAll() {
		return this.dao.readAll();
	}
	
	public Account getAccount(Integer id) {
		return this.dao.read(id);
	}
	
	public void updateAccount(Account entity) {
		this.dao.update(entity);
	}


}
