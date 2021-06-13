package com.example.apzumi2.testrepository;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.apzumi2.Apzumi2Application;
import com.example.apzumi2.model.PostContentModel;
import com.example.apzumi2.repository.PostContentRepositoryInter;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes=com.example.apzumi2.Apzumi2Application.class)
public class PostContentRepositoryTest {

	@Autowired
	PostContentRepositoryInter postContentRepositoryInter;
	
	 @Autowired
	    private TestEntityManager entityManager;

	/* 
		 @Test
		 @DisplayName("Testing Test ")
		 public void whenOrElseGetAndOrElseOverlap_thenCorrect() {
		     String text = null;
	
		     String defaultText = Optional.ofNullable(text).orElse("Default Value");
		     assertEquals("Default Value", defaultText);
	
		     defaultText = Optional.ofNullable(text).orElse("123123123");
		     assertEquals("Default Value", defaultText);
		 }
	 */
		@Test
		public void test_saveListData() {
			
			Integer last = postContentRepositoryInter.getLastData();
			
			entityManager.clear();
			entityManager.flush();
		    List<PostContentModel> list = new ArrayList<PostContentModel>();
			PostContentModel post = new PostContentModel();
			post.setTitle("Post1");
			post.setBody("Boody 1");
			post.setUserId(56);
			
			list.add(post);
			PostContentModel post2 = new PostContentModel();
			post.setTitle("Post2");
			post.setBody("Body 2");
			post.setUserId(23);
			list.add(post2);
			
			
		    entityManager.persist(list);
		    entityManager.flush();

		   
		   postContentRepositoryInter.saveListData(list);
		   Integer lastafter = postContentRepositoryInter.getLastData();
		   
		    assertThat(last).isNotEqualTo(lastafter);
		    
		}
	
	@Test
	public void test_getAllByCell() {
		
	    // given
		PostContentModel post = new PostContentModel();
		post.setId(14);
		post.setTitle("Postownik");
		post.setBody("Boody 1");
		post.setUserId(56);
		
	    entityManager.persist(post);
	    entityManager.flush();

	    PostContentModel found = (PostContentModel) postContentRepositoryInter.getAllByCell(post.getTitle());
	    
	    assertThat(found.getTitle()).isEqualTo(post.getTitle());
	}
	
	@Test
	public void test_editTwoFieldsById() {
	
		
		PostContentModel post = new PostContentModel();
		post.setTitle("Post1");
		post.setBody("Boody 1");
		post.setUserId(56);
		
	    entityManager.persist(post);
	    entityManager.flush();
	    
	    PostContentModel post2 = new PostContentModel();
		post.setTitle("Post34");
		post.setBody("Boody 45");
		post.setUserId(58);
		
	    entityManager.persist(post2);
	    entityManager.flush();

	    String new_title="Tytul_edit";
	    String new_body="Body_edit";
	    postContentRepositoryInter.editTwoFieldsById(1, new_title, new_body );
	   	    
	    PostContentModel found = (PostContentModel) postContentRepositoryInter.getAllByCell(new_title);
	    
	    assertThat(found.getTitle()).isEqualTo(new_title);
	    assertThat(found.getBody()).isEqualTo(new_body);
	}
	

	
	@Test
	public void test_deleteByID() {
		
		Integer last = postContentRepositoryInter.getLastData();
		postContentRepositoryInter.deleteByID(1);
		Integer lastafter = postContentRepositoryInter.getLastData();
	    
	    assertThat(last).isNotEqualTo(lastafter);
	
	}
	

	//
	@Test
	public void test_getLastData() {
		
		
		Integer last=postContentRepositoryInter.getLastData();
		PostContentModel post = new PostContentModel();
		post.setTitle("Title1");
		post.setBody("Body 1");
		post.setUserId(56);
		
	    entityManager.persist(post);
	    entityManager.flush();

	    Integer lastafter = postContentRepositoryInter.getLastData();
	    
	    assertThat(last).isNotEqualTo(lastafter);
	}
	//
	  
	
}
