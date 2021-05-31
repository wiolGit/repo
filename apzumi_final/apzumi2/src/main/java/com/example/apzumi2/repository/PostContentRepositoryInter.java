package com.example.apzumi2.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.apzumi2.model.PostContentModel;


@Repository
@Transactional (propagation = Propagation.REQUIRED) 	
public interface PostContentRepositoryInter  {

	List<Object> getAllByCell(String val1);

	List<Object> getAll();

	void deleteByID(int id);

	void editTwoFieldsById(int id, String val1, String val2);

	void saveListData(List<PostContentModel> postcontentmodel);

	Integer getLastData();
	  
	
}
