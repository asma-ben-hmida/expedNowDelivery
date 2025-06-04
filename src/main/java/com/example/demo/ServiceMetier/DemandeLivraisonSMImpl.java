package com.example.demo.ServiceMetier;

import org.springframework.stereotype.Service;

import com.example.demo.ModelDomain.Colis;
import com.example.demo.ModelDomain.DemandeLivraison;
import com.example.demo.ModelDomain.DemandeLivraisonStatus;
import com.example.demo.ModelDomain.Livraison;
import com.example.demo.ModelDomain.LivraisonStatus;
import com.example.demo.repository.ColisRepository;
import com.example.demo.repository.DemandeLivraisonRepository;
import com.example.demo.repository.LivraisonRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.ModelDomain.User;
import com.example.demo.ModelDomain.UserRole;
import com.example.demo.ServiceMetier.ColisServiceMetier;
import com.example.demo.ServiceMetier.LivraisonServiceMetier;
import java.util.List;

import java.util.Date;
import java.util.Set;


@Service
public class DemandeLivraisonSMImpl implements DemandeLivraisonServiceMetier{


    private DemandeLivraisonRepository demandeLivraisonRepository;
        private UserMetierService userMetierService;
         private UserRepository userrRepository;
         private ColisServiceMetier colisServiceMetier;
         private ColisRepository colisRepository;
         private LivraisonServiceMetier livraisonServiceMetier;
         private LivraisonRepository livraisonRepository;

   public DemandeLivraisonSMImpl(DemandeLivraisonRepository demandeLivraisonRepository, LivraisonRepository livraisonRepository, LivraisonServiceMetier livraisonServiceMetier,ColisServiceMetier colisServiceMetier,UserRepository userRepository,UserMetierService userMetierService)

          {
           
            this.demandeLivraisonRepository = demandeLivraisonRepository;
            this.userMetierService = userMetierService;
            this.userrRepository = userRepository;
            this.colisServiceMetier = colisServiceMetier;
            this.livraisonServiceMetier= livraisonServiceMetier;
            this.livraisonRepository = livraisonRepository;
            
          }

    public void saveDemandeLivraison(DemandeLivraison demande)
          {
           demande.setStatus(DemandeLivraisonStatus.En_ATTENTE);
           DemandeLivraison savedDemande = demandeLivraisonRepository.save(demande);
          
           Livraison livraison = new Livraison();
           livraison.setStatut(LivraisonStatus.CREER);
           livraison.setDemandeLivraison(savedDemande);
           livraisonRepository.save(livraison);
        
          }
  
  
          
     
     public DemandeLivraison update(Long id, DemandeLivraison updatedDemande) {  

        return demandeLivraisonRepository.findById(id)
        .map(existing -> {
            existing.setStatus(updatedDemande.getStatus());
            existing.setDatecreationdemande(updatedDemande.getDatecreationdemande());
             
          List<Colis> existingColisList = existing.getColis();
          List<Colis> updatedColisList = updatedDemande.getColis();

          for(int i =0 ; i<existingColisList.size();i++){
            
            Colis colisExisting = existingColisList.get(i);
            Colis colisupdated = updatedColisList.get(i);

           colisServiceMetier.updateColis(colisExisting.getId(), colisupdated);
          }


            return demandeLivraisonRepository.save(existing);
        })
        .orElseThrow(() -> new RuntimeException("Demande de livraison non trouvée avec l'ID : " + id));
}
        
           

      public void annulerDemandeParClient(Long demandeId, Long  userId ) {
    
        DemandeLivraison   demandeLivraison = demandeLivraisonRepository.findById(demandeId).orElseThrow(() -> new RuntimeException("Demande introuvable"));
        
        User    user=userrRepository.findById(userId).orElseThrow(() -> new RuntimeException("user introuvable"));


              if (!Set.of(UserRole.CLIENT_ENTREPRiSE, UserRole.CLIENT_PROFESSIONNEL).contains(user.getRole())) {
                  throw new RuntimeException("invalid role");
              }

              if (!Set.of(DemandeLivraisonStatus.En_ATTENTE, DemandeLivraisonStatus.EN_COURS).contains(demandeLivraison.getStatus())) {

                     throw new RuntimeException("invalid demande status");
                  }

                  if(!demandeLivraison.getClient().getId().equals(user.getId())){

                    throw new RuntimeException("vous n'avez pas le droit d'annuler une demande");
                  }

                  demandeLivraison.setStatus(DemandeLivraisonStatus.ANNULER);
                  saveDemandeLivraison(demandeLivraison);

            }      


            public void deleteDemande(Long id){

              if (!demandeLivraisonRepository.existsById(id)){
                throw new RuntimeException("demande non trouve");
              }
              demandeLivraisonRepository.deleteById(id);
              
            }

          
       

           

        }
        

     


     

     

                

              
              
              
        
    
 
        

    

      



