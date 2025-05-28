package com.example.demo.Controller;
import com.example.demo.ServiceApplicatif.DemandeLivraisonServiceApp;

import java.net.http.HttpRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ModelDTO.DemandeLivraisonDTO;
import com.example.demo.ModelDTO.LivraisonDTO;
import com.example.demo.ModelDomain.DemandeLivraison;


@RestController
@RequestMapping("/Demande")
public class DemandeLivraisonController {

    private final DemandeLivraisonServiceApp demandeLivraisonServiceApp;

    public DemandeLivraisonController(DemandeLivraisonServiceApp demandeLivraisonServiceApp){
        this.demandeLivraisonServiceApp = demandeLivraisonServiceApp;
    }

    @PostMapping("/savedemande")
    public ResponseEntity<DemandeLivraisonDTO> saveDemandeLivraison(@RequestBody  DemandeLivraisonDTO demandeLivraisonDTO){
          
         DemandeLivraisonDTO savedDemande = demandeLivraisonServiceApp.saveDemandeLivraison(demandeLivraisonDTO);
         return ResponseEntity.status(HttpStatus.CREATED).body(savedDemande);
      
        }

    @PostMapping("/savelivraison")
    public ResponseEntity<LivraisonDTO> saveLivraison(@RequestBody LivraisonDTO livraisonDTO){
        LivraisonDTO savedLivraison = demandeLivraisonServiceApp.saveLivraison(livraisonDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedLivraison);
    }

    
    @PutMapping("/{id}")
    //pathvariable: recupere un variable dynamique depuia l url 
    public ResponseEntity<DemandeLivraisonDTO> update(@PathVariable Long id,@RequestBody DemandeLivraisonDTO updatedDemande){

        DemandeLivraisonDTO demandeUpdated= demandeLivraisonServiceApp.update(id, updatedDemande);
        return ResponseEntity.ok(demandeUpdated);
    }
  
     @PutMapping("/{id}")
     public ResponseEntity<DemandeLivraisonDTO> annulerDemandeParClient(@PathVariable Long id,@RequestBody DemandeLivraisonDTO demandeLivraisonDTO){
        DemandeLivraisonDTO demandeAnnuler = demandeLivraisonServiceApp.annulerDemandeParClient(demandeLivraisonDTO, id);
        return ResponseEntity.ok(demandeAnnuler);
     }
}
