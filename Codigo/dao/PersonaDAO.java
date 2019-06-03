package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Persona;
import servicios.Conexion;

public class PersonaDAO {

	public static void del(Persona persona) throws SQLException {
		String stringSql = "DELETE FROM persona WHERE id = " + String.valueOf(persona.getId());
		Conexion.instance().execute(stringSql);
	}

	public static void save(Persona persona) throws SQLException {
		if (exist(persona))
			update(persona);
		else
			add(persona);
	}

	public static boolean exist(Persona persona) throws SQLException {
		String stringSql = "SELECT * FROM persona WHERE id = " + String.valueOf(persona.getId());
		ResultSet res = Conexion.instance().query(stringSql);
		return res.next();
	}

	public static void update(Persona persona) throws SQLException {
		String stringSql = "UPDATE persona SET nombre = '" + persona.getNombre() + "' , apellido = '"
				+ persona.getApellido() + "' WHERE id = '" + String.valueOf(persona.getId()) + "'";
		Conexion.instance().execute(stringSql);
	}

	public static void add(Persona persona) throws SQLException {
		String stringSql = "INSERT INTO persona (nombre, apellido) VALUES ('" + persona.getNombre() + "' , '"
				+ persona.getApellido() + "')";
		Conexion.instance().execute(stringSql);
	}

	public static Persona find(int id) throws SQLException {
		String stringSql = "SELECT * FROM persona WHERE id = " + id;
		ResultSet res = Conexion.instance().query(stringSql);
		if (res.next()) {
			Persona per = new Persona(res.getInt("id"), res.getString("nombre"), res.getString("apellido"));
			return per;
		}
		return new Persona();
	}

	public static List<Persona> findAll() throws SQLException {
		ResultSet res = Conexion.instance().query("SELECT * from persona");
		List<Persona> per = new ArrayList<Persona>();
		while (res.next())
			per.add(new Persona(res.getInt("id"), res.getString("nombre"), res.getString("apellido")));
		return per;
	}

}
