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
	public Account read(Integer id){
		Account account = new Account();
		try {
			Statement st = this.mysqlConn.getConn().createStatement();
			ResultSet rs = st.executeQuery(String.format(SqlQueries.READ_ACCOUNT, id));
			while(rs.next()) {
				Integer idacc = rs.getInt("id");
				Boolean savings = rs.getBoolean("savings");
				String number = rs.getString("number");
				Float  balance = rs.getFloat("balance");
				account = new Account(idacc, number, balance, savings);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return account;	
	}

	public List<Account> readAll(Integer id) {
		List<Account> results = new ArrayList<>();
		try {
			Statement st = this.mysqlConn.getConn().createStatement();
			ResultSet rs = st.executeQuery(String.format(SqlQueries.READ_ALL_ACCOUNT, id));
			while(rs.next()) {
				Integer idacc = rs.getInt("id");
				Boolean savings = rs.getBoolean("savings");
				String number = rs.getString("number");
				Float  balance = rs.getFloat("balance");
				results.add(new Account(idacc, number, balance, savings));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}

	@Override
	public Account update(Account entity) {
		try {
			Statement st = this.mysqlConn.getConn().createStatement();
			String query = String.format(SqlQueries.UPDATE_ACCOUNT, entity.getBalance(), entity.getId());
			
			st.execute(query);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return entity;
	}

	@Override
	public boolean delete(Integer id) {
		Boolean result = false;
		try {
			Statement st = this.mysqlConn.getConn().createStatement();
			int rowsacc = st.executeUpdate(String.format(SqlQueries.DELETE_ACCOUNTS, id));
			if (rowsacc > 0) {	
				result = true;				
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
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
