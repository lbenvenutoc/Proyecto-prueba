package bastanteo.cloud.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.AliasToEntityMapResultTransformer;

import bastanteo.cloud.bean.Poder;
import bastanteo.cloud.bean.Representante;
import bastanteo.cloud.util.HibernateUtil;

public class PoderDaoImp implements PoderDao {

	public void registrarPoder(Poder objPoder) {

		Session session = HibernateUtil.getSessionFactory();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(objPoder);
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}

	}

	public Poder obtenerPoder(String codigo) {

		Session session = HibernateUtil.getSessionFactory();
		Poder objPoder = null;
		objPoder = (Poder) session.load(Poder.class, codigo);

		return objPoder;

	}

	@Override
	public List verificarPoder(String ruc, String dni, String codigoPoder,
			double importe) {

		Session session = HibernateUtil.getSessionFactory();
		Transaction tx = null;
		List lstResultado = new ArrayList();
		String select = "";
		Query query = null;

		try {

			tx = session.beginTransaction();
			select = "select p.c_poder as COD_PODER,p.nombre AS NOM_PODER,b.importe_min AS IMPORTE_MIN,b.importe_max AS IMPORTE_MAX,b.fecha_ini AS FECHA_INI,b.fecha_fin AS FECHA_FIN "
					+ "from representante r "
					+ "inner join empresa e "
					+ "on e.c_empresa=r.c_empresa "
					+ "inner join grupo_bastanteo gb "
					+ "on r.c_empresa_fk=gb.c_empresa and gb.c_grupo_bastanteo=r.c_grupo_bastanteo_fk "
					+ "inner join bastanteo b "
					+ "on gb.c_empresa=b.c_empresa and gb.c_grupo_bastanteo=b.c_grupo_bastanteo "
					+ "inner join poder p "
					+ "on p.c_poder=b.c_poder "
					+ "left join d_bastanteo_grupo dgb "
					+ "on gb.c_empresa=dgb.c_empresa and gb.c_grupo_bastanteo=dgb.c_grupo_bastanteo "
					+ "where p.c_poder=:codPoder and e.ruc=:ruc and r.num_doc_id=:dni and b.importe_min <= :importe and b.importe_max >= :importe";
			
			query = session.createSQLQuery(select)
			.addScalar("COD_PODER")
			.addScalar("NOM_PODER")
			.addScalar("IMPORTE_MIN")
			.addScalar("IMPORTE_MAX")
			.addScalar("FECHA_INI")
			.addScalar("FECHA_FIN")
			.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
			query.setString("codPoder", codigoPoder);
			query.setString("ruc", ruc);
			query.setString("dni", dni);
			query.setDouble("importe", importe);
			
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
