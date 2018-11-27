package fr.formation.proxi.persistance;

public class SqlQueries {

	public static final String READ_ALL_CLIENT = "SELECT * FROM client;";
	public static final String READ_CLIENT = "SELECT * FROM client WHERE id=%s;";
	public static final String READ_ALL_ACCOUNT = "SELECT * FROM account where id_client = %s;";
	public static final String UPDATE_CLIENT = "UPDATE client SET %s = '%s' WHERE id=%s;";
	public static final String UPDATE_ACCOUNT = "UPDATE account SET balance=%s WHERE idaccount=%s;";
	public static final String CREATE_CLIENT = "INSERT INTO client VALUES (null, '%s', '%s', '%s', '%s');";
	public static final String CREATE_ACCOUNT = "INSERT INTO account VALUES (null, );";

}
