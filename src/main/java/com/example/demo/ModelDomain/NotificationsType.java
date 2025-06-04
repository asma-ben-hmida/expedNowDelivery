package com.example.demo.ModelDomain;

public enum NotificationsType {
    
    demandeLivraison_En_attente("Votre demande de livraison est en attente."),
    demandeLivraison_annuler("Votre demande de livraison est annuler."),
    demandeLivraison_encours("Votre demande de livraison est en cours."),
    demandeLivraison_achever("Votre demande de livraison est achever."),
    livraison_creer("Votre livraison est creer."),
    livraison_annuler("Votre livraison est annuler."),
    livraison_encours("Votre livraison est en cours."),
    livraison_achever("Votre livraison est achever.");

    private final String message;

     NotificationsType(String message){
        this.message=message;

    }

    public String getMessage(){
        return message;
    }
}
