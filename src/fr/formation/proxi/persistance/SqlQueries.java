package fr.formation.proxi.persistance;

public class SqlQueries {

	public static final String READ_ALL_CLIENT = "SELECT * FROM client;";
	public static final String READ_ALL_ACCOUNT = "SELECT * FROM account where id_client = %s;";
	
}
