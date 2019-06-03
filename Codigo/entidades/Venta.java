package entidades;

import java.util.ArrayList;
import java.util.List;

public class Venta {
	private int id;
	private int idpersona;
	private String fecha;
	private int valor;
	private String descripcion;
	private List<Producto> productos;

	public Venta() {
	}

	public Venta(int id, int idpersona, String fecha, int valor, String descripcion) {
		this.id = id;
		this.idpersona = idpersona;
		this.fecha = fecha;
		this.valor = valor;
		this.descripcion = descripcion;
		this.productos = new ArrayList<Producto>();
	}

	public Venta(int idpersona, String fecha, int valor, String descripcion) {
		this.id = -1;
		this.idpersona = idpersona;
		this.fecha = fecha;
		this.valor = valor;
		this.descripcion = descripcion;
		this.productos = new ArrayList<Producto>();
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdpersona() {
		return idpersona;
	}

	public void setIdpersona(int idpersona) {
		this.idpersona = idpersona;
	}

}
