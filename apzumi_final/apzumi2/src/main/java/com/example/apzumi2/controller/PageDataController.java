package com.example.apzumi2.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apzumi2.model.PostContentModel;
import com.example.apzumi2.repository.PostContentRepositoryInter;


@RestController
@RequestMapping("/content")
public class PageDataController implements ControllerInterface {

	@Autowired
	PostContentRepositoryInter postContentRepositoryInter;

	
	@Override
	public List<Object> getAllByCell(String title) {
	
		return postContentRepositoryInter.getAllByCell( title );

	}

	@Override
	public void delete(int id) {
		postContentRepositoryInter.deleteByID(id);
		
	}

	@Override
	public void edit(int id, String title, String body) {
		postContentRepositoryInter.editTwoFieldsById( id, title, body );
		
	}


	@Override
	public List<PostContentModel> getById(int id) {
		return null;
	}

	@Override
	public List<Object> getAll() {
	  return	postContentRepositoryInter.getAll();
	}


	
 
}
