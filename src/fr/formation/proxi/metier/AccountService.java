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
	
	public void addAccount(String number, Float balance, Boolean savings, Integer id) {
		this.dao.create(new Account(number, balance, savings), id);
	}
	
	public List<Account> getAll(Integer id) {
		return this.dao.readAll(id);
	}
	
	public Account getAccount(Integer id) {
		return this.dao.read(id);
	}
	
	public void updateAccount(Account entity) {
		this.dao.update(entity);
	}


}
