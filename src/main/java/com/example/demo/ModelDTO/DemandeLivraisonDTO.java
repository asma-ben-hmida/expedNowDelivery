package com.example.demo.ModelDTO;

import java.time.LocalDate;
import java.util.List;
import com.example.demo.ModelDTO.ColisDTO;
import com.example.demo.ModelDTO.UserDTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import com.example.demo.ModelDTO.LivraisonDTO;
import com.example.demo.ModelDomain.DemandeLivraisonStatus;



@Data
@Getter
@Setter
public class DemandeLivraisonDTO {

    private Long id;
    private DemandeLivraisonStatus status;
    private LocalDate dateCreationDemande;
    
    private Long clientId;
    private String clientNom; 

    private Long livreurId;
    private String livreurNom; 

    private List<ColisDTO> colis;
    private List<LivraisonDTO> livraisons;
}

