package bastanteo.cloud.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.AliasToEntityMapResultTransformer;

import bastanteo.cloud.bean.Poder;
import bastanteo.cloud.util.HibernateUtil;
import bastanteo.cloud.util.Utilitario;

public class PoderDaoImp implements PoderDao {

	public int registrarPoder(Poder objPoder) {
		int indicador=0;
		Session session = HibernateUtil.getSessionFactory();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(objPoder);
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

	public Poder obtenerPoder(String codigo) {

		Session session = HibernateUtil.getSessionFactory();
		Poder objPoder = null;
		objPoder = (Poder) session.get(Poder.class, codigo);

		return objPoder;

	}

	@Override
	public String verificarPoder(String ruc, String dni, String codigoPoder,
			double importe) {

		Session session = HibernateUtil.getSessionFactory();
		Transaction tx = null;
		List lstResultado = new ArrayList();
		String select = "";
		Query query = null;
		String mensaje = "";
		Utilitario objUtilitario = Utilitario.crearUtilitario();

		try {

			tx = session.beginTransaction();
			select = "select p.c_poder as COD_PODER,p.nombre AS NOM_PODER,b.importe_min AS IMPORTE_MIN,b.importe_max AS IMPORTE_MAX,date_format(b.fecha_ini,'%d/%m/%Y') AS FECHA_INI,date_format(b.fecha_fin,'%d/%m/%Y') AS FECHA_FIN, (case when dgb.c_grupo_bastanteo_fk is null then '-' else dgb.c_grupo_bastanteo_fk end) AS COMBINACION,ti.nombre AS INTERVENCION "
					+ "from representante r "
					+ "inner join empresa e "
					+ "on e.c_empresa=r.c_empresa "
					+ "inner join grupo_bastanteo gb "
					+ "on r.c_empresa_fk=gb.c_empresa and gb.c_grupo_bastanteo=r.c_grupo_bastanteo_fk "
					+ "inner join bastanteo b "
					+ "on gb.c_empresa=b.c_empresa and gb.c_grupo_bastanteo=b.c_grupo_bastanteo "
					+ "inner join tipo_intervencion ti "
					+ "on ti.c_tipo_intervencion=b.c_tipo_intervencion "
					+ "inner join poder p "
					+ "on p.c_poder=b.c_poder "
					+ "left join d_bastanteo_grupo dgb "
					+ "on gb.c_empresa=dgb.c_empresa and gb.c_grupo_bastanteo=dgb.c_grupo_bastanteo "
					+ "where p.c_poder=:codPoder and e.ruc=:ruc and r.num_doc_id=:dni";

			query = session.createSQLQuery(select).addScalar("COD_PODER")
					.addScalar("NOM_PODER").addScalar("IMPORTE_MIN").addScalar(
							"IMPORTE_MAX").addScalar("FECHA_INI").addScalar(
							"FECHA_FIN").addScalar("COMBINACION").addScalar(
							"INTERVENCION").setResultTransformer(
							AliasToEntityMapResultTransformer.INSTANCE);
			query.setString("codPoder", codigoPoder);
			query.setString("ruc", ruc);
			query.setString("dni", dni);

			lstResultado = query.list();

		

			if (lstResultado.size() > 0) {
				Map objResultado = (Map) lstResultado.get(0);
				if (objUtilitario.convertirCadenaPorFecha(
						objResultado.get("FECHA_INI").toString()).compareTo(
						objUtilitario.convertirCadenaPorFecha(objUtilitario
								.obtenerFechaActual())) > 0) {

					mensaje += "Aun no entra en vigencia el poder#";

				}
				if (objUtilitario.convertirCadenaPorFecha(
						objResultado.get("FECHA_FIN").toString()).compareTo(
						objUtilitario.convertirCadenaPorFecha(objUtilitario
								.obtenerFechaActual())) < 0) {

					mensaje += "El poder ya caducó#";

				}
				if (Double.parseDouble(objResultado.get("IMPORTE_MIN")
						.toString()) > importe) {
					mensaje += "La cantidad debe ser mayor o igual a "
							+ Double.parseDouble(objResultado
									.get("IMPORTE_MIN").toString()) + "#";
				}
				if (Double.parseDouble(objResultado.get("IMPORTE_MAX")
						.toString()) < importe) {
					mensaje += "La cantidad debe ser menor o igual a "
							+ Double.parseDouble(objResultado
									.get("IMPORTE_MAX").toString()) + "#";
				} else {

					mensaje += "El representante tiene el poder "
							+ objResultado.get("NOM_PODER")
									.toString()+"#";

					for (int i = 0; i < lstResultado.size(); i++) {
						Map objResultadoCombinacion = (Map) lstResultado.get(0);
						if (i == 0) {
							if (!objResultadoCombinacion.get("COMBINACION")
									.toString().equals("-")) {

								mensaje += "y requiere "
										+ objResultado.get("INTERVENCION")
												.toString()
										+ " con algun representante del grupo "
										+ objResultadoCombinacion.get(
												"COMBINACION").toString() + "#";
							}
						} else {
							mensaje += " o con algun representante del grupo "
									+ objResultadoCombinacion
											.get("COMBINACION").toString()
									+ "#";
						}

					}

				}

			} /*else {
				mensaje += "El representante no tiene asignado el poder#";
			}
			*/
			tx.commit();
			return mensaje;

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
