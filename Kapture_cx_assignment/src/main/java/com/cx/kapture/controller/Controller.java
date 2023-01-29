package com.cx.kapture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cx.kapture.entities.CallDetailsDTO;
import com.cx.kapture.entities.CallDetails;
import com.cx.kapture.service.CallDetailsService;

@RestController
@RequestMapping("/api")
public class Controller {
	
	/*
	 * Hello, to perform the analytics  first configure the mysql database configuration 
	 * according to your local system in application.properties.
	 * then to add the data use url 
	 * localhost:8088/api/calldetails 
	 * and add data according to dto class.
	 * and you can call these api's to perform the analytics.
	 * Thank you.
	 */

	@Autowired
	private CallDetailsService callDetailsService;
	
	@PostMapping("/calldetails")
	public ResponseEntity<CallDetails> addData(@RequestBody CallDetailsDTO dto){
		CallDetails data=callDetailsService.addCallData(dto);
		
		return new ResponseEntity<CallDetails>(data, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/highest/hour")
	public ResponseEntity<String> highestCallByHour(){
		String ans=callDetailsService.highestCallVolumeByHour();
		
		return new ResponseEntity<String>(ans,HttpStatus.OK);
	}
	
	@GetMapping("/longest/hour")
	public ResponseEntity<String> longestCallByHour(){
		String ans=callDetailsService.longestCallVolumeByHour();
		
		return new ResponseEntity<String>(ans,HttpStatus.OK);
	}
	
	@GetMapping("/highest/day")
	public ResponseEntity<String> highestCallByDay(){
		String ans=callDetailsService.highestCallVolumeByDay();
		
		return new ResponseEntity<String>(ans,HttpStatus.OK);
	}
	
	@GetMapping("/longest/day")
	public ResponseEntity<String> longestCallByDay(){
		String ans=callDetailsService.longestCallVolumeByDay();
		
		return new ResponseEntity<String>(ans,HttpStatus.OK);
	}
	
}
