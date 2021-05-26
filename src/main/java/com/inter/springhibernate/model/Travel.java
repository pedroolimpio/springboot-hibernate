package com.inter.springhibernate.model;

import java.math.BigDecimal;

import com.inter.springhibernate.enums.TravelTypeEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Travel {	

	private Long id;
	private String orderNumber;
	private BigDecimal amount;
	private TravelTypeEnum type;

	public Travel(TravelTypeEnum type) {
		this.type = type;
	}

}
