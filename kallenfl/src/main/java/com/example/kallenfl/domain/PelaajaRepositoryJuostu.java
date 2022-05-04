package com.example.kallenfl.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PelaajaRepositoryJuostu extends CrudRepository<Pelaaja, Long> {

    List<Pelaaja> findById(long id);

    
}