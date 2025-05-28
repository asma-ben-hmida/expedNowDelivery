package com.example.demo.ServiceMetier;

import com.example.demo.ModelDomain.DemandeLivraison;
import com.example.demo.ModelDomain.DemandeLivraisonStatus;
import com.example.demo.ModelDomain.Livraison;
import com.example.demo.ModelDomain.LivraisonStatus;
import com.example.demo.ModelDomain.User;
import com.example.demo.ModelDomain.UserRole;

public interface DemandeLivraisonServiceMetier {

    Livraison saveLivraison(Livraison livraison);
    DemandeLivraison saveDemandeLivraison(DemandeLivraison demande);
    DemandeLivraison update(Long id, DemandeLivraison updatedDemande);
    void annulerDemandeParClient(DemandeLivraison demandeLivraison, long userId) ;
    void AcceptationParlivreur(User user, DemandeLivraison demandeLivraison);
    void annulerLivraisonParClient(Livraison livraison,User user,DemandeLivraison demandeLivraison);
    void CommencerLivraison(Livraison livraison, User user)  ; 
    void livraisonAchever(Livraison livraison , DemandeLivraison demandeLivraison, User user);
}
