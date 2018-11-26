package fr.formation.proxi.persistance;

public class SqlQueries {

	public static final String READ_ALL_CLIENT = "SELECT * FROM client;";
	public static final String READ_CLIENT = "SELECT * FROM client WHERE id=%s;";
	public static final String READ_ALL_ACCOUNT = "SELECT * FROM account;";
	public static final String UPDATE_CLIENT = "UPDATE client SET %s = '%s' WHERE id=%s;";
	public static final String UPDATE_ACCOUNT = "UPDATE account SET balance=%s WHERE idaccount=%s;";
	
}
