package entidades;

import java.util.ArrayList;
import java.util.List;

public class Persona {
	private int id;
	private String nombre;
	private String apellido;
	private List<Venta> ventas;

	public Persona(String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.id = -1;
		this.ventas = new ArrayList<Venta>();
	}

	public Persona(int id, String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.id = id;
		this.ventas = new ArrayList<Venta>();
	}

	public List<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Persona() {

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Override
	public String toString() {
		return "ID: " + id + "\nNombre: " + nombre + "\nApellido: " + apellido;
	}
}
