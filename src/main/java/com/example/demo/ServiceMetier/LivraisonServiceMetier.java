package com.example.demo.ServiceMetier;

import com.example.demo.ModelDomain.DemandeLivraison;
import com.example.demo.ModelDomain.Livraison;
import com.example.demo.ModelDomain.User;

public interface LivraisonServiceMetier {
    Livraison changerStatutLivraison(Livraison livraison);
    void annulerLivraisonParLivreur(Livraison livraison,User user,DemandeLivraison demandeLivraison);
    void assignerLivreur(Livraison livraisonId) ;

}
