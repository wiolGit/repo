package com.example.projecta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class WebController {

	
	@GetMapping(value="/")
    public String index1(){
        return "/index2.html";
    }
	
	@GetMapping(value="/index")
	    public String index(){
	        return "/index2.html";
	    }



}
