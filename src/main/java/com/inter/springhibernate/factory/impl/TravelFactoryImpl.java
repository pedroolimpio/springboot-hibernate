package com.inter.springhibernate.factory.impl;

import com.inter.springhibernate.enums.TravelTypeEnum;
import com.inter.springhibernate.factory.TravelFactory;
import com.inter.springhibernate.model.Travel;

public class TravelFactoryImpl implements TravelFactory {

	@Override
	public Travel createTravel(String type) {
	
		if (TravelTypeEnum.ONE_WAY.getValue().equals(type)) {
			return new Travel(TravelTypeEnum.ONE_WAY);
		} else if (TravelTypeEnum.MULTI_CITY.getValue().equals(type)) {
			return new Travel(TravelTypeEnum.MULTI_CITY);
		}
		
		return new Travel(TravelTypeEnum.RETURN);	
		
	}

}
