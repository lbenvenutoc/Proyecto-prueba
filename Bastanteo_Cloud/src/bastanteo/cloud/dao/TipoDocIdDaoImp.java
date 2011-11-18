package bastanteo.cloud.dao;

import org.hibernate.Session;

import bastanteo.cloud.bean.TipoDocId;
import bastanteo.cloud.util.HibernateUtil;

public class TipoDocIdDaoImp implements TipoDocIdDao {

	@Override
	public TipoDocId obtenerTipoDocId(TipoDocId objTipoDocId) {
		
		Session session = HibernateUtil.getSessionFactory();
		TipoDocId objTipoDocIdObt=null;
		try{
			objTipoDocIdObt=(TipoDocId)session.get(TipoDocId.class, objTipoDocId.getCTipoDocId());
		}catch (Exception ex) {
			System.out.println(ex);
		}finally{
			session.close();
		}
		
		
		return objTipoDocIdObt;
	}

}
