package com.sulamerica.increaseapprate.services;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sulamerica.increaseapprate.entities.Rate;
import com.sulamerica.increaseapprate.repositories.RateRepository;
import com.sulamerica.increaseapprate.services.exceptions.ObjectNotFoundException;
import com.sulamerica.increaseapprate.services.exceptions.RateInNotPassedTheConditionException;



@Service
public class RateService {

	@Autowired
	private RateRepository rateRepository;
	
	
	public Rate search(Long id) {
		Optional<Rate> obj = rateRepository.findById(id);
		return obj.orElse(null);
	}
	
	public Rate findByuId(Long uId) {
		Rate obj = rateRepository.findByuId(uId);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado uId: " + uId);
		}
		
		LocalDate today = LocalDate.now();
		long days = ChronoUnit.DAYS.between(obj.getRatedIn(), today);
		if(days < 90) {
			throw new RateInNotPassedTheConditionException("A data de avaliação não passou dos 90 dias: " + obj.getRatedIn() + days);
		}
		return obj;
	}
	
	public List<Rate> getAll() {
		List<Rate> obj = rateRepository.findAll();
		return obj;
	}
	
	public Rate createRate(Rate data) {
		Rate obj = rateRepository.save(data);
		return obj;
	}
}
