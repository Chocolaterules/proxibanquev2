package fr.formation.proxi.persistance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.formation.proxi.persistance.SqlQueries;
import fr.formation.proxi.metier.entity.Account;
import fr.formation.proxi.metier.entity.Client;

public class AccountDao  implements Dao<Account>{

	private final MySqlConnection mysqlConn;

	public AccountDao() {
		this.mysqlConn = MySqlConnection.getInstance();
	}
	
	@Override
	public Account create(Account entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account read(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> readAll(Integer id) {
		List<Account> results = new ArrayList<>();
		try {
			Statement st = this.mysqlConn.getConn().createStatement();
			ResultSet rs = st.executeQuery(String.format(SqlQueries.READ_ALL_ACCOUNT, id));
			//ResultSet rs = st.executeQuery(SqlQueries.READ_ALL_ACCOUNT);
			while(rs.next()) {
				Boolean savings = rs.getBoolean("savings");
				String number = rs.getString("number");
				Float  balance = rs.getFloat("balance");
				results.add(new Account(number, balance, savings));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}

	@Override
	public Account update(Account entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Account> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
