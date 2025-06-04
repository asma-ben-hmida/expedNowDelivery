package com.example.demo.ServiceApplicatif;

import com.example.demo.Mapper.DemandeLivraisonMapper;
import com.example.demo.Mapper.LivraisonMapper;
import com.example.demo.ModelDomain.DemandeLivraison;
import com.example.demo.ModelDomain.Livraison;
import com.example.demo.ServiceMetier.DemandeLivraisonServiceMetier;
import com.example.demo.ModelDTO.DemandeLivraisonDTO;
import com.example.demo.ModelDTO.LivraisonDTO;
import com.example.demo.ModelDTO.UserDTO;
import com.example.demo.Mapper.UserMapper;
import com.example.demo.ModelDomain.User;
public class DemandeLivraisonServiceApp {

    private final DemandeLivraisonServiceMetier demandeLivraisonServiceMetier;
    private final DemandeLivraisonMapper demandeLivraisonMapper;
    private final LivraisonMapper livraisonMapper;
    private final UserMapper userMapper;

    public DemandeLivraisonServiceApp(DemandeLivraisonServiceMetier demandeLivraisonServiceMetier,UserMapper userMapper, DemandeLivraisonMapper demandeLivraisonMapper, LivraisonMapper livraisonMapper){
        this.demandeLivraisonServiceMetier = demandeLivraisonServiceMetier;
        this.demandeLivraisonMapper = demandeLivraisonMapper;
        this.livraisonMapper = livraisonMapper;
        this.userMapper = userMapper;
    }

     public DemandeLivraisonDTO saveDemandeLivraison(DemandeLivraisonDTO demande)
     {
        //convertir en entity
         DemandeLivraison demandeLivraison = demandeLivraisonMapper.toEntity(demande);
         DemandeLivraison saved = demandeLivraisonServiceMetier.saveDemandeLivraison(demandeLivraison);
         return demandeLivraisonMapper.toDto(saved);
     }
         
     public LivraisonDTO saveLivraison(LivraisonDTO livraisonDTO){

        Livraison livraison = livraisonMapper.toEntity(livraisonDTO);
        Livraison saved = demandeLivraisonServiceMetier.saveLivraison(livraison);
        return livraisonMapper.toDto(saved);
           
     }
     public DemandeLivraisonDTO update (long id,DemandeLivraisonDTO demandeLivraisonDTO){

        DemandeLivraison demandeLivraison = demandeLivraisonMapper.toEntity(demandeLivraisonDTO);
        DemandeLivraison updated = demandeLivraisonServiceMetier.update(id, demandeLivraison);
        return demandeLivraisonMapper.toDto(updated);
     }

      public void annulerDemandeParClient(Long demandeId, long userId) {
        demandeLivraisonServiceMetier.annulerDemandeParClient(demandeId, userId);
       
    }

    public void acceptationParLivreur(Long userId, Long demandeId) {
       demandeLivraisonServiceMetier.AcceptationParlivreur(userId, demandeId);
    }
 
     public void annulerLivraisonParClient(Long  livraisonId, Long userId, Long demandeId) {

        demandeLivraisonServiceMetier.annulerLivraisonParClient(livraison, user, demandeLivraison);
    }

    public void commencerLivraison(Long livraisonId, Long userId) {

        demandeLivraisonServiceMetier.CommencerLivraison(livraisonId, userId);

    }

    public void livraisonAchever(Long livraisonId, Long userId) {
        
      
       demandeLivraisonServiceMetier.livraisonAchever(livraisonId,  userId);   
    
    }

}


