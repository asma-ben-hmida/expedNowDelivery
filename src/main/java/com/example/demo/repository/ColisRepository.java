package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.ModelDomain.Colis;

public interface ColisRepository extends JpaRepository<Colis, Long>{

}
