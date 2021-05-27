package com.inter.springhibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.inter.springhibernate.controller.dto.AddTravelDTO;
import com.inter.springhibernate.model.Travel;
import com.inter.springhibernate.repositories.TravelRepository;
import com.inter.springhibernate.service.TravelService;

@RestController
@RequestMapping("/api-travels/travels")
public class TravelController {

	private TravelRepository travelRepository;
	
	public TravelController(TravelRepository travelRepository) {
		this.travelRepository = travelRepository;
	}
	
	@Autowired
	private TravelService travelService;
	
	@GetMapping
	public ResponseEntity<List<Travel>> find() {
		
		return ResponseEntity.ok(travelRepository.findAll());
		
	}
	
	@DeleteMapping
	public ResponseEntity<Boolean> delete() {
		
		try {
			travelService.delete();
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
		
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Travel> create(@RequestBody AddTravelDTO travel) {
		
		try {
							
			Travel createdTravel  = travelService.createTravel(travel, travelRepository);
		
			var uri = ServletUriComponentsBuilder.fromCurrentRequest().path(createdTravel.getOrderNumber()).build().toUri();
			
			travelService.add(createdTravel);
			return ResponseEntity.created(uri).body(null);	
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
		}
		
	}
	
	@PutMapping(path = "/{id}", produces = { "application/json" })
	public ResponseEntity<Travel> update(@PathVariable("id") long id, @RequestBody AddTravelDTO travel) {
		
		try {
			
			Travel travelToUpdate = travelService.findById(id);
			
			if (travelToUpdate == null) {
				return ResponseEntity.notFound().build();
			}
			
			travelToUpdate = travelService.update(travelToUpdate, travel);
			return ResponseEntity.ok(travelToUpdate);
			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
			
		}
		
	}
	
	

}
