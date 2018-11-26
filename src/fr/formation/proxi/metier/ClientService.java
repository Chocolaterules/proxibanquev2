package fr.formation.proxi.metier;

import java.util.List;

import fr.formation.proxi.metier.entity.Client;
import fr.formation.proxi.persistance.ClientDao;

public class ClientService {
	
	public static final ClientService INSTANCE = new ClientService();

	public static ClientService getInstance() {
		return ClientService.INSTANCE;
	}
	
	private final ClientDao dao;

	public ClientService() {
		this.dao = new ClientDao();
	}
	
	public List<Client> getAll() {
		return this.dao.readAll();
	}
	
	public Client getClient(Integer id) {
		return this.dao.read(id);
	}
	
	public void updateClient(Client entity) {
		this.dao.update(entity);
	}

}
