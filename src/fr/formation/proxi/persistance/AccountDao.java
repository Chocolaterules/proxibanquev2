package fr.formation.proxi.persistance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.formation.proxi.persistance.SqlQueries;
import fr.formation.proxi.metier.entity.Account;

public class AccountDao  implements Dao<Account>{

	private final MySqlConnection mysqlConn;

	public AccountDao() {
		this.mysqlConn = MySqlConnection.getInstance();
	}
	
	@Override
	public Account create(Account entity, Integer id) {
		try {
			Statement st = this.mysqlConn.getConn().createStatement();
			String query = String.format(SqlQueries.CREATE_ACCOUNT, entity.getNumber(), entity.getBalance(), entity.isSavings(), id);
			boolean success = st.execute(query, Statement.RETURN_GENERATED_KEYS); 
			if (success) {
				ResultSet rs = st.getGeneratedKeys();
				Integer accountId = rs.getInt("GENERATED_KEY");
				entity.setId(accountId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entity;
	}

	@Override
	public Account read(Integer id) {
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
		return null;
	}

	@Override
	public boolean delete(Integer id) {
		return false;
	}

	@Override
	public List<Account> readAll() {
		return null;
	}

	@Override
	public Account create(Account entity) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
