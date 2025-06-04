package com.example.demo.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ServiceApplicatif.LivraisonServiceApplicatif;

@RestController
@RequestMapping("/")

public class LivraisonController {

    private final LivraisonServiceApplicatif livraisonServiceApplicatif;

    public LivraisonController(LivraisonServiceApplicatif livraisonServiceApplicatif){
        this.livraisonServiceApplicatif=livraisonServiceApplicatif;
    }

@PreAuthorize("hasAnyRole('LIVREUR_PERMANENT', 'LIVREUR_OCCASIONNEL')")


}
