package com.sulamerica.increaseapprate.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Rate implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Byte rating;
	private Long uId;	
	
	@Column(nullable = false, updatable = false)
	@CreationTimestamp
	private LocalDate ratedIn;
	
	public Rate() {		
	}

	public Rate(Long id, Byte rating, Long uId, LocalDate ratedIn) {
		super();
		this.id = id;
		this.rating = rating;
		this.uId = uId;
		this.ratedIn = ratedIn;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rate other = (Rate) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Byte getRating() {
		return rating;
	}

	public void setRating(Byte rating) {
		this.rating = rating;
	}

	public Long getuId() {
		return uId;
	}

	public void setuId(Long uId) {
		this.uId = uId;
	}

	public LocalDate getRatedIn() {
		return ratedIn;
	}

	public void setRatedIn(LocalDate ratedIn) {
		this.ratedIn = ratedIn;
	}
	
	
}
