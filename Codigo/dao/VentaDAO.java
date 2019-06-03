package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entidades.Producto;
import entidades.Venta;
import servicios.Conexion;

public class VentaDAO {
	public static void del(Venta venta) throws SQLException {
		String stringSql = "DELETE FROM ventas WHERE id = " + String.valueOf(venta.getId());
		Conexion.instance().execute(stringSql);
	}

	public static void save(Venta venta) throws SQLException {
		if (exist(venta))
			update(venta);
		else
			add(venta);
	}

	public static boolean exist(Venta venta) throws SQLException {
		String stringSql = "SELECT * FROM ventas WHERE id = " + String.valueOf(venta.getId());
		ResultSet res = Conexion.instance().query(stringSql);
		return res.next();
	}

	public static void update(Venta venta) throws SQLException {
		String stringSql = "UPDATE ventas SET valor = '" + String.valueOf(venta.getValor()) + "', descripcion = '"+ venta.getDescripcion() +"' WHERE id = '"
				+ String.valueOf(venta.getId()) + "'";
		Conexion.instance().execute(stringSql);
	}

	public static void add(Venta venta) throws SQLException {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
		String stringSql = "INSERT INTO ventas (`idpersona`, `fecha`, `valor`, `descripcion`) VALUES (" + String.valueOf(venta.getIdpersona()) + ", '"+ formatter.format(date) +"', "+ venta.getValor() +", '"+ venta.getDescripcion() +"')";
		Conexion.instance().execute(stringSql);
	}

	public static Venta find(int id) throws SQLException {
		String stringSql = "SELECT * FROM ventas WHERE id = " + id;
		ResultSet res = Conexion.instance().query(stringSql);
		if (res.next()) {
			Venta per = new Venta(res.getInt("id"),res.getInt("personaid"),String.valueOf(res.getDate("fecha")),res.getInt("valor"),res.getString("descripcion"));
			return per;
		}
		return new Venta();
	}

	public static List<Venta> findAll() throws SQLException {
		ResultSet res = Conexion.instance().query("SELECT * from ventas");
		List<Venta> prod = new ArrayList<Venta>();
		while (res.next())
			prod.add(new Venta(res.getInt("id"), res.getInt("idpersona"),String.valueOf(res.getDate("fecha")),res.getInt("valor"),res.getString("descripcion")));
		return prod;
	}
	
	public static void relprod(Venta venta, Producto producto) throws SQLException {
		String stringSql = "INSERT INTO relventaproducto (`idventa`, `idproducto`) VALUES ('"+ venta.getId() +"', '"+ producto.getId() +"');";
		Conexion.instance().execute(stringSql);
	}
}
