package com.example.projecta.repository;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Fetch;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.hibernate.ReplicationMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.projecta.config.StringOperation;
import com.example.projecta.model.AktywnyPracownik;
import com.example.projecta.model.Pracownik;

@Repository("aktywnyPracownikRepository")
@Transactional (propagation = Propagation.REQUIRED) 
public class AktywnyPracownikImpl implements MainRepository {

	
	@Autowired
	   private SessionFactory sessionfactory;
	@Autowired
	StringOperation stringOperation;

	
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Object> getOnlyOne() {
		
		Session session = sessionfactory.getCurrentSession(); 
	    Query query=session.createQuery("select  ap.salary ,ap.dataZatrudnienia  from AktywnyPracownik ap "); 
	    return  query.list(); 
	}
	
	
	
	@Override
	@SuppressWarnings("unchecked")
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

	
    // only active workers
	@Override
	public List<AktywnyPracownik> getAllByCell(  ) {
		
	//	Session session = sessionfactory.getCurrentSession();
	//    Query query=session.createQuery("select p.id, p.name, ap.salary ,ap.dataZatrudnienia  from Pracownik  p   inner join p.aktywnypracownik ap "); 
	//    return  (List<Optional>)query.list(); 
		
	    Session session = sessionfactory.getCurrentSession();
	    List<AktywnyPracownik>  out = new ArrayList<>();
	    String sql="select p.id as id, p.name as name, ap.salary as salary ,ap.dataZatrudnienia as datazatrudnienia  from Pracownik  p   inner join p.aktywnypracownik ap ";// where p.name  like  CONCAT('%', :pval, '%')";
	 
	    List<Object[]>  res = session.createQuery(  sql, Object[].class).getResultList();
		for(Object[]  row : res ) {
			AktywnyPracownik ap = new AktywnyPracownik();
			ap.setPracownik_id ((int)row[0]);
			ap.setDataZatrudnienia((java.sql.Date)row[3]);
			ap.setName((String)(row[1]));
			ap.setSalary((Double)row[2]);
			out.add(ap);
		}
		return out;
	    
	}


	@Override
	public void deleteByID(int id) {
		
		Session session = sessionfactory.getCurrentSession();
	    Query query=session.createQuery("delete  from AktywnyPracownik   where pracownik_id=:pId");  
	 
	    
	    query.setParameter("pId", id);
	    query.executeUpdate();  
	}

	@Override
	public void editData(int id, Optional<Object> val1, Optional<Object> val2, Optional<Object> val3 ) {
		Date date1 = null;
		try {
			 date1 = new SimpleDateFormat("yyyy-MM-dd").parse(val3.get().toString());
		} catch (ParseException e) {

			e.printStackTrace();
		}
		Session session = sessionfactory.getCurrentSession();
	    Query query=session.createQuery("update     AktywnyPracownik    set     salary= :pSalary,  dataZatrudnienia=: pDataZatrudnienia where pracownik_id=:pId");
	    query.setParameter("pSalary", Double.parseDouble( (String) val2.get())  );
	    query.setParameter("pDataZatrudnienia", date1);  
	    query.setParameter("pId", id);
	    query.executeUpdate(); 
	}
	
	@Override
	public Integer saveData( Object aktywnypracownik) {
		Session session = sessionfactory.getCurrentSession();
		sessionfactory.getCurrentSession().save ( "AktywnyPracownik", (AktywnyPracownik)aktywnypracownik);

	    return 0;
	}




	@Override
	public List<AktywnyPracownik> getAllByCellAktywnyPracownikTest() {
		/*
		Session session = sessionfactory.getCurrentSession();
		 CriteriaBuilder cribuild = session.getCriteriaBuilder();
		 CriteriaQuery<AktywnyPracownik> cq = cribuild.createQuery(AktywnyPracownik.class);	 
		 Root<AktywnyPracownik> msg = cq.from(AktywnyPracownik.class);
		 cq.select(msg);
		 Query<AktywnyPracownik> query = session.createQuery( cq);	
		 List<AktywnyPracownik>  res = query.getResultList();
	    return res; 
	    */
	
	    Session session = sessionfactory.getCurrentSession();
	    List<AktywnyPracownik>  out = new ArrayList<>();
		List<Object[]>  res = session.createQuery(  "select p.id as id, p.name as name, ap.salary as salary ,ap.dataZatrudnienia as datazatrudnienia  from Pracownik  p   inner join p.aktywnypracownik ap", Object[].class).getResultList();
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
		
			Query query = session.createQuery(	"select  coalesce(p.pracownik_id,0) from AktywnyPracownik p  where  p.pracownik_id= :pId "   );
			 query.setParameter("pId", id);
			 
			res = (Integer) query.getSingleResult();
		} catch (NoResultException e) {
		
			e.printStackTrace();
		}
		
		return res;	
	}

	
}
