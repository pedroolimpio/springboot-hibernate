package com.inter.springhibernate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inter.springhibernate.model.Travel;

@Repository
public interface TravelRepository extends JpaRepository<Travel, Long> {

}