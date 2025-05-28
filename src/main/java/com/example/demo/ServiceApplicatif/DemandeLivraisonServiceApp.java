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

      public void annulerDemandeParClient(DemandeLivraisonDTO demandeDto, long userId) {
        // Convertir les DTOs en entités
        DemandeLivraison demande = demandeLivraisonMapper.toEntity(demandeDto);
        demandeLivraisonServiceMetier.annulerDemandeParClient(demande, userId);
       
    }

    public void acceptationParLivreur(UserDTO userDto, DemandeLivraisonDTO demandeDto) {

        User user = userMapper.toEntity(userDto);
        DemandeLivraison demande = demandeLivraisonMapper.toEntity(demandeDto);

         demandeLivraisonServiceMetier.AcceptationParlivreur(user, demande);
    }
 
     public void annulerLivraisonParClient(LivraisonDTO livraisonDto, UserDTO userDto, DemandeLivraisonDTO demandeDto) {
        
        Livraison livraison = livraisonMapper.toEntity(livraisonDto);
        User user = userMapper.toEntity(userDto);
        DemandeLivraison demandeLivraison = demandeLivraisonMapper.toEntity(demandeDto);

        demandeLivraisonServiceMetier.annulerLivraisonParClient(livraison, user, demandeLivraison);
    }

    public void commencerLivraison(LivraisonDTO livraisonDto, UserDTO userDto) {

        Livraison livraison = livraisonMapper.toEntity(livraisonDto);
        User user = userMapper.toEntity(userDto);
        demandeLivraisonServiceMetier.CommencerLivraison(livraison, user);

    }

      public void livraisonAchever(LivraisonDTO livraisonDto, DemandeLivraisonDTO demandeDto, UserDTO userDto) {
        
        Livraison livraison = livraisonMapper.toEntity(livraisonDto);
        DemandeLivraison demande = demandeLivraisonMapper.toEntity(demandeDto);
        User user = userMapper.toEntity(userDto);

        demandeLivraisonServiceMetier.livraisonAchever(livraison, demande, user);    }

}


