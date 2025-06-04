package com.example.demo.ServiceMetier;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.example.demo.ModelDomain.DemandeLivraison;
import com.example.demo.ModelDomain.DemandeLivraisonStatus;
import com.example.demo.ModelDomain.Livraison;
import com.example.demo.ModelDomain.LivraisonStatus;
import com.example.demo.ModelDomain.User;
import com.example.demo.ModelDomain.UserRole;
import com.example.demo.repository.LivraisonRepository;
import com.example.demo.repository.UserRepository;

public class LivraisonServiceMetierImp {

  private final DemandeLivraisonServiceMetier demandeLivraison;
  private final LivraisonRepository livraisonRepository;
  private final UserMetierService userMetierService;
  private final UserRepository userRepository;




  public LivraisonServiceMetierImp(DemandeLivraisonServiceMetier demandeLivraison, UserRepository userRepository, LivraisonRepository livraisonRepository, UserMetierService userMetierService){
    this.demandeLivraison = demandeLivraison;
    this.livraisonRepository = livraisonRepository;
    this.userMetierService = userMetierService;
    this.userRepository = userRepository;
  }




     
   public void changerStatusLivraison(Long userId, Long livraisonId) {

                Livraison   livraison = livraisonRepository.findById(livraisonId).orElseThrow(() -> new RuntimeException("livraison introuvable"));
        
                 User    user=userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Demande introuvable"));

                    if (!Set.of(UserRole.LIVREUR_PERMANENT, UserRole.LIVREUR_OCCASIONNEL).contains(user.getRole()))
                     {

                      throw new RuntimeException("Rôle non autorisé pour accepter une demande");
                    
                      }
                      if (!livraison.getStatut().equals(LivraisonStatus.CREER)){
                        throw new IllegalStateException("La livraison n'est pas encore créée.");
                      }
                DemandeLivraison demande =  livraison.getDemandeLivraison();
                  if( demande == null){
                    throw new RuntimeException("Aucune demande associée à cette livraison");
                  }
                   
                // Récupérer la position du client depuis la demande
                 double latitudeClient = demande.getLatitude();
                 double longitudeClient = demande.getLongitude();

                // Appel à la méthode pour trouver le livreur le plus proche
                Optional<User> livreurplusproche = userMetierService.getLivreurDispoEtProche(latitudeClient,longitudeClient);
                 
                if (livreurplusproche.isPresent()){

                  livraison.setLivreur(livreurplusproche.get());
                  livraison.setStatut(LivraisonStatus.EN_COURS);
                  demande.setStatus(DemandeLivraisonStatus.EN_COURS);
                  livraison.setDemandeLivraison(demande);
                   
                }
                }



        public void annulerLivraisonParLivreur(Long livraisonId,Long userId){
          
        
                 User  user=userRepository.findById(userId).orElseThrow(() -> new RuntimeException("user introuvable"));

                 Livraison  livraison=livraisonRepository.findById(livraisonId).orElseThrow(() -> new RuntimeException("livraison introuvable"));

            if (!Set.of(UserRole.LIVREUR_OCCASIONNEL, UserRole.LIVREUR_PERMANENT).contains(user.getRole()))
             {
               throw new RuntimeException("Rôle non autorisé pour annuler livraison");
             }
                  if (!Set.of(LivraisonStatus.CREER, LivraisonStatus.EN_COURS).contains(livraison.getStatut())) 
                  {
                    throw new RuntimeException("status non autorise");
                  }
     
                  livraison.setStatut(LivraisonStatus.ANNULER);
                  DemandeLivraison demande= livraison.getDemandeLivraison();
                  demande.setStatus(DemandeLivraisonStatus.ANNULER);
                  livraison.setDemandeLivraison(demande);
                  livraisonRepository.save(livraison);

                }

      public void livraisonAchever(Long livraisonId , Long livreurId){

        User  livreur=userRepository.findById(livreurId).orElseThrow(() -> new RuntimeException("user  introuvable"));

        Livraison  livraison=livraisonRepository.findById(livraisonId).orElseThrow(() -> new RuntimeException("livraison introuvable"));

        
        if (!Set.of(UserRole.LIVREUR_PERMANENT,UserRole.LIVREUR_OCCASIONNEL).contains(livreur.getRole()))
         {
            throw new IllegalArgumentException("Rôle non autorisé pour terminer livraison");
          }
           
          if (!livraison.getLivreur().getId().equals(livreur.getId()))
          
          { 
            throw new RuntimeException("Ce livreur n'est pas assigné à cette livraison.");
          }
          livraison.setStatut(LivraisonStatus.SUCCES);
          DemandeLivraison demande= livraison.getDemandeLivraison();
          demande.setStatus(DemandeLivraisonStatus.SUCCES);
          livraison.setDemandeLivraison(demande);
          livraisonRepository.save(livraison);

      }
}
