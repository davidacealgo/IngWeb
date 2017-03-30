package com.udea.iw.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.HibernateException;

import org.hibernate.Criteria;
import com.udea.iw.dao.DataSource;
import com.udea.iw.dto.Ciudad;
import com.udea.iw.exception.Exceptions;

public class CiudadDaoImp {
	public List<Ciudad> obtener() throws Exceptions{ 
		
		List<Ciudad> lista = new ArrayList<Ciudad>();
		Session session = null;
		
		try{
			session = DataSource.getInstance().getSession();
			Criteria criteria = session.createCriteria(Ciudad.class);
			lista = criteria.list();
		}catch(Exceptions e){
			throw new Exceptions("Error consultando ciudades",e);
		}
		return lista;
	} 
	
	/*Metodo Largo
	public Ciudad obtener(long codigo) throws Exceptions{
		
		Ciudad ciudad = new Ciudad();
		Session session = null;
		
		try{
			session = DataSource.getInstance().getSession();
			Criteria criteria = session.createCriteria(Ciudad.class);
			criteria.add(Restrictions.eq("codigo", codigo));	//Condición de consultas
			ciudad =  (Ciudad)criteria.uniqueResult(); 	//Se hace casting para volver tipo ciudad y debe devolver un unico resultado
		}catch(HibernateException e){
			throw new Exceptions("Error consultando ciudad",e);
		}
		return ciudad;
	}*/
	
		public Ciudad obtener(long codigo) throws Exceptions{
				
				Ciudad ciudad = new Ciudad();
				Session session = null;
				try{
					session = DataSource.getInstance().getSession();
					ciudad = (Ciudad)session.load(Ciudad.class, codigo);	//load retorna una excepcion si no lo encuentra
					//ciudad = (Ciudad)session.get(Ciudad.class, codigo);   //get retorna null si no lo encuentra
				}catch(HibernateException e){
					throw new Exceptions("Error consultando ciudad",e);
				}
				return ciudad;
		}
		
		public void guardar(Ciudad ciudad) throws Exceptions{
			Transaction tx = null;
			Session session = null;
			try{
				session = DataSource.getInstance().getSession();
				tx = session.beginTransaction();
				session.saveOrUpdate(ciudad);
				tx.commit();
			}catch(HibernateException e){
				throw new Exceptions("Error al realizar la transacción",e);
			}
		}
		
		public void borrar(Ciudad ciudad) throws Exceptions{
			Transaction tx = null;
			Session session = null;
			try{
				session = DataSource.getInstance().getSession();
				tx = session.beginTransaction();
				session.delete(ciudad);
				tx.commit();
			}catch(HibernateException e){
				throw new Exceptions("Error al realizar la transacción",e);
			}
		}
		
		
 }
