package com.example.demo.ModelDomain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.example.demo.ModelDomain.Livraison;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-increment id
    private Long id;

  

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable =  false)
    private String adress;

    @Column(nullable = false, unique = true)
    private String email;

    private String phoneNumber;

   @Enumerated(EnumType.STRING)
    private UserRole role;  

  @OneToMany(mappedBy = "user")
  private Notifications notifications;

  @OneToOne(mappedBy = "user")
  private Vehicule vehicule;

  @OneToMany(mappedBy = "Livreur")
  private Livraison livraison;

  @OneToMany(mappedBy = "client")
  private List<DemandeLivraison> demandesClient;

 @OneToMany(mappedBy = "livreur")
 private List<Livraison> livraisonsLivreur;
  

    private boolean active = true;

     public User(String address,String password, String fullName, String email, String phoneNumber,List<DemandeLivraison> demandesClient,List<Livraison> livraisonsLivreur, UserRole role,boolean active,Notifications notifications,Vehicule vehicule,Livraison livraison) {
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.active =active;
        this.notifications = notifications;
        this.vehicule =vehicule;
        this.livraison =livraison;
        this.adress = adress;
        this.demandesClient=demandesClient;
        this.livraisonsLivreur = livraisonsLivreur;
    }


  

}
