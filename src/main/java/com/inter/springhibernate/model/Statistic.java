package com.inter.springhibernate.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Statistic {

	private BigDecimal sum;
	private BigDecimal avg;
	private BigDecimal max;
	private BigDecimal min;
	private Long count;	

}
