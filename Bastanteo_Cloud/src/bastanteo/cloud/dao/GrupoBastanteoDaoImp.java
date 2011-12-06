package bastanteo.cloud.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bastanteo.cloud.bean.Empresa;
import bastanteo.cloud.bean.GrupoBastanteo;
import bastanteo.cloud.bean.Poder;
import bastanteo.cloud.util.HibernateUtil;

public class GrupoBastanteoDaoImp implements GrupoBastanteoDao {

	public GrupoBastanteo obtenerGrupoBastanteo(GrupoBastanteo objGrupoBastanteo) {
		Session session = HibernateUtil.getSessionFactory();
		GrupoBastanteo objGrupo = null;
		try {
			objGrupo = (GrupoBastanteo) session.get(GrupoBastanteo.class,
					objGrupoBastanteo.getId());
		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			session.close();
		}

		return objGrupo;
	}

	public List lstGrupoBastanteoxEmpresa(Empresa objEmpresa) {
		List lstGrupoBastanteoxEmpresa = null;
		Session session = HibernateUtil.getSessionFactory();
		Query q = null;
		try {
			session.beginTransaction();

			// lstGrupoBastanteoxEmpresa
			q = session
					.createQuery("select gb from GrupoBastanteo gb join fetch gb.empresa where gb.empresa.CEmpresa=:codEmpresa");
			q.setParameter("codEmpresa", objEmpresa.getCEmpresa());
			lstGrupoBastanteoxEmpresa = q.list();
			return lstGrupoBastanteoxEmpresa;

		} finally {
			session.close();
		}
	}

	@Override
	public int registraGrupoBastanteo(GrupoBastanteo objGrupoBastanteo) {
		int indicador=0;
		Session session = HibernateUtil.getSessionFactory();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(objGrupoBastanteo);
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

}
