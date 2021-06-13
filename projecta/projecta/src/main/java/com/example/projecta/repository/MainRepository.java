package com.example.projecta.repository;



import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.projecta.model.AktywnyPracownik;
import com.example.projecta.model.Pracownik;
import com.example.projecta.model.Test;




@Repository
@Transactional (propagation = Propagation.REQUIRED) 
	
public interface MainRepository  {

	void deleteByID(int id);

	void editData(int id, Optional<Object> val1, Optional<Object> val2, Optional<Object> val3);


	Integer saveData(Object data);

	List<AktywnyPracownik> getAll();
	
	List<AktywnyPracownik> getAllByCell(  );

	List<AktywnyPracownik> getAllByCellAktywnyPracownikTest();

	List<Object> getOnlyOne();

	Integer getSingelCellById(int id);

	

}
