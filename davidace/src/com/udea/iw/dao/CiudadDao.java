/**
 * 
 */
package com.udea.iw.dao;
import java.util.List;
import com.udea.iw.dto.Ciudad;
import com.udea.iw.exception.Exception1;
/**
 * @author davida.acevedo
 * Versión 2.0
 */
public interface CiudadDao {
	//Entrega la lista completa de ciudades de la base de datos ordenada
	public List<Ciudad> obtener() throws Exception1; 
	//Lista de codigos
	public Ciudad obtener(Long codigo) throws Exception1;
}
