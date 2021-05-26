package com.inter.springhibernate.factory;

import com.inter.springhibernate.model.Travel;

public interface TravelFactory {

	Travel createTravel(String type);
	
}
