package com.inter.springhibernate.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.inter.springhibernate.enums.TravelTypeEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "travels")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Travel {	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="order_number")
	private String orderNumber;
	@Column(name="amount")
	private BigDecimal amount;
	@Column(name="type")
	private TravelTypeEnum type;

	public Travel(TravelTypeEnum type) {
		this.type = type;
	}

}
