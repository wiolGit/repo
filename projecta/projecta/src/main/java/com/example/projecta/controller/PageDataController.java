package com.example.projecta.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projecta.model.AktywnyPracownik;
import com.example.projecta.model.Pracownik;
import com.example.projecta.model.Test;
import com.example.projecta.repository.MainRepository;

@RestController
@RequestMapping("/content")

public class PageDataController implements ControllerInterface {

	@Autowired
	@Qualifier("aktywnyPracownikRepository")
	MainRepository mainRepositoryAP;
	@Autowired
	@Qualifier("pracownikRepository")
	MainRepository mainRepositoryP;

	

	
	
	@Override
	public List<AktywnyPracownik> getAllByCellP( ) {
	
		return (List<AktywnyPracownik>)(Object)mainRepositoryP.getAllByCell();
	}
	
	
	@Override
	public List<AktywnyPracownik> getAllByCellAP(  ) {
	
		return (List<AktywnyPracownik>)(Object)mainRepositoryAP.getAllByCell();
	}
	

	@Override
	public List<AktywnyPracownik> getAllAP() {
	
	 return (List<AktywnyPracownik>)(Object)mainRepositoryAP.getAll();
	//  return  mainRepositoryAP.getAllByCellAktywnyPracownikTest();
	}
	
	@Override
	public List<AktywnyPracownik> getAllP() {
	
	  return	(List<AktywnyPracownik>)(Object)mainRepositoryP.getAll();
	}
	

	
	
	@Override
	public void delete(int id) {
		mainRepositoryAP.deleteByID(id);
		mainRepositoryP.deleteByID(id);
		
	}
	
	@Override
	public void deleteP(int id) {
		mainRepositoryP.deleteByID(id);
		
	}
	
	@Override
	public void deleteAP(int id) {
		mainRepositoryAP.deleteByID(id);
		
	}

	@Override
	public void editData(int id, String val1, String val2, String val3) {
		
		mainRepositoryP.editData(id,    Optional.of(val1),  Optional.of(val2),  Optional.of(val3) );
		mainRepositoryAP.editData(id,   Optional.of(val1),  Optional.of(val2),  Optional.of(val3) );
	}


	


	
	
	@Override
	public void saveData(AktywnyPracownik data) {
		
		Pracownik pr = new Pracownik();
		pr.setName(data.getName());
		pr.setAktywnypracownik(data);
		data.setPracownik(pr);
	    Integer id =	mainRepositoryP.saveData(pr);	
	    System.out.println("ID "+id);
	    mainRepositoryAP.saveData(data);
		
	}
	
	@Override
	public void saveDataP(Object data) {
	
		mainRepositoryP.saveData(data);
	}
	
	@Override
	public void saveDataAP(Object data) {
	
		
		mainRepositoryAP.saveData(data);
	}







	
 
}
