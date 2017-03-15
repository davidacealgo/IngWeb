package com.udea.iw.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.udea.iw.dao.impl.CiudadDaoImplementation;
import com.udea.iw.dto.Ciudad;
import com.udea.iw.exception.Exception1;

public class CiudadDaoTest {

	@Test
	public void testObtener() {
		//Test para el metodo obtener()
				CiudadDaoImplementation ciudadDao = null;
				List<Ciudad> lista = null; //Se guarda el query
				
				try {
					ciudadDao = new CiudadDaoImplementation(); //crea el objeto
					lista = ciudadDao.obtener();
					assertTrue(lista.size()>0);  //Envia solo si la lista tiene datos
				}catch(Exception1 e) {
					e.printStackTrace(); //Envia el error 
					fail(e.getMessage());  //Mensaje de error
				}
			}

}
