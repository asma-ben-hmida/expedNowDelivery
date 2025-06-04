package com.example.demo.ServiceMetier;
import com.example.demo.ModelDomain.Colis;

public interface ColisServiceMetier {

    Colis updateColis(Long id, Colis updatedColis);
}
