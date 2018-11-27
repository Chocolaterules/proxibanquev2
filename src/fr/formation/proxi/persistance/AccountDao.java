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
	public Account create(Account entity) {
		return null;
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return account;	
	}

	@Override
	public List<Account> readAll(Integer id) {
		List<Account> results = new ArrayList<>();
		try {
			Statement st = this.mysqlConn.getConn().createStatement();
			ResultSet rs = st.executeQuery(String.format(SqlQueries.READ_ALL_ACCOUNT, id));
			//ResultSet rs = st.executeQuery(SqlQueries.READ_ALL_ACCOUNT);
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
		return false;
	}

	@Override
	public List<Account> readAll() {
		return null;
	}

	
	
}
