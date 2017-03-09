package com.udea.iw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.udea.iw.exception.Exception1;

public class DataSource {
	public static Connection getConnection() throws Exception1{//throws para utilizar la clase exception1
		Connection con = null; //Conexión con la BD
		PreparedStatement ps = null;	//Consulta a la BD
		ResultSet rs = null;	//Resultado
		
		try{	
			Class.forName("com.mysql.jdbc.Driver");		//Buscar el driver
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/davidace","root","root"); //Generar conexión con la BD
		}catch(ClassNotFoundException e){
			throw new Exception1("Driver no encontrado",e);
		}catch(SQLException e){
			throw new Exception1("No puede establecer conexión",e);//throws es para mandar a que la clase exception maneje la excepción
		}
		return con;
	}
}