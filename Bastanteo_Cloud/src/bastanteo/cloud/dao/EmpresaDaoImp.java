// Author: Kid Rivera Valera


package bastanteo.cloud.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;

import org.hibernate.Session;

import bastanteo.cloud.bean.Empresa;
import bastanteo.cloud.util.HibernateUtil;

public class EmpresaDaoImp implements EmpresaDao {

	@Override
	public Empresa obtenerEmpresa(Empresa objEmpresa) {
		Session sesion=HibernateUtil.getSessionFactory();
		Empresa objEmpresaObt=null;
		try{
			
			objEmpresaObt=(Empresa)sesion.get(Empresa.class, objEmpresa.getCEmpresa());
		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			sesion.close();
		}
	
		return objEmpresaObt;
	}

	@Override
	public int registrarEmpresa(Empresa objEmpresa) {
		int indicador=0;
		Session session = HibernateUtil.getSessionFactory();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(objEmpresa);
			tx.commit();
			indicador=1;
		} catch (Exception ex) {
			tx.rollback();
			indicador=0;
		} finally {
			session.close();
		}
		return indicador;
	}

	@Override
	public int modificarEmpresa(Empresa objEmpresa) {
		int indicador=0;
		Session session = HibernateUtil.getSessionFactory();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(objEmpresa);
			
			tx.commit();
			indicador=1;
		} catch (Exception ex) {
			System.out.println(ex);
			tx.rollback();
			indicador=0;
		} finally {
			session.close();
		}
		return indicador;
	}

	@Override
	public Empresa obtenerEmpresaxRuc(Empresa objEmpresa) {
		Session sesion=HibernateUtil.getSessionFactory();
		Empresa objEmpresaObt=null;
		try{
			Query q= null;
			q= sesion.createQuery("from Empresa where ruc=:ruc");
			q.setParameter("ruc", objEmpresa.getRuc());
			objEmpresaObt=(Empresa)q.uniqueResult();
		}catch (Exception ex) {
			System.out.println(ex);
		}finally {
			sesion.close();
		}
	
		return objEmpresaObt;
	}
	
	public List listar() {
		List listaEmpresa=null;
		Session session=HibernateUtil.getSessionFactory();
		
		try{
			session.beginTransaction();
			
			
			listaEmpresa=session.createQuery("select e from Empresa e join fetch e.tipoEmpresa").list();
				return listaEmpresa;
		
			
		}finally{
			session.close();
		}
	}

}
