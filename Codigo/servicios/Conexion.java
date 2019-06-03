package servicios;

import java.sql.*;

import entidades.Persona;

public class Conexion {
	private Connection con;

	private static Conexion pInstance = null;

	public static Conexion instance() {
		if (pInstance == null)
			pInstance = new Conexion();
		return pInstance;
	}

	public Conexion() {
		this.con = null;
	}

	public void Desconexion() throws SQLException {
		this.con.close();
	}

	public void Conectar() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {

			String url = "jdbc:mysql://localhost:3306/prog2dao1?user=root&password=";
			this.con = DriverManager.getConnection(url);
			if (this.con != null) {
				System.out.println("Conectado");
			}
		} catch (SQLException e) {
			System.out.println("No se pudo conectar a la base de datos”);" + " e.printStackTrace();}");
		}
	}

	public Connection getConexion() {
		return this.con;
	}

	public ResultSet query(String stringSql) throws SQLException {
		if (this.con == null)
			this.Conectar();
		return this.con.createStatement().executeQuery(stringSql);
	}

	public void execute(String stringSql) throws SQLException {
		if (this.con == null)
			this.Conectar();
		this.con.createStatement().executeUpdate(stringSql);
	}

	public Persona Obtenerpersona(int id) {
		Statement stmt = null;
		ResultSet rs = null;
		String sqlBuscar = "select * from login where id = " + id + ";";

		try {
			stmt = this.con.createStatement();
			rs = stmt.executeQuery(sqlBuscar);
			// Paso 3 - leer datos
			while (rs.next()) {
				return (new Persona(rs.getString("nombre"), rs.getString("apellido")));
			}
			stmt.close();// con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (new Persona());

	}

	/*
	 * public void Cargarpersona(String nombre, String apellido) { Statement stmt =
	 * null; ResultSet rs = null; String query =
	 * "INSERT INTO login (`nombre`, `apellido`) VALUES ('"+nombre+"', '"+apellido+
	 * "');";
	 * 
	 * try { stmt= this.con.createStatement(); //rs = stmt.executeQuery(query);
	 * stmt.execute(query); stmt.close(); } catch (SQLException e)
	 * {e.printStackTrace();} }
	 * 
	 * public void Cerrarcon() throws SQLException { this.con.close(); }
	 */
}