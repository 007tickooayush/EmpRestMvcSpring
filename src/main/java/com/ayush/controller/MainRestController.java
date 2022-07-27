package com.ayush.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

class DemoReponseRest{
	private Long id;
	private String name;
	
	public DemoReponseRest() {
		// TODO Auto-generated constructor stub
	}
	
	public DemoReponseRest(Long id, String name) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
	}
	
	static List<DemoReponseRest> createUsers(){
		List<DemoReponseRest> usersList = new ArrayList<DemoReponseRest>();
		
		for(int i=0;i<20;i++) {
			usersList.add(new DemoReponseRest(Long.valueOf(i),"Ayush"+i));
		}			
		
		return usersList;
	}
}



@RestController
public class MainRestController {

	private Gson gson;
	
	
	@RequestMapping(value="/api-demo",method=RequestMethod.GET,produces = {"application/json"})
	public ResponseEntity<?> getAll(){
		
		List<DemoReponseRest> list = DemoReponseRest.createUsers();
		gson = new Gson();
		
		String jsonResp = gson.toJson(list);
		
		return new ResponseEntity<>(jsonResp,HttpStatus.OK);
	}
}
