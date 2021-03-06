package com.udea.iw.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.udea.iw.dao.CiudadDao;
import com.udea.iw.dao.DataSource;
import com.udea.iw.dto.Ciudad;
import com.udea.iw.exception.Exception1;

public class CiudadDaoImplementation implements CiudadDao{
	
	public List<Ciudad> obtener() throws Exception1 { //Entrega la lista completa de ciudades de la base de datos ordenada
	
	Connection con = null; //Conexión con la BD
	PreparedStatement ps = null;	//Consulta a la BD
	ResultSet rs = null;	//Resultado
	List<Ciudad> lista = new ArrayList<Ciudad>();
	
	try{
		con = DataSource.getConnection();
		ps = con.prepareStatement("Select * From ciudades");
		rs = ps.executeQuery();
		
		while(rs.next()){
			Ciudad ciudad = new Ciudad();
			ciudad.setCodigo(rs.getLong("codigo"));
			ciudad.setNombre(rs.getString("Nombre"));
			ciudad.setCodigoArea(rs.getString("codigoArea"));
			lista.add(ciudad);
		}
	}catch(SQLException e){
		throw new Exception1("Error consultando",e);
	}finally{
		try{
			if(rs != null)
				rs.close();
			if(ps != null)
				ps.close();
			if(con != null)
				con.close();
		}catch(SQLException e){
			throw new Exception1("Error cerrando",e);
		}
		
	}
	return lista;
	}
	
	public Ciudad obtener(Long codigo) throws Exception1{
		Ciudad ciudad = null;
		Connection con = null;
		PreparedStatement ps= null;
		ResultSet rs=null;
		try {
			con = DataSource.getConnection();
			ps = con.prepareStatement("SELECT * FROM ciudades WHERE codigo=?");
			ps.setLong(1, codigo); //Evita SQL Injection
			rs= ps.executeQuery();
			if(rs.next()) {
				ciudad = new Ciudad();
				ciudad.setCodigo(rs.getLong("codigo"));
				ciudad.setNombre(rs.getString("nombre"));
				ciudad.setCodigoArea(rs.getString("codigoArea"));
			}
		}catch(SQLException e){
			throw new Exception1("No se realizó la conexión",e);
		}finally{
			try{
				rs.close();
				ps.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();	//No se realiza en una buena practica 
			}
		}
		return ciudad;
		}

}
