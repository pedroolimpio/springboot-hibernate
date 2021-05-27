package com.inter.springhibernate.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inter.springhibernate.controller.dto.AddTravelDTO;
import com.inter.springhibernate.enums.TravelTypeEnum;
import com.inter.springhibernate.factory.TravelFactory;
import com.inter.springhibernate.factory.impl.TravelFactoryImpl;
import com.inter.springhibernate.model.Travel;
import com.inter.springhibernate.repositories.TravelRepository;

@Service
public class TravelService {

	private TravelFactory factory;
	private List<Travel> travels;
	
	public void createFactory() {
		if (factory == null) {
			factory = new TravelFactoryImpl();
		}
	}
	
	public void createTravelList() {
		if (travels == null) {
			travels = new ArrayList<>();
		}
	}
	
	public boolean isJSONValid(String jsonInString) {
		
		try {
			return new ObjectMapper().readTree(jsonInString) != null;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	public long parseId(JSONObject travel) {
		return Long.valueOf((int) travel.getInt("id"));
	}
	
	private BigDecimal parseAmount(String amount) {
		return new BigDecimal(amount);
	}
	
	public void setTravelValues(AddTravelDTO requestTravel, Travel travel) {
		
		String orderNumber = requestTravel.getOrderNumber();
		String type = requestTravel.getType();
		
		travel.setOrderNumber(orderNumber != null ? orderNumber : travel.getOrderNumber());
		travel.setAmount(requestTravel.getAmount() != null ? parseAmount(requestTravel.getAmount()) : travel.getAmount());
		travel.setType(type != null ? TravelTypeEnum.getEnum(type) : travel.getType());
		
	}
	
	public Travel createTravel(AddTravelDTO aTravel, TravelRepository travelRepository) {
		
		createFactory();
		
		Travel travel = factory.createTravel((String) aTravel.getType());
		travel.setId(aTravel.getId());
		setTravelValues(aTravel, travel);
		
		travelRepository.save(travel);
		
		return travel;
		
	}
	
	public Travel update(Travel travel, AddTravelDTO jsonTravel) {
		
		setTravelValues(jsonTravel, travel);
		return travel;
		
	}
	
	public void add(Travel travel) {
	
		createTravelList();
		travels.add(travel);
	
	}
	
	public List<Travel> find() {
		
		createTravelList();
		return travels;
		
	}
	
	public Travel findById(long id) {
		if (travels != null && travels.stream().count() > 0) {
			try {
				return travels.stream().filter(t -> id == t.getId()).collect(Collectors.toList()).get(0);	
			} catch (Exception e) {}
		}
		
		return null;
		
	}
	
	public void delete() {
		if (travels != null)
		travels.clear();
	}
	
	public void clearObjects() {
		travels = null;
		factory = null;
	}
	
}
