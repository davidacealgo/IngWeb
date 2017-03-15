package com.udea.iw.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.udea.iw.exception.Exception1;

//Esta clase se encarga de administrar las conexiones de las bd
public class DataSource{
	private static Connection con;
	private DataSource() {
		//Se creó el datasource
	}
	private static Connection getConnect() throws Exception1 { 
		Connection conn = null; //Única conexión(instancia) del singleton
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ciudades","root","root");
		}catch(ClassNotFoundException e) {
			throw new Exception1("No se encuentra el Driver", e);
		}catch(SQLException e) {
			throw new Exception1("No se puede establecer conexion", e);
		}
		return conn; //Retorna la conexión
	}
	
	public static Connection getConnection() throws Exception1 {
		if (con == null) { // Si aún no se ha creado la conexión, se crea.
				con = getConnect(); //Se llama al metodo de la clase actual
			}
		return con; //Retorna la conexión
		}
}
