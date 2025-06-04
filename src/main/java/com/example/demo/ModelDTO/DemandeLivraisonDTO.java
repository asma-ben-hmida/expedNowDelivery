package com.example.demo.ModelDTO;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class DemandeLivraisonDTO {

    @NotNull(message = "dateCreationDemande is mandatory")
    private LocalDate dateCreationDemande;
    
    @NotNull(message = "clientId is mandatory")
    private Long clientId; 

    @NotEmpty(message = "colis cannot empty")
    private List<ColisDTO> colis;

    

}

