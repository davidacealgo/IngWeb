/**
 * 
 */
package com.udea.iw.dao;
import java.util.List;

import com.udea.iw.dto.Ciudad;
import com.udea.iw.exception.Exception1;
/**
 * @author davida.acevedo
 * Versión 1.0
 */
public interface CiudadDao {
	public List<Ciudad> obtener() throws Exception1; //Entrega la lista completa de ciudades de la base de datos ordenada
	
}
