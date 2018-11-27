package fr.formation.proxi.persistance;


import fr.formation.proxi.persistance.MySqlConnection;
import fr.formation.proxi.metier.entity.Client;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ClientDao implements Dao<Client>{
	
	
	
	private final MySqlConnection mysqlConn;

	public ClientDao() {
		this.mysqlConn = MySqlConnection.getInstance();
	}
	
	@Override
	public Client create(Client entity) {
		try {
			Statement st = this.mysqlConn.getConn().createStatement();
			String query = String.format(SqlQueries.CREATE_CLIENT, entity.getFirstname(), entity.getLastname(), entity.getEmail(), entity.getAddress());
			boolean success = st.execute(query, Statement.RETURN_GENERATED_KEYS); 
			if (success) {
				ResultSet rs = st.getGeneratedKeys();
				Integer clientId = rs.getInt("GENERATED_KEY");
				entity.setId(clientId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entity;
	}

	@Override
	public Client read(Integer id) {
		Client client = new Client();
		try {
			Statement st = this.mysqlConn.getConn().createStatement();
			ResultSet rs = st.executeQuery(String.format(SqlQueries.READ_CLIENT, id));
			while(rs.next()) {
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String email = rs.getString("email");
				String address = rs.getString("address");
				client =new Client(firstname, lastname, email, address);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return client;
	}

	@Override
	public List<Client> readAll() {
		List<Client> results = new ArrayList<>();
		try {
			Statement st = this.mysqlConn.getConn().createStatement();
			ResultSet rs = st.executeQuery(SqlQueries.READ_ALL_CLIENT);
			while(rs.next()) {
				Integer id = rs.getInt("id");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String email = rs.getString("email");
				String address = rs.getString("address");
				results.add(new Client(id, firstname, lastname, email, address));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}

	@Override
	public Client update(Client entity) {
		try {
			Statement st = this.mysqlConn.getConn().createStatement();
			String queryFirstname = String.format(SqlQueries.UPDATE_CLIENT, "firstname", entity.getFirstname(), entity.getId());
			String queryLastname = String.format(SqlQueries.UPDATE_CLIENT, "lastname", entity.getLastname(), entity.getId());
			String queryEmail = String.format(SqlQueries.UPDATE_CLIENT, "email", entity.getEmail(), entity.getId());
			String queryAddress = String.format(SqlQueries.UPDATE_CLIENT, "address", entity.getAddress(), entity.getId());
			st.execute(queryFirstname);
			st.execute(queryLastname);
			st.execute(queryEmail);
			st.execute(queryAddress);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return entity;
	}

	@Override
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public List<Client> readAll(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
