package com.example.demo.ServiceMetier;

import org.springframework.stereotype.Service;

import com.example.demo.ModelDomain.DemandeLivraison;
import com.example.demo.ModelDomain.DemandeLivraisonStatus;
import com.example.demo.ModelDomain.Livraison;
import com.example.demo.ModelDomain.LivraisonStatus;
import com.example.demo.repository.DemandeLivraisonRepository;
import com.example.demo.repository.LivraisonRepository;
import com.example.demo.ModelDomain.User;
import com.example.demo.ModelDomain.UserRole;

import java.util.Date;
import java.util.Set;

@Service
public class DemandeLivraisonSMImpl implements DemandeLivraisonServiceMetier{


    private DemandeLivraisonRepository demandeLivraisonRepository;
        private LivraisonRepository livraisonRepository;
        private UserMetierService userMetierService;


   public DemandeLivraisonSMImpl(DemandeLivraisonRepository demandeLivraisonRepository, LivraisonRepository livraisonRepository,UserMetierService userMetierService)
          {
           
            this.demandeLivraisonRepository = demandeLivraisonRepository;
            this.livraisonRepository = livraisonRepository;
            this.userMetierService = userMetierService;
            
          }

    public DemandeLivraison saveDemandeLivraison(DemandeLivraison demande)
          {
          return demandeLivraisonRepository.save(demande);
          }
  
     public Livraison saveLivraison(Livraison livraison)
          {
            return livraisonRepository.save(livraison);
          }
          
     
     public DemandeLivraison update(Long id, DemandeLivraison updatedDemande) {  

        return demandeLivraisonRepository.findById(id)
        .map(existing -> {
            existing.setStatus(updatedDemande.getStatus());
            existing.setDatecreationdemande(updatedDemande.getDatecreationdemande());
            existing.setColis(updatedDemande.getColis());
            existing.setLivraison(updatedDemande.getLivraison());
            return demandeLivraisonRepository.save(existing);
        })
        .orElseThrow(() -> new RuntimeException("Demande de livraison non trouvée avec l'ID : " + id));
}
        
           

      public void annulerDemandeParClient(DemandeLivraison demandeLivraison, Long  userId ) {

        User user= userMetierService.getUserById(userId);
        
          if (demandeLivraison == null || user == null  ) {
                throw new IllegalArgumentException("des arguments sont null verifier");
              }

              if (!Set.of(UserRole.CLIENT_ENTREPRiSE, UserRole.CLIENT_PROFESSIONNEL).contains(user.getRole())) {
                  throw new RuntimeException("invalid role");
              }

              if (!Set.of(DemandeLivraisonStatus.En_ATTENTE, DemandeLivraisonStatus.TRAITER).contains(demandeLivraison.getStatus())) {

                     throw new RuntimeException("invalid demande status");
                  }

                  if(!demandeLivraison.getClient().getId().equals(user.getId())){

                    throw new RuntimeException("vous n'avez pas le droit d'annuler une demande");
                  }

                  demandeLivraison.setStatus(DemandeLivraisonStatus.ANNULER);
                  saveDemandeLivraison(demandeLivraison);

            }      
      

         public void AcceptationParlivreur(User user, DemandeLivraison demandeLivraison){

                   if (demandeLivraison == null  || user == null  )
                   {
                      throw new IllegalArgumentException("des arguments sont null verifier");
                   }

                    if (!Set.of(UserRole.LIVREUR_PERMANENT, UserRole.LIVREUR_OCCASIONNEL).contains(user.getRole())) {

                      throw new RuntimeException("Rôle non autorisé pour accepter une demande");
                    
                     
                      }
                    if (demandeLivraison.getStatus() != DemandeLivraisonStatus.En_ATTENTE)
                    
                    {
                       throw new RuntimeException("invalid demande status ");
                    }
                        Livraison livraison = new Livraison(LivraisonStatus.CREER, new Date(),demandeLivraison,user) ;
                        saveLivraison(livraison);
                        demandeLivraison.setStatus(DemandeLivraisonStatus.TRAITER);    
                        saveDemandeLivraison(demandeLivraison);

                    }
    

      public void annulerLivraisonParClient(Livraison livraison,User user,DemandeLivraison demandeLivraison){
          
        if(livraison == null || user ==  null ) 
         {
            throw new IllegalArgumentException("des arguments sont verifiers null");
         }

            if (!Set.of(UserRole.CLIENT_ENTREPRiSE, UserRole.CLIENT_PROFESSIONNEL).contains(user.getRole()))
             {
               throw new RuntimeException("Rôle non autorisé pour annuler livraison");
             }
                  if (!Set.of(LivraisonStatus.CREER, LivraisonStatus.EN_COURS).contains(livraison.getStatut())) 
                  {
                    throw new RuntimeException("status non autorise");
                  }

                   if (!demandeLivraison.getClient().getId().equals(user.getId()))
          
                    { 
                      throw new RuntimeException("Ce livreur n'est pas assigné à cette livraison.");
                    }
                     livraison.setStatut(LivraisonStatus.ANNULER);
                     livraisonRepository.save(livraison);
                     demandeLivraison.setStatus(DemandeLivraisonStatus.ANNULER);
                     demandeLivraisonRepository.save(demandeLivraison);
                    }


      public void CommencerLivraison(Livraison livraison, User user){
        
        if (livraison == null || user == null) 
          {
            throw new IllegalArgumentException("Arguments manquants");
          }
        
        if (!Set.of(UserRole.LIVREUR_PERMANENT,UserRole.LIVREUR_OCCASIONNEL).contains(user.getRole()))
         {
            throw new IllegalArgumentException("Rôle non autorisé pour commencer livraison");
          }
           
          if (!livraison.getLivreur().getId().equals(user.getId()))
          
          { 
            throw new RuntimeException("Ce livreur n'est pas assigné à cette livraison.");
          }

         if(livraison.getStatut() != LivraisonStatus.CREER)
          {
            throw new IllegalArgumentException("La livraison doit être au statut 'CREEE' pour être commencée");
          }
            livraison.setStatut(LivraisonStatus.EN_COURS);
            livraisonRepository.save(livraison);
      }

      public void livraisonAchever(Livraison livraison , DemandeLivraison demandeLivraison, User user){
        if (livraison == null || user == null) 
          {
            throw new IllegalArgumentException("Arguments manquants");
          }
        
        if (!Set.of(UserRole.LIVREUR_PERMANENT,UserRole.LIVREUR_OCCASIONNEL).contains(user.getRole()))
         {
            throw new IllegalArgumentException("Rôle non autorisé pour commencer livraison");
          }
           
          if (!livraison.getLivreur().getId().equals(user.getId()))
          
          { 
            throw new RuntimeException("Ce livreur n'est pas assigné à cette livraison.");
          }
          livraison.setStatut(LivraisonStatus.SUCCES);
          demandeLivraison.setStatus(DemandeLivraisonStatus.SUCCES);
          livraisonRepository.save(livraison);
          demandeLivraisonRepository.save(demandeLivraison);

      }

     

                

              
              
              
        
    
 }

    

      



