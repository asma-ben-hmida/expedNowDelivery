package com.example.demo.ModelDTO;
import com.example.demo.ModelDomain.FragiliteColis;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter
public class ColisDTO {
 
     private Long id;
    private String description;
    private String destinataire;
    private FragiliteColis fragiliteColis;
    private Long demandeLivraisonId;


    public ColisDTO( Long id,String description,String destinataire, FragiliteColis fragiliteColis, Long demandeLivraisonId){
        this.id = id;
        this.description = description;
        this.destinataire = destinataire;
        this.fragiliteColis = fragiliteColis;
        this.demandeLivraisonId = demandeLivraisonId;
    }
}
