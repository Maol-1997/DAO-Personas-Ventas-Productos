package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Producto;
import servicios.Conexion;

public class ProductoDAO {
	public static void del(Producto producto) throws SQLException {
		String stringSql = "DELETE FROM productos WHERE id = " + String.valueOf(producto.getId());
		Conexion.instance().execute(stringSql);
	}

	public static void save(Producto producto) throws SQLException {
		if (exist(producto))
			update(producto);
		else
			add(producto);
	}

	public static boolean exist(Producto producto) throws SQLException {
		String stringSql = "SELECT * FROM productos WHERE id = " + String.valueOf(producto.getId());
		ResultSet res = Conexion.instance().query(stringSql);
		return res.next();
	}

	public static boolean exist(String producto) throws SQLException {
		String stringSql = "SELECT * FROM productos WHERE nombre = '" + producto + "';";
		ResultSet res = Conexion.instance().query(stringSql);
		return res.next();
	}

	public static void update(Producto producto) throws SQLException {
		String stringSql = "UPDATE productos SET nombre = '" + producto.getNombre() + "' WHERE id = '"
				+ String.valueOf(producto.getId()) + "'";
		Conexion.instance().execute(stringSql);
	}

	public static void add(Producto producto) throws SQLException {
		String stringSql = "INSERT INTO productos (nombre,descripcion,precio) VALUES ('" + producto.getNombre() + "', '"
				+ producto.getDescripcion() + "', " + String.valueOf(producto.getPrecio()) + ")";
		Conexion.instance().execute(stringSql);
	}

	public static Producto find(int id) throws SQLException {
		String stringSql = "SELECT * FROM productos WHERE id = " + id;
		ResultSet res = Conexion.instance().query(stringSql);
		if (res.next()) {
			Producto per = new Producto(res.getInt("id"), res.getString("nombre"), res.getString("descripcion"),
					res.getInt("precio"));
			return per;
		}
		return new Producto();
	}

	public static Producto find(String nombre) throws SQLException {
		String stringSql = "SELECT * FROM productos WHERE nombre = '" + nombre + "';";
		ResultSet res = Conexion.instance().query(stringSql);
		if (res.next()) {
			Producto per = new Producto(res.getInt("id"), res.getString("nombre"), res.getString("descripcion"),
					res.getInt("precio"));
			return per;
		}
		return new Producto();
	}

	public static List<Producto> findAll() throws SQLException {
		ResultSet res = Conexion.instance().query("SELECT * from persona");
		List<Producto> prod = new ArrayList<Producto>();
		while (res.next())
			prod.add(new Producto(res.getInt("id"), res.getString("nombre"), res.getString("descripcion"),
					res.getInt("precio")));
		return prod;
	}
}
