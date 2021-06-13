package com.example.apzumi2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apzumi2.model.PostContentModel;
import com.example.apzumi2.repository.ConfigInter;
import com.example.apzumi2.repository.PostContentRepositoryInter;


@Service
public class ScheduleServiceImpl  implements   ScheduleServiceInter  {

	

	@Autowired
	SetHttpUrlConnectionImpl setHttpUrlConnectionImpl;
	@Autowired
	ConfigInter configInter;
	@Autowired
	PostContentRepositoryInter postContentRepositoryInter;
	

    private  List<PostContentModel> mapobj = new ArrayList<PostContentModel>();

    
    @Override
	public void startGetContentService(){
		
		mapobj = setHttpUrlConnectionImpl.callGetConsentService();
		
		Integer maxId = configInter.getSingelCellById(1);
		mapobj = mapobj.stream().filter(li -> li.getId()>maxId).collect(Collectors.toList());		
		postContentRepositoryInter.saveListData( (mapobj = mapobj.stream().filter(li -> li.getId()>maxId).collect(Collectors.toList()) ));
		Integer last = postContentRepositoryInter.getLastData();
		configInter.updateSigleCellByID(1, last);
		
	}
	
	

}
