package com.example.demo.ServiceApplicatif;

import com.example.demo.Mapper.LivraisonMapper;
import com.example.demo.ServiceMetier.LivraisonServiceMetier;

public class LivraisonServiceApplicatif {


    private LivraisonMapper livraisonMapper;
    private LivraisonServiceMetier livraisonServiceMetier;


    public LivraisonServiceApplicatif(LivraisonMapper livraisonMapper, LivraisonServiceMetier livraisonServiceMetier){
        this.livraisonMapper =livraisonMapper;
        this.livraisonServiceMetier = livraisonServiceMetier;
    }


 public void changerStatusLivraison(Long userId, Long livraisonId) {
    
 }
}
