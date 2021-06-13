package com.example.apzumi2.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.apzumi2.model.PostContentModel;

@RestController
@RequestMapping("/main")
public interface ControllerInterface {

	

    @GetMapping("/")
    List<Object> getAll();
    
    @GetMapping("/byfield/{title}")
	List<Object> getAllByCell(@PathVariable String title);


    @GetMapping("/{id}")
    
    List<PostContentModel> getById(@PathVariable int id);

    @PostMapping("/delete/{id}")
    public void delete( @PathVariable int id);
    

    @PostMapping("/edit/{id}")
    public void edit(  @PathVariable int id, @RequestParam (required = false) String title, @RequestParam (required = false)  String body );


    
}
