package com.example.projecta.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.projecta.model.AktywnyPracownik;
import com.example.projecta.model.Pracownik;


@Repository("pracownikRepository")
@Transactional (propagation = Propagation.REQUIRED) 
public class PracownikRepositoryImpl  implements MainRepository {
	
	@Autowired
	   private SessionFactory sessionfactory;
	
	



	@Override
	public void deleteByID(int id) {
		
		Session session = sessionfactory.getCurrentSession();
	    Query query=session.createQuery("delete from Pracownik where id= :pId");  
	 
	    
	    query.setParameter("pId", id);
	    query.executeUpdate();  
	}

	@Override
	public void editData(int id, Optional<Object> val1, Optional<Object> val2, Optional<Object> val3 ) {
		
		Session session = sessionfactory.getCurrentSession();
	    Query query=session.createQuery("update Pracownik set   name=: pName where id= :pId");  
	    
	    query.setParameter("pName", val1.get());
	    query.setParameter("pId", id);
	    query.executeUpdate(); 
	}
	
	@Override
	public Integer saveData( Object pracownik) {
		

	 return	(Integer) sessionfactory.getCurrentSession().save((Pracownik)pracownik);
		
	}

	
	


	@Override
	public List<AktywnyPracownik> getAllByCell( ) {
		
	//	Session session = sessionfactory.getCurrentSession();
	//   Query query=session.createQuery("select  p.id as id,  p.name as name, ap.salary as salary ,ap.dataZatrudnienia  as datazatrudnienia from Pracownik  p   left join p.aktywnypracownik ap ");  
	//    return  (List<Optional>)query.list();
	    
	    Session session = sessionfactory.getCurrentSession();
	    List<AktywnyPracownik>  out = new ArrayList<>();
	    String sql="select p.id as id, p.name as name, ap.salary as salary ,ap.dataZatrudnienia as datazatrudnienia  from Pracownik  p   inner join p.aktywnypracownik ap ";// where p.name  like  CONCAT('%', :pval, '%')";
	 
	    List<Object[]>  res = session.createQuery(  sql, Object[].class).getResultList();
		for(Object[]  row : res ) {
			AktywnyPracownik ap = new AktywnyPracownik();
			ap.setPracownik_id((int)row[0]);
			ap.setDataZatrudnienia((java.sql.Date)row[3]);
			ap.setName((String)(row[1]));
			ap.setSalary((Double)row[2]);
			out.add(ap);
		}
		return out;
	}

	
	
	
	
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Object> getOnlyOne() {
		

		Session session = sessionfactory.getCurrentSession();
		   Query query=session.createQuery("select  p.id, p.name from Pracownik  p   "); 
	   
		    return  (List<Object>)query.list();
	
	
	}
	

	@Override
	public List<AktywnyPracownik> getAllByCellAktywnyPracownikTest() {
	
		return null;
	}


	@Override
	public List<AktywnyPracownik> getAll() {
		
	    
	    Session session = sessionfactory.getCurrentSession();
	    List<AktywnyPracownik>  out = new ArrayList<>();
		List<Object[]>  res = session.createQuery(  "select p.id as id, p.name as name, ap.salary as salary ,ap.dataZatrudnienia as datazatrudnienia  from Pracownik  p   left join p.aktywnypracownik ap", Object[].class).getResultList();
		for(Object[]  row : res ) {
			AktywnyPracownik ap = new AktywnyPracownik();
			ap.setPracownik_id((int)row[0]);
			ap.setDataZatrudnienia((java.sql.Date)row[3]);
			ap.setName((String)(row[1]));
			ap.setSalary((Double)row[2]);
			out.add(ap);
		}
		return out;
	}

	@Override
	public Integer getSingelCellById(int id) {
		
		Session session;
		@SuppressWarnings("unchecked")
		Integer res = null;
		session = sessionfactory.getCurrentSession();
		try {
		
			Query query = session.createQuery(	"select  coalesce(p.id,0) from Pracownik p  where  p.id= :pId "   );
			 query.setParameter("pId", id);
			 
			res = (Integer) query.getSingleResult();
		} catch (NoResultException e) {
		
			e.printStackTrace();
		}
		
		return res;	
	}

}
