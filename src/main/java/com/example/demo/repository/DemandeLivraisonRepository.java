package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.ModelDomain.DemandeLivraison;

@Repository
public interface DemandeLivraisonRepository  extends JpaRepository<DemandeLivraison, Long>{

}
