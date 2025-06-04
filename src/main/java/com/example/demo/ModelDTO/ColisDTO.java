package com.example.demo.ModelDTO;
import com.example.demo.ModelDomain.FragiliteColis;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter
public class ColisDTO {
 
     private Long id;
    private String description;

    @NotBlank(message = "champ obligatoire")
    private String destinataire;

    @NotBlank(message = "champ obligatoire")
    private String   adresseDépart;
    private FragiliteColis fragiliteColis;
    private Long demandeLivraisonId;


    public ColisDTO( Long id,String   adresseDépart,String description,String destinataire, FragiliteColis fragiliteColis, Long demandeLivraisonId){
       
        this.id = id;
        this.description = description;
        this.destinataire = destinataire;
        this.adresseDépart =adresseDépart;
        this.fragiliteColis = fragiliteColis;
        this.demandeLivraisonId = demandeLivraisonId;
    }
}
