package com.inter.springhibernate.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddTravelDTO {
	
	private Long id;
	private String orderNumber;
	private String amount;
	private String type;
}
