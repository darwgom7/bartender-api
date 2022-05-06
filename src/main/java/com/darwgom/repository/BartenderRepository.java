package com.darwgom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.darwgom.model.Bartender;

@Repository
public interface BartenderRepository extends JpaRepository<Bartender, Long> {

}
