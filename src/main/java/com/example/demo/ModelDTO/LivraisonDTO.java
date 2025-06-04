package com.example.demo.ModelDTO;

import java.time.LocalDate;
import java.util.Date;

import com.example.demo.ModelDomain.LivraisonStatus;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LivraisonDTO {

    @NotNull(message = "id obligatoire")
    private Long id;
   @NotEmpty
    private LivraisonStatus statut;
      
    @NotNull(message = "dateCreationDemande is mandatory")
     private LocalDate datePrevuLivraison;
 
     @NotEmpty
    private Long demandeLivraisonId;  
   @NotNull
    private Long livreurId;
}
