package com.udea.iw.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.udea.iw.exception.Exceptions;

public class DataSource {
	//Patron Singleton
	//Constructor Privado (Paso 1)
	private static DataSource instancia;
	private SessionFactory factory = null;
	private Configuration conf = new Configuration();
	
	private DataSource(){
		
	}
	//Metodo Público (Paso 2)
	public static DataSource getInstance(){
			if(instancia==null){
				instancia = new DataSource();
			}
			return instancia;
		}
	
	//Administración de la sesión con sus respectivas excepciones
	public Session getSession() throws Exceptions{
		try{
			if (factory == null){
				//Dirección del paquete de la configuración de hibernate
				conf.configure("com/udea/configHibernate/hibernate.cfg.xml");
				//Crea la sesión
				factory = conf.buildSessionFactory();
			}
			return factory.openSession();
		//Casos de error	
		}catch(HibernateException e){
			//Nueva excepción, ocurre al configurar mal la excepción
			throw new Exceptions("Error configurando la sesión",e);
			
		}
	}
	
}
