package com.sulamerica.increaseapprate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sulamerica.increaseapprate.entities.Rate;

@Repository
public interface RateRepository extends JpaRepository<Rate, Long> {

	@Transactional(readOnly = true)
	Rate findByuId(Long uId);
}
