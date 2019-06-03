package mysql.mysql_connector_java;

import entidades.Persona;
import servicios.Vender;

import java.sql.SQLException;
import java.util.List;

import dao.PersonaDAO;

public class App {
	public static void main(String[] args) throws SQLException {
		Persona persona = PersonaDAO.find(2);
		System.out.println(persona.getId());
		Vender.nuevaventa(new Persona("Mateo", "Morgui"));
	}
}
