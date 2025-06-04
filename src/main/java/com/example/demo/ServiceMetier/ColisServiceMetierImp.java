package com.example.demo.ServiceMetier;

import com.example.demo.ModelDomain.Colis;
import com.example.demo.repository.ColisRepository;

public class ColisServiceMetierImp implements ColisServiceMetier {

    private final ColisRepository colisRepository;


    public  ColisServiceMetierImp(ColisRepository colisRepository){
        
        this.colisRepository = colisRepository;
    }
       
    
    public Colis updateColis(Long id, Colis updatedColis){

         return colisRepository.findById(id)
         .map(existing -> {
            existing.setAdresseDépart(updatedColis.getAdresseDépart());
            existing.setDestination(updatedColis.getDestination());
            existing.setDescription(updatedColis.getDescription());
            existing.setFragiliteColis(updatedColis.getFragiliteColis());

            return colisRepository.save(existing);
         }).orElseThrow(()-> new RuntimeException("Colis non trouvé avec l'ID : " + id));
         
         
    }


}
