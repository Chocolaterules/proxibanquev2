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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client read(Integer id) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
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
