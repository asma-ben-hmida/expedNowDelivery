package com.example.demo.ServiceMetier;

import com.example.demo.ModelDomain.DemandeLivraison;
import com.example.demo.ModelDomain.DemandeLivraisonStatus;
import com.example.demo.ModelDomain.Livraison;
import com.example.demo.ModelDomain.LivraisonStatus;
import com.example.demo.ModelDomain.User;
import com.example.demo.ModelDomain.UserRole;

public interface DemandeLivraisonServiceMetier {

    void saveDemandeLivraison(DemandeLivraison demande);
    DemandeLivraison update(Long id, DemandeLivraison updatedDemande);
    void annulerDemandeParClient(Long demandeId, Long  userId ) ;
    void deleteDemande(Long id );
}
