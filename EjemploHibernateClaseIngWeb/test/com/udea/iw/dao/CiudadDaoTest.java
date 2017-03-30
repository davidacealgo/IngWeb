package com.udea.iw.dao;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;

import com.udea.iw.dao.impl.CiudadDaoImp;
import com.udea.iw.dto.Ciudad;
import com.udea.iw.exception.Exceptions;

public class CiudadDaoTest {

	@Test
	public void testObtener() {
		//Test para el metodo obtener()
				CiudadDaoImp ciudad = null;
				List<Ciudad> lista = null; //Se guarda el query
				
				try {
					ciudad = new CiudadDaoImp(); //crea el objeto
					lista = ciudad.obtener();
					assertTrue(lista.size()>0);  //Envia solo si la lista tiene datos
				}catch(Exceptions e) {
					e.printStackTrace(); //Envia el error 
					fail(e.getMessage());  //Mensaje de error
				}
			}

}
