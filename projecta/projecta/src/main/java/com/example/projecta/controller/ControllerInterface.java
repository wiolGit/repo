package com.example.projecta.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.projecta.model.AktywnyPracownik;
import com.example.projecta.model.Pracownik;
import com.example.projecta.model.Test;



@RestController
@RequestMapping("/main")
public interface ControllerInterface {


    
	  @RequestMapping(value ="/ap/", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    List<AktywnyPracownik> getAllAP();
    
    @RequestMapping(value = "/p/", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    List<AktywnyPracownik> getAllP();
    
    @RequestMapping(value ="/byfield/p/", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	List<AktywnyPracownik> getAllByCellP( );

    @RequestMapping(value ="/byfield/ap/", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
 	List<AktywnyPracownik> getAllByCellAP();

    
    

    @GetMapping("/delete/{id}")
    public void delete( @PathVariable int id);

    @GetMapping("/delete/ap/{id}")
    public void deleteAP( @PathVariable int id);

    @GetMapping("/delete/p/{id}")
    public void deleteP( @PathVariable int id);
    
    @PostMapping(value = "/edit/{id}"  )
 //   @ResponseBody
    public void editData(  @PathVariable int id, @RequestParam (required = false) String val1, @RequestParam (required = false)  String val2, @RequestParam (required = false)  String val3 );


    @RequestMapping(value = "/savedata/"  )
	 @ResponseBody
    public void saveData(@ModelAttribute AktywnyPracownik data);


   
    @RequestMapping(value = "/savedata/p/", consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
    public void saveDataP(@RequestBody Object data);
    
    //@PostMapping("/savedata/ap/")
    @RequestMapping(value = "/savedata/ap/", consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
    public void saveDataAP(@RequestBody Object data);



    

}
