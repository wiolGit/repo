package com.example.apzumi2.testcontroller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import com.example.apzumi2.controller.ControllerInterface;
import com.example.apzumi2.model.PostContentModel;
import com.example.apzumi2.repository.PostContentRepository;
import static org.mockito.BDDMockito.*;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import org.springframework.web.context.WebApplicationContext;



@RunWith(SpringRunner.class)
@WebMvcTest
@ContextConfiguration(classes=com.example.apzumi2.controller.ControllerInterface.class)
public class PageDataControllerIntegrationTest  {

	
	  @Autowired
	    private MockMvc mvc;

	  @Autowired
	  PostContentRepository postContentRepository;
	  @Autowired
	  ControllerInterface controllerInterface;
	  @Autowired
	  WebApplicationContext webApplicationContext; 
	  
	

	  
	  @Test
	  @DisplayName("Get All Data controller ===================================================== ")
	  public void getAll_Controller_Test()
	    throws Exception {
	      
		  PostContentModel post = new PostContentModel();
			post.setTitle("Post2");
			post.setBody("Body_222");
			post.setUserId(23);

		 List<PostContentModel> allPost= Arrays.asList(post);
		 List<PostContentModel> getRepo = (List<PostContentModel>)(Object)postContentRepository.getAll();
			 
	      given( getRepo).willReturn(allPost);
	     
	      mvc.perform(get("/content/")
	        .contentType(MediaType.APPLICATION_JSON))
	        .andDo(print())
	        .andExpect(status().isOk())
	        .andExpect(MockMvcResultMatchers.jsonPath("$.content").exists())
	        .andExpect(jsonPath("$[0].body", is(post.getBody())));
	     //   
	     //   .andExpect(MockMvcResultMatchers.jsonPath("$.content[*].id").isNotEmpty());
	   
	  }
	  
	  
		  
	
	//         @GetMapping("/byfield/{title}")
	//List<Object> getAllByCell(@PathVariable String title);


	
	  @Test
	  public void getById_Controller_Test()
	    throws Exception {
	      
		  PostContentModel post = new PostContentModel();
			post.setTitle("Title111");
			post.setBody("Body_getByCell");
			post.setUserId(23);

		 List<PostContentModel> allPost= Arrays.asList(post);
		 List<PostContentModel> getRepo = (List<PostContentModel>)(Object)postContentRepository.getAllByCell("Body_getByCell");
			 
	      given( getRepo).willReturn(allPost);
	     
	
	      mvc.perform(get("/byfield/Title111")
	  	        .contentType(MediaType.APPLICATION_JSON))
	  	        .andDo(print())
	  	        .andExpect(status().isOk())
	            .andExpect(MockMvcResultMatchers.jsonPath("$.content").exists())
	            .andExpect(jsonPath("$[0].title", is(post.getTitle())));
	      // .andExpect(MockMvcResultMatchers.jsonPath("$.content[*].id").isNotEmpty());
	  }
	  
	  

	//     @PostMapping("/edit/{id}")
 //   public void edit(  @PathVariable int id, @RequestParam (required = false) String title, @RequestParam (required = false)  String body );

	  @Test
	  public void edit_Controller_Test()
	    throws Exception {
	      
		  PostContentModel post = new PostContentModel();
			post.setTitle("Post2");
			post.setBody("Body_getByCell");
			post.setUserId(23);
			post.setId(22);

		 List<PostContentModel> allPost= Arrays.asList(post);
		 List<PostContentModel> getRepo = (List<PostContentModel>)(Object)postContentRepository.getAllByCell("Body_getByCell");
			 
	      given( getRepo).willReturn(allPost);
	      doNothing().when(postContentRepository).editTwoFieldsById(22, post.getTitle(), post.getBody()); 
	
	      mvc.perform( MockMvcRequestBuilders.put("/content/edit/1").param("title", "Edit_test_controller").param("body","Edit_body_tsetcontroller")
          ).andExpect(status().isOk());
	 
	  }
	  
	  
	
//	   @PostMapping("/delete/{id}")
 //   public void delete( @PathVariable int id);
	
	  @Test
	  public void delete_Controller_Test()
	    throws Exception {
	      
		  PostContentModel post = new PostContentModel();
			post.setTitle("Post2");
			post.setBody("Body_getByCell");
			post.setUserId(23);

		 List<PostContentModel> allPost= Arrays.asList(post);
		 List<PostContentModel> getRepo = (List<PostContentModel>)(Object)postContentRepository.getAllByCell("Body_getByCell");
			 
	      given( getRepo).willReturn(allPost);
	     doNothing().when(postContentRepository).deleteByID(post.getId());
	      
	      postContentRepository.deleteByID(0);
	      this.mvc.perform(get("/content/delete/1")).andExpect(status().isOk()) ;
	      
	      mvc.perform( MockMvcRequestBuilders.delete("/content/delete/1")
	              ).andExpect(status().isOk());
	  }


}
