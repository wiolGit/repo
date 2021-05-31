package com.example.apzumi2.repository;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.apzumi2.model.PostContentModel;



@Repository("postContentRepository")

public class PostContentRepository  implements PostContentRepositoryInter {

	@Autowired
	   private SessionFactory sessionfactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getAllByCell(String val1) {
		
		Session session = sessionfactory.getCurrentSession();
		Query query = session.createQuery(
		        " from PostContentModel p where  p.title like  CONCAT('%', :pval, '%')"
		    );

		query.setParameter("pval", val1);

		@SuppressWarnings("unchecked")
		List<Object> res = (List<Object>) query.list();
		return res;	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getAll() {
		
		return sessionfactory.getCurrentSession().createCriteria(PostContentModel.class).list();
		
	
	}

	@Override
	public void deleteByID(int id) {
		
		Session session = sessionfactory.getCurrentSession();
	    Query query=session.createQuery("delete from PostContentModel where id= :pId");  
	 
	    
	    query.setParameter("pId", id);
	    query.executeUpdate();  
	}

	@Override
	public void editTwoFieldsById(int id, String val1, String val2 ) {
		
		Session session = sessionfactory.getCurrentSession();
	    Query query=session.createQuery("update PostContentModel set title= :pTitle,  body=: pBody where id= :pId");  
	    
	    query.setParameter("pTitle", val1);
	    query.setParameter("pBody", val2);
	    query.setParameter("pId", id);
	    query.executeUpdate(); 
	}
	
	@Override
	public void saveListData(List<PostContentModel> postcontentmodel) {
		
		postcontentmodel.stream().forEach(p -> sessionfactory.getCurrentSession().save(p));
		
	}




	@Override
	public Integer getLastData() {
		
		Session session = sessionfactory.getCurrentSession();
		return (Integer) session.createQuery(    "select  max(p.id) from PostContentModel p   "    ).getSingleResult();
	}
	

}
