package com.sulamerica.increaseapprate.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sulamerica.increaseapprate.entities.Rate;
import com.sulamerica.increaseapprate.repositories.RateRepository;
import com.sulamerica.increaseapprate.services.RateService;

@RestController
@RequestMapping("/rates")
public class RateController {
	
	@Autowired
	private RateService restServ;
	
	
	@GetMapping
	public List<Rate> findAll() {
		List<Rate> obj = restServ.getAll();
		
		return obj;
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> findOne(@PathVariable Long id) {
		Rate obj = restServ.search(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/findByUId/{uId}")
	public ResponseEntity<?> findUId(@PathVariable Long uId) {
		Rate obj = restServ.findByuId(uId);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> addRate(@RequestBody Rate data) {
		Rate obj = restServ.createRate(data);
		return ResponseEntity.ok().body(obj);
	}
}
