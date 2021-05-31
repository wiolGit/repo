package com.example.apzumi2.repository;



import javax.persistence.NoResultException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.apzumi2.model.ConfigTable;



@Repository("configurationRepo")
@Transactional (propagation = Propagation.REQUIRED) 
public  class ConfigurationRepo  implements ConfigInter  {
	@Autowired
	   private SessionFactory sessionfactory;
	
	@Override
	public void updateSigleCellByID(int id, Integer val1) {
		
		Session session = sessionfactory.getCurrentSession();
	    Query query=session.createQuery(" update ConfigTable set last_c= :pLast_c  where id= :pId ");  
	    //specifying class name (Emp) not tablename  
	    
	    query.setParameter("pId", id);
	    query.setParameter("pLast_c", val1);
	    query.executeUpdate();  
	}
	
	@Override
	public Integer getSingelCellById(int id) {
		
		Session session;
		@SuppressWarnings("unchecked")
		Integer res = null;
		session = sessionfactory.getCurrentSession();
		try {
		
			Query query = session.createQuery(
			      
					"select  coalesce(p.last_c,0) from ConfigTable p  where  p.id= :pId "
			    );
			 query.setParameter("pId", id);
			 
			res = (Integer) query.getSingleResult();
		} catch (NoResultException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		if (res==null) {
			ConfigTable conf = new ConfigTable();
			conf.setLast_c(0);
			session.persist(conf);
			return 0;
		}
		return res;	
	}

	

	

	
}
