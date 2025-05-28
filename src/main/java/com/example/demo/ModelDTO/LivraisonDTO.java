package com.example.demo.ModelDTO;

import java.util.Date;

import com.example.demo.ModelDomain.LivraisonStatus;

import lombok.Data;

@Data
public class LivraisonDTO {

    private Long id;
    private LivraisonStatus statut;
    private Date dateLivraison;

    private Long demandeLivraisonId;  
    private Long livreurId;
    private String livreurNom;      
}
