package com.example.demo.ModelDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class VehiculeDTO {

    private Long id;
    private String matricule;
    private Long numSerie;
    private Long userId; // Pour éviter de retourner tout l'objet User

    // Constructeur personnalisé
    public VehiculeDTO(Long id, String matricule, Long numSerie, Long userId) {
        this.id = id;
        this.matricule = matricule;
        this.numSerie = numSerie;
        this.userId = userId;
    }
}



