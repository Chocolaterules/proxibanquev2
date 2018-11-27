package fr.formation.proxi.metier;

import java.util.List;

import fr.formation.proxi.metier.entity.Client;
import fr.formation.proxi.persistance.AccountDao;
import fr.formation.proxi.persistance.ClientDao;

public class ClientService {
	
	public static final ClientService INSTANCE = new ClientService();

	public static ClientService getInstance() {
		return ClientService.INSTANCE;
	}
	
	private final ClientDao dao;
	private final AccountDao daoAcc;

	public ClientService() {
		this.dao = new ClientDao();
		this.daoAcc = new AccountDao();
	}
	
	public void addClient(String firstname, String lastname, String email, String address) {
		this.dao.create(new Client(firstname, lastname, email, address));
	}
	
	public List<Client> getAll() {
		return this.dao.readAll();
	}
	
	public Client getClient(Integer id) {
		return this.dao.read(id);
	}
	
	public void updateClient(String firstname, String lastname, String email, String address, Integer id) {
		Client client = new Client(id, firstname, lastname, email, address);
		this.dao.update(client);
	}
	
	public void deleteClient(Integer id) {
		if (AccountService.getInstance().getAll(id).size()!=0) {
			this.daoAcc.delete(id);
		}
		this.dao.delete(id);
	}

}
