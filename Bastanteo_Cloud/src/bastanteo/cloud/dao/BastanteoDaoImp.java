package bastanteo.cloud.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.AliasToEntityMapResultTransformer;

import bastanteo.cloud.bean.Bastanteo;
import bastanteo.cloud.bean.BastanteoId;
import bastanteo.cloud.bean.GrupoBastanteoId;
import bastanteo.cloud.bean.RepresentanteId;
import bastanteo.cloud.util.HibernateUtil;

public class BastanteoDaoImp implements BastanteoDao {

	private int verificarBastanteo(Bastanteo objBastanteo) {
		int retorno = 0;

		Session session = HibernateUtil.getSessionFactory();
		Transaction tx = null;
		List lstResultado = new ArrayList();
		String select = "";
		Query query = null;

		try {
			tx = session.beginTransaction();

			select = "select c_empresa from bastanteo where c_empresa = :c_empresa and c_grupo_bastanteo = :c_grupo_bastanteo and c_poder = :c_poder and c_tipo_intervencion = :c_tipo_intervencion";

			query = session
					.createSQLQuery(select)
					.addScalar("C_EMPRESA")
					.setResultTransformer(
							AliasToEntityMapResultTransformer.INSTANCE);

			query.setString("c_empresa", objBastanteo.getId().getCEmpresa());
			query.setInteger("c_grupo_bastanteo", objBastanteo.getId()
					.getCGrupoBastanteo());
			query.setString("c_poder", objBastanteo.getId().getCPoder());
			query.setInteger("c_tipo_intervencion", objBastanteo
					.getTipoIntervencion().getCTipoIntervencion());

			lstResultado = query.list();
			System.out.println("LIATA " + lstResultado.size());
			if (lstResultado.size() > 0) {
				retorno = 1;
			} else {
				retorno = 0;
			}

			tx.commit();

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			try {
				throw e;
			} catch (Exception e1) {

				e1.printStackTrace();
			}
			retorno = 0;
		} finally {
			session.close();
		}

		return retorno;
	}

	public int insertarBastanteo(Bastanteo objBastanteo) {

		int retorno;

		retorno = verificarBastanteo(objBastanteo);
		System.out.println(retorno);
		if (retorno != 0) {
			System.out.println("Ya se anotó el mismo poder para el mismo grupo de bastanteo, en el mismo cliente, considerando el mismo tipo de intervención y combinación");
			return retorno;
		}

		Session session = HibernateUtil.getSessionFactory();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.save(objBastanteo);
			tx.commit();
			retorno = 1;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			tx.rollback();
			retorno = 0;
		} finally {
			session.close();
		}

		return retorno;
	}

	public Bastanteo obtenerBastanteo(BastanteoId objBastanteoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List obtenerBastanteosxCriterios(String ruc,
			RepresentanteId idRepresentante, GrupoBastanteoId idGrupoBastanteo,
			int idTipoIntervencion) {

		Session session = HibernateUtil.getSessionFactory();
		Transaction tx = null;
		List lstResultado = new ArrayList<Bastanteo>();
		String select = "";
		Query query = null;

		try {

			tx = session.beginTransaction();
			select = "select "
					+ "e.razon_social as RAZSOC,CONCAT(re.APE_PATERNO, CONCAT(' ',re.APE_MATERNO),CONCAT(' ',re.NOMBRE)) AS REPRESENTANTE,gb.descripcion as DESCRIPT_BASTANTEO,ti.nombre AS C_TIPO_INTERVENCION,b.importe_min as IMPORTE_MIN,"
					+ "b.importe_max AS IMPORTE_MAX, b.fecha_ini AS FECINI, b.fecha_fin AS FECFIN,p.nombre AS NOMBRE_PODER "
					+ "from empresa e "
					+ "inner join grupo_bastanteo gb "
					+ "on e.c_empresa=gb.c_empresa "
					+ "inner join representante re "
					+ "on gb.c_empresa=re.c_empresa_fk "
					+ "and gb.c_grupo_bastanteo=re.c_grupo_bastanteo_fk "
					+ "inner join bastanteo b "
					+ "on b.c_empresa=gb.c_empresa and b.c_grupo_bastanteo=gb.c_grupo_bastanteo "
					+ "inner join poder p on b.c_poder=p.c_poder "
					+ "inner join tipo_intervencion ti on ti.c_tipo_intervencion=b.c_tipo_intervencion "
/*
			if (ruc != null) {
				select += " where e.ruc=:ruc";
			} else {
				if (idRepresentante != null) {
					select += " where re.c_empresa=:idRep1 and re.c_representante=:idRep2";
				} else {
					if (idGrupoBastanteo != null) {
						select += " where  b.c_grupo_bastanteo=:idGrupoBas";
					} else {
						if (idTipoIntervencion != -1) {
							select += " where b.c_tipo_intervencion=:tipInt";
						}

					}
				}
			}
*/
					+"where e.ruc=:ruc and re.c_empresa=:idRep1 and re.c_representante=:idRep2";
					if (idGrupoBastanteo != null) {
						select += " and  b.c_grupo_bastanteo=:idGrupoBas";
					} else {
						if (idTipoIntervencion != 0) {
							select += " and b.c_tipo_intervencion=:tipInt";
						}

					}
			
			query = session
					.createSQLQuery(select)
					.addScalar("RAZSOC")
					.addScalar("REPRESENTANTE")
					.addScalar("DESCRIPT_BASTANTEO")
					.addScalar("C_TIPO_INTERVENCION")
					.addScalar("IMPORTE_MIN")
					.addScalar("IMPORTE_MAX")
					.addScalar("FECINI")
					.addScalar("FECFIN")
					.addScalar("NOMBRE_PODER")

					.setResultTransformer(
							AliasToEntityMapResultTransformer.INSTANCE);

			//if (ruc != null) {
				query.setString("ruc", ruc);
				query.setString("idRep1", idRepresentante.getCEmpresa());
				query.setInteger("idRep2",idRepresentante.getCRepresentante());
				if (idGrupoBastanteo != null) {
					query.setInteger("idGrupoBas",
							idGrupoBastanteo.getCGrupoBastanteo());
				} else {
					if (idTipoIntervencion != 0) {
						query.setInteger("tipInt", idTipoIntervencion);
					}

				}
				
			//} else {
				/*
				if (idRepresentante != null) {
				
				} else {
					if (idGrupoBastanteo != null) {
						query.setInteger("idGrupoBas",
								idGrupoBastanteo.getCGrupoBastanteo());
					} else {
						if (idTipoIntervencion != -1) {
							query.setInteger("tipInt", idTipoIntervencion);
						}

					}
				}
				*/
			//}

			lstResultado = query.list();

			tx.commit();
			return lstResultado;

		} catch (Exception e) {

			if (tx != null)
				tx.rollback();
			try {
				throw e;
			} catch (Exception e1) {

				e1.printStackTrace();
			}
		} finally {
			session.close();

		}
		return null;

	}
}
